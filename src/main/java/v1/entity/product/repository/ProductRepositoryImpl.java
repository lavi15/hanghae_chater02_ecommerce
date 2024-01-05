package v1.entity.product.repository;

import jakarta.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import v1.domain.product.Product;
import v1.entity.product.ProductEntity;

@Repository
@RequiredArgsConstructor
public class ProductRepositoryImpl implements ProductRepository{
    private final ProductEntityRepository productEntityRepository;

    @Override
    public List<Product> findAll(){
        return productEntityRepository.findAll().stream().map(ProductEntity::toProduct).toList();
    }

    @Override
    public Optional<Product> findById(Long productId) {
        return productEntityRepository.findById(productId).map(ProductEntity::toProduct);
    }

    @Override
    public void saveAll(List<Product> products) {
        productEntityRepository.saveAll(products.stream().map(product -> ProductEntity.fromProduct(product)).toList());
    }
}
