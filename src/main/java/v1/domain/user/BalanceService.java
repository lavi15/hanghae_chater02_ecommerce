package v1.domain.user;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import v1.entity.user.BalanceRepository;

@Service
@RequiredArgsConstructor
public class BalanceService {
    private final BalanceRepository balanceRepository;
    private final UserBalanceReader userBalanceReader;

    public void chargeBalance(Long userId, int chargeBalance) {
        userBalanceReader.validateChargeBalance(chargeBalance);
        Balance balance = userBalanceReader.read(userId);
        balance.charge(chargeBalance);
        balanceRepository.save(balance);
    }

    public Balance getUserPoint(Long userId) {
        return userBalanceReader.read(userId);
    }
}