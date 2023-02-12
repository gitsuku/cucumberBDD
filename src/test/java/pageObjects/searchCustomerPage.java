package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import stepdefs.baseClass;

import java.util.List;

public class searchCustomerPage  extends baseClass {
    public searchCustomerPage(WebDriver driver){
        //this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "SearchEmail") WebElement txtEmail;
    @FindBy(id = "SearchFirstName") WebElement firstname;
    @FindBy(id = "SearchLastName") WebElement lastname;
    @FindBy(id = "search-customers") WebElement search;
    @FindBy(how = How.XPATH, using = "//table[@id ='customers-grid']//tbody/tr")
    List<WebElement> tablerows;
    @FindBy(how = How.XPATH, using = "//table[@id ='customers-grid']//tbody//tr/td[2]")
    List<WebElement> tabcolumns;

    public void setemail(String mail){
        txtEmail.sendKeys(mail);
    }
    public void setname(String name){
        String [] names = name.split(" ");
        firstname.sendKeys(names[0]);
        lastname.sendKeys(names[1]);

    }
    public void setFirstName(String fName){
        firstname.sendKeys(fName);
    }
    public void setSectName(String sName){
        lastname.sendKeys(sName);
    }
public void search() throws InterruptedException {

        search.click();
        Thread.sleep(3000);
}
public int getNoOfRows(){
        return (tablerows.size());
}
    public int getNoOfColomns(){
        return (tabcolumns.size());
    }

    public boolean searchCustomerByEmail(String email){
        boolean flag = false;
        for (int i =1; i<= getNoOfRows(); i++){
            String emailID = driver.findElement(By.xpath("//table[@id ='customers-grid']//tbody//tr["+i+"]/td[2]")).getText();
            System.out.println("============= "+emailID);
            if(emailID.equals(email)){
                flag = true;
            }
        }
        return flag;

    }
    public boolean searchByName(String n){
        boolean flag = false;
        String [] expectedname = n.split(" ");
        for (int i =1; i<= getNoOfRows(); i++){
            String name = driver.findElement(By.xpath("//table[@id ='customers-grid']//tbody//tr["+i+"]/td[3]")).getText();
            String [] names = name.split(" ");

            System.out.println("============= "+name);
            if(names[0].equals(expectedname[0]) && names[1].equals(expectedname[1])){
                flag = true;
            }
        }

        return flag;
    }
}
