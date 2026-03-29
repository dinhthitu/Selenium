package core.config;

import java.io.InputStream;
import java.util.Properties;

public class ConfigLoader implements ConfigReader {

    private final Properties properties = new Properties();

    public ConfigLoader(String fileName) {
        try (InputStream is =
                     getClass().getClassLoader().getResourceAsStream(fileName)) {
            properties.load(is);
        } catch (Exception e) {
            throw new RuntimeException("Cannot load config: " + fileName);
        }
    }

    @Override
    public String get(String key) {
        String sysValue = System.getProperty(key);
        if (sysValue != null) {
            return sysValue;
        }
        return properties.getProperty(key);
    }

}