package stepdefs;

import org.apache.commons.lang.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import pageObjects.addCustomerPage;
import pageObjects.loginPage;

public class baseClass {
    WebDriver driver = null;
    loginPage login;
     addCustomerPage addC;

     public static String randomString(){
         String generateString  = RandomStringUtils.randomAlphabetic(5);
         return generateString;
     }
}
