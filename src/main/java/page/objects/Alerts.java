package page.objects;

import common.TestBase;
import enums.WebElementType;
import org.openqa.selenium.Alert;
import utils.Locator;

public class Alerts extends BaseWebElement {


    public Alerts( String elementName, Locator elementLocator){
        super (elementName, elementLocator);
        this.type = WebElementType.ALERTS;
    }

    public String getAlertTitle() {
        try {
            Alert alert = TestBase.getDriver().switchTo().alert();
            String alertTitle = alert.getText();
            System.out.println("Alert Title: '" + alertTitle + "'");
            return alertTitle;
        } catch (Exception e) {
            // Log the exception message and stack trace for better error reporting
            System.out.println("Failed to retrieve text from alert: " + e);
            // Rethrow the original exception
            throw new RuntimeException(e);
        }
    }

    public void acceptAlert() {
        try {
            Alert alert = TestBase.getDriver().switchTo().alert();
            alert.accept();
            System.out.println(this.type.getName()  + " Pop-Up was accepted");
        } catch (Exception e) {
            // Log the exception message and stack trace for better error reporting
            System.out.println("Failed to accept the alert: " + e);
            // Rethrow the original exception
            throw new RuntimeException(e);
        }
    }
}