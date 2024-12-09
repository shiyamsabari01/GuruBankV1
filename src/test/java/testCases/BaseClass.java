package testCases;

import driverManager.DriverManager;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.ss.formula.functions.T;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import utilities.Constants;
import utilities.ReadConfigProperties;

import java.io.File;
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

    }

    public void takeScreenShot(WebDriver driver, String TName) {
        try {
            TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
            File Source = takesScreenshot.getScreenshotAs(OutputType.FILE);
            File Target = new File("src/test/resources/ScreenShots/" + TName + ".png");
            FileUtils.copyFile(Source, Target);
        } catch (Exception e) {
            e.printStackTrace();
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

