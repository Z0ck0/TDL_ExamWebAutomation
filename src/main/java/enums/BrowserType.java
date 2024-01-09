package enums;

public enum BrowserType {
    CHROME("Chrome"),
    FIREFOX("Firefox"),
    EDGE("Edge");


    private final String browserType;

    BrowserType(String browserType) {
        this.browserType = browserType;
    }

    public String getBrowser() {
        return this.browserType;
    }

}
