package pom.exercise3_2;

import locator.exercise3_2.PracticePageLocator;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import pom.BasePage;

import java.util.List;

public class PracticePage extends BasePage {

    public PracticePage(WebDriver driver) {
        super(driver);
    }

    public PracticePage openPracticePage() {
        WebElement forms = waitForClickable(PracticePageLocator.FORM);
        scrollToCenter(forms);
        forms.click();
        WebElement practiceForm = waitForClickable(PracticePageLocator.PRACTICE_FORM);
        scrollToCenter(practiceForm);
        practiceForm.click();
        return this;
    }

    public PracticePage enterName(String value1, String value2) {
        WebElement firstName = findElement(PracticePageLocator.FIRST_NAME);
        WebElement lastName = findElement(PracticePageLocator.LAST_NAME);

        action
                .click(firstName)
                .sendKeys(value1)
                .click(lastName)
                .sendKeys(value2)
                .perform();
        return this;
    }

    public PracticePage enterEmail(String value) {
        WebElement email = waitForClickable(PracticePageLocator.EMAIL);
        action
                .click(email)
                .sendKeys(value)
                .perform();
        return this;
    }

    public PracticePage selectGender(String value) {
        List<WebElement> genders = findElements(PracticePageLocator.GENDER_LABELS);

        for (WebElement label : genders) {
            if (label.getText().equalsIgnoreCase(value)) {
                action
                        .click(label)
                        .perform();
                break;

            }
        }
        return this;
    }

    public PracticePage selectDateOfBirth(String dateOfBirth) {

        WebElement dates = findElement(PracticePageLocator.DATE_OF_BIRTH);
        scrollToCenter(dates);

        String[] parts = dateOfBirth.split(" ");
        String day = parts[0];
        String month = parts[1];
        String year = parts[2];

        dates.click();

        WebElement monthDropdown = waitForVisibilityElementLocated(PracticePageLocator.DATE_PICKER_MONTH);
        Select monthSelect = new Select(monthDropdown);
        monthSelect.selectByVisibleText(month);

        WebElement yearDropdown = waitForVisibilityElementLocated(PracticePageLocator.DATE_PICKER_YEAR);
        Select yearSelect = new Select(yearDropdown);
        yearSelect.selectByVisibleText(year);

        By dayLocator = By.xpath("//div[contains(@class, 'react-datepicker__day') and " +
                "not(contains(@class, 'outside-month')) and text()='" + day + "']");

        WebElement dayElement = waitForClickable(dayLocator);
        dayElement.click();

        return this;
    }

    public PracticePage selectHobbies(String value) {

        List<WebElement> hobbies = findElements(PracticePageLocator.HOBBIES_LABELS);

        String[] hobbyValue = value.split(",");

        for (String h: hobbyValue) {
            h = h.trim();

            for (WebElement label: hobbies) {
                if (label.getText().equalsIgnoreCase(h)) {
                    action.click(label).perform();
                }
            }
        }
        return this;
    }

    public PracticePage setAddress(String value) {

        WebElement address = findElement(PracticePageLocator.ADDRESS);
        action.click(address)
                .sendKeys(value)
                .perform();
        return this;
    }

    public PracticePage selectState(String value) {

        WebElement stateSelection = waitForClickable(PracticePageLocator.STATE_DROPDOWN);
        scrollToCenter(stateSelection);
        stateSelection.click();
        String stateXpath = "//div[text()='" + value + "']";
        waitForClickable(By.xpath(stateXpath)).click();
        return this;
    }

    public PracticePage enterMobile(String value) {
        WebElement mobile = findElement(PracticePageLocator.MOBILE);
        scrollToCenter(mobile);
        action.click(mobile)
                .sendKeys(value)
                .perform();
        return this;
    }

    public PracticePage enterSubjects(String subjects) {

        String[] subjectArray = subjects.split(",");
        WebElement subjectsInput = findElement(PracticePageLocator.SUBJECTS);
        scrollToCenter(subjectsInput);

        for (String subject : subjectArray) {
            subject = subject.trim();
            subjectsInput.sendKeys(subject);
            subjectsInput.sendKeys(Keys.ENTER);
        }

        return this;
    }

    public PracticePage submitForm() {

        WebElement submitBtn = waitForClickable(PracticePageLocator.SUBMIT);
        scrollToCenter(submitBtn);
        action
                .click(submitBtn)
                .perform();
        return this;
    }

    public boolean isModalDisplayed() {
        try {
            return findElement(PracticePageLocator.MODAL_TITLE).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public String getModalTitle() {
        return findElement(PracticePageLocator.MODAL_TITLE).getText();
    }

}
