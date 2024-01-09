# Automated Test Framework
![img_3.png](img_3.png)

# Overview
This test framework is designed for automating web application testing using Java, Selenium WebDriver and TestNG. It follows the Page Object Model (POM) and incorporates the ExtentReports framework for detailed test reporting. This design enhances code maintainability, readability, and scalability for efficient testing of web applications.

##  Project Structure

**Packages:**

* `common`: Shared functionalities (config, pages, WebDriver).
  * `CommonLogic`: Open URLs, handle page loading, element interaction.
  * `ConfigReader`: Read configuration properties (URLs, test data).
  * `ExtentTestManager`: Create and log ExtentTest instances for reporting.
  * `Pages`: Initialize and manage various page objects using ThreadLocal.
  * `TestBase`: Base class for tests (WebDriver, WebDriverWait, common methods).
* `enums`: Defines web element types with names and retrieval methods.
* `page.objects`: Element classes extend BaseWebElement, providing common attributes and specific functionalities for web elements.
* `pages`: Page classes extending BasePage (designed to interact with specific elements and functionalities).
* `utils`: Utility classes for enhanced functionality and reporting aspects.
  * `DataProviderForWebTables`: Provides web table test data sets.
  * `Locator`: Defines data structure for element locators (type, value).
  * `Retry`: Implements test case retry for improved robustness.
  * `TestListener`: Listens for test events, logs information, manages WebDriver and Extent report.
* `resources`: Essential testing components.
  * `configs`: Configuration files `configuration.properties` (dynamic parameters) and `extentConfig.xml` (Extent reporting settings).
  * `reports`: Generated test reports, including `TestResults.html` with screenshots and logs.

##  TestNG Suite Configurations

* `Exam Tests Suite`: Parallel execution, thread count control, group exclusion.
* `Extent Tests Suite`: Parallel execution, thread count control, group exclusion.

##  Test Listener Integration

Both suites utilize a dedicated TestListener for:

* Logging information.
* Managing WebDriver and Extent report.
* Performing actions based on test events.

##  Benefits

* Improved code maintainability and readability (POM).
* Comprehensive and visual reporting (ExtentReports).
* Efficient testing (parallel execution).
* Enhanced robustness (test case retry).
