package v1.entity.order;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderProductEntityRepository extends JpaRepository<OrderProductEntity, Long>{

    OrderProductEntity findByProductId(Long productId);
}