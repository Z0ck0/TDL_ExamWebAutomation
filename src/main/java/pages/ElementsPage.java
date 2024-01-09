package pages;

import page.objects.Button;
import page.objects.Table;
import page.objects.TextBox;
import utils.Locator;

public class ElementsPage extends BasePage{

    public ElementsPage(String pageName, Locator pageLocator){
        super(pageName, pageLocator);
    }

    public Button webTablesNavigationButton = new Button("Web Tables' from 'Elements Menu List", new Locator(Locator.LocatorType.XPATH, "//span[text()=\"Web Tables\"]"));
    public TextBox webTablesSearchBar = new TextBox("Search Field", new Locator(Locator.LocatorType.ID, "searchBox"));
    public Table webTableSearchResults = new Table("Search Results", new Locator(Locator.LocatorType.CSS_SELECTOR, ".rt-td"));
}
