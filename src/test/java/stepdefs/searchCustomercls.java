package stepdefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.*;
import org.junit.Assert;
import pageObjects.searchCustomerPage;

public class searchCustomercls extends baseClass{

    @And("enter email {string}")
    public void enter_email(String email) {
    searchPage = new searchCustomerPage(driver);
    searchPage.setemail(email);
    }
    @When("enter customer name {string}")
    public void enter_customer_name(String Name) {
        searchPage = new searchCustomerPage(driver);
    searchPage.setname(Name);
    }
    @When("clicks on search button")
    public void clicks_on_search_button() throws InterruptedException {
    searchPage.search();
    Thread.sleep(3000);
    }
    @Then("user should found email")
    public void user_should_found_email() {

        searchPage.searchCustomerByEmail("y9vsq6al@gmail.com");
    }
    @Then("user should find name {string}")
    public void user_should_find_name(String name) {
   boolean status= searchPage.searchByName(name);
        //Assert.assertEquals(status, name);
    }
}
