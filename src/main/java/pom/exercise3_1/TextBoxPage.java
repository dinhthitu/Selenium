package pom.exercise3_1;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pom.BasePage;

public class TextBoxPage extends BasePage {

    public static final By CURRENT_ADDRESS = By.id("currentAddress");
    public static final By ELEMENT_BTN = By.xpath("//div[normalize-space()='Elements']");
    public static final By TEXT_BOX = By.xpath("//span[text()='Text Box']");

    public TextBoxPage(WebDriver driver) {
        super(driver);
    }

    public TextBoxPage openTextBoxPage() {
        waitForClickable(ELEMENT_BTN).click();
        WebElement button = waitForClickable(TEXT_BOX);
        scrollToCenter(button);
        button.click();
        return this;
    }

    public TextBoxPage setCurrentAddress(String address) {
        WebElement currentAddress = findElement(CURRENT_ADDRESS);
        action
                .click(currentAddress)
                .sendKeys(address)
                .perform();
        return this;
    }

    public TextBoxPage deleteCurrentAddress() {
        WebElement currentAddress = findElement(CURRENT_ADDRESS);
        action
                .click(currentAddress)
                .keyDown(Keys.CONTROL)
                .sendKeys("a")
                .keyUp(Keys.CONTROL)
                .sendKeys(Keys.BACK_SPACE)
                .perform();
        return this;
    }

    public String getCurrentAddress() {
        WebElement currentAddress = findElement(CURRENT_ADDRESS);
        return currentAddress.getAttribute("value");
    }

}
