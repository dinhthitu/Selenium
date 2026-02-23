package pom.exercise4_2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pom.BasePage;

public class IFramePage extends BasePage {

    public IFramePage(WebDriver driver) {
        super(driver);
    }

    public static final By IFRAME          = By.id("mce_0_ifr");
    public static final By IFRAME_BODY     = By.id("tinymce");


    public static final By FRAME_TOP       = By.name("frame-top");
    public static final By FRAME_BOTTOM    = By.name("frame-bottom");
    public static final By FRAME_LEFT      = By.name("frame-left");
    public static final By FRAME_MIDDLE    = By.name("frame-middle");
    public static final By FRAME_RIGHT     = By.name("frame-right");


    public IFramePage switchToIframeById(String id) {
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.id(id)));
        return this;
    }

    public IFramePage switchToIframeByName(String name) {
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.name(name)));
        return this;
    }

    public IFramePage switchToIframeByIndex(int index) {
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(index));
        return this;
    }

    public IFramePage switchToIframeByLocator(By locator) {
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(locator));
        return this;
    }

    public IFramePage switchToMainContent() {
        driver.switchTo().defaultContent();
        return this;
    }

    public IFramePage switchToParentFrame() {
        driver.switchTo().parentFrame();
        return this;
    }


    public String getIframeBodyText() {
        WebElement body = waitForVisibilityElementLocated(IFRAME_BODY);
        return body.getText();
    }

    public IFramePage clearIframeBody() {
        WebElement body = waitForVisibilityElementLocated(IFRAME_BODY);
        body.clear();
        return this;
    }

    public IFramePage typeInIframe(String text) {
        WebElement body = waitForVisibilityElementLocated(IFRAME_BODY);
        body.clear();
        body.sendKeys(text);
        return this;
    }


    public String getFrameBodyText() {
        return driver.findElement(By.tagName("body")).getText();
    }
}