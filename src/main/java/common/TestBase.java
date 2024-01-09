package common;

import com.aventstack.extentreports.Status;
import enums.BrowserType;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.jetbrains.annotations.NotNull;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import utils.Locator;

import java.time.Duration;

import static common.Pages.setPages;

/**
 * The TestBase class provides common functionalities and settings for the test automation framework.
 * It initializes the WebDriver, manages wait conditions, handles page elements, and logs test information.
 */

public class TestBase {

    private static final int implicitWait = 20;

    private static final ConfigReader configReader = new ConfigReader();

    public static ConfigReader getConfig() {
        return configReader;
    }

/*  ThreadLocal is a class in Java that provides a way to create thread-local and thread-safe variables.
    These variables are unique to each thread(test method), meaning that each thread has its own independent copy of the variable.
    The primary purpose of ThreadLocal is to maintain thread-specific data and avoid data sharing between threads.*/

    private static final ThreadLocal<RemoteWebDriver> remoteWebDriver = new ThreadLocal<>();


    // Getter Method: A getDriver() method returns the RemoteWebDriver instance from the remoteWebDriver.
    public static RemoteWebDriver getDriver() {
        return remoteWebDriver.get();
    }

    // ---------------------------------------------------------------------------------------------------------------------
    private static final ThreadLocal<WebDriverWait> wait = new ThreadLocal<>();

    // Setter Method: A setRemoteWebDriver() method sets the RemoteWebDriver instance in the remoteWebDriver.
    private static void setRemoteWebDriver( RemoteWebDriver driver ) {
        remoteWebDriver.set(driver);
        wait.set(new WebDriverWait(getDriver(), Duration.ofSeconds(implicitWait)));
    }

// ---------------------------------------------------------------------------------------------------------------------

    /* Initialization Method: This method sets up the ChromeDriver using WebDriverManager and
    initializes the remoteWebDriver with a new instance of ChromeDriver.*/

/*    public static void initializeDriver2() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        setRemoteWebDriver(new ChromeDriver(options));
        setPages();
    }*/

    public static void initializeDriver( BrowserType browserType ) {
        switch (browserType) {
            case CHROME:
                WebDriverManager.chromedriver().setup();
                setRemoteWebDriver(new ChromeDriver(new ChromeOptions()));
                break;
            case FIREFOX:
                WebDriverManager.firefoxdriver().setup();
                setRemoteWebDriver(new FirefoxDriver(new FirefoxOptions()));
                break;
            case EDGE:
                WebDriverManager.edgedriver().setup();
                setRemoteWebDriver(new EdgeDriver(new EdgeOptions()));
                break;
            default:
                throw new IllegalArgumentException("Unsupported browser type: " + browserType);
        }
        maximizeWindow();
        setPages();
    }

    private static void maximizeWindow() {
        getDriver().manage().window().maximize();
    }


    @AfterMethod
    public void closeDriver() {
        if (getDriver() != null) {
            getDriver().close();
            getDriver().quit();
            logInfo("WebDriver closed");
        }
    }


// ---------------------------------------------------------------------------------------------------------------------

    private static WebDriverWait getWait() {
        return wait.get();
    }

    public static boolean isElementVisible( Locator locator ) {
        if (getElement(locator) != null) return true;
        else return false;
    }


    public static void waitForPageLoaded() {
        ExpectedCondition<Boolean> condition = new ExpectedCondition<Boolean>() {
            public @NotNull Boolean apply( WebDriver driver ) {
                return ((JavascriptExecutor) driver).executeScript("return document.readyState").toString().equals("complete");
            }
        };
        try {
            getWait().until(condition);
        } catch (Exception exception) {
            System.out.println("Page loaded more than " + implicitWait + "  seconds");
        }
    }

// ---------------------------------------------------------------------------------------------------------------------

    public static WebElement getElement( Locator locator ) {
        WebElement returnElement = null;
        try {
            switch (locator.type) {
                case ID:
                    returnElement = getDriver().findElement(By.id(locator.value));
                    break;
                case XPATH:
                    returnElement = getDriver().findElement(By.xpath(locator.value));
                    break;
                case NAME:
                    returnElement = getDriver().findElement(By.name(locator.value));
                    break;
                case CSS_SELECTOR:
                    returnElement = getDriver().findElement(By.cssSelector(locator.value));
                    break;
                default:
                    System.out.println("Incorrect locator type (" + locator.type.name() + "), unable to element");
            }
        } catch (NoSuchElementException exception) {
            returnElement = null;
        }
        return returnElement;
    }


    public static void logInfo( String message) {
        ExtentTestManager.logInfo(Status.INFO, message);
        Reporter.log(message);
        System.out.println(message);
    }


    public static void validationFail( String message, boolean stopTest ) {
        message = "VALIDATION FAIL: " + message;
        System.out.println(message);
        ExtentTestManager.logWithScreenShot(Status.FAIL, message);
        Reporter.log(message);
        Reporter.getCurrentTestResult().setStatus(2);
        if (stopTest) {
            message = "TEST STOPPED: " + message;
            Reporter.log(message);
            ExtentTestManager.logInfo(Status.FAIL, message);
            throw new RuntimeException(message);
        }
    }

    public static void validationFail( String message ) {
        validationFail(message, false);
    }

    public static void validationPass( String message ) {
        message = "VALIDATION PASS: " + message;
        System.out.println(message);
        ExtentTestManager.logInfo(message);
        Reporter.log(message);
    }
}