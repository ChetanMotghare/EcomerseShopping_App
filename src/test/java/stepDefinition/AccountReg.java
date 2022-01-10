package stepDefinition;

import DriverFactory.TestBase;
import Pages.AccountRegPage;
import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;



public class AccountReg extends TestBase {
    AccountRegPage page ;
    private String verifyUser;


    @Given("User is on My Account Menu Page")
    public void user_is_on_My_Account_Menu_Page(){
        TestBase.setUp();
        page = new AccountRegPage();
        page.openAccountPage();
    }

    @When("Enter registered Email Address in Email-Address textbox")
    public void enter_registered_Email_Address_in_Email_Address_textbox() {page.enterEmail();}

    @When("Enter your own password in password textbox")
    public void enter_your_own_password_in_password_textbox() throws InterruptedException {page.enterPassword();}

    @When("Click on Register button")
    public void click_on_Register_button() {page.clickRegisterBtn();}

    @Then("User will be registered successfully and will be navigated to the Home page")
    public void user_will_be_registered_successfully_and_will_be_navigated_to_the_Home_page() {
        page.verifyUser();
    }

    @When("Keep Empty Email-Address textbox")
    public void keep_Empty_Email_Address_textbox() {page.enterEmail("");}

    @Then("Registration must fail with a warning message\\(ie You must enter a valid email address)")
    public void registration_must_fail_with_a_warning_message_ie_You_must_enter_a_valid_email_address() {
       page.verifyWrongEmail();
    }

    @When("Enter Valid Email Address in Email-Address textbox")
    public void enter_Valid_Email_Address_in_Email_Address_textbox() {page.enterEmail();}

    @When("Keep empty password textbox")
    public void keep_empty_password_textbox() {page.enterPassword("");}

    @Then("Registration must fail with a warning message\\(ie please enter an account password)")
    public void registration_must_fail_with_a_warning_message_ie_please_enter_an_account_password() {
      page.verifyWrongPwd();
    }

    @After
    public void tearDown()
    {
        driver.close();
    }


}
