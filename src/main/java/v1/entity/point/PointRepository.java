package v1.entity.point;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import v1.domain.point.Point;

public interface PointRepository{
    Point findByUserId(Long userID);

    void save(Point point);
}
