package utils;

import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Duration;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.support.ui.FluentWait;

public class FileUtils {

    private static Workbook workbook;
    private static Sheet sheet;

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



    public static void waitUntilFileExists(Path filePath, int timeoutSeconds) {
        new FluentWait<>(filePath)
                .withTimeout(Duration.ofSeconds(timeoutSeconds))
                .pollingEvery(Duration.ofMillis(500))
                .until(Files::exists);
    }


    public static boolean isFileValid(Path filePath) {
        try {
            return Files.exists(filePath) && Files.size(filePath) > 0;
        } catch (IOException e) {
            return false;
        }
    }

    public static void createLoginCSV(String filePath) {
        try (FileWriter writer = new FileWriter(filePath)) {
            writer.append("username,password,expected\n");
            writer.append("student,Password123,true\n");
            writer.append("invalid,invalid,false\n");
            writer.append("student,,false\n");

            System.out.println("CSV file is created successfully");
        } catch (IOException ioe) {
            throw new RuntimeException("Failed to create CSV file", ioe);
        }
    }

    public static void createLoginExcel(String filePath) {
        workbook = new XSSFWorkbook();
        sheet = workbook.createSheet("loginData");

        Row header = sheet.createRow(0);
        header.createCell(0).setCellValue("username");
        header.createCell(1).setCellValue("password");
        header.createCell(2).setCellValue("expected");

        Row row1 = sheet.createRow(1);
        row1.createCell(0).setCellValue("student");
        row1.createCell(1).setCellValue("Password123");
        row1.createCell(2).setCellValue(true);

        Row row2 = sheet.createRow(2);
        row2.createCell(0).setCellValue("invalid");
        row2.createCell(1).setCellValue("invalid");
        row2.createCell(2).setCellValue(false);

        Row row3 = sheet.createRow(3);
        row3.createCell(0).setCellValue("student");
        row3.createCell(1).setCellValue("");
        row3.createCell(2).setCellValue(false);

        try (FileOutputStream fos = new FileOutputStream(filePath)) {
            workbook.write(fos);
            workbook.close();
            System.out.println("Excel file created successfully");
        } catch (Exception e) {
            throw new RuntimeException("Failed to create Excel file", e);
        }
    }

}
