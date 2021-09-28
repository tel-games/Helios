package cz.helios;

import io.github.cdimascio.dotenv.Dotenv;

public class Config {

    private static final Dotenv dotenv = Dotenv.configure().filename("src/main/java/cz/helios/config.env").load();

    public static String get(String key) {
        return dotenv.get(key.toUpperCase());
    }

    public static String get(SavedData data) {
        return dotenv.get(data.name().toUpperCase());
    }

    public static enum SavedData {
            PREFIX,
    }

    public static class secretConfig {

        private static final Dotenv dotenv = Dotenv.configure().filename("src/main/java/cz/helios/secred-config.env").load();

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
