package page.objects;

import common.TestBase;
import enums.WebElementType;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.Locator;

import java.time.Duration;


public class Button extends BaseWebElement {

    public Button( String elementName, Locator elementLocator ) {
        super(elementName, elementLocator);
        this.type = WebElementType.BUTTON;
    }

    public void clickButton() {
        WebElement button = TestBase.getElement(this.locator);

        if (button != null) {
            waitForElementToBeClickable(button);
            button.click();
            System.out.println(this.type.getName() + " '" + this.name + "' clicked");
        } else {
            System.out.println(this.type.getName() + " '" + this.name + "' not found");
        }
    }

    public void clickSubmitButton() {
        WebElement button = TestBase.getElement(this.locator);

        if (button != null) {
            waitForElementToBeClickable(button);
            button.sendKeys(Keys.ENTER);
            System.out.println(this.type.getName() + " '" + this.name + "' clicked");
        } else {
            System.out.println(this.type.getName() + " '" + this.name + "' not found");
        }
    }


    private void waitForElementToBeClickable(WebElement element) {
        try {
            WebDriverWait wait = new WebDriverWait(TestBase.getDriver(), Duration.ofSeconds(20));
            wait.until(ExpectedConditions.elementToBeClickable(element));
        } catch (Exception e) {
            System.out.println("Element not clickable: " + e.getMessage());
        }
    }

    public void clickButtonAndWait() {
        clickButton();
        TestBase.waitForPageLoaded();
    }

}