package cz.helios.config;

import java.io.IOException;

public class Test {
    public static void main(String[] args) {
        try {
            Config.saveConfig();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
