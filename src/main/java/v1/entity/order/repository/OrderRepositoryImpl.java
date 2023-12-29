package v1.entity.order.repository;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import v1.domain.order.Order;
import v1.entity.order.OrderEntity;
import v1.entity.orderproduct.repository.OrderProductEntityRepository;
import v1.entity.orderproduct.repository.OrderProductRepository;

@Repository
@Transactional
@RequiredArgsConstructor
public class OrderRepositoryImpl implements OrderRepository {
    private final OrderEntityRepository orderEntityRepository;
    private final OrderProductRepository orderProductRepository;
    private final OrderProductEntityRepository orderProductEntityRepository;

    @Override
    public void save(Order order) {
        orderProductRepository.saveAll(order.getOrderProducts());
        orderEntityRepository.save(OrderEntity.fromOrder(order, order.getOrderProducts().stream()
            .map(orderProduct -> orderProductEntityRepository.findByProductId(orderProduct.getProductId())).toList()));
    }
}