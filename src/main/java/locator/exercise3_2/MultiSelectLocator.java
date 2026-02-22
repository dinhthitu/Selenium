package locator.exercise3_2;

import org.openqa.selenium.By;

public class MultiSelectLocator {

    public static final By WIDGETS = By.xpath("//div[normalize-space() = 'Widgets']");
    public static final By SELECT_MENU = By.xpath("//span[text() = 'Select Menu']");
    public static final By OLD_SELECT_MENU = By.id("oldSelectMenu");
    public static final By MULTI_SELECT = By.id("cars");
}
