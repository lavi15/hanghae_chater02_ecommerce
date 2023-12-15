package v1.controller.point;

import lombok.Getter;
import v1.domain.point.Point;

@Getter
public class PointResponse {
    private Long userId;
    private int point;

    public PointResponse(Point point) {
        this.userId = point.getUserId();
        this.point = point.getPoint();
    }
}
