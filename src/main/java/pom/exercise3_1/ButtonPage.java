package pom.exercise3_1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pom.BasePage;

import java.time.Duration;

public class ButtonPage extends BasePage {

    public ButtonPage(WebDriver driver) {
        super(driver);
    }

    public static final By ELEMENT_BTN = By.xpath("//div[normalize-space()='Elements']");
    public static final By BUTTON = By.xpath("//span[text() = 'Buttons']");
    public static final By DOUBLE_CLICK_BTN = By.id("doubleClickBtn");
    public static final By RIGHT_CLICK_BTN = By.id("rightClickBtn");
    public static final By CLICK_BTN = By.xpath("//button[text()='Click Me']");
    public static final By DOUBLE_BTN_MSG = By.id("doubleClickMessage");
    public static final By RIGHT_CLICK_MSG = By.id("rightClickMessage");
    public static final By CLICK_MSG = By.id("dynamicClickMessage");


    public ButtonPage openButtonPage() {
        waitForClickable(ELEMENT_BTN).click();
        WebElement button = waitForClickable(BUTTON);
        scrollToCenter(button);
        button.click();
        return this;
    }

    public ButtonPage doubleClickButton() {
        WebElement element = waitForClickable(DOUBLE_CLICK_BTN);
        action.
                doubleClick(element)
                .perform();
        return this;
    }

    public String getDoubleClickMsg() {
        WebElement element = findElement(DOUBLE_BTN_MSG);
        waitForVisibility(element);
        return element.getText();
    }

    public ButtonPage rightClickButton() {
        WebElement element = waitForClickable(RIGHT_CLICK_BTN);
        action
                .contextClick(element)
                .perform();
        return this;
    }

    public String getRightClickMsg() {
        WebElement element = findElement(RIGHT_CLICK_MSG);
        waitForVisibility(element);
        return element.getText();
    }

    public ButtonPage moveToButtonAndClick() {
        WebElement element = waitForClickable(CLICK_BTN);
        action
                .moveToElement(element)
                .pause(Duration.ofMillis(10))
                .click()
                .perform();
        return this;
    }

    public String getClickMsg() {
        WebElement element = findElement(CLICK_MSG);
        return element.getText();
    }

    public boolean isDoubleClickMsgDisplayed() {
        return findElements(DOUBLE_BTN_MSG).size() > 0;
    }

    public boolean isRightClickMsgDisplayed() {
        return findElements(RIGHT_CLICK_MSG).size() > 0;
    }

}
