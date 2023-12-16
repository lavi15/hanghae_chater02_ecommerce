package v1.domain.product;

import org.springframework.stereotype.Component;

@Component
public class ProductReader {

    public void checkProduct(int point) {
        if (point <= 0) {
            throw new IllegalArgumentException("0포인트 이하로 충전할 수 없습니다.");
        }
    }
}
