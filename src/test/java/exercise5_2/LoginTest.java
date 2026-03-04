package exercise5_2;

import builder.exercise5_2.LoginDataBuilder;
import core.base.BaseTest;
import core.config.ConfigLoader;
import core.config.ConfigReader;
import core.driver.DriverManager;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pom.exercise5_2.Login;

import static org.testng.Assert.*;

public class LoginTest extends BaseTest {

    private final String username;
    private final String password;
    private final boolean expected;
    private final String source;

    public LoginTest(String username, String password,
                     boolean expected, String source) {
        this.username = username;
        this.password = password;
        this.expected = expected;
        this.source = source;
    }

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

    @Test
    public void testLogin() {
        System.out.println("Running test: " + source);

        Login loginPage = new LoginDataBuilder()
                .withUsername(username)
                .withPassword(password)
                .login(DriverManager.get());

        if (expected) {
            assertEquals(
                    loginPage.getSuccessText(),
                    config.get("successMessage")
            );
        } else {
            String errorMsg = loginPage.getErrorText();
            assertTrue(
                    errorMsg.equals(config.get("invalidUsernameMsg")) ||
                            errorMsg.equals(config.get("invalidPasswordMsg"))
            );
        }
    }
}