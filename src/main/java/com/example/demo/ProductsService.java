package com.example.demo;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import jakarta.annotation.PostConstruct;
import lombok.Getter;
import org.springframework.stereotype.Component;

@Getter
@Component
public class ProductsService {

  private final List<Product> products = new ArrayList<>();

  @PostConstruct
  public void init() {
      products.add(new Product("Sky F1", ProductType.SPORTS, "Watch every race of the season, exclusively on Sky Sports in the UK.", new BigDecimal("10.00"), 12));
      products.add(new Product("Sky Golf", ProductType.SPORTS, "Great for those who enjoy watching grass and sky in the same show.", new BigDecimal("15.00"), 12));
      products.add(new Product("Sky Tennis", ProductType.SPORTS, "Ideal for those who enjoy tennis beyond Wimbledon", new BigDecimal("15.50"), 18));
      products.add(new Product("Sky Football", ProductType.SPORTS, "Catch every premier league game of the season exclusively on Sky Sports.", new BigDecimal("15.00"), 12));
      products.add(new Product("Sky Horror", ProductType.MOVIES, "Ideal for the horror lover, you get it all. Now in HD", new BigDecimal("30.00"), 12));
      products.add(new Product("Sky Cinema", ProductType.MOVIES, "Ideal for the movie lover, all the movies, all day. Now in HD", new BigDecimal("30.00"), 12));
  }
}
