package com.example.demo;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class BasketController {

  private final BasketService basketService;

  @GetMapping("/basket")
  public BasketResponse getBasket() {
    return new BasketResponse(basketService.getBasketItems());
  }
}
