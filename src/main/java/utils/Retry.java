package utils;


import org.jetbrains.annotations.NotNull;
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;


/**
 * The Retry class implements TestNG's IRetryAnalyzer interface to enable test case retry in case of failure.
 * It controls the number of retries and enhances test execution robustness.
 */


public class Retry implements IRetryAnalyzer {
    private int count = 0;
    private static int maxTry = 3;

    @Override
    public boolean retry(@NotNull ITestResult iTestResult) {
        if (!iTestResult.isSuccess()) {
            if (count < maxTry) {
                count++;
                iTestResult.setStatus(ITestResult.FAILURE);
                return true;
            } else {
                iTestResult.setStatus(ITestResult.FAILURE);
            }
        } else {
            iTestResult.setStatus(ITestResult.SUCCESS);
        }
        return false;
    }
}