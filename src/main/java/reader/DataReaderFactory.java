package reader;

public class DataReaderFactory {

    public static DataReader getReader(String filePath) {
        if (filePath.endsWith(".csv")) {
            return new CSVReader();
        }

        if (filePath.endsWith(".xlsx")) {
            return new ExcelReader();
        }

        throw new IllegalArgumentException("Unsupported data source: " + filePath);
    }

}
