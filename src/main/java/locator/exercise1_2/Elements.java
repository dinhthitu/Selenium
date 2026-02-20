package locator.exercise1_2;

import org.openqa.selenium.By;
import org.openqa.selenium.support.pagefactory.ByChained;

public class Elements {

    // 1. By ID
    public static final By TEXT_BOX_MENU = By.xpath("//span[contains(normalize-space(), 'Text Box')]");
    public static final By BROKEN_LINKS = By.xpath("//span[contains(text(),'Broken Links')]");
    public static final By UP_DOWN = By.xpath("//span[contains(text(),'Upload and Download')]");
    public static final By PERMANENT_ADDRESS = By.id("permanentAddress");

    // 2. By className
    public static final By ELEMENT_DROPDOWN = By.className("pr-1");

    // 3. By cssSelector
    public static final By USERNAME = By.cssSelector("#userName");

    // 4. By xPath relative
    public static final By WEB_TABLES = By.xpath("//li[@id='item-3']");

    // 5. By chained
    public static final By UPLOAD_FILE = new ByChained(By.className("form-file"), By.id("uploadFile"));

    // 6. By linkText
    public static final By VALID_LINK = By.linkText("Click Here for Valid Link");

    // 7. By partialLinkText
    public static final By INVALID_LINK = By.partialLinkText("Click Here");

    // 8. By tagName
    public static final By ALL_LINKS = By.tagName("a");

    // 9. By xpath
    public static final By CURRENT_ADDRESS = By.xpath("//textarea[contains(normalize-space(),'Current Address')]");

    // 10. By xpath ancestor
    public static final By FULL_NAME = By.xpath("//input[@placeholder = 'Full Name']");

    // Advance

    // 1. Contains
    public static final By XPATH_CONTAIN = By.xpath("//input[contains(@placeholder,'Full')]");

    // 2. Start with
    public static final By XPATH_STARTWITHS = By.xpath("//input[starts-with(@id,'user')]");

    // 3. Text
    public static final By XPATH_BY_TEXT = By.xpath("//input[@type='text' and @id='userName']");

    // 4. ID
    public static final By XPATH_BY_ID = By.xpath("//input[@id='userName' or @id='userEmail']");

    // 5. Normalize-space
    public static final By XPATH_CBY_NORMALIZE = By.xpath("//span[@normalize-space()='Interactions']");

}

