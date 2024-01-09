package pages;

import page.objects.*;
import utils.Locator;

public class AlertsPage extends BasePage {

    public AlertsPage( String pageName, Locator pageLocator ) {
        super(pageName, pageLocator);
    }

    public Button alertsNavigationButton = new Button("Alerts' from 'Alerts Menu List", new Locator(Locator.LocatorType.XPATH, "//span[text()=\"Alerts\"]"));
    public Button informationalAlertsButton = new Button("Click Button to see Alert", new Locator(Locator.LocatorType.ID, "alertButton"));
    public Alerts informationalAlertsPopUpPage = new Alerts("Informational Alerts Pop-Up", new Locator(Locator.LocatorType.ID, "alertButton"));
}
