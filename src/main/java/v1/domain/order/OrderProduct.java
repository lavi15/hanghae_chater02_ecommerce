package v1.domain.order;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class OrderProduct {
    private Long productId;
    private int quantity;
}
