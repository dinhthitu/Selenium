package locator.exercise1_4;

import org.openqa.selenium.By;

public class WaitLocators {

    public static final By START_BTN = By.xpath("//div[@id='start']/child::button");

    public static final By LOADING_STATUS = By.xpath("//div[@id='loading']/img");

    public static final By SUCCESS_MESSAGE = By.xpath("//h4[text()='Hello World!']");
}
