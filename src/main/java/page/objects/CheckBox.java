package page.objects;

import common.TestBase;
import enums.WebElementType;
import org.openqa.selenium.WebElement;
import utils.Locator;

public class CheckBox extends BaseWebElement {

    public CheckBox( String elementName, Locator elementLocator ) {
        super(elementName, elementLocator);
        this.type = WebElementType.CHECK_BOX;
    }


    public void selectCheckbox() {
        WebElement button = TestBase.getElement(this.locator);
        if (button != null) {
            button.click();
            System.out.println(this.type.getName() + " '" + this.name + "' clicked");
        } else {
            System.out.println(this.type.getName() + " '" + this.name + "' not found");
        }
    }

}
