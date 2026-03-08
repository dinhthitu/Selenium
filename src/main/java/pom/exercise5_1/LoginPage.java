package pom.exercise5_1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pom.BasePage;

public class LoginPage extends BasePage {

    public LoginPage (WebDriver driver) {
        super(driver);
    }

    public static final By USERNAME = By.id("userName");
    public static final By PASSWORD = By.id("password");
    public static final By LOGIN = By.id("login");

    public LoginPage enterUsername(String name) {
        senKeys(USERNAME, name);
        return this;
    }

    public LoginPage enterPassword(String pass) {
        senKeys(PASSWORD, pass);
        return this;
    }

    public DashboardPage clickSubmit() {
        click(LOGIN);
        return new DashboardPage(driver);
    }
}
