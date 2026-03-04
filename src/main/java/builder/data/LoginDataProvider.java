package builder.data;

import org.testng.annotations.DataProvider;
import reader.DataReader;
import reader.DataReaderFactory;

public class LoginDataProvider {

    @DataProvider(name = "loginData")
    public static Object[][] loginData() {
        String filePath = "src/test/resources/test-data/loginData.csv";
        DataReader reader = DataReaderFactory.getReader(filePath);
        return reader.readData(filePath);
    }




}
