public class Main {
    public static void main(String[] args) {
        Logger logger = Logger.getInstance();
        logger.log("Application started");

        ConfigManager config = ConfigManager.getInstance();
        System.out.println("App Name: " + config.getConfig("appName"));
        System.out.println("Version: " + config.getConfig("version"));

        Logger logger2 = Logger.getInstance();
        System.out.println("Same logger? " + (logger == logger2)); // true
    }
}
