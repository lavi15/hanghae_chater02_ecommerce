package v1.entity.orderproduct.repository;

import java.util.List;
import v1.domain.orderproduct.OrderProduct;

public interface OrderProductRepository {
    List<OrderProduct> getPopularProductsInThreeDays();

    void saveAll(List<OrderProduct> orderProducts);
}
