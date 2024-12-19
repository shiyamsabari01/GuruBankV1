package testCases;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import driverManager.DriverManager;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.ss.formula.functions.T;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.ITestContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import utilities.Constants;
import utilities.ReadConfigProperties;
import utilities.ReportingFile;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class BaseClass {
    private static final Logger LOGGER = LogManager.getLogger(BaseClass.class);

    @BeforeClass
    public void setUp() {
        try {
            ReadConfigProperties read = new ReadConfigProperties();
            read.loadProperties();
            DriverManager.launchBrowser();
            LOGGER.info("Browser Launched!!!");
            DriverManager.getDriver().navigate().to(Constants.APP_URL);
            LOGGER.info("URL Opened");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @AfterClass
    public void tearDown() {
        DriverManager.getDriver().quit();
    }

    public void takeScreenShot(WebDriver driver, String TName) {
        try {
            TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
            File Source = takesScreenshot.getScreenshotAs(OutputType.FILE);
            File Target = new File("src/test/resources/ScreenShots/" + TName + ".png");
            FileUtils.copyFile(Source, Target);
            System.out.println("Screenshot is taken");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void selectDropDown(WebElement dropDown,String type,String value){
        Select select=new Select(dropDown);
        switch (type){
            case"index":
                select.selectByIndex(Integer.parseInt(value));
                break;
            case "value":
                select.selectByValue(value);
                break;
            case "visibleText":
                select.selectByVisibleText(value);
                break;
            default:
                LOGGER.info("Provide valid selection are : visibleText, value, index");
                break;
        }
    }

    public boolean isAlertIsPresent() {
        try {
            DriverManager.getDriver().switchTo().alert();
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    public String randomString(){
        String randomLetters= RandomStringUtils.randomAlphabetic(5);
        return (randomLetters);
    }
}

