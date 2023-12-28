package v1.domain.user;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class Balance {
    private Long balanceId;
    private Long userId;
    private int balance;


    public void charge(int balance) {
        this.balance += balance;
    }

    public void payment(int balance) {
        this.balance -= balance;
    }
}
