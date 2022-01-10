Feature: Validate Cart Product Price


  Scenario: Add Product to cart and Validate Price and Clear cart
    Given User is on Shopping App HomePage
    When  User Click on Women SubCategory
    And   User click on Top sub category
    And   User search product with some product name
    And   Add product to cart
    And   Get total price of product
    Then  compare with total price with actual
    When  Clear shopping cart
    Then  Check is cart is cleared or not


