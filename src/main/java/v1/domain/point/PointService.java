package v1.domain.point;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import v1.domain.user.UserReader;
import v1.entity.point.PointEntity;
import v1.entity.point.PointRepository;

@Service
@RequiredArgsConstructor
public class PointService {
    private final PointRepository pointRepository;
    private final UserReader userReader;
    private final PointReader pointReader;

    public void chargeBalance(Long userId, int chargePoint) {
        pointReader.checkPositive(chargePoint);
        Point point = userReader.getUserPoint(userId).toPoint();
        point.charge(chargePoint);
        pointRepository.save(PointEntity.fromPoint(point));
    }

    public Point getUserPoint(Long userId) {
        return userReader.getUserPoint(userId).toPoint();
    }
}
