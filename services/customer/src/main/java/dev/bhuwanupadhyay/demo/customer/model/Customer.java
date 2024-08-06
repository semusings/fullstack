package dev.bhuwanupadhyay.demo.customer.model;

import jakarta.persistence.Embeddable;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Table;
import java.io.Serializable;
import java.util.UUID;

@Entity
@Table(name = "customers")
public class Customer implements Serializable {

  @EmbeddedId
  private CustomerId customerId;

  @Enumerated(EnumType.STRING)
  private Status status;

  private String name;
  private String address;

  // Required for persistence layer
  protected Customer() {
  }

  Customer(String name, String address) {
    this.customerId = new CustomerId(UUID.randomUUID());
    this.name = name;
    this.address = address;
    this.status = Status.ACTIVE;
  }

  public void updateAddress(String address) {
    this.address = address;
  }

  public void disable() {
    this.status = Status.DISABLED;
  }

  public CustomerId getCustomerId() {
    return customerId;
  }

  public String getAddress() {
    return address;
  }

  public String getName() {
    return name;
  }

  public enum Status {
    ACTIVE,
    DISABLED
  }

  @Embeddable
  public record CustomerId(UUID productId) implements Serializable {

    public static CustomerId of(String uuid) {
      return new CustomerId(UUID.fromString(uuid));
    }

    public String S() {
      return productId.toString();
    }
  }
}
