package v1.controller.product;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.bind.annotation.GetMapping;
import v1.domain.product.ProductService;

import java.util.List;

@WebMvcTest(ProductController.class)
class ProductControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private ProductService productService;

    @Test
    @DisplayName("모든 상품을 조회 및 반환한다.")
    void findProductsTest() {
        //given


        //when

        //then
    }

    public List<ProductResponse> findProducts() {
        return productService.getProducts()
                .stream()
                .map(ProductResponse::new)
                .toList();
    }

    @GetMapping("/popular")
    public void findPopularProductsInThreeDays(){

    }
}