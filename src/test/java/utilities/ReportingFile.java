package utilities;


import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ReportingFile implements ITestListener {
    public static ExtentReports extentReports;
    public static ExtentSparkReporter sparkReporter;
    public static ExtentTest testCase;


    public void onStart(ITestContext context) {
        String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
        String reportName = "Extent-report-" + timeStamp + ".html";
        extentReports = new ExtentReports();
        sparkReporter = new ExtentSparkReporter("src/test/resources/Reports/"+reportName);
        extentReports.attachReporter(sparkReporter);
        extentReports.setSystemInfo("Host Name", "localhost");
        extentReports.setSystemInfo("Environment", "QA");
        extentReports.setSystemInfo("User", "Sabari");

        sparkReporter.config().setDocumentTitle("Guru Bank V1");
        sparkReporter.config().setReportName("Automation Test Report");
        sparkReporter.config().setTheme(Theme.DARK);

    }

    public void onTestSuccess(ITestResult result) {
        testCase = extentReports.createTest(result.getName());
        testCase.log(Status.PASS, MarkupHelper.createLabel(result.getName(), ExtentColor.GREEN));
    }

    public void onTestFailure(ITestResult result) {
        testCase = extentReports.createTest(result.getName());
        testCase.log(Status.FAIL, MarkupHelper.createLabel(result.getName(), ExtentColor.RED));

        String screenPath = "src/test/resources/ScreenShots/" + result.getName() + ".png";
        File file = new File(screenPath);
        if (file.exists()) {
            try {
                testCase.fail("ScreenShot Below:" + testCase.addScreenCaptureFromPath(screenPath));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void onTestSkipped(ITestResult result) {
        testCase = extentReports.createTest(result.getName());
        testCase.log(Status.SKIP, MarkupHelper.createLabel(result.getName(), ExtentColor.ORANGE));
    }

    public void onFinish(ITestContext context) {
        extentReports.flush();
    }
}
