package v1.domain.order;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import v1.domain.user.Balance;
import v1.domain.user.UserBalanceReader;

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
