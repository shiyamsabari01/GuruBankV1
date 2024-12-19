package pageObjects;

import driverManager.DriverManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FundTransferObject {

    public FundTransferObject(){
        PageFactory.initElements(DriverManager.getDriver(),this);
    }

    @FindBy(xpath = "//ul[@class='menusubnav']//following::a[text()='Fund Transfer']")
    WebElement fundTransferPage;
    @FindBy(xpath = "//input[@name='payersaccount']")
    WebElement payersAccountNo;
    @FindBy(xpath = "//input[@name='payeeaccount']")
    WebElement payeeAccountNo;
    @FindBy(xpath = "//input[@name='ammount']")
    WebElement amount;
    @FindBy(xpath = "//input[@name='desc']")
    WebElement description;
    @FindBy(xpath = "//input[@name='AccSubmit']")
    WebElement accSubmit;
    @FindBy(xpath = "//input[@name='res']")
    WebElement accReset;

    public void navigateFundTransfer(){
      fundTransferPage.click();
    }
    public void enterPayersAccountNo(String CPayersAccountNo){
        payersAccountNo.sendKeys(CPayersAccountNo);
    }
    public void enterPayeeAccountNumber(String CPayeeAccountNo){
        payeeAccountNo.sendKeys(CPayeeAccountNo);
    }
    public void enterAmount(String Amount){
        amount.sendKeys(Amount);
    }
    public void enterDesc(String Desc){
        description.sendKeys(Desc);
    }
    public void clickAccountSubmit(){
        accSubmit.click();
    }
    public void clickAccountReset(){
        accReset.click();
    }
}
