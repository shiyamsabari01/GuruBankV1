package testCases;

import driverManager.DriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.AddCustomerObject;
import pageObjects.LoginPageObject;
import utilities.Constants;

import java.util.concurrent.TimeUnit;

public class AddCustomer_Test extends BaseClass{
    private static final Logger LOGGER= LogManager.getLogger(AddCustomer_Test.class);

    @Test
    public void addCustomer(){
        try {
            LoginPageObject LP=new LoginPageObject();
            LP.setUserName(Constants.USERNAME);
            LOGGER.info("UserName Entered");
            LP.setPassword(Constants.PASSWORD);
            LOGGER.info("Password Entered");
            LP.clickSubmit();
            DriverManager.getDriver().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

            AddCustomerObject customerAdd= new AddCustomerObject();
            LOGGER.info("Navigating Customer Add page");
            customerAdd.clickAddCustomer();
            LOGGER.info("Customer Name Entered");
            customerAdd.enterCustName("LeoDos");
            LOGGER.info("Customer gender selected");
            customerAdd.enterGender("male");
            LOGGER.info("Customer DOB selected");
            customerAdd.selectDOB("12","01","98");
            DriverManager.getDriver().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
            LOGGER.info("Customer Address Entered");
            customerAdd.enterAddress("India");
            LOGGER.info("Customer City Name Entered");
            customerAdd.enterCity("Madurai");
            LOGGER.info("Customer State Name Entered");
            customerAdd.enterState("Tamilnadu");
            LOGGER.info("Customer Pincode Entered");
            customerAdd.enterPIN("625012");
            LOGGER.info("Customer Mobile Number Entered");
            customerAdd.enterTele("9000180001");
            String emailGenerate=randomString()+"@gmail.com";
            LOGGER.info("Customer Email Entered");
            customerAdd.enterEMAIL(emailGenerate);
            LOGGER.info("Customer Password Entered");
            customerAdd.enterPassword("Test@1234");
            customerAdd.clickingSubmit();

            boolean result=DriverManager.getDriver().getPageSource().contains("Customer Registered Successfully!!!");
            if(result==true){
                Assert.assertTrue(true);
                LOGGER.info("Add Customer Test case Passed");
            }else {
                LOGGER.info("Add Customer Test case Failed");
                takeScreenShot(DriverManager.getDriver(),"addCustomer");
                Assert.assertTrue(false);
            }

            WebElement CusId=DriverManager.getDriver().findElement(By.xpath("//table[@id='customer']//following::td[5]"));
            String CustomerId= CusId.getText();
            LOGGER.info("Customer Id is: "+CustomerId);
            System.out.println("Customer Id is: "+CustomerId);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
