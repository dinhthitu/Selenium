package core.config;

import java.io.InputStream;
import java.util.Properties;

public class ConfigReader {

    public static Properties load(String filePath) {
        Properties properties = new Properties();

        try (InputStream input = ConfigReader.class
                .getClassLoader()
                .getResourceAsStream(filePath)) {
            if (input == null) {
                throw new RuntimeException("Config file not found: " + filePath);
            }
            properties.load(input);
        } catch (Exception e) {
            throw new RuntimeException("Cannot load config: " + filePath);
        }
        return properties;
    }
}
