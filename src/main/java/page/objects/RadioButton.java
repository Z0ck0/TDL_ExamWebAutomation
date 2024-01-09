package page.objects;

import common.TestBase;
import enums.WebElementType;
import org.openqa.selenium.WebElement;
import utils.Locator;

public class RadioButton extends BaseWebElement{

    public RadioButton( String elementName, Locator elementLocator){
        super (elementName, elementLocator);
        this.type = WebElementType.RADIO_BUTTON;
    }

    public void clickRadioButton() {
        WebElement radioButton = TestBase.getElement(this.locator);
        if (radioButton != null) {
            radioButton.click();
            System.out.println(this.type.getName() + " '" + this.name + "' clicked");
        } else {
            System.out.println(this.type.getName() + " '" + this.name + "' not found");
        }
    }

}
