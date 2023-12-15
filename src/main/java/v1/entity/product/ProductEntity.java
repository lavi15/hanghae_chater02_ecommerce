package v1.entity.product;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import v1.domain.point.Point;
import v1.domain.product.Product;
import v1.entity.BaseEntity;
import v1.entity.point.PointEntity;

@Entity
@RequiredArgsConstructor
@Table(name = "product")
@Getter
public class ProductEntity extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private int price;

    private int quantity;

    @Builder
    private ProductEntity(Long id, String name, int price, int quantity) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public static ProductEntity fromProduct(Product product){
        return ProductEntity.builder()
                .id(product.getProductId())
                .name(product.getName())
                .price(product.getPrice())
                .quantity(product.getQuantity())
                .build();
    }

    public Product toProduct(){
        return Product.builder()
                .productId(getId())
                .name(getName())
                .price(getPrice())
                .quantity(getQuantity())
                .build();
    }
}
