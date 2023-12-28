package v1.domain.order;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import v1.domain.product.Product;
import v1.domain.product.ProductReader;
import v1.entity.product.ProductRepository;

@Component
@RequiredArgsConstructor
public class OrderProductReader {
    private final ProductReader productReader;

    public int readPrice(Long productId, int quantity) {
        if ( quantity <= 0) {
            throw new IllegalArgumentException("수량은 0이하가 될 수 없습니다.");
        }

        return productReader.read(productId).getPrice()*quantity;
    }

    public int readPrice(List<OrderProduct> orderProducts) {
        int totalPrice = 0;
        for(OrderProduct orderProduct : orderProducts) {
            totalPrice += readPrice(orderProduct.getProductId(), orderProduct.getQuantity());
        }
        return totalPrice;
    }

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
}
