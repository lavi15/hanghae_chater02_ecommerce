package v1.controller.product;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class ProductRequest {
    private Long productId;
    private int quantity;
}
