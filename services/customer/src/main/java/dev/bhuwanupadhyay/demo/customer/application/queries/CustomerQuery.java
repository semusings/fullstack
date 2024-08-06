package dev.bhuwanupadhyay.demo.customer.application.queries;

import dev.bhuwanupadhyay.demo.customer.model.Customer;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/customers")
public interface CustomerQuery {

  static Map<String, Object> toProductResponse(Customer customer) {
    Map<String, Object> response = new HashMap<>();
    response.put("customerId", customer.getCustomerId().S());
    response.put("name", customer.getName());
    response.put("address", customer.getAddress());
    return response;
  }

  @GetMapping
  QueryListResponse getCustomers(String filters, Pageable pageable);

  @GetMapping("/{customerId}")
  QueryResponse getCustomer(@PathVariable String customerId);

  record QueryListResponse(List<Map<String, Object>> records, Long totalCount) {

  }

  record QueryResponse(Map<String, Object> record) {

  }
}
