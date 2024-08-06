package dev.bhuwanupadhyay.demo.customer.application.commands;

import dev.bhuwanupadhyay.demo.customer.model.Customer;
import dev.bhuwanupadhyay.demo.customer.model.Customer.CustomerId;
import dev.bhuwanupadhyay.demo.customer.model.CustomerRegistrar;
import org.springframework.web.bind.annotation.RestController;

@RestController
class CustomerCommandRequestHandler implements CustomerCommand {

  private final CustomerRegistrar customerRegistrar;

  public CustomerCommandRequestHandler(CustomerRegistrar customerRegistrar) {
    this.customerRegistrar = customerRegistrar;
  }

  @Override
  public CustomerResponse createCustomer(CustomerEntryRequest request) {
    Customer customer = customerRegistrar.create(request.name(), request.address());
    return CustomerResponse.of(customer);
  }

  @Override
  public CustomerResponse updateAddress(String productId, UpdateAddressRequest request) {
    Customer customer = customerRegistrar.update(CustomerId.of(productId), request.address());
    return CustomerResponse.of(customer);
  }
}
