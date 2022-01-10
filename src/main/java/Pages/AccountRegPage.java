package Pages;

import DriverFactory.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class AccountRegPage extends TestBase {


    //find elements
    @FindBy(xpath ="//input[@id='reg_email']")
    WebElement emailTextbox;
    @FindBy(xpath = "//input[@id='reg_password']")
    WebElement passTextbox ;
    @FindBy(xpath = "//input[@name='register']")
    WebElement registerBTN ;
    @FindBy(xpath = "//p[contains(text(),'Hello')]/child::strong")
    WebElement userNameVerify ;
    @FindBy(xpath = "//div[@id='body']//li[1]")
    WebElement errorMsg;
    @FindBy(xpath = "//a[@class='pull-down']")
    WebElement pullDown;

    //constructor to invoke page elements
    public AccountRegPage(){
        PageFactory.initElements(driver,this);
    }

    //methods to perform action on page
    public void openAccountPage(){driver.get(prop.getProperty("Regurl"));}

    public void enterEmail(){emailTextbox.sendKeys(prop.getProperty("emailid"));}

    public void enterEmail(String emailid){emailTextbox.sendKeys(emailid);}

    public void enterPassword() throws InterruptedException {
        passTextbox.sendKeys(prop.getProperty("pwd"));
        Actions act = new Actions(driver);
        act.moveToElement(pullDown).click().build().perform();
        Thread.sleep(2000);
        act.moveToElement(pullDown).click().build().perform();
        passTextbox.sendKeys("2");

    }
    public void enterPassword(String pwd){passTextbox.sendKeys(pwd);}

    public void clickRegisterBtn()  {
       WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
       wait.until(ExpectedConditions.elementToBeClickable(registerBTN)).click();
    }

    public void verifyUser() {
        String username = userNameVerify.getText();
        Assert.assertEquals(prop.getProperty("expeUsername"),username);
    }

    public void verifyWrongEmail(){
         String error = errorMsg.getText();
         Assert.assertEquals(error,prop.getProperty("errorMsg"));
         System.out.println("Error msg :: " + error);
    }

    public void verifyWrongPwd()
    {
        String error = errorMsg.getText();
        Assert.assertEquals(error,prop.getProperty("errorPwdMsg"));
        System.out.println("Error msg :: " + error );
    }
}
