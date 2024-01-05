package v1.commons.advice;

import java.util.concurrent.TimeUnit;
import java.util.function.Supplier;
import lombok.RequiredArgsConstructor;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class LockHandler {
    private final RedissonClient redissonClient;

    public <T> T runOnLock(String key, Long waitTimeMs, Long leaseTimeMs, Supplier<T> execute) {
        RLock lock = redissonClient.getLock(key);
        try {
            boolean available = lock.tryLock(waitTimeMs, leaseTimeMs, TimeUnit.MILLISECONDS);
            if (!available) {
                throw new RuntimeException("Lock Fail");
            }
            return execute.get();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            lock.unlock();
        }
    }
}
