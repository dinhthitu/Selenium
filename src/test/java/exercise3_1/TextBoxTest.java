package exercise3_1;

import core.base.BaseTest;
import core.config.ConfigLoader;
import core.config.ConfigReader;
import core.driver.DriverManager;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pom.exercise3_1.TextBoxPage;

import static org.testng.AssertJUnit.assertEquals;

public class TextBoxTest extends BaseTest {

    private TextBoxPage textBoxPage;

    @BeforeMethod
    public void setup() {
        textBoxPage = new TextBoxPage(DriverManager.get());
        textBoxPage.openTextBoxPage();
    }

    @Override
    public ConfigReader loadConfig() {
        return new ConfigLoader("exercise3_1.properties");
    }


    @Test
    public void testSetCurrentAddress() {
        String currentAddress = textBoxPage
                .setCurrentAddress(config.get("currentAddress"))
                .deleteCurrentAddress()
                .setCurrentAddress(config.get("currentAddress"))
                .getCurrentAddress();

        assertEquals(currentAddress, config.get("currentAddress"));
    }
}
