package exercise4_1;

import core.base.BaseTest;
import core.config.ConfigLoader;
import core.config.ConfigReader;
import core.driver.DriverManager;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pom.exercise4_1.AlertPage;

import static org.testng.AssertJUnit.assertEquals;

public class AlertTest extends BaseTest {

    @Override
    public ConfigReader loadConfig() {
        return new ConfigLoader("exercise4_1.properties");
    }

    private AlertPage alertPage;

    @BeforeMethod(alwaysRun = true)
    public void init() {
        alertPage = new AlertPage(DriverManager.get());
    }

    @Test
    public void alert_test() {

        //Simple alert
        String alertResult = alertPage
                .clickJSAlert()
                .acceptAlert()
                .getAlertResult();
        assertEquals(config.get("acceptAlert"), alertResult);

        //Confirm dialog
        String confirmResult = alertPage
                .clickJSConfirm()
                .dismissAlert()
                .getAlertResult();
        assertEquals(config.get("confirmAlert"), confirmResult);

        //Prompt dialog
        String promptResult = alertPage
                .clickJSPrompt()
                .sendKeyAlert(config.get("input"))
                .acceptAlert()
                .getAlertResult();
        assertEquals(config.get("promptAlert"), promptResult);

    }


}
