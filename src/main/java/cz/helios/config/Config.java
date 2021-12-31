package cz.helios.config;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import cz.helios.config.ConfigModel;

import java.io.*;

public class Config {
    private static final Gson gson = new GsonBuilder().setPrettyPrinting().create();
    private static final File configFile = new File("src/main/java/cz/helios/config/settings.helios");

    public static ConfigModel getConfig() {
        return config;
    }

    private static ConfigModel config;

    public static void loadConfig() throws IOException {
        assert configFile.exists() : "Cannot find config file...";

        BufferedReader reader = new BufferedReader(new FileReader(configFile));

        config = gson.fromJson(reader, ConfigModel.class);
        reader.close();
    }

    public static void saveConfig() throws IOException { // only for debugging
        ConfigModel model = new ConfigModel("token", ";", "admin alfjda", "1234567890", "devRole");
        configFile.createNewFile();
        Writer writer = new FileWriter(configFile, true);
        gson.toJson(model, writer);
        writer.flush();
        writer.close();
    }

}
