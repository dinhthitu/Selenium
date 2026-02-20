package core.driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class DriverFactory {

    public static WebDriver create(String browser, boolean headless) {

        if (!browser.equalsIgnoreCase("chrome")) {
            throw new IllegalArgumentException("Unsupported browser: " + browser);
        }

        WebDriverManager.chromedriver().setup();

        ChromeOptions options = new ChromeOptions();

        if (headless) {
            options.addArguments("--headless=new");
            options.addArguments("--no-sandbox");
            options.addArguments("--disable-dev-shm-usage");
            options.addArguments("--window-size=1920,1080");
            options.addArguments("--disable-gpu");
        }

        return new ChromeDriver(options);
    }
}