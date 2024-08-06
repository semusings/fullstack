package dev.bhuwanupadhyay.demo.inventory.application.queries;

import dev.bhuwanupadhyay.demo.inventory.model.Product;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/products")
@Tag(name = "${serviceApi.tag}", description = "${serviceApi.description}")
public interface ProductQuery {

  static Map<String, Object> toProductResponse(Product product) {
    Map<String, Object> response = new HashMap<>();
    response.put("productId", product.getProductId().S());
    response.put("name", product.getName());
    response.put("description", product.getDescription());
    response.put("retailPrice", product.getRetailPrice());
    response.put("availableQuantity", product.getAvailableQuantity());
    response.put("status", product.getStatus().name());
    return response;
  }

  @Operation(
      summary = "${serviceApi.create.summary}",
      description = "${serviceApi.create.description}",
      security = {@SecurityRequirement(name = "Authorization")},
      tags = {"${serviceApi.tag}"})
  @QueryApiResponse
  @GetMapping
  QueryListResponse getProducts(String filters, Pageable pageable);

  @GetMapping("/{productId}")
  QueryResponse getProduct(@PathVariable String productId);

  record AppError(int code, String reason, String message) implements Serializable {

  }

  record QueryListResponse(List<Map<String, Object>> records, Long totalCount) {

  }

  record QueryResponse(Map<String, Object> record) {

  }

}
