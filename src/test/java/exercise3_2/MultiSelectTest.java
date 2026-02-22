package exercise3_2;

import core.config.ConfigLoader;
import core.config.ConfigReader;
import core.driver.DriverManager;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pom.exercise3_2.MultiSelectPage;
import core.base.BaseTest;

import static org.testng.AssertJUnit.assertTrue;

public class MultiSelectTest extends BaseTest {

    @Override
    public ConfigReader loadConfig() {
        return new ConfigLoader("exercise3_2.properties");
    }

    private MultiSelectPage multiSelectPage;

    @BeforeMethod(alwaysRun = true)
    public void setUpPage() {
        multiSelectPage = new MultiSelectPage(DriverManager.get());
        multiSelectPage.openMultiSelectPage();
    }

    @Test
    public void select_multiple_options_by_text_and_value() {

        multiSelectPage
                .selectByText(config.get("multi.text"))
                .selectByValue(config.get("multi.value"));

        Assert.assertEquals(multiSelectPage.getSelectSize(), 2);
    }

    @Test
    public void deselect_option_by_text() {

        multiSelectPage
                .selectByText(config.get("multi.text"));

        assertTrue(multiSelectPage.getSelectSize() > 0);

    }

    @Test
    public void deselect_all_option() {

        multiSelectPage.deselectAll();

        Assert.assertEquals(multiSelectPage.getSelectSize(), 0);

    }


}