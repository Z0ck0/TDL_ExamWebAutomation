package page.objects;

import common.TestBase;
import enums.WebElementType;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Select;
import utils.Locator;


public class DropDown extends BaseWebElement{

    public DropDown( String elementName, Locator elementLocator){
        super (elementName, elementLocator);
        this.type = WebElementType.DROP_DOWN;
    }


        public void selectOptionByVisibleText(DropDown dropdown, String text) {
            WebElement dateDropdown = TestBase.getElement(this.locator);

            try {
                Select selectDate = new Select(dateDropdown);
                selectDate.selectByVisibleText(text);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }

    public void selectFromDropDown(String text) {
        WebElement selectStateFromDropDown = TestBase.getElement(this.locator);
        try {
            selectStateFromDropDown.sendKeys(text);
            selectStateFromDropDown.sendKeys(Keys.ENTER);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
