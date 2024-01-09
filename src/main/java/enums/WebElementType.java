package enums;


/**
 * The WebElementType enum defines different types of web elements encountered in the web application.
 * Each type has an associated name and provides a method for retrieval.
 *
 *  Enumerations are a special kind of class in Java used to define a fixed set of constants.
 */

public enum WebElementType {

    NAVIGATION_CARD("Navigation Card"),
    BUTTON("Button" ),
    ALERTS("Alerts"),
    TEXT_BOX("Text Box" ),
    TABLE("Table"),
    RADIO_BUTTON("Radio Button"),
    DROP_DOWN("Drop Down"),
    CHECK_BOX("Check Box");


    public final String name;

    WebElementType( String name ) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }
}