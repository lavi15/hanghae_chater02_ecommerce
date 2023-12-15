package v1.entity.product;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import v1.domain.product.Product;
import v1.entity.point.PointEntity;

@Repository
public interface ProductRepository extends JpaRepository<ProductEntity, Long>{
}
