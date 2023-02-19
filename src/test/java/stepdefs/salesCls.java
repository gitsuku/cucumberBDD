package stepdefs;

import io.cucumber.java.en.*;
import pageObjects.salespage;

public class salesCls extends baseClass{

    @When("user clicks on salesmenu")
    public void user_clicks_on_salesmenu() {
        salesP = new salespage(driver);
        salesP.clickSales();
    }
    @And("clicks on orders button")
    public void clicks_on_orders_button() {
        salesP.clickOrders();
    }
    @Then("verify orders status")
    public void verify_orders_status() {
        salesP.validateOrderstatus();
    }
}
