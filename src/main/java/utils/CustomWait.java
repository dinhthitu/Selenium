package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CustomWait {

    private WebDriverWait wait;

    public CustomWait(WebDriver driver, int timeout) {
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
    }

    public void waitForLoadingDisappear(By loadingStatus) {
        wait.until(driver -> {
            try {
                WebElement loadingSt = driver.findElement(loadingStatus);
                return !loadingSt.isDisplayed();

            } catch (Exception e) {
                return true;
            }

        });
    }

    public void waitForText(By locator) {
        wait.until(driver -> {
            try {
                WebElement message = driver.findElement(locator);
                return message.isDisplayed();

            } catch (Exception ex) {
                return false;
            }

        });
    }
}
