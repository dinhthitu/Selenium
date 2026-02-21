package pom.exercise3_3;

import locator.exercise3_3.PageLocator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pom.BasePage;

public class FilePage extends BasePage {

    public FilePage(WebDriver driver) {
        super(driver);
    }

    public FilePage openFilePage() {
        WebElement element = waitForClickable(PageLocator.ELEMENT_BTN);
        scrollToCenter(element);
        element.click();
        WebElement upAndDown = waitForClickable(PageLocator.UPLOAD_DOWNLOAD);
        scrollToCenter(upAndDown);
        upAndDown.click();
        return this;
    }

    public void uploadFile(String filePath) {
        senKeys(PageLocator.FILE_UPLOAD, filePath);
    }

    public boolean isUploadSuccess(String fileName) {
        return findElement(PageLocator.UPLOADED_FILE_PATH)
                .getText()
                .contains(fileName);
    }

    public void downloadFile() {
        waitForClickable(PageLocator.FILE_DOWNLOAD).click();
    }
}
