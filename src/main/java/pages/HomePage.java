package pages;

import page.objects.NavigationCard;
import utils.Locator;

public class HomePage extends BasePage{

    public HomePage(String pageName, Locator pageLocator){
        super(pageName, pageLocator);
    }

    public NavigationCard alertsNavigationCard = new NavigationCard("Alerts, Frame & Windows", new Locator(Locator.LocatorType.XPATH, "//div[@class='card-body'][contains(.,'Alerts, Frame & Windows')]"));
    public NavigationCard elementsNavigationCard = new NavigationCard("Elements", new Locator(Locator.LocatorType.XPATH, "//div[@class='card-body'][contains(.,'Elements')]"));
}
