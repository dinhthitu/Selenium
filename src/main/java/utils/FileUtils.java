package utils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Duration;

import org.openqa.selenium.support.ui.FluentWait;

public class FileUtils {

    // Tạo file txt tạm để upload
    public static Path createTempTxtFile(String fileName) {
        try {
            Path dir = Paths.get("test-output", "temp-files");
            Files.createDirectories(dir);

            Path filePath = dir.resolve(fileName);
            Files.write(filePath, "Demo upload file".getBytes());

            return filePath.toAbsolutePath();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


    // Chờ file download xong
    public static void waitUntilFileExists(Path filePath, int timeoutSeconds) {
        new FluentWait<>(filePath)
                .withTimeout(Duration.ofSeconds(timeoutSeconds))
                .pollingEvery(Duration.ofMillis(500))
                .until(Files::exists);
    }

    // Check file tồn tại + size > 0
    public static boolean isFileValid(Path filePath) {
        try {
            return Files.exists(filePath) && Files.size(filePath) > 0;
        } catch (IOException e) {
            return false;
        }
    }
}