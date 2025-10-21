package com.example.demo;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class BasketControllerTest {

  @Mock BasketService basketService;
  @InjectMocks BasketController testee;

  private final Product product = new Product();
  private final BasketItem basketItem = new BasketItem(product, 1);
  private final BasketItem updatedBasketItem = new BasketItem(product, 2);

  @Test
  void getBasket_whenEmpty() {
    when(basketService.getBasketItems()).thenReturn(List.of());
    assertThat(testee.getBasket()).isEqualTo(new BasketResponse(List.of()));
  }

  @Test
  void getBasket_whenNotEmpty() {
    when(basketService.getBasketItems()).thenReturn(List.of(basketItem));
    assertThat(testee.getBasket()).isEqualTo(new BasketResponse(List.of(basketItem)));
  }

  @Test
  void addBasketItem() {
    testee.addBasketItem(basketItem);
    when(basketService.getBasketItems()).thenReturn(List.of(basketItem));
    verify(basketService).addBasketItem(basketItem);
    assertThat(testee.getBasket()).isEqualTo(new BasketResponse(List.of(basketItem)));
  }

  @Test
  void updateBasketQuantity() {
    testee.updateBasketQuantity(basketItem.getName(), basketItem.getQuantity() + 1);
    verify(basketService).updateBasketQuantity(basketItem.getName(), basketItem.getQuantity() + 1);
    when(basketService.getBasketItems()).thenReturn(List.of(updatedBasketItem));
    assertThat(testee.getBasket()).isEqualTo(new BasketResponse(List.of(updatedBasketItem)));
  }

  @Test
  void deleteBasketItem() {
    testee.clearBasket();
    verify(basketService).clearBasket();
    when(basketService.getBasketItems()).thenReturn(List.of());
    assertThat(testee.getBasket()).isEqualTo(new BasketResponse(List.of()));
  }
}
