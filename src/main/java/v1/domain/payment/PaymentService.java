package v1.domain.payment;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import v1.commons.advice.KafkaTopics;
import v1.domain.order.Order;

@Service
@RequiredArgsConstructor
public class PaymentService {
    private final ObjectMapper objectMapper;

    @KafkaListener(topics = KafkaTopics.ORDER_CREATED_TOPIC, groupId = "payment")
    public void payment(String orderToString) {
        try {
            Order order = objectMapper.readValue(orderToString, Order.class);
        } catch (JsonProcessingException e) {
            throw new RuntimeException("JsonProcessing Failed");
        }

    }
}
