package locator.exercise1_3;

import org.openqa.selenium.By;

public class LoginLocators {

    public static final By PRACTICE_PAGE = By.xpath("//a[contains(normalize-space(), 'Practice')]");
//    public static final By PRACTICE_PAGE = By.linkText("Practice");

    public static final By TEST_LOGIN_PAGE = By.linkText("Test Login Page");

    public static final By USERNAME = By.id("username");

    public static final By PASSWORD = By.id("password");

    public static final By SUBMIT = By.id("submit");

    public static final By LOGIN_SUCCESS = By.xpath("//h1[text()='Logged In Successfully']");

    public static final By ERROR_MSG = By.id("error");
}
