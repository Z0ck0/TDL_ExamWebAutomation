package utils;

/**
 * The Locator class represents a data structure for web element locators.
 * It includes the locator type and its corresponding value.
 */

public class Locator {
    public LocatorType type;
    public String value;

    public Locator(LocatorType locatorType, String value){
        this.type = locatorType;
        this.value = value;
    }
    public enum LocatorType{
        ID,
        XPATH,
        NAME,
        CSS_SELECTOR
    }
}