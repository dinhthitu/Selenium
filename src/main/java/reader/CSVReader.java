package reader;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CSVReader implements DataReader {

    @Override
    public Object[][] readData(String filePath) {

        List<Object[]> data = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            boolean skipHeader = true;

            while ((line = reader.readLine()) != null) {
                if (skipHeader) {
                    skipHeader = false;
                    continue;
                }
                String[] values = line.split(",", -1);
                data.add(new Object[]{
                        values[0],
                        values[1],
                        Boolean.parseBoolean(values[2])
                });
            }
        } catch (IOException ioe) {
            throw new RuntimeException("Can not read CSV file" , ioe);
        }
        return data.toArray(new Object[0][0]);
    }
}
