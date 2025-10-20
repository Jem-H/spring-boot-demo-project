package com.example.demo;

import static org.assertj.core.api.Assertions.assertThat;

import java.math.BigDecimal;
import org.junit.jupiter.api.Test;

class ProductsServiceTest {

  private final Product product1 =
      new Product(
          "Sky F1",
          ProductType.SPORTS,
          "Watch every race of the season, exclusively on Sky Sports in the UK.",
          new BigDecimal("10.00"),
          12);

  private final Product product2 =
      new Product(
          "Sky Golf",
          ProductType.SPORTS,
          "Great for those who enjoy watching grass and sky in the same show.",
          new BigDecimal("15.00"),
          12);

  private final Product product3 =
      new Product(
          "Sky Tennis",
          ProductType.SPORTS,
          "Ideal for those who enjoy tennis beyond Wimbledon",
          new BigDecimal("15.50"),
          18);

  private final Product product4 =
      new Product(
          "Sky Football",
          ProductType.SPORTS,
          "Catch every premier league game of the season exclusively on Sky Sports.",
          new BigDecimal("15.00"),
          12);

  private final Product product5 =
      new Product(
          "Sky Horror",
          ProductType.MOVIES,
          "Ideal for the horror lover, you get it all. Now in HD",
          new BigDecimal("30.00"),
          12);

  private final Product product6 =
      new Product(
          "Sky Cinema",
          ProductType.MOVIES,
          "Ideal for the movie lover, all the movies, all day. Now in HD",
          new BigDecimal("30.00"),
          12);

  private final ProductsService productsService = new ProductsService();

  @Test
  void findAllProducts() {
    productsService.init();
    // This works (even without overriding the equals method)
    //    assertThat(productsService.getProducts())
    //        .usingRecursiveComparison()
    //        .ignoringCollectionOrder()
    //        .isEqualTo(mockProductList);

    // This works after overriding the equals method
    assertThat(productsService.getProducts())
        .containsExactlyInAnyOrder(product1, product2, product3, product4, product5, product6);
  }
}
