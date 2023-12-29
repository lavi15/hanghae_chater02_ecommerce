package v1.domain.order;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import v1.commons.advice.KafkaProducer;
import v1.domain.orderproduct.OrderProductReader;
import v1.domain.product.Product;
import v1.domain.user.UserBalanceReader;
import v1.entity.order.repository.OrderRepository;
import v1.entity.product.repository.ProductRepository;
import v1.entity.user.repository.BalanceRepository;

@Service
@RequiredArgsConstructor
public class OrderService {
    private final OrderRepository orderRepository;
    private final OrderProductReader orderProductReader;
    private final ProductRepository productRepository;
    private final KafkaProducer kafkaProducer;

    public void createOrder(Order order) {
        //유효성 검사
        List<Product> products = orderProductReader.readDeductProduct(order.getOrderProducts());

        //재고 차감
        productRepository.saveAll(products);

        //주문 저장
        try {
            orderRepository.save(order);
            kafkaProducer.publish(order);
        }catch (Exception e){
            orderProductReader.readAddProduct(order.getOrderProducts());
            productRepository.saveAll(products);
        }
    }
}