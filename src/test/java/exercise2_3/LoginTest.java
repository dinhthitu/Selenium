package exercise2_3;

import core.base.BaseTest;
import core.config.ConfigLoader;
import core.config.ConfigReader;
import core.driver.DriverManager;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pom.exercise2_3.LoginPage;
import pom.exercise2_3.SuccessPage;

import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertTrue;

public class LoginTest extends BaseTest {

    private LoginPage loginPage;
    private SuccessPage successPage;

    @Override
    protected ConfigReader loadConfig() {
        return new ConfigLoader("exercise2_3.properties");
    }

    @BeforeMethod
    public void initPage(){
        loginPage = new LoginPage(DriverManager.get());
        loginPage.openLoginPage();
    }

    @Test(priority = 1)
    public void test_login_successfully() {

        successPage = loginPage
                .enterUsername(config.get("username"))
                .enterPassword(config.get("password"))
                .clickSubmit();

        assertTrue(successPage.isLoggedIn());
        assertEquals(config.get("successUrl"), successPage.getSuccessUrl());
        assertEquals(config.get("message"), successPage.getSuccessText());
    }
}
