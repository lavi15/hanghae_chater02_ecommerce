package v1.domain.product;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import v1.entity.product.repository.ProductRepository;

@Component
@RequiredArgsConstructor
public class ProductReader {
    private final ProductRepository productRepository;

    public Product read(Long productId) {
        if ( productId <= 0) {
            throw new IllegalArgumentException("ID는 0이하가 될 수 없습니다.");
        }
        return productRepository.findById(productId).orElseThrow(() -> new RuntimeException("확인할 수 없는 상품입니다."));
    }
}
