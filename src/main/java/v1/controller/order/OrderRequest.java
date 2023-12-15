package v1.controller.order;

import java.util.List;
import lombok.Builder;
import lombok.Getter;
import v1.controller.product.ProductRequest;

@Getter
@Builder
public class OrderRequest {
    private Long orderId;
    private List<ProductRequest> products;
}
