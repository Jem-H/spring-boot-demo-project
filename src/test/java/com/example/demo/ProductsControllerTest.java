package com.example.demo;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

import java.math.BigDecimal;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class ProductsControllerTest {

  private final List<Product> mockProductList =
      List.of(
          new Product(
              "Sky F1",
              ProductType.SPORTS,
              "Watch every race of the season, exclusively on Sky Sports in the UK.",
              new BigDecimal("10.00"),
              12));

  @Mock private ProductsService productsService;
  @InjectMocks private ProductsController testee;

  @Test
  void getProducts_whenEmptyList_shouldReturnEmptyList() {
    when(productsService.getProducts()).thenReturn(List.of());
    assertThat(testee.getProducts()).isEqualTo(new ProductsResponse(List.of()));
  }

  @Test
  void getProducts_whenProductsExist_shouldReturnProducts() {
    when(productsService.getProducts()).thenReturn(mockProductList);
    assertThat(testee.getProducts()).isEqualTo(new ProductsResponse(mockProductList));
  }
}
