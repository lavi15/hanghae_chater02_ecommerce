package v1.domain.order;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import v1.domain.product.Product;
import v1.domain.user.Balance;
import v1.domain.user.BalanceService;
import v1.domain.user.UserBalanceReader;
import v1.entity.product.ProductRepository;
import v1.entity.user.BalanceRepository;

@Component
@RequiredArgsConstructor
public class OrderChecker {
    private final UserBalanceReader userBalanceReader;

    public void check(Balance balance, int totalPrice) {
        if(balance.getBalance() < totalPrice) {
            throw new RuntimeException("잔액이 부족하여 주문하실 수 없습니다.");
        }
    }
}
