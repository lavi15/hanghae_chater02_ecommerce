package v1.entity.product;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import v1.domain.product.Product;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class ProductRepositoryImpl implements ProductRepository{
    private final ProductEntityRepository productEntityRepository;

    @Override
    public List<Product> findAll(){
        return productEntityRepository.findAll().stream().map(ProductEntity::toProduct).toList();
    }

    @Override
    public List<Product> findPopular(){
        return productEntityRepository.findAll().stream().map(ProductEntity::toProduct).toList();
    }
}
