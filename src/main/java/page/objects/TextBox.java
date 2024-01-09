package page.objects;

import common.TestBase;
import enums.WebElementType;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import utils.Locator;



public class TextBox extends BaseWebElement {

    public TextBox( String elementName, Locator elementLocator ) {
        super(elementName, elementLocator);
        this.type = WebElementType.TEXT_BOX;
    }

    public void sendKeys() {
        sendKeys(this.value);
    }

    public void sendKeys( String text ) {
        WebElement field = TestBase.getElement(this.locator);
        if (field != null) {
            field.sendKeys(text);
            System.out.println(this.type.getName() + " '" + this.name + "' entered text '" + text + "' ");
        } else {
            System.out.println(this.type.getName() + " '" + this.name + "' not found");
        }
    }


    public String getTextValue() {
        WebElement label = TestBase.getElement(this.locator);
        if (label != null) {
            return label.getText();
        } else {
            System.out.println(this.type.getName() + " '" + this.name + "' not found");
            return null;
        }
    }

    public void validateText(String expectedText) {
        String actualText = getTextValue();

        if (actualText != null && actualText.equals(expectedText)) {
            System.out.println(this.type.getName() + " '" + this.name + "' text is correct: " + actualText);
        } else {
            System.out.println(this.type.getName() + " '" + this.name + "' text validation failed. Expected: " + expectedText + ", Actual: " + actualText);
        }
    }

    public void enterSubject (String subject) throws InterruptedException{
        WebElement customerSubject = TestBase.getElement(this.locator);
        Thread.sleep(500);
        customerSubject.sendKeys(subject);
        customerSubject.sendKeys(Keys.ENTER);

    }
}
