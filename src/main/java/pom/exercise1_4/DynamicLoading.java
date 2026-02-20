package pom.exercise1_4;

import locator.exercise1_4.WaitLocators;
import org.openqa.selenium.WebDriver;
import pom.BasePage;

public class DynamicLoading extends BasePage {

    private WebDriver driver;

    public DynamicLoading(WebDriver driver) {
        super(driver);
    }

    public void clickStartBtn() {
        waitForClickable(WaitLocators.START_BTN).click();
    }

    public void waitForLoadingDisappear() {
        waitForInvisibility(WaitLocators.LOADING_STATUS);
    }

    public String getSuccessMessage() {
        return getText(WaitLocators.SUCCESS_MESSAGE);
    }
}
