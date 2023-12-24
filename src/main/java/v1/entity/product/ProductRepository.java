package v1.entity.product;

import v1.domain.product.Product;

import java.util.List;

public interface ProductRepository{
    List<Product> findAll();
    Product findById(Long productId);
}
