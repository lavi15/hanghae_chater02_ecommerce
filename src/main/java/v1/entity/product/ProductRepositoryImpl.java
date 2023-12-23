package v1.entity.product;

import jakarta.transaction.Transactional;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import v1.domain.product.Product;
import v1.entity.order.OrderProductRepository;

@Repository
@RequiredArgsConstructor
@Transactional
public class ProductRepositoryImpl implements ProductRepository{
    private final ProductEntityRepository productEntityRepository;

    @Override
    public List<Product> findAll(){
        return productEntityRepository.findAll().stream().map(ProductEntity::toProduct).toList();
    }

}
