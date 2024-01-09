//import common.ExtentTestManager;
import common.TestBase;
import org.testng.annotations.Test;
import utils.DataProviderForWebTables;

import static common.CommonLogic.*;
import static common.Pages.*;
//import static common.TestBase.closeDriver;

public class ExamTests {


    @Test(priority = 1)
    public void testOne() {
       TestBase.logInfo("Starting test 'testOne'");
        openDemoQaUrl();
        homePage.get().alertsNavigationCard.clickNavigationCard();
        alertsPage.get().alertsNavigationButton.clickButton();
        alertsPage.get().informationalAlertsButton.clickButton();
        alertsPage.get().informationalAlertsPopUpPage.getAlertTitle();
        alertsPage.get().informationalAlertsPopUpPage.acceptAlert();
        TestBase.logInfo("Finishing test 'testOne'");
    }


    @Test(priority = 2)
    public void testTwo() {
        TestBase.logInfo("Starting test 'testTwo'");
        openDemoQaBooksUrl();
        bookStorePage.get().booksSearchBar.value = "JavaScript";
        bookStorePage.get().booksSearchBar.sendKeys();
        bookStorePage.get().tableSearchResults.validateBooksCount();

        bookStorePage.get().tableSearchResults.validateCell(bookStorePage.get().booksSearchBar.value);
        String bookName = "Title";
        bookStorePage.get().tableSearchResults.validateTextInColumn(bookName, bookStorePage.get().booksSearchBar.value);

        bookStorePage.get().tableSearchResults.openBookWithTitle("Speaking JavaScript");
        bookDetailsPage.get().isbnLabel.validateText("9781449365035");

        TestBase.logInfo("Finishing test 'testTwo'");
    }


    @Test(priority = 3)
    public void testThree() {
        TestBase.logInfo("Starting test 'testThree'");

        openDemoQaUrl();
        homePage.get().elementsNavigationCard.clickNavigationCard();
        elementsPage.get().webTablesNavigationButton.clickButton();
        elementsPage.get().webTablesSearchBar.value = "Cierra";
        elementsPage.get().webTablesSearchBar.sendKeys();

        elementsPage.get().webTableSearchResults.validateCell(elementsPage.get().webTablesSearchBar.value);
        String firstName = "First Name";
        elementsPage.get().webTableSearchResults.validateTextInColumn(firstName, elementsPage.get().webTablesSearchBar.value);

        elementsPage.get().webTableSearchResults.logNewDataFromTable();

        TestBase.logInfo("Finishing test 'testThree'");
    }


    @Test(priority = 4, dataProvider = "webTablesFormData", dataProviderClass = DataProviderForWebTables.class)
    public void testFour( String firstName, String lastName, String eMail, String age, String salary, String department ) {
        TestBase.logInfo("Starting test 'testFour'");
        openDemoQaUrl();
        homePage.get().elementsNavigationCard.clickNavigationCard();
        elementsPage.get().webTablesNavigationButton.clickButtonAndWait();
        webTablesPage.get().addButton.clickButton();

        webTablesPage.get().webTableRegistrationForm.fillRegistrationForm(firstName, lastName, eMail, age, salary, department);
        webTablesPage.get().submitButton.clickButtonAndWait();
        webTablesPage.get().webTableNewRecord.validateDataIsAddedInTable(firstName, lastName, eMail, age, salary, department);

        webTablesPage.get().webTableNewRecord.logNewDataFromTable();

        if (!webTablesPage.get().isPageVisible())
            TestBase.validationFail("Page '" + webTablesPage.get().name + "' isn't visible", true);

        TestBase.logInfo("Finishing test 'testFour'");
    }



    /* Test 5:
    1. Open page 'https://demoqa.com/forms'
    2. Click ‘Practice Form’
    3. Fill in the form with valid data
    4. Click ‘Submit’
    5. Validate the success message
    6. Close browser*/
    @Test(priority = 5, retryAnalyzer = utils.Retry.class, description = "Submit \"Practice Form\" with valid data and verify success message")
    public void testFive() throws InterruptedException {
        TestBase.logInfo("Starting test 'testFive'");
        openDemoQaPracticeFormUrl();
        practiceFormPage.get().practiceFormNavigationButton.clickButton();
        practiceFormPage.get().firstNameField.sendKeys(getConfig().getFirstName());
        practiceFormPage.get().lastNameField.sendKeys(getConfig().getLastName());
        practiceFormPage.get().emailField.sendKeys(getConfig().getEmail());
        practiceFormPage.get().genderRadioButton.clickRadioButton();
        practiceFormPage.get().mobileTextField.sendKeys(getConfig().getMobile());
        practiceFormPage.get().dateOfBirthPicker.clickButton();
        practiceFormPage.get().monthSelector.selectOptionByVisibleText(practiceFormPage.get().monthSelector, "February");
        practiceFormPage.get().yearSelector.selectOptionByVisibleText(practiceFormPage.get().yearSelector, "2024");
        practiceFormPage.get().daySelector.clickButton();
        practiceFormPage.get().musicHobbiesCheckBox.selectCheckbox();
        practiceFormPage.get().subjectTextField.enterSubject("English");
        practiceFormPage.get().currentAddressField.sendKeys(getConfig().getCurrentAddress());
        practiceFormPage.get().selectState.selectFromDropDown("NCR");
        practiceFormPage.get().selectCity.selectFromDropDown("Delhi");
        practiceFormPage.get().submitButton.clickSubmitButton();
        practiceFormPage.get().successMessage.validateText("Thanks for submitting the form");

        if (!practiceFormPage.get().isPageVisible())
            TestBase.validationFail("Page '" + practiceFormPage.get().name + "' isn't visible", true);
        TestBase.logInfo("Finishing test 'testFive'");

    }
}