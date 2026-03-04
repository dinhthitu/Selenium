package builder.exercise5_2;

import org.openqa.selenium.WebDriver;
import pom.exercise5_2.Login;

public class LoginDataBuilder {

    private String username;
    private String password;

    public LoginDataBuilder withUsername(String username) {
        this.username = username;
        return this;
    }

    public LoginDataBuilder withPassword(String password) {
        this.password = password;
        return this;
    }

    public Login login(WebDriver driver) {
        return new Login(driver)
                .enterUsername(username)
                .enterPassword(password)
                .submit();
    }

}
