package page.objects;

import common.TestBase;
import enums.WebElementType;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.Locator;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;

import static common.Pages.webTablesPage;


public class Table extends BaseWebElement {

    public Table( String elementName, Locator elementLocator ) {
        super(elementName, elementLocator);
        this.type = WebElementType.TABLE;
    }


    public void validateBooksCount() {
        WebElement table = TestBase.getElement(this.locator);

        if (table != null) {
            List<WebElement> visibleBooks = table.findElements(By.cssSelector(".action-buttons"));
            int bookCount = visibleBooks.size();

            System.out.println("The " + this.type.getName() + " displays " + bookCount + " visible books.");
        } else {
            System.out.println("Couldn't find " + this.type.getName() + " '" + this.name + "'");
        }
    }


    public void openBookWithTitle( String bookTitle ) {
        WebElement table = TestBase.getElement(this.locator);

        if (table != null) {
            WebElement bookRow = table.findElement(By.id("see-book-" + bookTitle));

            if (bookRow != null) {
                WebElement bookLink = bookRow.findElement(By.xpath(".//a[contains(text(), '" + bookTitle + "')]"));
                if (bookLink != null) {
                    bookLink.click();
                    System.out.println("Clicked on the book with title: '" + bookTitle + "'");
                } else {
                    System.out.println("Book link not found for title: '" + bookTitle + "'");
                }
            } else {
                System.out.println("Row not found for book title: '" + bookTitle + "'");
            }
        } else {
            System.out.println("Couldn't find " + this.type.getName() + " '" + this.name + "'");
        }
    }


    public void validateCell( String text ) {
        WebElement table = TestBase.getElement(this.locator);
        if (table != null) {
            WebDriverWait wait = new WebDriverWait(TestBase.getDriver(), Duration.ofSeconds(10));
            wait.until(ExpectedConditions.visibilityOf(table));

            List<WebElement> cells = table.findElements(By.xpath("//*[contains(text(),'" + text + "')]"));

            if (!cells.isEmpty())
                TestBase.validationPass(this.type.getName() + " contains the expected text '" + text + "'");
            else TestBase.validationFail(this.type.getName() + " doesn't contains cell with value '" + text + "'");
        } else {
            TestBase.validationFail(" Couldn't find " + this.type.getName() + " '" + this.name + "'");
        }
    }

    public void validateTextInColumn( String columnName, String text ) {
        if (doesColumnContainText(columnName, text)) {
            System.out.println("Success: The '" + columnName + "' column contains the value '" + text + "'.");
        }
    }

    public boolean doesColumnContainText( String columnName, String text ) {
        WebElement table = TestBase.getElement(this.locator);
        if (table != null) {
            int headerIndex = getHeaderIndex(columnName);
            if (headerIndex >= 0) {
                List<WebElement> cells = table.findElements(By.xpath("//div[@class='rt-td'][" + headerIndex + "]"));
                for (WebElement cell : cells) {
                    if (cell.getText().contains(text)) return true;
                }
            } else {
            }
        } else {
            System.out.println("Couldn't find " + this.type.getName() + " '" + this.name + "'");
        }
        System.out.println(this.type.getName() + " column '" + columnName + "' cells don't contain value '" + text + "'");
        return false;
    }


    public int getHeaderIndex( String columnName ) {
        WebElement table = TestBase.getElement(this.locator);
        if (table != null) {
            List<WebElement> headers = table.findElements(By.xpath("//div[@class='rt-resizable-header-content']"));
            for (int i = 0; i < headers.size(); i++) {
                WebElement headerCell = headers.get(i);
                if (headerCell.getText().equals(columnName)) return i + 1;
            }
        } else {
            System.out.println("Couldn't find column '" + columnName + "'" + this.name + "'");
        }
        System.out.println("Couldn't find column '" + columnName + "'");
        return -1;
    }


    // Method to print text of elements in rows containing a specific word
    public void logNewDataFromTable() {
        try {
            WebElement table = TestBase.getElement(this.locator);
            List<WebElement> rows = table.findElements(By.xpath("//*[@class='rt-tr-group']"));

            String lastRowData = null;

            if (!rows.isEmpty()) {
                for (WebElement row : rows) {
                    List<WebElement> cells = row.findElements(By.xpath(".//*[@class='rt-td']"));

                    // Check if the row has data
                    if (cells.stream().anyMatch(cell -> !cell.getText().trim().isEmpty())) {
                        // Collecting text from each cell and joining them with a comma
                        lastRowData = cells.stream().map(WebElement::getText).collect(Collectors.joining(", "));
                    }
                }

                if (lastRowData != null) {
                    System.out.println("Log new data in table: '" + lastRowData + "'");
                } else {
                    System.out.println("All rows are empty.");
                }
            } else {
                System.out.println("Table is empty.");
            }
        } catch (Exception e) {
            System.out.println("Failed to retrieve rows from the table: " + e);
            throw new RuntimeException(e);
        }
    }

    public void fillRegistrationForm( String firstName, String lastName, String eMail, String age, String salary, String department){
        webTablesPage.get().firstName.sendKeys(firstName);
        webTablesPage.get().lastName.sendKeys(lastName);
        webTablesPage.get().userEmail.sendKeys(eMail);
        webTablesPage.get().userAge.sendKeys(age);
        webTablesPage.get().salary.sendKeys(salary);
        webTablesPage.get().department.sendKeys(department);
    }

    public void validateDataIsAddedInTable( String firstName, String lastName, String eMail, String age, String salary, String department){
        webTablesPage.get().webTableNewRecord.validateCell(firstName);
        webTablesPage.get().webTableNewRecord.validateCell(lastName);
        webTablesPage.get().webTableNewRecord.validateCell(eMail);
        webTablesPage.get().webTableNewRecord.validateCell(age);
        webTablesPage.get().webTableNewRecord.validateCell(salary);
        webTablesPage.get().webTableNewRecord.validateCell(department);
    }
}