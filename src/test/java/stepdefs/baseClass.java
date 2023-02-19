package stepdefs;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.lang.RandomStringUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import pageObjects.addCustomerPage;
import pageObjects.loginPage;
import pageObjects.salespage;
import pageObjects.searchCustomerPage;

import java.util.concurrent.TimeUnit;

public class baseClass {



   public static WebDriver driver;
    public loginPage login;
    public  addCustomerPage addC;
    public searchCustomerPage searchPage;
    public salespage salesP;
     public static String randomString(){
         String generateString  = RandomStringUtils.randomAlphabetic(5);
         return generateString;
     }
    public static void launchBrowser() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }
     public static void closeBrowser(){
        driver.close();
     }
     public static void openUrl(String url){
         driver.get(url);
         driver.manage().window().maximize();
         driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
         driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
     }
     public static void clickwithJavascript(WebElement element){
         JavascriptExecutor executor = (JavascriptExecutor)driver;
         executor.executeScript("arguments[0].click();", element);
     }
}
