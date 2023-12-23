package v1.entity.user;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BalanceEntityRepository extends JpaRepository<BalanceEntity, Long>{
    Optional<BalanceEntity> findByUserId(Long userId);
}
