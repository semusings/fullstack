package dev.bhuwanupadhyay.demo.customer.model;

public interface CustomerPermission {

  void assign(Permission permission);

  record Permission(String customerId, String relation) {

    public static Permission asOwner(Customer customer) {
      String productId = customer.getCustomerId().S();
      return new Permission(productId, "owner");
    }
  }
}
