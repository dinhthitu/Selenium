package pom.exercise5_3;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pom.BasePage;

import java.util.List;

import static utils.CalculateContrastColor.getRelativeLuminance;

public class HomePage extends BasePage {

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public static final By BANNER = By.cssSelector(".home-banner");

    public static final By CATEGORY_CARDS = By.cssSelector(".category-cards");


    public String getAriaLabel(By locator) {
        waitForReadyPage();
        WebElement el = waitForVisibilityElementLocated(locator);
        return el.getAttribute("aria-label");
    }

    public String getRole(By locator) {
        waitForReadyPage();
        WebElement el = waitForVisibilityElementLocated(locator);
        return el.getAttribute("role");
    }


    public HomePage pressTabTimes(int times) {
        for (int i = 0; i < times; i++) {
            action.sendKeys(Keys.TAB).perform();
        }
        return this;
    }

    public HomePage pressShiftTab() {
        action.keyDown(Keys.SHIFT)
                .sendKeys(Keys.TAB)
                .keyUp(Keys.SHIFT)
                .perform();
        return this;
    }

    public HomePage pressEnter() {
        action.sendKeys(Keys.ENTER).perform();
        return this;
    }

    public String getFocusedElementInfo() {
        waitForReadyPage();
        WebElement focused = driver.switchTo().activeElement();

        String ariaLabel = focused.getAttribute("aria-label");
        if (ariaLabel != null && !ariaLabel.isEmpty()) {
            return "aria-label: " + ariaLabel;
        }

        String role = focused.getAttribute("role");
        if (role != null && !role.isEmpty()) {
            return "role: " + role;
        }

        String text = focused.getText();
        if (text != null && !text.isEmpty()) {
            return "text: " + text;
        }

        return "tag: " + focused.getTagName();
    }

    public WebElement getFocusedElement() {
        return driver.switchTo().activeElement();
    }

    public String getColor(By locator) {
        return waitForVisibilityElementLocated(locator).getCssValue("color");
    }

    public String getBackgroundColor(By locator) {
        return waitForVisibilityElementLocated(locator).getCssValue("background-color");
    }

    public String getFontSize(By locator) {
        return waitForVisibilityElementLocated(locator).getCssValue("font-size");
    }

    public String getPageTitle() {
        return driver.getTitle();
    }

    public String hasH1() {
        List<WebElement> h1s = driver.findElements(By.tagName("h1"));
        if (!h1s.isEmpty()) {
            return h1s.get(0).getText();
        }
        return "Page missing H1 heading";
    }

    public double getContrastRatio(By locator) {

        String textColor = getColor(locator);
        String bgColor = getBackgroundColor(locator);

        double lum1 = getRelativeLuminance(textColor);
        double lum2 = getRelativeLuminance(bgColor);

        double lighter = Math.max(lum1, lum2);
        double darker = Math.min(lum1, lum2);

        return (lighter + 0.05) / (darker + 0.05);
    }


}