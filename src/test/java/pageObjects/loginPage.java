package pageObjects;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import stepdefs.baseClass;

public class loginPage extends baseClass {

    public loginPage(WebDriver driver){
        //this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    @FindBy(id = "Email")
    WebElement username;
    @FindBy(id = "Password") WebElement password;
    @FindBy(xpath = "//button[text() = 'Log in']") WebElement loginbtn;
    @FindBy(xpath = "//img[@class='brand-image-xl logo-xl']") WebElement logo;
    public void setUser_password(String user, String pass){
        username.clear();
        username.sendKeys(user);
        password.clear();
        password.sendKeys(pass);
    }
    public void clicklogin() throws InterruptedException {

        loginbtn.click();
        Thread.sleep(5000);
    }
    public void verify_loginLogo(){
        boolean verifyLogo = logo.isDisplayed();
        Assert.assertTrue(verifyLogo);
    }
}
