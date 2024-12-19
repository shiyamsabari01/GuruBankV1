package pageObjects;

import driverManager.DriverManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EditCustomerObject {

    public EditCustomerObject() {
        PageFactory.initElements(DriverManager.getDriver(), this);
    }
    @FindBy(xpath = "//ul[@class='menusubnav']/li/a[text()='Edit Customer']")
    WebElement editCustomerPage;
    @FindBy(xpath = "//input[@name='cusid']")
    WebElement custId;
    @FindBy(xpath = "//input[@name='AccSubmit']")
    WebElement submitBtn;
    @FindBy(xpath="//input[@name='res']")
    WebElement resetBtn;

    public void navigateEditCustomer(){
        editCustomerPage.click();
    }
    public void enetrCustomerId(String CID){
        custId.sendKeys(CID);
    }
    public void clickSubmit(){
        submitBtn.click();
    }
    public void clickReset(){
        resetBtn.click();

    }
}
