package v1.entity.order;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Builder.Default;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import v1.domain.order.Order;
import v1.entity.BaseEntity;

import java.util.List;
import v1.entity.orderproduct.OrderProductEntity;

@Entity
@RequiredArgsConstructor
@Getter
@Table(name = "orders")
public class OrderEntity extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long userId;

    @Enumerated(EnumType.STRING)
    private OrderState orderState;

    @OneToMany(mappedBy = "orderEntity")
    private List<OrderProductEntity> orderProductEntities;

    public Order toOrder() {
        return Order.builder()
                .orderId(getId())
                .userId(getUserId())
                .orderProducts(getOrderProductEntities().stream().map(OrderProductEntity::toOrderProduct).toList())
                .build();
    }

    @Builder
    public OrderEntity(Long userId, List<OrderProductEntity> orderProductEntities, OrderState orderState) {
        this.userId = userId;
        this.orderProductEntities = orderProductEntities;
        this.orderState = orderState != null ? orderState : OrderState.INIT;;
    }

    public static OrderEntity fromOrder(Order order, List<OrderProductEntity> orderProductEntities){
        return OrderEntity.builder()
            .userId(order.getUserId())
            .orderProductEntities(orderProductEntities)
            .build();
    }
}