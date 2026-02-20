package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {

    private WebDriver driver;
    private WebDriverWait wait;
    private JavascriptExecutor js;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        this.js = (JavascriptExecutor) driver;
    }

    protected void scrollToCenter(WebElement element) {
        js.executeScript(
                "arguments[0].scrollIntoView({block:'center'});",
                element
        );
    }

    public void waitForVisibility(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public WebElement waitForClickable(By locator) {
        WebElement element = findElement(locator);
        scrollToCenter(element);
        return wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public String getText(By locator) {
        WebElement element = findElement(locator);
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        scrollToCenter(element);
        return element.getText();
    }

    public WebElement findElement(By locator) {
        return driver.findElement(locator);
    }

    public void senKeys(By locator, String text) {
        WebElement element = findElement(locator);
        scrollToCenter(element);
        waitForVisibility(element);
        element.clear();
        element.sendKeys(text);
    }

    public void waitForInvisibility(By locator) {
        wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
    }
}
