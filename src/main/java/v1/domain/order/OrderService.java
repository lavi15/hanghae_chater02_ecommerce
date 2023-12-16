package v1.domain.order;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import v1.domain.point.Point;
import v1.domain.point.PointReader;
import v1.domain.product.ProductReader;
import v1.domain.user.UserReader;
import v1.entity.order.OrderRepository;
import v1.entity.point.PointRepository;

@Service
@RequiredArgsConstructor
public class OrderService {
    private final OrderRepository orderRepository;
    private final UserReader userReader;
    private final ProductReader productReader;

    public void createOrder(Order order) {

    }
}