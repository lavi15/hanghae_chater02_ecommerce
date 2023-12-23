package v1.domain.order;

import lombok.Builder;
import lombok.Getter;
import v1.entity.BaseEntity;

@Getter
@Builder
public class OrderProduct extends BaseEntity {
    private Long productId;
    private int quantity;
}
