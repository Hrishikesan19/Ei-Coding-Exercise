

import java.util.Properties;

public class ConfigManager {
    private static ConfigManager instance;
    private Properties config;

    private ConfigManager() {
        config = new Properties();
        config.setProperty("appName", "SingletonApp");
        config.setProperty("version", "1.0");
    }

    public static synchronized ConfigManager getInstance() {
        if (instance == null) {
            instance = new ConfigManager();
        }
        return instance;
    }

    public String getConfig(String key) {
        return config.getProperty(key);
    }
}
