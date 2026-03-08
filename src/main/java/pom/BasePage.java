package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class BasePage {

    protected WebDriver driver;
    protected WebDriverWait wait;
    protected JavascriptExecutor js;
    protected Actions action;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        this.js = (JavascriptExecutor) driver;
        this.action = new Actions(driver);
        PageFactory.initElements(driver, this);

    }

    public void scrollToCenter(WebElement element) {
        js.executeScript(
                "arguments[0].scrollIntoView({block:'center'});",
                element
        );
    }

    public void waitForVisibility(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
        scrollToCenter(element);
    }

    public WebElement waitForClickable(By locator) {
        WebElement clickableBtn = wait.until(ExpectedConditions.elementToBeClickable(locator));
        return clickableBtn;
    }

    public WebElement waitForVisibilityElementLocated(By locator) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public void click(By locator) {
        wait.until(ExpectedConditions.elementToBeClickable(locator)).click();
    }

    public String getText(By locator) {
        WebElement element = wait.until(
                ExpectedConditions.visibilityOfElementLocated(locator)
        );
        scrollToCenter(element);
        return element.getText();
    }

    public WebElement findElement(By locator) {
        return driver.findElement(locator);
    }

    public List<WebElement> findElements(By locator) {
        return driver.findElements(locator);
    }

    public void senKeys(By locator, String text) {
        WebElement element = findElement(locator);
        waitForVisibility(element);
        element.clear();
        element.sendKeys(text);
    }

    public void waitForInvisibility(By locator) {
        wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
    }

    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }

    public void waitForReadyPage() {
        wait.until(driver ->
                ((JavascriptExecutor) driver)
                        .executeScript("return document.readyState")
                        .equals("complete")
        );
    }

    public void selectByVisibleText(By locator, String text) {
        WebElement element = waitForVisibilityElementLocated(locator);

        scrollToCenter(element);
        new Select(element).selectByVisibleText(text);
    }

    public void selectByValue(By locator, String value) {
        WebElement element = waitForVisibilityElementLocated(locator);
        scrollToCenter(element);
        new Select(element).selectByValue(value);
    }

    public void selectByIndex(By locator, int index) {
        WebElement element = waitForVisibilityElementLocated(locator);
        scrollToCenter(element);
        new Select(element).selectByIndex(index);
    }



}
