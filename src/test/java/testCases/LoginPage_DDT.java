package testCases;

import driverManager.DriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pageObjects.LoginPageObject;
import utilities.ExcelUtils;

import java.io.IOException;

@Test(dataProvider = "LoginData")
public class LoginPage_DDT extends BaseClass {
    private static final Logger LOGGER= LogManager.getLogger(LoginPage_DDT.class);

    public void loginDTT(String user,String pwd) {
        LoginPageObject login=new LoginPageObject();
        login.setUserName(user);
        LOGGER.info("User Name Provided");
        login.setPassword(pwd);
        LOGGER.info("Password Provided");
        login.clickSubmit();

        if (isAlertIsPresent()==true){
            DriverManager.getDriver().switchTo().alert().accept();
            DriverManager.getDriver().switchTo().defaultContent();
            Assert.assertTrue(false);
            LOGGER.info("Login Failed");
        }else {
            Assert.assertTrue(true);
            LOGGER.info("Login Passed");
            login.clickLogOut();
            DriverManager.getDriver().switchTo().alert().accept();
            DriverManager.getDriver().switchTo().defaultContent();
        }
    }

    @DataProvider(name = "LoginData")
    String[][] getData() throws IOException {
        String path = "src/test/java/testData/LoginDataExcel.xlsx";
        int rows = ExcelUtils.getRowCount(path, "Sheet1");
        int colums = ExcelUtils.getCellCount(path, "Sheet1", 1);

        String loginData[][] = new String[rows][colums];
        for (int row = 1; row < rows; row++) {
            for (int cell = 0; cell < colums; cell++) {
                loginData[row - 1][cell] = ExcelUtils.getCellData(path, "Sheet1", row, colums);
            }
        }
        return loginData;
    }
}
