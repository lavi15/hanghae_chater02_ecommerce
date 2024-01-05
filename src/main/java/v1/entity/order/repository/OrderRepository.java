package v1.entity.order.repository;

import java.util.List;
import java.util.Optional;
import v1.domain.order.Order;
import v1.domain.product.Product;

public interface OrderRepository {
    Order save(Order order);

    void completePayment(Order order);
}
