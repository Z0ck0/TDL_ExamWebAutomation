package pages;

import page.objects.TextBox;
import utils.Locator;

public class BookDetailsPage extends BasePage{

    public BookDetailsPage(String pageName, Locator pageLocator){
        super(pageName, pageLocator);
    }
    public TextBox isbnLabel = new TextBox("ISBN Label", new Locator(Locator.LocatorType.XPATH, "//*[@id=\"ISBN-wrapper\"]//label[@id=\"userName-value\"]"));
}
