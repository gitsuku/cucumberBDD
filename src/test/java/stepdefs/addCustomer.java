package stepdefs;

import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pageObjects.addCustomerPage;

public class addCustomer extends baseClass{
    //WebDriver driver;

     //addC = new addCustomerPage(driver);
    @Then("user can view dashboard")
    public void user_can_view_dashboard() throws InterruptedException {
        System.out.println("user dashboard page");
       addC = new addCustomerPage(driver);
    Thread.sleep(4000);
    String title = addC.verifyDashboard();
        Assert.assertEquals("Dashboard", title );
    }

    @When("user clicks on customer menu")
    public void user_clicks_on_customer_menu() {
addC.clickCustomerMenu();
    }

    @And("clicks on customer menu item")
    public void clicks_on_customer_menu_item() {
addC.clickCustomerItem();
    }

    @And("clicks on add new button")
    public void clicks_on_add_new_button() {
addC.clickaddNewCust();
    }

    @Then("user can view add new customer page")
    public void user_can_view_add_new_customer_page() throws InterruptedException {
    Thread.sleep(3000);
    Assert.assertEquals("Add a new customer / nopCommerce administration", addC.getPageTitle());
    }

    @When("user enter customer info")
    public void user_enter_customer_info() throws InterruptedException {
    String email = randomString()+"@gmail.com";
    addC.setEmail(email);
    addC.setFirstName("sukumar");
    addC.setSecondName("suk");
    addC.dob("7/02/2000");
    addC.genderSelect();
    addC.setCustomerRole("guests");
    addC.setManageVendor("Vendor 1");
    }

    @And("clicks on save button")
    public void clicks_on_save_button() {
    addC.saveCustomer();
    }

    @Then("user can see confirmation message")
    public void user_can_see_confirmation_message(String string) throws InterruptedException {
    addC.verifyAlertMessage();
    }

}
