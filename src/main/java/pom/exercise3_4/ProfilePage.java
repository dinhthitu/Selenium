package pom.exercise3_4;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pom.BasePage;

public class ProfilePage extends BasePage {

    public ProfilePage(WebDriver driver) {
        super(driver);
    }

    public static final By LOGOUT = By.xpath("//button[text() = 'Logout']");
    public static final By USERNAME_VALUE = By.id("userName-value");

    public LoginPage logout() {
        WebElement logout = waitForVisibilityElementLocated(LOGOUT);
        scrollToCenter(logout);
        action
                .click(logout)
                .perform();
        return new LoginPage(driver);
    }

    public boolean isLoggedIn() {
        WebElement userLogin = waitForVisibilityElementLocated(USERNAME_VALUE);
        scrollToCenter(userLogin);
        if (userLogin.isDisplayed()) {
            return true;
        }
        return false;
    }
}
