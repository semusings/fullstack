package dev.bhuwanupadhyay.demo.payment;

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
@RequestMapping("/payments")
public class Payments {

  private Map<String, Object> object = new HashMap<>();

  @PostMapping("/{orderId}")
  public Map<String, Object> createPayment(@PathVariable Long orderId,
      @RequestBody Map<String, Object> payload) {
    this.object = payload;
    return object;
  }

  @GetMapping("/{orderId}")
  public Map<String, Object> getPayment(@PathVariable Long orderId) {
    return object;
  }

  @PatchMapping("/{orderId}/refund")
  public Map<String, Object> refundPayment(@PathVariable Long orderId,
      @RequestBody Map<String, Object> payload) {
    this.object = payload;
    return object;
  }

}
