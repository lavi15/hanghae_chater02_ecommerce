package v1.entity.order;

import java.util.List;
import java.util.Optional;
import v1.domain.order.Order;
import v1.domain.product.Product;

public interface OrderRepository {
    void save(Order order);
}
