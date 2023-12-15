package v1.entity.point;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import v1.domain.point.Point;
import v1.entity.BaseEntity;

@Entity
@RequiredArgsConstructor
@Getter
@Table(name = "point")
public class PointEntity extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int point;

    private Long userId;

    @Builder
    private PointEntity(Long id, int point, Long userId) {
        this.id = id;
        this.point = point;
        this.userId = userId;
    }


    public static PointEntity fromPoint(Point  point){
        return PointEntity.builder()
                .id(point.getPointId())
                .point(point.getPoint())
                .userId(point.getUserId())
                .build();
    }

    public Point toPoint(){
        return Point.builder()
                .pointId(getId())
                .userId(getUserId())
                .point(getPoint())
                .build();
    }
}
