package v1.controller.product;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import v1.domain.product.ProductService;

@RestController
@RequestMapping("/v1/product")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;

    @GetMapping("/request")
    public List<ProductResponse> getProducts() {
        return productService.getProducts()
            .stream()
            .map(ProductResponse::new)
            .toList();
    }

    @GetMapping("/popular")
    public List<ProductResponse> getPopular(){
        return productService.getProducts()
                .stream()
                .map(ProductResponse::new)
                .toList();
    }
}
