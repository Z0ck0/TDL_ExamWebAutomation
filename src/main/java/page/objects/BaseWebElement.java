package page.objects;

import enums.WebElementType;
import utils.Locator;

public class BaseWebElement {
    public String name;
    public Locator locator;
    public String value;
    public WebElementType type;

    public BaseWebElement(String elementName, Locator elementLocator){
        this.name = elementName;
        this.locator = elementLocator;
    }
}