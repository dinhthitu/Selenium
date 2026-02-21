package exercise3_3;

import core.base.BaseTest;
import core.config.ConfigLoader;
import core.config.ConfigReader;
import core.driver.DriverManager;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pom.exercise3_3.FilePage;
import utils.FileUtils;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileTest extends BaseTest {

    @Override
    public ConfigReader loadConfig() {
        return new ConfigLoader("exercise3_3.properties");
    }

    FilePage filePage;

    @BeforeMethod
    public void setup() {
        filePage = new FilePage(DriverManager.get());
        filePage.openFilePage();
    }

    @Test
    public void uploadAndDownloadFile_Normal() throws Exception {

        String fileName = config.get("upload.file");

        Path uploadFile = Paths.get(
                "src", "test", "resources", "upload", fileName
        ).toAbsolutePath();

        filePage.uploadFile(uploadFile.toString());

        Assert.assertTrue(
                filePage.isUploadSuccess(fileName));


        filePage.downloadFile();

        Path downloadedFile = Paths.get(
                "test-output", "downloads", "sampleFile.jpeg"
        );

        FileUtils.waitUntilFileExists(downloadedFile, 10);

        Assert.assertTrue(Files.exists(downloadedFile));
        Assert.assertTrue(Files.size(downloadedFile) > 0);
    }

    // ADVANCED TEST
    @Test
    public void uploadAndDownloadFile_Advanced() {

        Path uploadFile = FileUtils.createTempTxtFile("dynamic-upload.txt");

        filePage.uploadFile(uploadFile.toString());

        Assert.assertTrue(
                filePage.isUploadSuccess(uploadFile.getFileName().toString())
        );

        // DOWNLOAD
        filePage.downloadFile();

        Path downloadedFile = Paths.get(
                "test-output", "downloads", "sampleFile.jpeg"
        );

        FileUtils.waitUntilFileExists(downloadedFile, 10);

        Assert.assertTrue(
                FileUtils.isFileValid(downloadedFile)
        );
    }
}
