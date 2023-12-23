package v1.domain.user;

import jakarta.transaction.Transactional;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import v1.entity.user.BalanceEntity;
import v1.entity.user.BalanceEntityRepository;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@ActiveProfiles("dev")
class BalanceServiceTest {
    @Autowired
    private BalanceEntityRepository balanceEntityRepository;

    @Autowired
    private BalanceService balanceService;

    @Autowired
    private UserBalanceReader userBalanceReader;

    @Transactional
    @BeforeEach
    void createUserBalance() {
        BalanceEntity balance = BalanceEntity.builder()
                .balance(0)
                .userId(1L)
                .build();
        balanceEntityRepository.save(balance);
    }

    @Test
    @DisplayName("0 초과의 유저포인트를 충전한다.")
    @Transactional
    void chargeBalanceTest() {
        //given
        Long userId = 1L;
        int chargeBalance = 1000;

        //when
        balanceService.chargeBalance(userId, chargeBalance);
        Balance balance = userBalanceReader.read(userId);

        //then
        assertThat(balance.getBalance()).isEqualTo(1000);
    }

    @Test
    @DisplayName("특정 유저의 잔액을 조회한다.")
    @Transactional
    void getUserPointTest() {
        //given
        Long userId = 1L;

        //when
        Balance balance = balanceService.getUserPoint(userId);

        //then
        assertThat(balance.getBalance()).isEqualTo(0);
    }
}