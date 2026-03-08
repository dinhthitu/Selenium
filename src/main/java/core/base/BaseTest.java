package core.base;

import core.config.ConfigReader;
import core.driver.DriverFactory;
import core.driver.DriverManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public abstract class BaseTest {

    protected ConfigReader config;

    protected abstract ConfigReader loadConfig();

    @BeforeMethod
    public void setUp() {
        config = loadConfig();
        WebDriver driver = DriverFactory.create(config.get("browser"),  config.getBoolean("headless"));
        DriverManager.set(driver);
//        DriverManager.get().get(config.get("baseUrl"));
    }

    @AfterMethod
    public void tearDown() {
        DriverManager.quit();
    }
}