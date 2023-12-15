package v1.domain.order;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class Order {
    private Long orderId;
    private Long userId;
    private Long productId;
    private int quantity;
}
