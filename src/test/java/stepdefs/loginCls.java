package stepdefs;

import io.cucumber.java.en.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pageObjects.loginPage;

import java.util.concurrent.TimeUnit;

public class loginCls  extends baseClass{

    @Given("I launch chrome browser")
    public void i_launch_chrome_browser() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }
    @When("open application url")
    public void open_application_url() {
    driver.get("https://admin-demo.nopcommerce.com/login");
    driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
    driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
    }
    @And("^enter(.*)and(.*)$")
    public void enter_user_password(String username, String password){
        login = new loginPage( driver);
    login.setUser_password(username,password);

    }
    @And("click on submit")
    public void clicklogin() throws InterruptedException {
        login.clicklogin();
    }
    @Then("I verify logo on page")
    public void i_verify_logo_on_page() {

        login.verify_loginLogo();
    }
    @And("close browser")
    public void close_browser(){

        driver.close();
}
}
