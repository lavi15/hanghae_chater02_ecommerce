package v1.entity.product;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import v1.domain.product.Product;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class ProductRepositoryImplTest {
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private ProductEntityRepository productEntityRepository;

    @Test
    @DisplayName("모든 상품의 정보를 product class로 매핑해서 반환한다.")
    void findAllTest() {
        //given
        List<ProductEntity> productEntities = new ArrayList<>();
        productEntities.add(ProductEntity.builder()
                .name("샴푸")
                .price(10000)
                .quantity(5)
                .build());
        productEntities.add(ProductEntity.builder()
                .name("린스")
                .price(20000)
                .quantity(3)
                .build());
        productEntities.add(ProductEntity.builder()
                .name("오일")
                .price(15000)
                .quantity(10)
                .build());
        productEntities.add(ProductEntity.builder()
                .name("바디로션")
                .price(30000)
                .quantity(20)
                .build());
        productEntities.add(ProductEntity.builder()
                .name("바디워시")
                .price(12000)
                .quantity(5)
                .build());

        productEntityRepository.saveAll(productEntities);

        //when
        List<Product> products = productRepository.findAll();

        //then
        assertThat(products.size()).isEqualTo(5);
    }
}