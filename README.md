## Java Spring Boot Backend Practice Project

1. Building a spring boot project from https://start.spring.io/

2. Following https://spring.io/guides/gs/rest-service to build GreetingController (GET only)

3. Building my own controllers to maintain, retrieve and modify a Product list and a shopping Basket

4. Link up to a UI... maybe

## Running the project

- You require Java 21
- To start the project, do ./mvnw spring-boot:run at project root

## Endpoints
GET product list
http://localhost:8080/products

GET basket list
http://localhost:8080/products

POST - Add basket item
http://localhost:8080/basket
{
  "name": "blah",
  "quantity": 1
}

PATCH - Update item quantity
http://localhost:8080/basket/{itemName}

http://localhost:8080/basket/blah
50

DELETE - Clear basket list
http://localhost:8080/basket


