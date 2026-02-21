package exercise3_1;

import core.base.BaseTest;
import core.config.ConfigLoader;
import core.config.ConfigReader;
import core.driver.DriverManager;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pom.exercise3_1.ButtonPage;

import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertFalse;

public class ButtonTest extends BaseTest {

    @Override
    public ConfigReader loadConfig() {
        return new ConfigLoader("exercise3_1.properties");
    }

    private ButtonPage buttonPage;

    @BeforeMethod
    public void setup() {
        buttonPage = new ButtonPage(DriverManager.get());
        buttonPage.openButtonPage();
    }

    @Test
    public void testDoubleClickSuccess() {
        String message = buttonPage
                .doubleClickButton()
                .getDoubleClickMsg();

        assertEquals(message, config.get("doubleClickMsg"));
    }

    @Test
    public void testDoubleClickUnsuccessful() {
        buttonPage.moveToButtonAndClick();
        assertFalse(buttonPage.isDoubleClickMsgDisplayed());
    }

    @Test
    public void testRightClickSuccess() {
        String message = buttonPage
                .rightClickButton()
                .getRightClickMsg();

        assertEquals(message, config.get("rightClickMsg"));
    }

    @Test
    public void testRightClickUnsuccessful() {
        buttonPage.doubleClickButton();
        assertFalse(buttonPage.isRightClickMsgDisplayed());
    }

    @Test
    public void testMoveAndClickSuccess() {
        String message = buttonPage
                .moveToButtonAndClick()
                .getClickMsg();

        assertEquals(message, config.get("clickMsg"));
    }
}
