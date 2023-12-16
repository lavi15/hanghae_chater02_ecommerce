package v1.domain.user;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import v1.entity.User.UserRepository;
import v1.entity.point.PointEntity;
import v1.entity.point.PointRepository;

@Component
@RequiredArgsConstructor
public class UserReader {
    private final UserRepository userRepository;

    public void checkUser(Long userId) {
        userRepository.findById(userId).orElseThrow(() ->
            new RuntimeException("해당 유저를 찾을 수 없습니다.")
        );
    }
}
