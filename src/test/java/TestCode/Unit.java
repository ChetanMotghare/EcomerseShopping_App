package TestCode;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import utility.ActionUtils;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class Unit extends ActionUtils{

    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        //driver.get("https://jqueryui.com/resources/demos/slider/default.html");
        driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
       driver.get("http://practice.automationtesting.in/shop/");
//Identify WebElement
        WebElement slider = driver.findElement(By.xpath("//div[@class='price_slider ui-slider ui-slider-horizontal ui-widget ui-widget-content ui-corner-all']//span[2]"));
       // WebElement slider1 = driver.findElement(By.xpath("//div[@class='price_slider ui-slider ui-slider-horizontal ui-widget ui-widget-content ui-corner-all']//span[1]"));
//Using Action Class
        Actions act = new Actions(driver);
        act.dragAndDropBy(slider,-80,300).perform();
        driver.findElement(By.cssSelector("button[type='submit']")).click();
      //List<WebElement> priceList = driver.findElements(By.xpath("//span[@class='woocommerce-Price-currencySymbol']"));
      //List<WebElement> priceList = driver.findElements(By.xpath("//span[@class='woocommerce-Price-currencySymbol']/child::text()"));
      List<WebElement> priceList = driver.findElements(By.xpath("//*[@id=\"content\"]/ul/li/a/span/span"));
        System.out.println(priceList.size());
      for(WebElement price:priceList)
        {
            String bookPrice = price.getText().replaceAll("[^0-9.]","");
            int actualPrice = Double.valueOf(bookPrice).intValue();
            if(360>=actualPrice)
            {
                System.out.println(300 + "::" + actualPrice);
            }
        }
        driver.quit();
        //move.clickAndHold(slider1).moveByOffset( 500, 0).build().perform();
        //action.perform();


       /* WebElement slider = driver.findElement(By.xpath("//span[@class='ui-slider-handle ui-corner-all ui-state-default']"));
        Actions action = new Actions(driver);
        action.dragAndDropBy(slider, 1200, 0).perform();*/

    }
}
