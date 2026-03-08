package builder.exercise5_1;

import org.openqa.selenium.WebDriver;
import pom.exercise5_1.DashboardPage;
import pom.exercise5_1.LoginPage;

public class LoginBuilder {

    private String userName;
    private String password;

    public LoginBuilder withUsername(String userName) {
        this.userName = userName;
        return this;
    }

    public LoginBuilder withPassword(String password) {
        this.password = password;
        return this;
    }

    public DashboardPage login (WebDriver driver) {
        LoginPage loginPage = new LoginPage(driver);
        return loginPage
                .enterUsername(userName)
                .enterPassword(password)
                .clickSubmit();

    }

}
