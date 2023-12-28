package v1.entity.product;

import java.util.Optional;
import v1.domain.product.Product;

import java.util.List;

public interface ProductRepository{
    List<Product> findAll();
    Optional<Product> findById(Long productId);

    void saveAll(List<Product> products);
}
