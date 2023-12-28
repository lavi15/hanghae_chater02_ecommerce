package v1.domain.order;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import v1.domain.product.Product;
import v1.domain.product.ProductReader;
import v1.domain.user.Balance;
import v1.domain.user.UserBalanceReader;
import v1.entity.order.OrderRepository;
import v1.entity.product.ProductRepository;
import v1.entity.user.BalanceRepository;

@Service
@RequiredArgsConstructor
public class OrderService {
    private final OrderRepository orderRepository;
    private final OrderProductReader orderProductReader;
    private final OrderChecker orderChecker;
    private final UserBalanceReader userBalanceReader;
    private final BalanceRepository balanceRepository;
    private final ProductRepository productRepository;

    public int createOrder(Order order) {
        //유효성 검사
        int totalPrice = orderProductReader.readPrice(order.getOrderProducts());
        List<Product> products = orderProductReader.readDeductProduct(order.getOrderProducts());
        Balance balance = userBalanceReader.read(order.getUserId());
        orderChecker.check(balance, totalPrice);

        //주문 저장
        orderRepository.save(order);

        //재고 차감
        productRepository.saveAll(products);

        //결제
        balance.payment(totalPrice);
        balanceRepository.save(balance);

        return totalPrice;
    }
}