package pages;

import page.objects.Table;
import page.objects.TextBox;
import utils.Locator;

public class BookStorePage extends BasePage{

    public BookStorePage(String pageName, Locator pageLocator){
        super(pageName, pageLocator);
    }

    public TextBox booksSearchBar = new TextBox("Books Search Box", new Locator(Locator.LocatorType.ID, "searchBox"));
    public Table tableSearchResults = new Table("Search Results", new Locator(Locator.LocatorType.CSS_SELECTOR, ".rt-table"));
}
