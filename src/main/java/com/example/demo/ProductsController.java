package com.example.demo;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class ProductsController {

  private final ProductsService productsService;

  @GetMapping("/products")
  public ProductsResponse getProducts() {
    return new ProductsResponse(productsService.getProducts());
  }
}
