package core.config;

import java.util.Properties;

public interface ConfigReader {

    String get(String key);

    Properties getAll();

    default boolean getBoolean(String key) {
        return Boolean.parseBoolean(get(key));
    }
}