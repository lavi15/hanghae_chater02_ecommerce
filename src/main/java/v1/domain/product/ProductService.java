package v1.domain.product;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import v1.entity.orderproduct.repository.OrderProductRepository;
import v1.entity.product.repository.ProductRepository;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;
    private final OrderProductRepository orderProductRepository;
    private final ProductReader productReader;

    public List<Product> getProducts() {
        return productRepository.findAll();
    }

    public List<Product> getPopularProductsInThreeDays() {
        return orderProductRepository.getPopularProductsInThreeDays().stream()
                .map(orderProduct -> productReader.read(orderProduct.getProductId())).toList();
    }
}
