package DriverFactory;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class TestBase
{
      public static WebDriver driver;
      public static Properties prop;

      //constructor that reads properties from property file
      public TestBase() {
          try {
            prop = new Properties();
            FileInputStream fi = new FileInputStream("D:\\Selenium Stuff\\Selenium Stuff\\Cucumber_ProjectERP\\AutomationTesting\\src\\main\\resources\\config.properties");
            prop.load(fi);
          }catch(IOException e){e.getMessage();}
      }


      //initialize browser
    public static void setUp()
    {
       String browserName = prop.getProperty("browser");

       if(browserName.equalsIgnoreCase("chrome")){
           WebDriverManager.chromedriver().setup();
           driver = new ChromeDriver();
       }else if(browserName.equalsIgnoreCase("FF")){
           WebDriverManager.firefoxdriver().setup();
           driver = new FirefoxDriver();
       }else if (browserName.equalsIgnoreCase("edge")){
           WebDriverManager.edgedriver().setup();
           driver = new EdgeDriver();
       }
       driver.manage().window().maximize();
       driver.manage().deleteAllCookies();
       driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
       driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
    }

}
