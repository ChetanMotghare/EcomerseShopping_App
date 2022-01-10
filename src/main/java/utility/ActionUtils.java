package utility;
import DriverFactory.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

public class ActionUtils extends TestBase {

   //private static WebElement driver;
    public static void priceSlider(WebElement slider,int x)
    {
        Actions act = new Actions(driver);
        act.dragAndDropBy(slider, x, 300).build().perform();
    }

    public static void action(WebElement element)
    {
        Actions act = new Actions(driver);
        act.moveToElement(element).click().perform();
    }

    public static void extractPrice(List<WebElement> priceList,int filterPrice)
    {
        for(WebElement price:priceList)
        {
            String bookPrice = price.getText().replaceAll("[^0-9.]","");
            int actualPrice = Double.valueOf(bookPrice).intValue();
            if(filterPrice>=actualPrice)
            {
                System.out.println(filterPrice + "::" + actualPrice);
            }
        }
    }

    public static void dropDown(WebElement selectDropDown,List<WebElement> countries,String countryName) {
        selectDropDown.click();
        for(int i = 0; i<=countries.size()-1; i++) {
            if(countries.get(i).getText().equals(countryName)) {
                countries.get(i).click();
                break;
            }
        }

    }
}
