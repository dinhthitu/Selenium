package exercise5_1;

import builder.exercise5_1.LoginBuilder;
import core.base.BaseTest;
import core.config.ConfigLoader;
import core.config.ConfigReader;
import core.driver.DriverManager;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pom.exercise5_1.DashboardPage;
import pom.exercise5_1.LoginPage;

import static org.testng.AssertJUnit.assertEquals;

public class LoginTest extends BaseTest {

//    private LoginPage loginPage;

    @Override
    public ConfigReader loadConfig() {
        return new ConfigLoader("exercise5_1.properties");
    }

    @BeforeMethod
    @Override
    public void setUp() {
        super.setUp();
        DriverManager.get().get(config.get("url") + config.get("login.url"));
//        loginPage = new LoginPage(DriverManager.get());
    }

    @Test
    public void login_success() {

        DashboardPage dashboard = new LoginBuilder()
                .withUsername(config.get("u.name"))
                        .withPassword(config.get("u.password"))
                                .login(DriverManager.get());

        dashboard.waitForReadyPage();

        assertEquals(config.get("u.name"), dashboard.getCurrentUser());
        assertEquals((config.get("url") + config.get("profile.url")), dashboard.getCurrentUrl());

    }



}
