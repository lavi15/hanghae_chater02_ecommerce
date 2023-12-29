package v1.domain.user;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import v1.entity.user.repository.BalanceRepository;

@Component
@RequiredArgsConstructor
public class UserBalanceReader {
    private final BalanceRepository balanceRepository;

    public Balance read(Long userId) {
        if(userId<=0){
            throw new IllegalArgumentException("ID는 0이하가 될 수 없습니다.");
        }
        return balanceRepository.findByUserId(userId).orElseThrow(() -> new RuntimeException("확인할 수 없는 사용자입니다."));
    }

    public Balance read(Long userId, int chargeBalance) {
        if(chargeBalance<=0){
            throw new IllegalArgumentException("충전 금액은 0보다 커야 합니다.");
        }
        return read(userId);
    }
}
