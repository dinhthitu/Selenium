package exercise1_2;

import core.base.BaseTest;
import core.config.ConfigLoader;
import core.config.ConfigReader;
import core.driver.DriverManager;
import locator.exercise1_2.Elements;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class ElementsTest extends BaseTest {

    @Override
    protected ConfigReader loadConfig() {
        return new ConfigLoader("exercise1_2.properties");
    }

    @Test
    void verifyMenuLocators() {
        Assert.assertTrue(DriverManager.get().findElement(Elements.TEXT_BOX_MENU).isDisplayed());
        Assert.assertTrue(DriverManager.get().findElement(Elements.BROKEN_LINKS).isDisplayed());
        Assert.assertTrue(DriverManager.get().findElement(Elements.UP_DOWN).isDisplayed());
    }

    @Test
    void verifyInputFields() {
        DriverManager.get().findElement(Elements.TEXT_BOX_MENU).click();

        Assert.assertTrue(DriverManager.get().findElement(Elements.USERNAME).isDisplayed());
        Assert.assertTrue(DriverManager.get().findElement(Elements.PERMANENT_ADDRESS).isDisplayed());
    }

    @Test
    void verifyWebTablesLocator() {
        Assert.assertTrue(DriverManager.get().findElement(Elements.WEB_TABLES).isDisplayed());
    }

    @Test
    void verifyChainedLocator() {
        DriverManager.get().findElement(Elements.UPLOAD_FILE).sendKeys("C:\\fakepath\\test.txt");
        Assert.assertTrue(true, "Upload file locator works");
    }

    @Test
    void verifyLinks() {
        DriverManager.get().findElement(Elements.VALID_LINK).click();
        DriverManager.get().navigate().back();

        DriverManager.get().findElement(Elements.INVALID_LINK).click();
        DriverManager.get().navigate().back();
    }

    @Test
    void verifyTagNameLocator() {
        List<WebElement> links = DriverManager.get().findElements(Elements.ALL_LINKS);
        Assert.assertTrue(links.size() > 0, "Links should not be empty");
    }

    @Test
    void verifyAdvancedXpath() {
        DriverManager.get().findElement(Elements.TEXT_BOX_MENU).click();

        Assert.assertTrue(DriverManager.get().findElement(Elements.XPATH_CONTAIN).isDisplayed());
        Assert.assertTrue(DriverManager.get().findElement(Elements.XPATH_STARTWITHS).isDisplayed());
        Assert.assertTrue(DriverManager.get().findElement(Elements.XPATH_BY_TEXT).isDisplayed());
        Assert.assertTrue(DriverManager.get().findElement(Elements.XPATH_BY_ID).isDisplayed());
    }
}