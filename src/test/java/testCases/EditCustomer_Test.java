package testCases;

import driverManager.DriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.EditCustomerObject;
import pageObjects.LoginPageObject;
import utilities.Constants;

public class EditCustomer_Test extends BaseClass {
    private static final Logger LOGGER = LogManager.getLogger(EditCustomer_Test.class);

    @Test
    public void editCustomer() {
        try {
            LoginPageObject LP = new LoginPageObject();
            LP.setUserName(Constants.USERNAME);
            LP.setPassword(Constants.PASSWORD);
            LP.clickSubmit();

            EditCustomerObject editCustomer = new EditCustomerObject();
            editCustomer.navigateEditCustomer();
            editCustomer.enetrCustomerId("45111");
            editCustomer.clickSubmit();

            boolean res = DriverManager.getDriver().getPageSource().contains("Edit Customer");
            if (res == true) {
                LOGGER.info("Edit Customer Test case Passed");
                Assert.assertTrue(true);
            } else {
                LOGGER.info("Edit Customer Test case Failed");
                takeScreenShot(DriverManager.getDriver(), "editCustomer");
                Assert.assertTrue(false);
            }
            System.out.println(res);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
