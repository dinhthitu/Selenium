package core.base;

import core.config.ConfigReader;
import core.driver.DriverFactory;
import core.driver.DriverManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import utils.FileUtils;

public abstract class BaseTest {

    protected ConfigReader config;

    protected abstract ConfigReader loadConfig();

    @BeforeSuite
    public void setUpData() {
        FileUtils.createLoginCSV("src/test/resources/test-data/loginData.csv");
    }

    @BeforeMethod
    public void setUp() {
        config = loadConfig();
        WebDriver driver = DriverFactory.create(config.get("browser"),  config.getBoolean("headless"));
        DriverManager.set(driver);
    }

    @AfterMethod
    public void tearDown() {
        DriverManager.quit();
    }
}