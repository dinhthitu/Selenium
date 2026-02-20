package exercise1_3;

import core.base.BaseTest;
import core.config.ConfigLoader;
import core.config.ConfigReader;
import core.driver.DriverManager;
import locator.exercise1_3.LoginLocators;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pom.exercise1_3.LoginPage;

import static org.testng.AssertJUnit.assertEquals;

public class LoginTest extends BaseTest {

    private LoginPage loginPage;

    @Override
    protected ConfigReader loadConfig() {
        return new ConfigLoader("exercise1_3.properties");
    }

    @BeforeMethod
    public void initPage()
    {
        loginPage = new LoginPage(DriverManager.get());
    }

    @Test(priority = 1)
    public void test_login_successfully(){

        loginPage.openLoginPage();
        loginPage.
                login(LoginLocators.USERNAME, LoginLocators.PASSWORD, config.get("username"), config.get("password"))
                .clickSubmit(LoginLocators.SUBMIT);

        assertEquals(config.get("message"), loginPage.getSuccessMessage(LoginLocators.LOGIN_SUCCESS));
    }


    @Test(priority = 2)
    public void test_login_invalid_username(){

        loginPage.openLoginPage();
        loginPage.
                login(LoginLocators.USERNAME, LoginLocators.PASSWORD, config.get("invalidUsername"), config.get("password"))
                .clickSubmit(LoginLocators.SUBMIT);

        assertEquals("Your username is invalid!", loginPage.getErrorMessage(LoginLocators.ERROR_MSG));
    }

    @Test(priority = 3)
    public void test_login_invalid_password(){

        loginPage.openLoginPage();
        loginPage.
                login(LoginLocators.USERNAME, LoginLocators.PASSWORD, config.get("username"), config.get("invalidPassword"))
                .clickSubmit(LoginLocators.SUBMIT);

        assertEquals("Your password is invalid!", loginPage.getErrorMessage(LoginLocators.ERROR_MSG));
    }
}


