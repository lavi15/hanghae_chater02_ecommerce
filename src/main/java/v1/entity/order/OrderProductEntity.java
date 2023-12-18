package v1.entity.order;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import v1.domain.order.OrderProduct;

@Getter
@Entity(name = "order_product")
@RequiredArgsConstructor
public class OrderProductEntity {
    @Id
    private Long Id;
    private Long productId;
    private int quantity;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id")
    private OrderEntity orderEntity;

    public OrderProduct toOrderProduct() {
        return OrderProduct.builder()
                    .productId(getProductId())
                    .quantity(getQuantity())
                    .build();
    }
}