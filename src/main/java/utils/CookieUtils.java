package utils;

import core.driver.DriverManager;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Set;


public class CookieUtils  {

    private static WebDriver driver() {
        return DriverManager.get();
    }

    public static void addCookie(Cookie cookie) {
        driver().manage().addCookie(cookie);
    }

    public static Set<Cookie> getAllCookies() {
        return driver().manage().getCookies();
    }

    public static Cookie getCookie(String cookieName) {
        return driver().manage().getCookieNamed(cookieName);
    }

    public static void deleteCookie(String name) {
        driver().manage().deleteCookieNamed(name);
    }

    public static void deleteAllCookie() {
        driver().manage().deleteAllCookies();
    }

    public static void saveToFile(String filePath) throws IOException {
        Path path = Paths.get(filePath);
        Path parent = path.getParent();
        if (parent != null) {
            Files.createDirectories(parent);
        }

        Set<Cookie> cookies = getAllCookies();
        try (ObjectOutputStream obj = new ObjectOutputStream(new FileOutputStream(filePath))) {
            obj.writeObject(cookies);
        }
    }

    public static void loadFromFile(String filePath) throws IOException,
            ClassNotFoundException {
        Path path = Paths.get(filePath);

        if (!Files.exists(path)) {
            throw new RuntimeException("Cookie file not found: " + filePath);
        }

        try (ObjectInputStream obj =
                     new ObjectInputStream(new FileInputStream(filePath))) {

            Set<Cookie> cookies = (Set<Cookie>) obj.readObject();
            for (Cookie cookie : cookies) {
                driver().manage().addCookie(cookie);
            }
        }
    }
}
