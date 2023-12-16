package v1.domain.order;

import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
public class Order {
    private Long orderId;
    private Long userId;
    private List<OrderProduct> orderProducts;

    @Builder
    public Order(Long userId, List<OrderProduct> orderProducts) {
        this.userId=userId;
        this.orderProducts = orderProducts;
    }
}
