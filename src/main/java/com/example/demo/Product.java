package com.example.demo;

import java.math.BigDecimal;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class Product {
  private String name;
  private ProductType type;
  private String description;
  private BigDecimal monthlyCost;
  private int contractLength;
}
