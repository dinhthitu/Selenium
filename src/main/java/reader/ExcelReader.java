package reader;


import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ExcelReader implements DataReader {

    @Override
    public Object[][] readData(String filePath) {

        List<Object[]> data = new ArrayList<>();

        try (
                FileInputStream input = new FileInputStream(filePath);
                Workbook workbook = new XSSFWorkbook(input)
        ) {

            Sheet sheet = workbook.getSheetAt(0);
            boolean skipHeader = true;

            for (Row row : sheet) {
                if (skipHeader) {
                    skipHeader = false;
                    continue;
                }

                String username = getCellValueAsString(row.getCell(0));
                String password = getCellValueAsString(row.getCell(1));
                boolean expectedResult = row.getCell(2).getBooleanCellValue();

                data.add(new Object[]{ username, password, expectedResult }
                );
            }

        } catch (IOException e) {
            throw new RuntimeException("Cannot read Excel file: " + filePath, e);
        }

        return data.toArray(new Object[0][0]);
    }

    private String getCellValueAsString(Cell cell) {
        if (cell == null) {
            return "";
        }
        cell.setCellType(CellType.STRING);
        return cell.getStringCellValue();
    }
}