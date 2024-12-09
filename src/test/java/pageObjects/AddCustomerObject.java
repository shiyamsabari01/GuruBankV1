package pageObjects;

import driverManager.DriverManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddCustomerObject {

    public AddCustomerObject(){
        PageFactory.initElements(DriverManager.getDriver(),this);
    }

    @FindBy(xpath = "//a[text()='New Customer']")
    WebElement linkAddCustomer;
    @FindBy(xpath = "//input[@name='name']")
    WebElement custName;
    @FindBy(xpath = "//input[@name='rad1']")
    WebElement gender;
    @FindBy(xpath = "//input[@name='dob']")
    WebElement DOB;
    @FindBy(xpath = "//textarea[@name='addr']")
    WebElement address;
    @FindBy(xpath = "//input[@name='city']")
    WebElement cityName;
    @FindBy(xpath = "//input[@name='state']")
    WebElement stateName;
    @FindBy(xpath = "//input[@name='pinno']")
    WebElement pinNum;
    @FindBy(xpath = "//input[@name='telephoneno']")
    WebElement teleNum;
    @FindBy(xpath = "//input[@name='emailid']")
    WebElement emailID;
    @FindBy(xpath = "//input[@name='sub']")
    WebElement subBtn;

    public void clickAddCustomer(){
        linkAddCustomer.click();
    }
    public void enterCustName(String cusName){
        custName.sendKeys(cusName);
    }
    public void enterGender(String rGender){
        gender.click();
    }
    public void selectDOB(String mm,String dd,String yy){
        DOB.sendKeys(mm);
        DOB.sendKeys(dd);
        DOB.sendKeys(yy);
    }
    public void enterAddress(String Add){
        address.sendKeys(Add);
    }
    public void enterCity(String Ccity){
        cityName.sendKeys(Ccity);
    }
    public void enterState(String Cstate){
        stateName.sendKeys(Cstate);
    }
    public void enterPIN(String cpin){
        pinNum.sendKeys(String.valueOf(cpin));
    }
    public void enterTele(String CTele){
        teleNum.sendKeys(CTele);
    }
    public void enterEMAIL(String CEmail){
        emailID.sendKeys(CEmail);
    }
    public void clickingSubmit(){
        subBtn.click();
    }
}
