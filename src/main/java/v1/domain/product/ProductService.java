package v1.domain.product;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import v1.domain.order.OrderProduct;
import v1.entity.order.OrderProductRepository;
import v1.entity.product.ProductRepository;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;
    private final OrderProductRepository orderProductRepository;

    public List<Product> getProducts() {
        return productRepository.findAll();
    }

    public List<OrderProduct> findPopularProductsInThreeDays() {
        return orderProductRepository.findPopularProducts();
    }
}
