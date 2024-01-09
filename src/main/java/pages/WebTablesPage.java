package pages;

import page.objects.Button;
import page.objects.Table;
import page.objects.TextBox;
import utils.Locator;

public class WebTablesPage extends BasePage{

    public WebTablesPage(String pageName, Locator pageLocator){
        super(pageName, pageLocator);
    }

    public Button addButton = new Button("Add", new Locator(Locator.LocatorType.ID, "addNewRecordButton"));
    public Table webTableRegistrationForm = new Table("Registration Form", new Locator(Locator.LocatorType.CSS_SELECTOR, ".modal-content"));
    public TextBox firstName = new TextBox(("First Name"), new Locator(Locator.LocatorType.ID, "firstName"));
    public TextBox lastName = new TextBox(("Last Name"), new Locator(Locator.LocatorType.ID, "lastName"));
    public TextBox userEmail = new TextBox(("Email"), new Locator(Locator.LocatorType.ID, "userEmail"));
    public TextBox userAge = new TextBox(("Age"), new Locator(Locator.LocatorType.ID, "age"));
    public TextBox salary = new TextBox(("Salary"), new Locator(Locator.LocatorType.ID, "salary"));
    public TextBox department = new TextBox(("Department"), new Locator(Locator.LocatorType.ID, "department"));
    public Button submitButton = new Button(("Submit Button"), new Locator(Locator.LocatorType.ID, "submit"));
    public Table webTableNewRecord = new Table("Search Results", new Locator(Locator.LocatorType.CSS_SELECTOR, ".rt-tr-group"));
}
