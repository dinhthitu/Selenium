package pom.exercise5_2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pom.BasePage;

public class Login extends BasePage {

    public Login(WebDriver driver) {
        super(driver);
    }

    public static final By USERNAME = By.id("username");
    public static final By PASSWORD = By.id("password");
    public static final By SUBMIT = By.id("submit");
    public static final By SUCCESS_MSG = By.xpath("//h1[contains(text(), 'Logged In Successfully')]");
    public static final By ERROR_MSG = By.id("error");

    public Login enterUsername(String username) {
        senKeys(USERNAME, username);
        return this;
    }

    public Login enterPassword(String password) {
        senKeys(PASSWORD, password);
        return this;
    }

    public String getSuccessText() {
        return getText(SUCCESS_MSG);
    }

    public Login submit() {
        click(SUBMIT);
        return this;
    }


    public String getErrorText() {
        return getText(ERROR_MSG);
    }

}
