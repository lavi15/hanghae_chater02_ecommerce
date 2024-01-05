package v1.domain.order;

import java.util.ArrayList;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import v1.commons.advice.KafkaProducer;
import v1.commons.advice.TransactionHandler;
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
    private final TransactionHandler transactionHandler;

    public void createOrder(Order order) {
        transactionHandler.runOnWriteTransaction(() -> {
            // 유효성 검사 및 재고 차감
            List<Product> products = orderProductReader.readDeductProduct(order.getOrderProducts());

            // 재고 저장
            productRepository.saveAll(products);
            return null;
        });

        //주문 저장
        try {
            transactionHandler.runOnWriteTransaction(() -> {
                orderRepository.save(order);
                kafkaProducer.publish(order);

                return null;
            });
        }catch (Exception e){
            transactionHandler.runOnWriteTransaction(() -> {
                List<Product> products = orderProductReader.readAddProduct(order.getOrderProducts());
                productRepository.saveAll(products);

                return null;
            });
        }
    }
}