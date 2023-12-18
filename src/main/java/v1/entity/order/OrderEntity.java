package v1.entity.order;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import v1.domain.order.Order;
import v1.entity.BaseEntity;

import java.util.List;

@Entity
@RequiredArgsConstructor
@Getter
@Table(name = "orders")
public class OrderEntity extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long userId;

    @OneToMany(mappedBy = "orderEntity")
    private List<OrderProductEntity> orderProductEntities;

    public Order toOrder() {
        return Order.builder()
                .orderId(getId())
                .userId(getUserId())
                .orderProducts(getOrderProductEntities().stream().map(OrderProductEntity::toOrderProduct).toList())
                .build();
    }
}