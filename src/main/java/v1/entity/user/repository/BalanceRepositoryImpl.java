package v1.entity.user.repository;

import jakarta.transaction.Transactional;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import v1.domain.user.Balance;
import v1.entity.user.BalanceEntity;

@Repository
@RequiredArgsConstructor
public class BalanceRepositoryImpl implements BalanceRepository {
    private final BalanceEntityRepository balanceEntityRepository;

    @Override
    public Optional<Balance> findByUserId(Long userId) {
        return balanceEntityRepository.findByUserId(userId).map(BalanceEntity::toBalance);
    }

    @Override
    public void save(Balance balance) {
        balanceEntityRepository.save(BalanceEntity.fromBalance(balance));
    }
}