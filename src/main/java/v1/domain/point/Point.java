package v1.domain.point;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class Point {
    private Long pointId;
    private Long userId;
    private int point;


    public void charge(int point) {
        this.point += point;
    }
}
