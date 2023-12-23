package v1.domain.product;

import jakarta.transaction.Transactional;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import v1.entity.product.ProductEntity;
import v1.entity.product.ProductEntityRepository;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class ProductServiceTest {
    @Autowired
    private ProductService productService;

    @Autowired
    private ProductEntityRepository productEntityRepository;

    @Transactional
    @BeforeEach
    void createUserBalance() {
        List<ProductEntity> products = new ArrayList<>();
       products.add(ProductEntity.builder()
               .name("샴푸")
               .price(10000)
               .quantity(5)
               .build());
       products.add(ProductEntity.builder()
                .name("린스")
                .price(20000)
                .quantity(3)
                .build());
       products.add(ProductEntity.builder()
                .name("오일")
                .price(15000)
                .quantity(10)
                .build());
       products.add(ProductEntity.builder()
                .name("바디로션")
                .price(30000)
                .quantity(20)
                .build());
       products.add(ProductEntity.builder()
                .name("바디워시")
                .price(12000)
                .quantity(5)
                .build());

       productEntityRepository.saveAll(products);
    }

    @Test
    @DisplayName("모든 상품을 조회하여 반환한다.")
    @Transactional
    void getProductsTest() {
        //when
        List<Product> products = productService.getProducts();

        //then
        assertThat(products.size()).isEqualTo(5);
    }
}