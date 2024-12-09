package testCases;

import driverManager.DriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.LoginPageObject;
import utilities.Constants;

public class LoginPage_Test extends BaseClass {
    private static final Logger LOGGER = LogManager.getLogger(LoginPage_Test.class);

    @Test
    public void loginTest() {
        LoginPageObject LP = new LoginPageObject();
        LP.setUserName(Constants.USERNAME);
        LOGGER.info("UserName Entered");
        LP.setPassword(Constants.PASSWORD);
        LOGGER.info("Password Entered");
        LP.clickSubmit();
        LOGGER.info("Home Page Entered");
        LOGGER.info("Verifying the Page Title");
        if (DriverManager.getDriver().getTitle().equalsIgnoreCase("gtpl bank manager homepage")) {
            Assert.assertTrue(true);
            LOGGER.info("Login Test Passed");
        } else {
            takeScreenShot(DriverManager.getDriver(),"loginTest");
            Assert.assertTrue(false);
            LOGGER.info("Login Test Failed");
        }
    }
}
