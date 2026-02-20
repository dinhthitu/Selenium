package pom.exercise1_3;

import locator.exercise1_3.LoginLocators;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pom.BasePage;

public class LoginPage extends BasePage {

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public LoginPage openLoginPage() {

        waitForClickable(LoginLocators.PRACTICE_PAGE).click();
        waitForClickable(LoginLocators.TEST_LOGIN_PAGE).click();
        return this;
    }

    public LoginPage login (By locator1, By locator2, String username, String password) {
        senKeys(locator1, username);
        senKeys(locator2, password);
        return this;
    }

    public void clickSubmit(By locator) {
        waitForClickable(locator).click();
    }

    public String getSuccessMessage(By locator) {
        return getText(locator);
    }

    public String getErrorMessage(By locator) {
        return getText(locator);
    }
}
