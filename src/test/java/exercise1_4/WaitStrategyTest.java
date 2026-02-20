package exercise1_4;

import core.base.BaseTest;
import core.config.ConfigLoader;
import core.config.ConfigReader;
import core.driver.DriverManager;
import locator.exercise1_4.WaitLocators;
import org.testng.annotations.Test;
import pom.exercise1_4.DynamicLoading;
import utils.CustomWait;

import static org.testng.AssertJUnit.assertEquals;

public class WaitStrategyTest extends BaseTest {

    private DynamicLoading dynamicLoading;

    @Override
    protected ConfigReader loadConfig() {
        return new ConfigLoader("exercise1_4.properties");
    }

    @Test(priority = 1)
    public void testSuccessMessage(){

        dynamicLoading = new DynamicLoading(DriverManager.get());
        dynamicLoading.clickStartBtn();
        dynamicLoading.waitForLoadingDisappear();
        String successMessage = dynamicLoading.getSuccessMessage();
        assertEquals("Hello World!", successMessage);
    }


    // advance
    @Test (priority = 2)
    public void testAdvance(){

        CustomWait waitFunc = new CustomWait(DriverManager.get(), 10);

        DriverManager.get().findElement(WaitLocators.START_BTN).click();

        waitFunc.waitForLoadingDisappear(WaitLocators.LOADING_STATUS);

        waitFunc.waitForText(WaitLocators.SUCCESS_MESSAGE);

        assertEquals("Hello World!", DriverManager.get().findElement(WaitLocators.SUCCESS_MESSAGE).getText());

    }


}
