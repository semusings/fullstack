package dev.bhuwanupadhyay.demo.customer.application.commands;

import dev.bhuwanupadhyay.demo.customer.model.Customer;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/customers")
public interface CustomerCommand {

  @PostMapping()
  CustomerResponse createCustomer(@RequestBody CustomerEntryRequest request);

  @PostMapping("/{customerId}/update-address")
  CustomerResponse updateAddress(
      @PathVariable String customerId, @RequestBody UpdateAddressRequest request);

  record CustomerEntryRequest(String name, String address) {

  }

  record UpdateAddressRequest(String address) {

  }

  record CustomerResponse(String customerId, String name, String address) {

    public static CustomerResponse of(Customer customer) {
      return new CustomerResponse(
          customer.getCustomerId().S(), customer.getName(), customer.getAddress());
    }
  }
}
