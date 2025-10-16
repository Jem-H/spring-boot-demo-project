package com.example.demo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Component;

@Component
public class BasketService {

  Map<String, BasketItem> basketItems = new HashMap<>();

  public List<BasketItem> getBasketItems() {
    return new ArrayList<>(basketItems.values());
  }

  public void addBasketItem(BasketItem basketItem) {
    // If the same key (item name) is used, Map will replace rather than add an identical one
    basketItems.put(basketItem.getName(), basketItem);
  }

  public void updateBasketQuantity(String name, int quantity) {
    BasketItem basketItem = basketItems.get(name);
    if (basketItem != null) {
      basketItem.setQuantity(basketItem.getQuantity() + quantity);
    }
  }

  public void clearBasket() {
    basketItems.clear();
  }
}
