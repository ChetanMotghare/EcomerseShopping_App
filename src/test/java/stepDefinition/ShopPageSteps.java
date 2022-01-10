package stepDefinition;

import DriverFactory.TestBase;
import Pages.CheckOutPage;
import Pages.ShopPage;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.jetbrains.annotations.NotNull;

import java.util.List;


public class ShopPageSteps extends TestBase{
    private ShopPage shopPage;
    private CheckOutPage check;

    @Given("User is on Shop page")
    public void user_is_on_Shop_page() {
        TestBase.setUp();
        shopPage = new ShopPage();
        shopPage.openAccountPage();
    }

    @When("Adjust filter by price")
    public void adjust_filter_by_price() {
      shopPage.moveSlider();
    }

    @When("Click on filter button")
    public void click_on_filter_button() {
       shopPage.clickOnFilterBtn();
    }

    @Then("User can view books only between  adjusted price")
    public void user_can_view_books_only_between_adjusted_price() {
        shopPage.comparePrice();
    }

    @When("Click on the Add To Basket button which adds that book to your basket")
    public void click_on_the_Add_To_Basket_button_which_adds_that_book_to_your_basket() {
       shopPage.addToBasket();
    }

   /* @Then("User can view that Book in the Menu item with price.")
    public void user_can_view_that_Book_in_the_Menu_item_with_price() {
         spage.viewItemPrice();
    }*/

    @When("Now click on View Basket link which navigates to proceed to check out page.")
    public void now_click_on_View_Basket_link_which_navigates_to_proceed_to_check_out_page() {
      shopPage.clickviewBasket();
    }

    @Then("Now user can find total and subtotal values just above the Proceed to Checkout button.")
    public void now_user_can_find_total_and_subtotal_values_just_above_the_Proceed_to_Checkout_button() {
          check.compareSubtotalPrice();
    }

    @When("Now click on Proceed to Check out button which navigates to payment gateway page.")
    public void now_click_on_Proceed_to_Check_out_button_which_navigates_to_payment_gateway_page() {
           shopPage.clickCheckOutBtn();
    }

    @When("Now user can fill his details in billing details form and can opt any payment in the payment gateway like Direct bank transfer,cheque,cash or paypal.")
    public void now_user_can_fill_his_details_in_billing_details_form_and_can_opt_any_payment_in_the_payment_gateway_like_Direct_bank_transfer_cheque_cash_or_paypal(@NotNull DataTable dataTable) {
       List<List<String>> data = dataTable.asLists(String.class);
       check = new CheckOutPage();
       check.fillForm(data.get(0).get(1),data.get(1).get(1),data.get(2).get(1),data.get(3).get(1),
                data.get(4).get(1),data.get(5).get(1),data.get(6).get(1),data.get(7).get(1),data.get(8).get(1));
    }
    @When("Now click on Place Order button to complete process")
    public void now_click_on_Place_Order_button_to_complete_process() {
        check.clickOnPlaceOrder();
    }

    @Then("Check Order confirmation page with order details,bank details,customer details and billing details.")
    public void check_Order_confirmation_page_with_order_details_bank_details_customer_details_and_billing_details() {
        check.getOrderDetails();
    }

    @Then("Tax rate for indian should be {int}% and for abroad it should be {int}%")
    public void tax_rate_for_indian_should_be_and_for_abroad_it_should_be(Integer int1, Integer int2) {


    }

    @Then("User can view that Book in the Menu item with price.")
    public void userCanViewThatBookInTheMenuItemWithPrice() {
    }
}
