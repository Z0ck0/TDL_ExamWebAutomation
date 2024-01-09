package pages;

import page.objects.*;
import utils.Locator;

public class PracticeFormPage extends BasePage{

    public PracticeFormPage(String pageName, Locator pageLocator){
        super(pageName, pageLocator);
    }

    public Button practiceFormNavigationButton = new Button("Practice Form' Button from 'Forms Menu List", new Locator(Locator.LocatorType.XPATH, "//span[text()=\"Practice Form\"]"));
    public TextBox firstNameField = new TextBox(("First Name input field"), new Locator(Locator.LocatorType.ID, "firstName"));
    public TextBox lastNameField = new TextBox(("Last Name input field"), new Locator(Locator.LocatorType.ID, "lastName"));
    public TextBox emailField = new TextBox(("Email input field"), new Locator(Locator.LocatorType.ID, "userEmail"));
    public RadioButton genderRadioButton = new RadioButton(("Male Gender Radio Button"), new Locator(Locator.LocatorType.XPATH, "//label[normalize-space()=\"Male\"]"));
    public TextBox mobileTextField = new TextBox(("Mobile Text Field"), new Locator(Locator.LocatorType.ID, "userNumber"));
    public Button dateOfBirthPicker = new Button(("Date of Birth Picker"), new Locator(Locator.LocatorType.CSS_SELECTOR, ".react-datepicker__input-container"));
    public DropDown monthSelector = new DropDown(("Month Selector"), new Locator(Locator.LocatorType.CSS_SELECTOR, ".react-datepicker__month-select"));
    public DropDown yearSelector = new DropDown(("Year Selector"), new Locator(Locator.LocatorType.CSS_SELECTOR, ".react-datepicker__year-select"));
    public Button daySelector = new Button(("Day Selector"), new Locator(Locator.LocatorType.XPATH, "//div[@aria-label=\"Choose Thursday, February 15th, 2024\"]"));
    public TextBox subjectTextField = new TextBox(("Subject Text Field"), new Locator(Locator.LocatorType.XPATH, "//*[@id=\"subjectsInput\"]"));
    public CheckBox musicHobbiesCheckBox = new CheckBox(("Music Hobbies Check Box"), new Locator(Locator.LocatorType.XPATH, "//label[@for='hobbies-checkbox-3'][contains(.,'Music')]"));
    public TextBox currentAddressField = new TextBox(("Current Address Text Field"), new Locator(Locator.LocatorType.ID, "currentAddress"));
    public DropDown selectState = new DropDown(("State Drop Down Menu"), new Locator(Locator.LocatorType.XPATH, "//*[@id=\"react-select-3-input\"]"));
    public DropDown selectCity = new DropDown(("City Drop Down Menu"), new Locator(Locator.LocatorType.XPATH, "//*[@id=\"react-select-4-input\"]"));
    public Button submitButton = new Button(("Practice Form 'Submit' Button"), new Locator(Locator.LocatorType.XPATH, "//button[@id=\"submit\"]"));
    public TextBox successMessage = new TextBox(("Practice Form Success Message"), new Locator( Locator.LocatorType.ID, "example-modal-sizes-title-lg" ));



}
