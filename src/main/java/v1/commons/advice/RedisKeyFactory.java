package v1.commons.advice;

import org.springframework.stereotype.Component;

@Component
public class RedisKeyFactory {

    public String createUserKey(Long userId) {
        return "RLOCK_User_"+userId.toString();
    }
}
