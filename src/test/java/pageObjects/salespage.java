package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import stepdefs.baseClass;

import java.util.List;

public class salespage  extends baseClass {
    //table[@id='orders-grid']/tbody//tr[1]/td/span

    public salespage(WebDriver driver){
        //this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "(//p[contains(text(), 'Sales')])[1]")
    WebElement salesBtn;
    @FindBy(xpath = "//p[contains(text(), ' Orders')]") WebElement ordersBtn;
    @FindBy(how = How.XPATH, using = " //table[@id='orders-grid']/tbody//tr")
    List<WebElement> tablerows;
    public void clickSales(){
        salesBtn.click();
    }
    public void clickOrders(){
        ordersBtn.click();
    }
    public int rowSize(){
        return tablerows.size();
    }
    public void validateOrderstatus(){
for(int i =1; i<=rowSize(); i++){
    String status = driver.findElement(By.xpath("//table[@id='orders-grid']/tbody//tr["+i+"]/td/span")).getText();
if(status.equalsIgnoreCase("complete")){
    String customer = driver.findElement(By.xpath("//table[@id='orders-grid']/tbody//tr["+i+"]/td[6]/a")).getText();
    String price = driver.findElement(By.xpath("//table[@id='orders-grid']/tbody//tr["+i+"]/td[9]")).getText();
    System.out.println(customer +"  :  "+price);
}else{
    System.out.println("not matched");
}
}
    }

}
