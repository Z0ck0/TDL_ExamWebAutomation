package utils;

import common.ExtentTestManager;
import common.TestBase;
import enums.BrowserType;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

/**
 * The TestListener class implements TestNGs ITestListener interface to act as a listener for test events.
 * It is responsible for logging test information, initializing the WebDriver, managing the Extent report,
 * and performing other actions based on test events.
 */

public class TestListener extends TestBase implements ITestListener {

    @Override
    public void onStart( ITestContext iTestContext ) {
        iTestContext.setAttribute("WebDriver", getDriver());
    }

    @Override
    public void onFinish( ITestContext iTestContext ) {
        ExtentTestManager.createReport();
    }


    @Override
    public void onTestStart( ITestResult iTestResult ) {

        //Getting info from method to log to report
        String testCode = iTestResult.getMethod().getConstructorOrMethod().getName();
        String description = iTestResult.getMethod().getConstructorOrMethod().getMethod().getAnnotation(Test.class).description();
        int priority = iTestResult.getMethod().getConstructorOrMethod().getMethod().getAnnotation(Test.class).priority();
        boolean isDataProviderUsed = !iTestResult.getMethod().getConstructorOrMethod().getMethod().getAnnotation(Test.class).dataProvider().isEmpty();


        //Creating a test in Extent report
        ExtentTestManager.startTest(
                testCode + " - " + description,
                "TDL - EXAM Web Automation with Java and Selenium",
                "Priority_" + priority,
                "Data Provider Used_" + isDataProviderUsed);

        ExtentTestManager.logLabel("Test started" );
        TestBase.initializeDriver(BrowserType.EDGE);

    }



    @Override
    public void onTestSuccess( ITestResult iTestResult ) {
        ExtentTestManager.logLabel("Test finished with success");
    }


    @Override
    public void onTestFailure( ITestResult iTestResult ) {
        ExtentTestManager.logLabel("Test finished with failure");
    }

    @Override
    public void onTestSkipped( ITestResult iTestResult ) {
        ExtentTestManager.logLabel("Test skipped");
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage( ITestResult iTestResult ) {
        ExtentTestManager.logLabel("Test finished with failure with success percentage");
    }


}
