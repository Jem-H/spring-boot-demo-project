package com.example.demo;

import static org.assertj.core.api.Assertions.assertThat;

import java.math.BigDecimal;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BasketServiceTest {

  private BasketService basketService;

  private final Product product =
      new Product(
          "Sky F1",
          ProductType.SPORTS,
          "Watch every race of the season, exclusively on Sky Sports in the UK.",
          new BigDecimal("10.00"),
          12);
  private final BasketItem item1 = new BasketItem(product, 1);
  private final BasketItem item2 = new BasketItem();

  @BeforeEach
  void setUp() {
    basketService = new BasketService();
    basketService.addBasketItem(item1);
  }

  @Test
  void getBasketItems_whenEmpty() {
    basketService = new BasketService();
    assertThat(basketService.getBasketItems()).isEqualTo(List.of());
  }

  @Test
  void getBasketItems_whenNotEmpty() {
    assertThat(basketService.getBasketItems()).isEqualTo(List.of(item1));
  }

  @Test
  void addBasketItem_forNewBasketItem() {
    basketService.addBasketItem(item2);
    assertThat(basketService.getBasketItems()).containsExactlyInAnyOrder(item1, item2);
  }

  @Test
  void addBasketItem_shouldNotAddDuplicateBasketItem() {
    basketService.addBasketItem(item1);
    assertThat(basketService.getBasketItems()).isEqualTo(List.of(item1));
  }

  @Test
  void updateBasketQuantity() {
    basketService.updateBasketQuantity(item1.getName(), 5);
    assertThat(item1.getQuantity()).isEqualTo(6);
  }

  @Test
  void clearBasket() {
    basketService.clearBasket();
    assertThat(basketService.getBasketItems()).isEqualTo(List.of());
  }
}
