package exercise5_3;

import core.base.BaseTest;
import core.config.ConfigLoader;
import core.config.ConfigReader;
import core.driver.DriverManager;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pom.exercise5_3.HomePage;

import static org.testng.Assert.assertNotEquals;
import static org.testng.AssertJUnit.*;

public class HomePageTest extends BaseTest {

    private HomePage homePage;

    @Override
    public ConfigReader loadConfig() {
        return new ConfigLoader("exercise5_3.properties");
    }

    @BeforeMethod
    @Override
    public void setUp() {
        super.setUp();
        config = loadConfig();
        DriverManager.get().get(config.get("url"));
        homePage = new HomePage(DriverManager.get());
    }

    @Test(priority = 1)
    public void banner_ariaLabel() {
        String ariaLabel = homePage.getAriaLabel(HomePage.BANNER);
        assertNotNull(ariaLabel, "Banner missing aria-label");
    }

    @Test(priority = 2)
    public void categoryCard_roleAttribute() {
        String role = homePage.getRole(HomePage.CATEGORY_CARDS);
        assertNull(role, "Card missing role");
    }


    @Test(priority = 3)
    public void keyboard_tabNavigation() {
        homePage.pressTabTimes(3);

        String focusedInfo = homePage.getFocusedElementInfo();

        assertNotNull(homePage.getFocusedElement());
    }

    @Test(priority = 4)
    public void keyboard_shiftTabNavigation() {
        homePage.pressTabTimes(3);
        homePage.pressShiftTab();
        assertNotNull(homePage.getFocusedElement());
    }

    @Test(priority = 5)
    public void keyboard_enterToNavigate() {
        homePage.pressTabTimes(4)
                .pressEnter();

        String url = DriverManager.get().getCurrentUrl();
        assertNotEquals(url, config.get("url"));
    }

    @Test(priority = 6)
    public void colorContrast_banner() {
        String color = homePage.getColor(HomePage.BANNER);
        String bgColor = homePage.getBackgroundColor(HomePage.BANNER);
        double contrast = homePage.getContrastRatio(HomePage.BANNER);

        System.out.println("Color: "      + color);
        System.out.println("Background: " + bgColor);

        assertNotNull(color);
        assertNotNull(bgColor);
        assertTrue("Contrast ratio does not meet WCAG standard", contrast >= 4.5);
    }

    @Test(priority = 7)
    public void pageTitle_screenReader() {
        String title = homePage.getPageTitle();
        System.out.println("Page title: " + title);

        assertNotNull(title);
        assertFalse(title.trim().isEmpty());
    }

    @Test(priority = 8)
    public void h1_screenReader() {
        String h1 = homePage.hasH1();
        assertNotNull(h1);
    }


}