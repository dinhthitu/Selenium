package pom.exercise4_1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pom.BasePage;

public class AlertPage extends BasePage {

    public AlertPage(WebDriver driver) {
        super(driver);
    }

    public static final By JS_ALERT = By.xpath("//button[text() = 'Click for JS Alert']");
    public static final By JS_CONFIRM = By.xpath("//button[text() = 'Click for JS Confirm']");
    public static final By JS_PROMPT = By.xpath("//button[text() = 'Click for JS Prompt']");
    public static final By RESULT = By.id("result");

    public AlertPage clickJSAlert() {
        waitForReadyPage();
        WebElement alert = waitForVisibilityElementLocated(JS_ALERT);
        alert.click();
        wait.until(ExpectedConditions.alertIsPresent());
        return this;
    }

    public AlertPage clickJSConfirm() {
        waitForReadyPage();
        WebElement confirmAlert = waitForVisibilityElementLocated(JS_CONFIRM);
        confirmAlert.click();
        wait.until(ExpectedConditions.alertIsPresent());
        return this;
    }

    public AlertPage clickJSPrompt() {
        waitForReadyPage();
        WebElement promptAlert = waitForVisibilityElementLocated(JS_PROMPT);
        promptAlert.click();
        wait.until(ExpectedConditions.alertIsPresent());
        return this;
    }

    public AlertPage acceptAlert() {
        wait.until(ExpectedConditions.alertIsPresent());
        driver.switchTo().alert().accept();
        return this;
    }

    public AlertPage dismissAlert() {
        wait.until(ExpectedConditions.alertIsPresent());
        driver.switchTo().alert().dismiss();
        return this;
    }

    public AlertPage sendKeyAlert(String input) {
        wait.until(ExpectedConditions.alertIsPresent());
        driver.switchTo().alert().sendKeys(input);
        return this;
    }

    public String getAlertResult() {
        wait.until(ExpectedConditions.not(
                ExpectedConditions.textToBe(RESULT, "")
        ));
        return waitForVisibilityElementLocated(RESULT).getText();
    }
}
