package core.config;


public interface ConfigReader {

    String get(String key);

    default boolean getBoolean(String key) {
        return Boolean.parseBoolean(get(key));
    }
}