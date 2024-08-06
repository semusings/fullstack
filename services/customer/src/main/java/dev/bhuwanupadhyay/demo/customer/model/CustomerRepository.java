package dev.bhuwanupadhyay.demo.customer.model;

import dev.bhuwanupadhyay.demo.customer.model.Customer.CustomerId;
import org.springframework.data.repository.RepositoryDefinition;

@RepositoryDefinition(domainClass = Customer.class, idClass = CustomerId.class)
interface CustomerRepository {

  Customer getByCustomerId(CustomerId customerId);

  Customer save(Customer customer);
}
