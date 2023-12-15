package v1.entity.point;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public class PointRepository extends JpaRepository<PointEntity, Long>{
}
