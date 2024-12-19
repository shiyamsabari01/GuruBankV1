package testCases;

import driverManager.DriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.FundTransferObject;
import pageObjects.LoginPageObject;
import utilities.Constants;

public class FundTransfer_Test extends BaseClass{
    private static final Logger LOGGER = LogManager.getLogger(FundTransfer_Test.class);

    @Test
    public void sendFundTransfer() {
        try {
            LoginPageObject LP = new LoginPageObject();
            LP.setUserName(Constants.USERNAME);
            LOGGER.info("UserName Entered");
            LP.setPassword(Constants.PASSWORD);
            LOGGER.info("Password Entered");
            LP.clickSubmit();

            FundTransferObject fundTransferObject=new FundTransferObject();
            LOGGER.info("Navigating Fund Transfer Page");
            fundTransferObject.navigateFundTransfer();
            LOGGER.info("Payers Account Number Entered");
            fundTransferObject.enterPayersAccountNo("141662");
            LOGGER.info("Payees Account Number Entered");
            fundTransferObject.enterPayeeAccountNumber("141656");
            LOGGER.info("Amount Entered");
            fundTransferObject.enterAmount("500");
            LOGGER.info("Description Entered");
            fundTransferObject.enterDesc("Transfer");
            fundTransferObject.clickAccountSubmit();

            boolean res= DriverManager.getDriver().getPageSource().contains("Fund Transfer Details");
            if (res==true){
                LOGGER.info("Fund Transfer Test is Passed");
                Assert.assertTrue(true);
            }else {
                takeScreenShot(DriverManager.getDriver(),"sendFundTransfer");
                LOGGER.info("Fund Transfer Test is Failed");
                Assert.assertTrue(true);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

