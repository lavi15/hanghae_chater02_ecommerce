package v1.entity.user;

import java.util.Optional;
import v1.domain.user.Balance;

public interface BalanceRepository {
    Optional<Balance> findByUserId(Long userID);

    void save(Balance balance);
}
