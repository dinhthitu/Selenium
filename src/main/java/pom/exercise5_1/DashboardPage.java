package pom.exercise5_1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pom.BasePage;

public class DashboardPage extends BasePage {

    public DashboardPage (WebDriver driver) {
        super(driver);
    }

    public static final By USER_ACCOUNT = By.id("userName-value");

    public String getCurrentUser() {
        return getText(USER_ACCOUNT);
    }

    public String getUrl() {
        return getCurrentUrl();
    }
}
