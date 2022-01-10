package Pages;

import DriverFactory.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

import static utility.ActionUtils.action;
import static utility.ActionUtils.dropDown;

public class CheckOutPage {

    @FindBy(xpath = "//input[@id='billing_first_name']")
    WebElement firstName;
    @FindBy(xpath = "//input[@id='billing_last_name']")
    WebElement lastName;
    @FindBy(xpath = "//input[@id='billing_email']")
    WebElement emailId;
    @FindBy(xpath = "//input[@id='billing_phone']")
    WebElement phone;
    @FindBy(xpath = "//div[@class=\"select2-result-label\"]")
    List<WebElement> countryList;
    @FindBy(xpath = "//div[@id='s2id_billing_country']//a[@class='select2-choice']")
    WebElement countryDropDown;
    @FindBy(xpath = "//input[@id='s2id_autogen1_search']")
    WebElement countryInput;
    @FindBy(xpath = "//input[@id='billing_address_1']")
    WebElement address;
    @FindBy(xpath = "//input[@id='billing_city']")
    WebElement townCity;
    @FindBy(xpath = "//span[contains(text(),'Select an option…')]")
    WebElement stateDropDown;
    @FindBy(xpath = "//li[@role='presentation']")
    List<WebElement> stateList;
    @FindBy(xpath = "//input[@id='billing_postcode']")
    WebElement zipCode;
    @FindBy(xpath = "//input[@id='payment_method_cod']")
    WebElement CODbtn;

    @FindBy(xpath = "//td[@class='product-total']//span[@class='woocommerce-Price-amount amount']")
    WebElement subTotal;
    @FindBy(xpath = "//tr[@class='tax-rate tax-rate-in-tax-1']//span[@class='woocommerce-Price-amount amount']")
    WebElement tax;
    @FindBy(xpath = "//tr[@class='order-total']//span[@class='woocommerce-Price-amount amount']")
    WebElement total;

    @FindBy(xpath = "//input[@id='place_order']")
    WebElement placeOrderBtn;
    @FindBy(xpath = "//ul[@class='woocommerce-thankyou-order-details order_details']")
    List<WebElement> orderDetails;

    @FindBy(xpath = "//li[@class='total']//span[@class='woocommerce-Price-amount amount']")
    WebElement finalPriceOnBill;

    public CheckOutPage() {
        PageFactory.initElements(TestBase.driver,this);
    }

    public void fillForm(String firstName,String lastName,String emailId,String phone,String countryName,String address,String townCity,String state,String zipCode)
    {
        this.firstName.sendKeys(firstName);
        this.lastName.sendKeys(lastName);
        this.emailId.sendKeys(emailId);
        this.phone.sendKeys(phone);
        dropDown(countryDropDown,countryList,countryName);
        this.address.sendKeys(address);
        this.townCity.sendKeys(townCity);
        dropDown(stateDropDown,stateList,state);
        this.zipCode.sendKeys(zipCode);
    }

    public void compareSubtotalPrice()
    {
        String subPrice = subTotal.getText().replaceAll("[^0-9.]","");
        double subTotalPrice = Double.parseDouble(subPrice);
        String totalPrice = total.getText().replaceAll("[^0-9.]","");
        //int actualPrice = Double.valueOf(subTotalPrice).intValue();
        double priceAfterTax = Double.parseDouble(totalPrice);
        System.out.println("Subtotal Price :: " + subTotalPrice + " Total price :: " + priceAfterTax);
        if(priceAfterTax > subTotalPrice)
        {
            System.out.println("Tax on book :: " + (priceAfterTax - subTotalPrice));
        }
    }

    public void clickOnPlaceOrder()
    {
        action(CODbtn);
        placeOrderBtn.click();
    }

    public void getOrderDetails()
    {
        String subPrice = finalPriceOnBill.getText().replaceAll("[^0-9.]","");
        double subTotalPrice = Double.parseDouble(subPrice);
        for(WebElement order:orderDetails) {
            System.out.println(order.getText());
        }
    }
}
