package pageObjects;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import stepdefs.baseClass;

import java.util.List;

public class addCustomerPage extends baseClass {
    public WebDriver driver;
    public addCustomerPage(WebDriver driver){
       // this.driver = driver;
        PageFactory.initElements(driver, this);
    }
@FindBy(xpath = "(//p[contains(text(), 'Customers')])[1]")
WebElement customerMenu;
    @FindBy(xpath = "(//p[contains(text(), 'Customers')])[2]") WebElement customerItem;

    @FindBy(xpath = "/a[@class= 'btn btn-primary']") WebElement addNewCust;
    @FindBy(id = "Email") WebElement email;
    @FindBy(id = "Password") WebElement Password;
    @FindBy(id = "FirstName") WebElement FirstName;
    @FindBy(id = "LastName") WebElement LastName;
    @FindBy(id = "Gender_Male") WebElement Gender_Male;
    @FindBy(id = "DateOfBirth") WebElement DateOfBirth;

    @FindBy(id = "Company") WebElement Company;


    @FindBy(id = "AdminComment") WebElement AdminComment;
    @FindBy(xpath = "//button[@name='save']") WebElement save;
    @FindBy(xpath = "(//div[@class='k-widget k-multiselect k-multiselect-clearable'])[2]") WebElement roleBox;
@FindBy(xpath = "//ul[@id='SelectedCustomerRoleIds_listbox']/li") WebElement cRoles;
@FindBy(xpath = "//select[@id='VendorId']") WebElement vendor;
@FindBy(xpath = "//div[@class= 'alert alert-success alert-dismissable']") WebElement alertMsg;
    public String getPageTitle(){
        return driver.getTitle();
    }

    public void clickCustomerMenu(){
        customerMenu.click();

    }
    public void clickCustomerItem(){

        customerItem.click();
    }
    public void clickaddNewCust(){
        addNewCust.click();
    }
    public void setEmail(String email1){
        email.sendKeys(email1);
    }
    public void setFirstName(String fName){
        FirstName.sendKeys(fName);
    }
    public void setSecondName(String sName){
        LastName.sendKeys(sName);
    }
    public void genderSelect(){
        Gender_Male.click();
    }
    public void dob(String birthDate){
        DateOfBirth.sendKeys(birthDate);
    }

    public void setCustomerRole(String role){
        roleBox.click();
       List<WebElement> allroles = driver.findElements(By.xpath(String.valueOf(cRoles)));
        for(WebElement e : allroles){
        if(e.getText().equalsIgnoreCase(role)){
            e.click();
            break;
        }
        }
    }
    public void setManageVendor(String vendorName){
        Select select = new Select(vendor);
        select.deselectAll();
        select.selectByVisibleText(vendorName);
    }
    public void saveCustomer(){
        save.click();
    }
    public void verifyAlertMessage() throws InterruptedException {
        Thread.sleep(5000);
        boolean alertverify = alertMsg.isDisplayed();
        Assert.assertEquals(true, alertverify);
    }
}
