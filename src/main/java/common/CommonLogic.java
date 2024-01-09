package common;

/**
 * The CommonLogic class extends TestBase and provides common functionalities for opening URLs and
 * interacting with web pages.
 */
public class CommonLogic extends TestBase {

    public static void openDemoQaUrl() {
        openUrl(getConfig().getDemoQaUrl());
    }

    public static void openDemoQaBooksUrl() {
        openUrl(getConfig().getDemoQaBooksUrl());
    }

    public static void openDemoQaPracticeFormUrl() {
        openUrl(getConfig().getDemoQaPracticeFormUrl());
    }


    public static void openUrl(String url) {
        getDriver().get(url);
        waitForPageLoaded();
        TestBase.logInfo("Url '" + url + "' opened");
    }
}