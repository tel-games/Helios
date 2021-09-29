package cz.helios.config;

import io.github.cdimascio.dotenv.Dotenv;

public class Config {
    private static final String normalConfigPath = "src/main/java/cz/helios/config/config.env";
    private static final String secredConfigPath = "src/main/java/cz/helios/config/secred-config.env";

    private static final Dotenv dotenv = Dotenv.configure().filename(normalConfigPath).load();

    public static String get(String key) {
        return dotenv.get(key.toUpperCase());
    }

    public static String get(SavedData data) {
        return dotenv.get(data.name().toUpperCase());
    }

    public static enum SavedData {
            PREFIX, INFO, COMMAND, DEVELOPERCH
    }

    public static class secretConfig {

        private static final Dotenv dotenv = Dotenv.configure().filename(secredConfigPath).load();

        public static String get(String key) {
            return dotenv.get(key.toUpperCase());
        }

        public static String get(SecredSavedData data) {
            return dotenv.get(data.name().toUpperCase());
        }

        public static enum SecredSavedData {
            TOKEN,
        }
    }

}
