package pageObjects;

import driverManager.DriverManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NewAccountObject {

    public NewAccountObject(){
        PageFactory.initElements(DriverManager.getDriver(),this);
    }

    @FindBy(xpath = "//ul[@class='menusubnav']/li/a[text()='New Account']")
    WebElement newAccountPage;
    @FindBy(xpath = "//input[@name='cusid']")
    WebElement accounCusId;
    @FindBy(xpath = "//select[@name='selaccount']")
    WebElement accountType;
    @FindBy(xpath = "//input[@name='inideposit']")
    WebElement initialDeposit;
    @FindBy(xpath = "//input[@name='button2']")
    WebElement sutBtn2;
    @FindBy(xpath = "//input[@name='reset']")
    WebElement rstBtn;

    public void naviagteAccountPage(){
        newAccountPage.click();
    }
    public void enterCustIdNewAccount(String CustId){
        accounCusId.sendKeys(CustId);
    }
    public WebElement selectAccountType(){
        return accountType;
    }
    public void enterInitialDeposit(String amount){
        initialDeposit.sendKeys(amount);
    }
    public void selectSubmit(){
        sutBtn2.click();
    }
    public void selectResetBtn(){
        rstBtn.click();
    }

}
