package dev.bhuwanupadhyay.demo.order;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/orders")
public class Orders {

    private Map<String, Object> object = new HashMap<>();

    @PostMapping
    public Map<String, Object> createOrder(@RequestBody Map<String, Object> payload) {
        this.object = payload;
        return object;
    }

    @GetMapping("/{orderId}")
    public Map<String, Object> getOrder(@PathVariable Long orderId, @RequestBody Map<String, Object> payload) {
        return object;
    }


    @PatchMapping("/{orderId}")
    public Map<String, Object> updateOrder(@PathVariable Long orderId, @RequestBody Map<String, Object> payload) {
        this.object = payload;
        return object;
    }

    @PatchMapping("/{orderId}/cancel")
    public Map<String, Object> cancelOrder(@PathVariable Long orderId) {
        return object;
    }
}
