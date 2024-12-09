package pageObjects;

import driverManager.DriverManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPageObject {

    public LoginPageObject(){
        PageFactory.initElements(DriverManager.getDriver(),this);
    }

    @FindBy(xpath = "//input[@type='text']")
    WebElement txtUserName;
    @FindBy(xpath = "//input[@type='password']")
    WebElement txtPassword;
    @FindBy(xpath = "//input[@name='btnLogin']")
    WebElement btnLogin;
    @FindBy(xpath = "//a[text()='Log out']")
    WebElement btnLogout;

    public void setUserName(String uname){
        txtUserName.sendKeys(uname);
    }
    public void setPassword(String pwd){
        txtPassword.sendKeys(pwd);
    }
    public void clickSubmit(){
        btnLogin.click();
    }
    public void clickLogOut(){
        btnLogout.click();
    }
}
