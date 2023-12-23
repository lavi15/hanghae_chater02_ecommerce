package v1.entity.order;

import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import v1.domain.order.OrderProduct;

@Repository
@Transactional
public class OrderProductRepositoryImpl implements OrderProductRepository {
    private final JPAQueryFactory jpaQueryFactory;

    public OrderProductRepositoryImpl(EntityManager em) {
        this.jpaQueryFactory = new JPAQueryFactory(em);
    }

    @Override
    public List<OrderProduct> findPopularProducts(){
        LocalDateTime threeDaysAgo = LocalDateTime.now().minusDays(3);
        QOrderEntity order = QOrderEntity.orderEntity;
        QOrderProductEntity orderProduct = QOrderProductEntity.orderProductEntity;

        return jpaQueryFactory
            .select(Projections.constructor(PopularProduct.class,
                orderProduct.productId,
                orderProduct.quantity.sum().as("salesQuantity")))
            .from(orderProduct)
            .join(orderProduct.orderEntity, order)
            .where(order.createdDateTime.after(threeDaysAgo))
            .groupBy(orderProduct.productId)
            .orderBy(orderProduct.quantity.sum().desc())
            .limit(5)
            .fetch()
            .stream()
            .map(PopularProduct::toOrderProduct)
            .toList();
    }
}
