package locator.exercise3_2;

import org.openqa.selenium.By;

public class PracticePageLocator {

    public static final By FORM = By.xpath("//h5[text() = 'Forms']");
    public static final By PRACTICE_FORM = By.xpath("//span[text() = 'Practice Form']");

    // NAME LOCATOR
    public static final By FIRST_NAME = By.xpath("//input[@id='firstName']");
    public static final By LAST_NAME = By.xpath("//input[@id='lastName']");

    // EMAIL LOCATOR
    public static final By EMAIL = By.xpath("//input[@id='userEmail']");

    // GENDER LOCATOR
    public static final By GENDER_LABELS = By.xpath("//div[@id='genterWrapper']//label");

    // DATE LOCATORS
    public static final By DATE_OF_BIRTH = By.xpath("//input[@id='dateOfBirthInput']");
    public static final By DATE_PICKER_MONTH = By.xpath("//select[@class='react-datepicker__month-select']");
    public static final By DATE_PICKER_YEAR = By.xpath("//select[@class='react-datepicker__year-select']");

    // SUBJECTS
    public static final By SUBJECTS = By.xpath("//input[@id='subjectsInput']");

    // HOBBIES
    public static final By HOBBIES_LABELS = By.xpath("//div[@id='hobbiesWrapper']//label");

    // CURRENT ADDRESS LOCATOR
    public static final By ADDRESS = By.xpath("//textarea[@id='currentAddress']");

    // STATE LOCATOR
    public static final By STATE_DROPDOWN = By.xpath("//div[@id='state']");

    // MOBILE
    public static final By MOBILE = By.xpath("//input[@id='userNumber']");

    // SUBMIT
    public static final By SUBMIT = By.xpath("//button[@id='submit']");

    // MODAL
    public static final By MODAL_TITLE = By.xpath("//div[@id='example-modal-sizes-title-lg']");
}
