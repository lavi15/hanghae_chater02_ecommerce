package v1.domain.product;


import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class Product {
    private Long productId;
    private String  name;
    private int price;
    private int quantity;
}
