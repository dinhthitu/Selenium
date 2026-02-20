package pom.exercise2_3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pom.BasePage;

public class LoginPage extends BasePage {

    public static final By PRACTICE_PAGE = By.xpath("//a[contains(normalize-space(), 'Practice')]");

    public static final By TEST_LOGIN_PAGE = By.linkText("Test Login Page");

    public static final By USERNAME = By.id("username");

    public static final By PASSWORD = By.id("password");

    public static final By SUBMIT = By.id("submit");


    public LoginPage(WebDriver driver) {
        super(driver);

    }

    public void openLoginPage() {
        waitForClickable(PRACTICE_PAGE).click();
        waitForClickable(TEST_LOGIN_PAGE).click();

    }
    public LoginPage enterUsername(String username) {
        senKeys(USERNAME, username);
        return this;
    }

    public LoginPage enterPassword(String password) {
        senKeys(PASSWORD, password);
        return this;
    }

    public SuccessPage clickSubmit() {
        waitForClickable(SUBMIT).click();
        return new SuccessPage(driver);
    }

}
