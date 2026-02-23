package pom.exercise3_4;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pom.BasePage;

import java.time.Duration;


public class LoginPage extends BasePage {

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public static final By USERNAME = By.xpath("//input[@placeholder = 'UserName']");
    public static final By PASSWORD = By.id("password");
    public static final By SUBMIT = By.id("login");

    public ProfilePage login(String text, String pass) {
        WebElement userName = waitForVisibilityElementLocated(USERNAME);
        WebElement password = waitForVisibilityElementLocated(PASSWORD);

        userName.click();
        userName.clear();
        userName.sendKeys(text);

        password.click();
        password.clear();
        password.sendKeys(pass);

        WebElement submit = waitForClickable(SUBMIT);
        submit.click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.urlContains("/profile"));

        return new ProfilePage(driver);
    }
}
