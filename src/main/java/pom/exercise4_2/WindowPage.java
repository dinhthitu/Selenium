package pom.exercise4_2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pom.BasePage;

import java.util.Set;

public class WindowPage extends BasePage {

    public WindowPage(WebDriver driver) {
        super(driver);
    }

    public static final By NEW_TAB_BTN       = By.id("tabButton");
    public static final By NEW_WINDOW_BTN    = By.id("windowButton");
    public static final By SAMPLE_HEADING    = By.id("sampleHeading");


    public String getMainWindowHandle() {
        return driver.getWindowHandle();
    }

    public Set<String> getAllWindowHandles() {
        return driver.getWindowHandles();
    }

    public WindowPage clickNewTab() {
        waitForClickable(NEW_TAB_BTN).click();
        wait.until(ExpectedConditions.numberOfWindowsToBe(2));
        return this;
    }

    public WindowPage clickNewWindow() {
        waitForClickable(NEW_WINDOW_BTN).click();
        wait.until(ExpectedConditions.numberOfWindowsToBe(2));
        return this;
    }

    public WindowPage switchToNewWindow(String mainHandle) {
        for (String handle : driver.getWindowHandles()) {
            if (!handle.equals(mainHandle)) {
                driver.switchTo().window(handle);
                break;
            }
        }
        return this;
    }

    public WindowPage switchToWindow(String handle) {
        driver.switchTo().window(handle);
        return this;
    }

    public WindowPage closeCurrentWindow() {
        driver.close();
        return this;
    }

    public String getHeadingText() {
        return waitForVisibilityElementLocated(SAMPLE_HEADING).getText();
    }

    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }


}