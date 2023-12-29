package v1.domain.orderproduct;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import v1.domain.product.Product;
import v1.domain.product.ProductReader;

@Component
@RequiredArgsConstructor
public class OrderProductReader {
    private final ProductReader productReader;

    public Product readDeductProduct(Long productId, int quantity) {
        Product product = productReader.read(productId);

        if ( quantity >= product.getQuantity()) {
            throw new RuntimeException("재고가 부족하여 주문하실 수 없습니다.");
        }
        product.deduct(quantity);
        return product;
    }

    public List<Product> readDeductProduct(List<OrderProduct> orderProducts) {
        return orderProducts.stream().map(orderProduct -> readDeductProduct(orderProduct.getProductId(), orderProduct.getQuantity())).toList();
    }

    public Product readAddProduct(Long productId, int quantity) {
        Product product = productReader.read(productId);

        product.add(quantity);
        return product;
    }

    public List<Product> readAddProduct(List<OrderProduct> orderProducts) {
        return orderProducts.stream().map(orderProduct -> readDeductProduct(orderProduct.getProductId(), orderProduct.getQuantity())).toList();
    }
}
