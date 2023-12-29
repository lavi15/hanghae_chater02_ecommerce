package v1.domain.orderproduct;

import lombok.Builder;
import lombok.Getter;
import v1.entity.BaseEntity;

@Getter
public class OrderProduct{
    private Long productId;
    private int quantity;

    @Builder
    public OrderProduct(Long productId, int quantity) {
        this.productId = productId;
        this.quantity = quantity;
    }
}
