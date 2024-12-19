package testCases;

import driverManager.DriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.LoginPageObject;
import pageObjects.NewAccountObject;
import utilities.Constants;

import java.util.concurrent.TimeUnit;

public class NewAccount_Test extends BaseClass{
    private static final Logger LOGGER= LogManager.getLogger(NewAccount_Test.class);
    @Test
    public void createNewAccount() {
        try {
            DriverManager.getDriver().manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
            LoginPageObject LP=new LoginPageObject();
            LP.setUserName(Constants.USERNAME);
            LOGGER.info("UserName Entered");
            LP.setPassword(Constants.PASSWORD);
            LOGGER.info("Password Entered");
            LP.clickSubmit();

            NewAccountObject accountObject=new NewAccountObject();
            LOGGER.info("Navigating New Account Page");
            accountObject.naviagteAccountPage();
            LOGGER.info("Customer Id Entered");
            accountObject.enterCustIdNewAccount("45111");
            LOGGER.info("Account Type selected");
            selectDropDown(accountObject.selectAccountType(), "visibleText","Savings");
            LOGGER.info("Entered Initial Deposit");
            accountObject.enterInitialDeposit("2000");
            accountObject.selectSubmit();
            boolean accRes=DriverManager.getDriver().getPageSource().contains("Account Generated Successfully!!!");
            if(accRes==true){
                Assert.assertTrue(true);
                LOGGER.info("New Account Created");
            }else{
                takeScreenShot(DriverManager.getDriver(),"createNewAccount");
                Assert.assertTrue(false);
                LOGGER.info("New Account NOT Created");
            }

            WebElement acccountId=DriverManager.getDriver().findElement(By.xpath("//table[@id='account']//following::td[5]"));
            String AccId=acccountId.getText();
            LOGGER.info("Account Id is: "+AccId);
            System.out.println(AccId);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
