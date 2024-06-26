package dev.bhuwanupadhyay.demo.inventory;

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
@RequestMapping("/inventory/products")
public class Products {

  private Map<String, Object> object = new HashMap<>();

  @PostMapping
  public Map<String, Object> createProduct(@RequestBody Map<String, Object> payload) {
    this.object = payload;
    return object;
  }

  @GetMapping("/{productId}")
  public Map<String, Object> getProduct(@PathVariable Long productId) {
    return object;
  }

  @PatchMapping("/{productId}/update-stock")
  public Map<String, Object> updateStock(@PathVariable Long productId,
      @RequestBody Map<String, Object> payload) {
    this.object = payload;
    return object;
  }

}
