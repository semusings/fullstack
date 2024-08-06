package dev.bhuwanupadhyay.demo.customer.application.queries;

import dev.bhuwanupadhyay.demo.customer.model.Customer;
import dev.bhuwanupadhyay.demo.customer.model.Customer.CustomerId;
import dev.bhuwanupadhyay.demo.customer.model.Customer.Status;
import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.repository.RepositoryDefinition;

@RepositoryDefinition(domainClass = Customer.class, idClass = CustomerId.class)
interface CustomerJpaRepository {

  static Specification<Customer> filters(String filters) {
    return (root, query, cb) -> {
      //
      return cb.and(cb.equal(root.get("status"), Status.ACTIVE));
    };
  }

  Page<Customer> findAll(Specification<Customer> spec, Pageable pageable);

  Optional<Customer> getByCustomerId(CustomerId orderId);
}
