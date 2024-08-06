package dev.bhuwanupadhyay.demo.customer.application.queries;

import dev.bhuwanupadhyay.demo.customer.model.Customer;
import dev.bhuwanupadhyay.demo.customer.model.Customer.CustomerId;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.RestController;

@RestController
class CustomerQueryRequestHandler implements CustomerQuery {

  private final CustomerJpaRepository customers;

  public CustomerQueryRequestHandler(CustomerJpaRepository customers) {
    this.customers = customers;
  }

  @Override
  public QueryListResponse getCustomers(String filters, Pageable pageable) {
    Page<Customer> page = customers.findAll(CustomerJpaRepository.filters(filters), pageable);
    List<Map<String, Object>> records =
        page.stream().map(CustomerQuery::toProductResponse).collect(Collectors.toList());
    return new QueryListResponse(records, page.getTotalElements());
  }

  @Override
  public QueryResponse getCustomer(String productId) {
    Customer customer =
        customers
            .getByCustomerId(CustomerId.of(productId))
            .orElseThrow(() -> new IllegalArgumentException("Not Found"));
    return new QueryResponse(CustomerQuery.toProductResponse(customer));
  }
}
