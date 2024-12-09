package testCases;

import driverManager.DriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;
import pageObjects.AddCustomerObject;
import pageObjects.LoginPageObject;
import utilities.Constants;

import java.util.concurrent.TimeUnit;

public class AddCustomer_Test extends BaseClass{
    private static final Logger LOGGER= LogManager.getLogger(AddCustomer_Test.class);

    @Test
    public void addCustomer(){
        LoginPageObject LP=new LoginPageObject();
        LP.setUserName(Constants.USERNAME);
        LOGGER.info("UserName Entered");
        LP.setPassword(Constants.PASSWORD);
        LOGGER.info("Password Entered");
        LP.clickSubmit();
        DriverManager.getDriver().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        AddCustomerObject customerAdd= new AddCustomerObject();
        customerAdd.clickAddCustomer();
        customerAdd.enterCustName("Sabari");
        customerAdd.enterGender("male");
        customerAdd.selectDOB("12","01","98");
        DriverManager.getDriver().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        customerAdd.enterAddress("India");
        customerAdd.enterCity("Madurai");
        customerAdd.enterState("Tamilnadu");
        customerAdd.enterPIN("625012");
        customerAdd.enterTele("9000180001");
        String emailGenerate=randomString()+"@gmail.com";
        customerAdd.enterEMAIL(emailGenerate);
        customerAdd.clickingSubmit();
        DriverManager.getDriver().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

    }
}
