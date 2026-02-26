package pom.exercise4_3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pom.BasePage;


public class ButtonPage extends BasePage {

    public ButtonPage(WebDriver driver) {
        super(driver);
    }

    public static final By CLICK_BTN = By.xpath("(//div[@class = 'mt-4']/button)[2]");
    public static final By MESSAGE = By.xpath("//p[contains(@id , 'ClickMessage')]");


    public ButtonPage clickBtn() {
        waitForReadyPage();
        WebElement clickBtn = findElement(CLICK_BTN);
        action .click(clickBtn).perform();
        return this;
    }

    public String getText() {
        waitForVisibilityElementLocated(MESSAGE);
        return getText(MESSAGE);
    }
}
