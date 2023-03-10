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
    launchBrowser();
    }
    @When("open application url")
    public void open_application_url() {
    openUrl("https://admin-demo.nopcommerce.com/login");

    }
    @And("^enter(.*)and(.*)$")
    public void enter_user_password(String username, String password){
        login = new loginPage( driver);
    login.setUser_password(username,password);

    }
    @When("new enter username as {string} and password as {string}")
    public void new_enter_username_as_and_password_as(String u, String p) {
        login = new loginPage( driver);
    login.setUser_password(u, p);
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

        closeBrowser();
}
}
