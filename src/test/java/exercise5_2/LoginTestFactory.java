package exercise5_2;

import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Factory;
import reader.DataReader;
import reader.DataReaderFactory;
import utils.FileUtils;

import java.util.ArrayList;
import java.util.List;

public class LoginTestFactory {

    static {
        FileUtils.createLoginCSV("src/test/resources/test-data/loginData.csv");
        FileUtils.createLoginExcel("src/test/resources/test-data/loginData.xlsx");
    }
    @Factory
    public Object[] createTests() {

        String[] sources = {
                "src/test/resources/test-data/loginData.csv",
                "src/test/resources/test-data/loginData.xlsx"
        };

        List<Object> tests = new ArrayList<>();

        for (String source : sources) {
            DataReader reader = DataReaderFactory.getReader(source);
            Object[][] data = reader.readData(source);

            for (Object[] row : data) {
                tests.add(new LoginTest(
                        (String) row[0],
                        (String) row[1],
                        (boolean) row[2],
                        source
                ));
            }
        }
        return tests.toArray();
    }
}

