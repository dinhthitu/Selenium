package exercise3_4;

import core.base.BaseTest;
import core.config.ConfigLoader;
import core.config.ConfigReader;
import core.driver.DriverFactory;
import core.driver.DriverManager;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pom.exercise3_4.LoginPage;
import pom.exercise3_4.ProfilePage;
import utils.CookieUtils;

import java.io.IOException;
import java.time.Duration;

import static org.testng.AssertJUnit.assertTrue;

public class PersistenceTest extends BaseTest {

    private LoginPage loginPage;
    private ProfilePage profilePage;

    @Override
    public ConfigReader loadConfig() {
        return new ConfigLoader("exercise3_4.properties");
    }

    @BeforeMethod
    @Override
    public void setUp() {
        super.setUp();
        config = loadConfig();
        WebDriver driver = DriverFactory.create(config.get("browser"),  config.getBoolean("headless"));
        DriverManager.set(driver);
        DriverManager.get().get(config.get("baseUrl") + "/login");
        loginPage = new LoginPage(DriverManager.get());
    }

    @Test
    public void login() throws IOException, ClassNotFoundException {

        loginPage.login(config.get("name"), config.get("pass"));
        for(Cookie cookie : CookieUtils.getAllCookies()) {
            System.out.println(cookie.getName() + "  -  " + cookie.getValue());
        }
        CookieUtils.saveToFile("src/test/resources/upload/demo-qa.txt");

        DriverManager.quit();

        WebDriver driver = DriverFactory.create(config.get("browser"), config.getBoolean("headless"));
        DriverManager.set(driver);
        DriverManager.get().get(config.get("baseUrl") + "/login");

        CookieUtils.loadFromFile("src/test/resources/upload/demo-qa.txt");

        new WebDriverWait(DriverManager.get(), Duration.ofSeconds(10))
                .until(d -> ((JavascriptExecutor) d)
                        .executeScript("return document.readyState").equals("complete"));


        DriverManager.get().get(config.get("baseUrl") + "/profile");

        profilePage = new ProfilePage(DriverManager.get());
        assertTrue(profilePage.isLoggedIn());
    }
}
