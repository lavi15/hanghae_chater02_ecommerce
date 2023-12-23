package v1.domain.order;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import v1.domain.product.ProductReader;
import v1.entity.order.OrderRepository;

@Service
@RequiredArgsConstructor
public class OrderService {
    private final OrderRepository orderRepository;
    private final ProductReader productReader;

    public void createOrder(Order order) {

    }
}