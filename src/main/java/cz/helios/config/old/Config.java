package cz.helios.config.old;

import io.github.cdimascio.dotenv.Dotenv;

import java.io.File;

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
            TOKEN, MONGO
        }
    }

    public static void checkFiles() {
        File config = new File(normalConfigPath);
        assert config.exists() : "Cannot find config file, download template form git: https://github.com/tel-games/Helios .";
        File secredConfig = new File(secredConfigPath);
        assert secredConfig.exists() : "Cannot find secredConfig file, text Bakterio for get one :D";
    }


}
