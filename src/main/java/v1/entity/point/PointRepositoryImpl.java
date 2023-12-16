package v1.entity.point;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import v1.domain.point.Point;

@Repository
@RequiredArgsConstructor
public class PointRepositoryImpl implements PointRepository{
    private final PointEntityRepository pointEntityRepository;

    @Override
    public Point findByUserId(Long userId) {
        return pointEntityRepository.findbyUserId(userId).toPoint();
    }

    @Override
    public void save(Point point) {
        pointEntityRepository.save(PointEntity.fromPoint(point));
    }
}