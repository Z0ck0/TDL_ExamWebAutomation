package page.objects;

import common.TestBase;
import enums.WebElementType;
import org.openqa.selenium.WebElement;
import utils.Locator;

public class NavigationCard extends BaseWebElement {

    public NavigationCard( String elementName, Locator elementLocator ) {
        super(elementName, elementLocator);
        this.type = WebElementType.NAVIGATION_CARD;
    }

    public void clickNavigationCard() {
        WebElement card = TestBase.getElement(this.locator);
        if (card != null) {
            card.click();
            System.out.println(this.type.getName() + " '" + this.name + "' clicked");
        } else {
            System.out.println(this.type.getName() + " '" + this.name + "' not found");
        }
    }
}
