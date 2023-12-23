package v1.entity.order;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import v1.entity.product.ProductEntity;

@Repository
public interface OrderProductEntityRepository extends JpaRepository<ProductEntity, Long>{
}