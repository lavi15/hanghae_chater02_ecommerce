package v1.domain.product;

import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import v1.entity.product.ProductEntity;
import v1.entity.product.ProductRepository;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;

    public List<Product> getProducts() {
        return productRepository.findAll();
    }

    public List<Product> getPopular() {
        return productRepository.findPopular();
    }
}
