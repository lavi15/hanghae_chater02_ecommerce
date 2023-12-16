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
        userReader.checkUser(userId);
        Point point = pointRepository.findByUserId(userId);
        point.charge(chargePoint);
        pointRepository.save(point);
    }

    public Point getUserPoint(Long userId) {
        userReader.checkUser(userId);
        return pointRepository.findByUserId(userId);
    }
}