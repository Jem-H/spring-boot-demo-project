package com.example.demo;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class BasketController {

  private final BasketService basketService;

  @GetMapping("/basket")
  public BasketResponse getBasket() {
    return new BasketResponse(basketService.getBasketItems());
  }

  @PostMapping("/basket")
  public void addBasketItem(@RequestBody BasketItem basketItem) {
    basketService.addBasketItem(basketItem);
  }

  @PatchMapping("/basket/{itemName}")
  public void updateBasketQuantity(@PathVariable String itemName, @RequestBody int quantity) {
      basketService.updateBasketQuantity(itemName, quantity);
  }

  @DeleteMapping("/basket")
  public void clearBasket() {
    basketService.clearBasket();
  }
}
