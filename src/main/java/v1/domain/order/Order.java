package v1.domain.order;

import lombok.Builder;
import lombok.Getter;

import java.util.List;
import v1.domain.orderproduct.OrderProduct;

@Getter
public class Order{
    private Long orderId;
    private Long userId;
    private List<OrderProduct> orderProducts;

    @Builder(toBuilder = true)
    public Order(Long orderId, Long userId, List<OrderProduct> orderProducts) {
        this.orderId=orderId;
        this.userId=userId;
        this.orderProducts = orderProducts;
    }
}
