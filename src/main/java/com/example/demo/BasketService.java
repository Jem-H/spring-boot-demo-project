package com.example.demo;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class BasketService {

  Map<String, BasketItem> basketItems = new HashMap<>();

  public List<BasketItem> getBasketItems() {
    return new ArrayList<>(basketItems.values());
  }
}
