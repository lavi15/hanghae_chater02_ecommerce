package v1.entity.order;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import v1.domain.order.Order;
import v1.domain.product.Product;
import v1.entity.BaseEntity;

import java.util.List;
import v1.entity.product.ProductEntity;

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

    @Builder
    public OrderEntity(Long userId, List<OrderProductEntity> orderProductEntities) {
        this.userId = userId;
        this.orderProductEntities = orderProductEntities;
    }

    public static OrderEntity fromOrder(Order order, List<OrderProductEntity> orderProductEntities){
        return OrderEntity.builder()
            .userId(order.getUserId())
            .orderProductEntities(orderProductEntities)
            .build();
    }
}