package core.driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

public class DriverFactory {

    public static WebDriver create(String browser, boolean headless) {

        if (!browser.equalsIgnoreCase("chrome")) {
            throw new IllegalArgumentException("Unsupported browser: " + browser);
        }

        WebDriverManager.chromedriver().setup();

        ChromeOptions options = new ChromeOptions();
        boolean isLinux = System.getProperty("os.name").toLowerCase().contains("linux");

        if (headless || isLinux) {
            options.addArguments("--headless=new");
            options.addArguments("--no-sandbox");
            options.addArguments("--disable-dev-shm-usage");
            options.addArguments("--window-size=1920,1080");
        }

        String downloadPath = Paths.get("test-output", "downloads")
                .toAbsolutePath().toString();

        Map<String, Object> prefs = new HashMap<>();
        prefs.put("download.default_directory", downloadPath);
        prefs.put("download.prompt_for_download", false);

        options.setExperimentalOption("prefs", prefs);


        return new ChromeDriver(options);
    }
}