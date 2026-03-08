package pom.exercise4_3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pom.BasePage;


public class WebTablePage extends BasePage {

    public WebTablePage(WebDriver driver) {
        super(driver);
    }


    public static final By ADD_NEW = By.xpath("//button[text() = 'Add']");
    public static final By MODAL = By.cssSelector(".modal-content");
    public static final By FIRST_NAME = By.xpath("//div[@id = 'firstName-wrapper']//descendant::input");
    public static final By LAST_NAME = By.xpath("//div[@class='modal-content']//form//input[@id='lastName']");
    public static final By EMAIL = By.xpath("//input[@placeholder = 'name@example.com']");
    public static final By AGE = By.xpath("//input[contains(@id, 'age')]");
    public static final By SALARY = By.xpath("//input[@id = 'salary']");
    public static final By DEPARTMENT = By.xpath("//input[@id = 'department']");
    public static final By SUBMIT = By.xpath("//button[@type='submit' and normalize-space()='Submit']");
    public static final By CLOSE_BTN = By.xpath("//button[contains(@class, 'close')]");
    public static final By TABLE_ROWS = By.xpath("//table[contains(@class,'table')]//tbody/tr");

    public WebTablePage addNewUser() {
        waitForReadyPage();
        waitForClickable(ADD_NEW).click();
        waitForVisibilityElementLocated(MODAL);
        return this;
    }

    public WebTablePage inputFirstName(String text) {
        senKeys(FIRST_NAME, text);
        return this;
    }

    public WebTablePage inputLastName(String text) {
        waitForVisibilityElementLocated(LAST_NAME).sendKeys(text);
        return this;
    }

    public WebTablePage inputEmail(String text) {
        senKeys(EMAIL, text);
        return this;
    }

    public WebTablePage inputAge(String age) {
        senKeys(AGE, age);
        return this;
    }

    public WebTablePage inputSalary(String salary) {
        senKeys(SALARY, salary);
        return this;
    }

    public WebTablePage inputDepartment(String department) {
        senKeys(DEPARTMENT, department);
        return this;
    }

    public WebTablePage submitData() {
        waitForClickable(SUBMIT).click();
        waitForInvisibility(MODAL);
        return this;
    }

    public WebTablePage closeAddNew() {
        waitForClickable(CLOSE_BTN).click();
        return this;
    }


    public int getAllUser() {
        return findElements(TABLE_ROWS).size();
    }


}



