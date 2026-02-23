package exercise4_2;

import core.base.BaseTest;
import core.config.ConfigLoader;
import core.config.ConfigReader;
import core.driver.DriverManager;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pom.exercise4_2.WindowPage;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class WindowTest extends BaseTest {

    private WindowPage windowPage;

    @Override
    public ConfigReader loadConfig() {
        return new ConfigLoader("exercise4_2.properties");
    }

    @BeforeMethod
    @Override
    public void setUp() {
        super.setUp();
        windowPage = new WindowPage(DriverManager.get());
    }

    @Test
    public void newTab() {
        DriverManager.get().get(config.get("windowUrl"));

        String mainHandle = windowPage.getMainWindowHandle();

        windowPage.clickNewTab();
        assertEquals(windowPage.getAllWindowHandles().size(), 2);

        windowPage.switchToNewWindow(mainHandle);
        assertEquals(windowPage.getHeadingText(), "This is a sample page");

        windowPage.closeCurrentWindow()
                .switchToWindow(mainHandle);
        assertEquals(windowPage.getAllWindowHandles().size(), 1);
    }

    @Test
    public void newWindow() {
        DriverManager.get().get(config.get("windowUrl"));

        String mainHandle = windowPage.getMainWindowHandle();

        windowPage.clickNewWindow();
        assertEquals(windowPage.getAllWindowHandles().size(), 2);

        windowPage.switchToNewWindow(mainHandle);
        assertEquals(windowPage.getHeadingText(), "This is a sample page");

        windowPage.closeCurrentWindow()
                .switchToWindow(mainHandle);
        assertEquals(windowPage.getAllWindowHandles().size(), 1);
        assertTrue(windowPage.getCurrentUrl().contains("browser-windows"));
    }


}