package exercise1_1;

import core.config.ConfigReader;
import core.driver.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import java.util.Properties;

public class Exercise1_1 {

    @Test
    public void openBrowserAndNavigate() {

        Properties props =
                ConfigReader.load("exercise1_1.properties");

        WebDriver driver = DriverFactory.initDriver(props);
        driver.get(props.getProperty("url"));
        driver.quit();
    }
}
