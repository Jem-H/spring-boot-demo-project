package com.example.demo;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
public class BasketItem {
  private String name;
  private int quantity;

  public BasketItem(Product product, int quantity) {
    this.name = product.getName();
    this.quantity = quantity;
  }
}
