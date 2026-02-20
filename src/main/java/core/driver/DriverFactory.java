package core.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverFactory {

    public static WebDriver create(String browser) {
        if ("chrome".equalsIgnoreCase(browser)) {
            return new ChromeDriver();
        }
        throw new IllegalArgumentException("Unsupported browser: " + browser);
    }
}