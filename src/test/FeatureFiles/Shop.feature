Feature: Check shop functionality


  Scenario: Verify Shop-Filter By Price Functionality
    Given User is on Shop page
    When  Adjust filter by price
    And   Click on filter button
    Then  User can view books only between  adjusted price

  @valid
  Scenario: Shop-Product Categories Functionality
    Given User is on Shop page
    When  Click on the Add To Basket button which adds that book to your basket
    #Then  User can view that Book in the Menu item with price.
    When  Now click on View Basket link which navigates to proceed to check out page.
    #Then  Now user can find total and subtotal values just above the Proceed to Checkout button.
    When  Now click on Proceed to Check out button which navigates to payment gateway page.
    When  Now user can fill his details in billing details form and can opt any payment in the payment gateway like Direct bank transfer,cheque,cash or paypal.
          | firstName |jone                |
          | lastname  |Broad               |
          | email     |jonebroad@gmail.com |
          | phone     |89082637364         |
          |country    |India               |
          |address    |Mannat ApartMent    |
          |city       |sans                |
          |state      |Bihar               |
          |zip        |441208              |
    Then  Now user can find total and subtotal values just above the Proceed to Checkout button.
    When  Now click on Place Order button to complete process
    Then  Check Order confirmation page with order details,bank details,customer details and billing details.


  Scenario: Shop-Add to Basket-View Basket-Tax Functionality
    Given User is on Shop page
    When  Click on the Add To Basket button which adds that book to your basket
    Then  User can view that Book in the Menu item with price.
    When  Now click on View Basket link which navigates to proceed to check out page.
    Then  Now user can find total and subtotal values just above the Proceed to Checkout button.
    When  Now click on Proceed to Check out button which navigates to payment gateway page.
    Then  Tax rate for indian should be 2% and for abroad it should be 5%
