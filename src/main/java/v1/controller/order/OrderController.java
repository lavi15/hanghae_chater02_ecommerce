package v1.controller.order;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import v1.controller.ApiResponse;
import v1.domain.order.OrderService;

@RestController
@RequestMapping("/v1/order")
@RequiredArgsConstructor
public class OrderController {
    private final OrderService orderService;

    @PostMapping("/request")
    public ApiResponse<OrderResponse> createOrder(@RequestBody OrderRequest orderRequest) {
        orderService.createOrder(orderRequest.toOrder());
        return ApiResponse.ok(OrderResponse.builder().build());
    }
}