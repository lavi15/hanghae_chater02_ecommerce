package v1.entity.point;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PointEntityRepository extends JpaRepository<PointEntity, Long>{
    PointEntity findbyUserId(Long userId);
}
