package dev.bhuwanupadhyay.demo.customer.model;

import dev.bhuwanupadhyay.demo.customer.model.Customer.CustomerId;
import dev.bhuwanupadhyay.demo.customer.model.CustomerPermission.Permission;
import jakarta.transaction.Transactional;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class CustomerRegistrar {

  private final CustomerRepository customers;
  private final CustomerPermission permission;

  CustomerRegistrar(CustomerRepository customers, CustomerPermission permission) {
    this.customers = customers;
    this.permission = permission;
  }

  public Customer create(String name, String address) {
    Customer customer = this.customers.save(new Customer(name, address));
    this.permission.assign(Permission.asOwner(customer));
    return customer;
  }

  @PreAuthorize("@fga.check('customer', #customerId, 'update', 'user')")
  public Customer update(@P("customerId") CustomerId customerId, String address) {
    Customer customer = this.customers.getByCustomerId(customerId);
    customer.updateAddress(address);
    return this.customers.save(customer);
  }
}
