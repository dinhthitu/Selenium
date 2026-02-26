package exercise4_3;

import core.base.BaseTest;
import core.config.ConfigLoader;
import core.config.ConfigReader;
import core.driver.DriverManager;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pom.exercise4_3.ButtonPage;

import static org.testng.AssertJUnit.assertEquals;

public class ButtonPageTest extends BaseTest {

    private ButtonPage buttonPage;

    @Override
    public ConfigReader loadConfig() {
        return new ConfigLoader("exercise4_3.properties");
    }

    @BeforeMethod
    @Override
    public void setUp() {
        super.setUp();
        DriverManager.get().get(config.get("url") + config.get("button"));
        buttonPage = new ButtonPage(DriverManager.get());
    }

    @Test
    public void clickBtn() {
        String message = buttonPage.clickBtn().getText();
        assertEquals(message, config.get("clickMsg"));
    }


}
