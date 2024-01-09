package common;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import enums.BrowserType;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.Reporter;

import java.io.File;

/**
 * The ExtentTestManager class manages the creation and logging of ExtentTest instances
 * for comprehensive test reporting within the generated HTML report.
 */

public class ExtentTestManager {

    protected static ExtentReports extent;

    public static void createReport() {
        if (extent != null) {
            extent.flush();
        }
    }

    private static final String CONFIG_PATH =
            "src" + File.separator +
                    "main" + File.separator +
                    "resources" + File.separator +
                    "configs" + File.separator +
                    "extentConfig.xml";

    private static final String PATH =
            "src" + File.separator +
                    "main" + File.separator +
                    "resources" + File.separator +
                    "reports" + File.separator +
                    "TestResults.html";

    public static synchronized ExtentTest startTest( String testName, String description, String priority, String dataProvider ) {
        if (extent == null) extent = initializeReport();
        ExtentTest test = extent.createTest(testName, description);

        if (priority != null) test.assignCategory(priority);
        if (dataProvider != null) test.assignCategory(dataProvider);

        setTest(test);
        return test;
    }

    private static final ThreadLocal<ExtentTest> testRepository = new ThreadLocal<>();

    private static void setTest( ExtentTest test ) {
        testRepository.set(test);
    }

    public static ExtentReports initializeReport() {
        ExtentReports newReport = new ExtentReports();
        try {
            ExtentSparkReporter spark = new ExtentSparkReporter(PATH);
            spark.loadXMLConfig(CONFIG_PATH);
            newReport.attachReporter(spark);
        } catch (Exception exception) {
            TestBase.validationFail("Couldn't create report", true);
        }
        return newReport;
    }

    public static ExtentTest getTest() {
        return testRepository.get();
    }

    public static void logLabel( String message ) {
        logLabel(ExtentColor.ORANGE, message);
    }

    public static void logLabel(ExtentColor color, String message){
        getTest().info(MarkupHelper.createLabel(message, color));
    }

    public static void logInfo(String message){
        logInfo(Status.INFO, message);
    }

    public static void logInfo(Status status, String message){
        getTest().log(status, message);
    }



    public static void logWithScreenShot(Status status, String message){
        if(TestBase.getDriver() != null) {
            //Take screenshot
            String base64Image = "data:image/png;base64," + ((TakesScreenshot) TestBase.getDriver()).getScreenshotAs(OutputType.BASE64);
            //Add screenshot to report
            getTest().log(status, message, MediaEntityBuilder.createScreenCaptureFromBase64String(base64Image).build());
        }else{
            getTest().info(message);
        }
    }

    public static void logStep(String stepName, String stepDescription) {
        getTest().log(Status.INFO, MarkupHelper.createLabel(stepName, ExtentColor.BLUE).getMarkup() + "<br/>" + stepDescription);
    }


}