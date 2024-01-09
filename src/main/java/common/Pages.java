package common;

import pages.*;
import utils.Locator;

/**
 * The Pages class manages ThreadLocal instances for different page objects in the web application.
 * It provides a centralized location for initializing and accessing page objects.
 */
public class Pages {

    public static ThreadLocal<HomePage> homePage = new ThreadLocal<>();
    public static ThreadLocal<AlertsPage> alertsPage = new ThreadLocal<>();
    public static ThreadLocal<BookStorePage> bookStorePage = new ThreadLocal<>();
    public static ThreadLocal<BookDetailsPage> bookDetailsPage = new ThreadLocal<>();
    public static ThreadLocal<ElementsPage> elementsPage = new ThreadLocal<>();
    public static ThreadLocal<WebTablesPage> webTablesPage = new ThreadLocal<>();
    public static  ThreadLocal<PracticeFormPage> practiceFormPage = new ThreadLocal<>();

    public static void setPages() {
        homePage.set(new HomePage("DemoQA Home page", new Locator(Locator.LocatorType.ID, "app")));
        alertsPage.set(new pages.AlertsPage("DemoQA Alerts page", new Locator(Locator.LocatorType.XPATH, "//div[@class='main-header'][contains(.,'Alerts')]")));
        bookStorePage.set(new BookStorePage("DemoQA Book Store page", new Locator(Locator.LocatorType.XPATH, "//div[@class='main-header'][contains(.,'Book Store')]")));
        bookDetailsPage.set(new BookDetailsPage("DemoQA Book Details page", new Locator(Locator.LocatorType.ID, "addNewRecordButton")));
        elementsPage.set(new ElementsPage("DemoQA Elements page", new Locator(Locator.LocatorType.XPATH, "//div[@class='header-wrapper'][contains(.,'Elements')]")));
        webTablesPage.set(new WebTablesPage("DemoQA Web Tables page", new Locator(Locator.LocatorType.XPATH, "//span[text()=\"Web Tables\"]")));
        practiceFormPage.set(new PracticeFormPage("DemoQA Practice Form page", new Locator(Locator.LocatorType.XPATH, "//span[text()=\"Practice Form\"]")));
    }
}