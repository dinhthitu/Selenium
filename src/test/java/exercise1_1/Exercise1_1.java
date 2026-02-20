package exercise1_1;

import core.base.BaseTest;
import core.config.ConfigLoader;
import core.config.ConfigReader;
import core.driver.DriverManager;
import org.testng.annotations.Test;

public class Exercise1_1 extends BaseTest {

    @Override
    protected ConfigReader loadConfig() {
        return new ConfigLoader("exercise1_1.properties");
    }

    @Test
    void openBrowser() {
        System.out.println("Title = " + DriverManager.get().getTitle());
    }
}