package exercise5_2;

import builder.data.LoginDataProvider;
import builder.exercise5_2.LoginDataBuilder;
import core.base.BaseTest;
import core.config.ConfigLoader;
import core.config.ConfigReader;
import core.driver.DriverManager;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pom.exercise5_2.Login;

import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertTrue;

public class LoginCSVTest extends BaseTest {

    @Override
    public ConfigReader loadConfig() {
        return new ConfigLoader("exercise5_2.properties");
    }

    @BeforeMethod
    @Override
    public void setUp() {
        super.setUp();
        DriverManager.get().get(config.get("url"));
    }

    @Test(
            dataProvider = "loginData",
            dataProviderClass = LoginDataProvider.class
    )
    public void testLogin(String username, String password, boolean expected) {

        Login loginPage = new LoginDataBuilder()
                .withUsername(username)
                .withPassword(password)
                .login(DriverManager.get());

        if (expected) {
            String successMsg = loginPage.getSuccessText();
            assertEquals(successMsg, config.get("successMessage"));
        } else {
            String errorMsg = loginPage.getErrorText();
            assertTrue(
                    errorMsg.equals(config.get("invalidUsernameMsg")) ||
                            errorMsg.equals(config.get("invalidPasswordMsg"))
            );
        }
    }


}
