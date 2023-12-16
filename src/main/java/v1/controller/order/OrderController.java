package v1.controller.order;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import v1.domain.order.OrderService;
import v1.domain.product.ProductService;

@RestController
@RequestMapping("/v1/order")
@RequiredArgsConstructor
public class OrderController {
    private final OrderService orderService;

    @PostMapping("/request")
    public void createOrder(@RequestBody OrderRequest orderRequest) {
        orderService.createOrder(orderRequest.toOrder());
    }
}
