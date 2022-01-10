package Pages;

import DriverFactory.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import java.util.List;

import static utility.ActionUtils.*;

public class ShopPage extends TestBase {

    //page element
    @FindBy(xpath ="//div[@class='price_slider ui-slider ui-slider-horizontal ui-widget ui-widget-content ui-corner-all']//span[2]")
    WebElement slider2;
    @FindBy(xpath = "//div[@class='price_slider ui-slider ui-slider-horizontal ui-widget ui-widget-content ui-corner-all']//span[1]")
    WebElement slider1;
    @FindBy(css = "button[type='submit']")
    WebElement filterBtn ;
    @FindBy(xpath = "//*[@id=\"content\"]/ul/li/a/span/span")
    List<WebElement> priceList ;
    @FindBy(xpath = "//*[@id=\"content\"]/ul/li[1]/a[2]")
    WebElement ClickaddToBasket ;
    @FindBy(xpath = "//span[@class='amount']")
    WebElement viewItem ;
    @FindBy(xpath = "//a[normalize-space()='View Basket']")
    WebElement ViewBasket ;
    @FindBy(xpath = "//*[@id=\"content\"]/ul/li[1]/a[1]/span[2]/ins/span")
    WebElement bookprice;
    @FindBy(xpath = "//a[normalize-space()='Proceed to Checkout']")
    WebElement checkOutBtn;


    //constructor to invoke page element
    public ShopPage() {PageFactory.initElements(driver,this);}


    public void openAccountPage(){driver.get(prop.getProperty("ShopUrl"));}

    public void moveSlider(){priceSlider(slider2,-120);}

    public void clickOnFilterBtn() {filterBtn.click();}

    public void comparePrice() {extractPrice(priceList,350);}

    public void addToBasket() {ClickaddToBasket.click();}

    public void clickviewBasket() {ViewBasket.click();}

    public void clickCheckOutBtn() {checkOutBtn.click();}



    public void viewItemPrice()
    {
        String viewItemprice = viewItem.getText().replaceAll("[^0-9.]","");
        int viewItem = Double.valueOf(viewItemprice).intValue();
        String subTotalPrice =  bookprice.getText().replaceAll("[^0-9.]","");
        int actualPrice = Double.valueOf(subTotalPrice).intValue();
        Assert.assertEquals(actualPrice,viewItem);
    }

}
