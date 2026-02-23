package exercise3_4;

import core.base.BaseTest;
import core.config.ConfigLoader;
import core.config.ConfigReader;
import core.driver.DriverManager;
import org.openqa.selenium.Cookie;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.CookieUtils;

import java.util.Set;

import static org.testng.AssertJUnit.*;

public class CookieTest extends BaseTest {

    @Override
    public ConfigReader loadConfig() {
        return new ConfigLoader("exercise3_4.properties");
    }

    @Test
    public void cookie_operation() {

        String key1 = config.get("key1");
        String value1 = config.get("value1");
        String key2 = config.get("key2");
        String value2 = config.get("value2");
        String key3 = config.get("key3");
        String value3 = config.get("value3");

        Cookie cookie1 = new Cookie(key1, value1);
        Cookie cookie2 = new Cookie(key2, value2);
        Cookie cookie3 = new Cookie(key3, value3);

        CookieUtils.addCookie(cookie1);
        CookieUtils.addCookie(cookie2);
        CookieUtils.addCookie(cookie3);

        Cookie getCookie = CookieUtils.getCookie(key1);
        assertEquals(getCookie.getValue(), value1);

        Set<Cookie> getAllCookies = CookieUtils.getAllCookies();
        assertTrue(getAllCookies.size() > 0);

        CookieUtils.deleteCookie(key2);
        assertNull(CookieUtils.getCookie(key2));

        CookieUtils.deleteAllCookie();
        assertNull(CookieUtils.getCookie(key1));
        assertNull(CookieUtils.getCookie(key2));
        assertNull(CookieUtils.getCookie(key3));
    }
}
