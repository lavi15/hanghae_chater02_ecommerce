package v1.domain.payment;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import v1.commons.advice.ConsumerMapper;
import v1.commons.advice.KafkaTopics;
import v1.domain.order.Order;
import v1.domain.orderproduct.OrderProductReader;
import v1.domain.product.ProductReader;
import v1.domain.user.Balance;
import v1.domain.user.UserBalanceReader;
import v1.entity.order.repository.OrderRepository;
import v1.entity.user.repository.BalanceRepository;

@Service
@RequiredArgsConstructor
public class PaymentService {
    private final ConsumerMapper consumerMapper;
    private final OrderProductReader orderProductReader;
    private final UserBalanceReader userBalanceReader;
    private final BalanceRepository balanceRepository;
    private final OrderRepository orderRepository;

    @KafkaListener(topics = KafkaTopics.ORDER_CREATED_TOPIC, groupId = "payment")
    public void payment(String orderToString) {
        Order order = consumerMapper.deserializeOrderFromJson(orderToString);
        int totalprice = orderProductReader.readTotalPrice(order.getOrderProducts());

        Balance balance = userBalanceReader.read(order.getUserId());
        balance.payment(totalprice);
        balanceRepository.save(balance);

        orderRepository.completePayment(order);
    }
}
