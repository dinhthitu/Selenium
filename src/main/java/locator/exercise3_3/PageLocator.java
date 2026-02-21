package locator.exercise3_3;

import org.openqa.selenium.By;

public class PageLocator {

    public static final By ELEMENT_BTN = By.xpath("//div[normalize-space()='Elements']");

    public static final By UPLOAD_DOWNLOAD = By.xpath("//span[text() = 'Upload and Download']");
    //FILE UPLOAD LOCATOR
    public static final By FILE_UPLOAD = By.id("uploadFile");

    // FILE DOWNLOAD LOCATOR
    public static final By FILE_DOWNLOAD = By.id("downloadButton");

    // UPLOAD RESULT
    public static final By UPLOADED_FILE_PATH = By.id("uploadedFilePath");
}
