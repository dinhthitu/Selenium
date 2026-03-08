package exercise4_2;

import core.base.BaseTest;
import core.config.ConfigLoader;
import core.config.ConfigReader;
import core.driver.DriverManager;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pom.exercise4_2.IFramePage;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class IFrameTest extends BaseTest {

    private IFramePage iframePage;

    @Override
    public ConfigReader loadConfig() {
        return new ConfigLoader("exercise4_2.properties");
    }

    @BeforeMethod
    @Override
    public void setUp() {
        super.setUp();
        iframePage = new IFramePage(DriverManager.get());
    }

    @Test
    public void switchIframeByIndex() {
        DriverManager.get().get(config.get("iframeUrl"));

        iframePage.switchToIframeByIndex(0);

        String text = iframePage.getIframeBodyText();
        System.out.println("IFrame text: " + text);
        assertTrue(text.length() > 0);

        iframePage.switchToMainContent();
    }

    @Test
    public void switchIframeById() {
        DriverManager.get().get(config.get("iframeUrl"));

        iframePage.switchToIframeById("mce_0_ifr");

        String text = iframePage.getIframeBodyText();
        assertTrue(text.length() > 0);

        iframePage.switchToMainContent();
    }


    @Test
    public void nestedFramesTop() {
        DriverManager.get().get(config.get("nestedFramesUrl"));

        iframePage.switchToIframeByLocator(IFramePage.FRAME_TOP);
        iframePage.switchToIframeByLocator(IFramePage.FRAME_LEFT);
        assertEquals(iframePage.getFrameBodyText(), "LEFT");

        iframePage.switchToParentFrame();
        iframePage.switchToIframeByLocator(IFramePage.FRAME_MIDDLE);
        assertEquals(iframePage.getFrameBodyText(), "MIDDLE");

        iframePage.switchToParentFrame();
        iframePage.switchToIframeByLocator(IFramePage.FRAME_RIGHT);
        assertEquals(iframePage.getFrameBodyText(), "RIGHT");

        iframePage.switchToMainContent();
    }

    @Test
    public void nestedFramesBottom() {
        DriverManager.get().get(config.get("nestedFramesUrl"));

        iframePage.switchToIframeByLocator(IFramePage.FRAME_BOTTOM);
        assertEquals(iframePage.getFrameBodyText(), "BOTTOM");

        iframePage.switchToMainContent();
    }

    @Test
    public void switchBetweenIframeAndMain() {
        DriverManager.get().get(config.get("iframeUrl"));

        iframePage.switchToIframeById("mce_0_ifr");

        iframePage.switchToMainContent();
        assertTrue(DriverManager.get().getCurrentUrl().contains("iframe"));
    }
}