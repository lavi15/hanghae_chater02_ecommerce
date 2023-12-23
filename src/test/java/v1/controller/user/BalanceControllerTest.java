package v1.controller.user;

import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.doNothing;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import v1.domain.user.BalanceService;

@WebMvcTest(controllers = BalanceController.class)
public class BalanceControllerTest{
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private BalanceService balanceService;

    @Test
    @DisplayName("잔액을 충전한다.")
    void chargeBalance() throws Exception {
        //given
        Long userId = 1L;
        ChargeBalanceRequest chargeBalanceRequest = ChargeBalanceRequest.builder().chargePoint(1000).build();

        doNothing().when(balanceService).chargeBalance(anyLong(), Mockito.anyInt());

        //when //then
        mockMvc.perform(put("/v1/user/balance/charge")
                .header("Authorization", userId.toString())
                .content(objectMapper.writeValueAsString(chargeBalanceRequest))
                .contentType(MediaType.APPLICATION_JSON))
            .andDo(print())
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.code").value("200"))
            .andExpect(jsonPath("$.status").value("OK"))
            .andExpect(jsonPath("$.message").value("OK"))
            .andExpect(jsonPath("$.data").value("충전에 성공했습니다."));
    }
}
