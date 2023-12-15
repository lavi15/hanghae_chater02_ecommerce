package v1.controller.point;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import v1.domain.point.PointService;

@RestController
@RequestMapping("/v1/user")
@RequiredArgsConstructor
public class PointController {
    private final PointService  pointService;

    @PutMapping("/{userId}/point/charge")
    public ResponseEntity<String> chargePoint(@PathVariable Long userId, @RequestBody ChargePointRequest chargePointRequest) {
        try {
            pointService.chargeBalance(userId, chargePointRequest.getChargePoint());
            return ResponseEntity.ok("");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error charging balance");
        }
    }

    @GetMapping("/{userId}/point/request")
    public PointResponse getUserPoint(@PathVariable Long userId) {
        return new PointResponse(pointService.getUserPoint(userId));
    }
}
