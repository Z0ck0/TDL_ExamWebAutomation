package pages;

import common.TestBase;
import utils.Locator;

public class BasePage {

    public String name;
    public Locator locator;

    public BasePage( String pageName, Locator pageLocator){
        this.name = pageName;
        this.locator = pageLocator;
    }

    public boolean isPageVisible(){
        return TestBase.isElementVisible(this.locator);}
}
