package cz.helios;

import cz.helios.commands.*;
import cz.helios.config.Config;
import cz.helios.listeners.ReadyEvent;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Activity;

import javax.security.auth.login.LoginException;

public class Helios {

    public static JDA jda;
    public static void main(String[] args) {
        try {
            jda = JDABuilder.createDefault(Config.secretConfig.get(Config.secretConfig.SecredSavedData.TOKEN)).build(); // Vytvoří objekt jda a připojí se na server pomocí tokenu.
        } catch (LoginException e) {
            e.printStackTrace();
        }

        jda.getPresence().setActivity(Activity.playing("Jsem nejlepší bot, hahaha")); // Nastaví status jako že se koukná na něco.
        listeners();
        Config.checkFiles();

    }

    static void listeners() {
        Object[] listners = {new WhoAmICommand(), new WhatTimeCommand(), new ReadyEvent(), new CPUCommand(),
                new DeleteMessages(), new DisconnectCommand(), new StfuCommand(), new SusCommand()};

        for (Object i : listners) {
            jda.addEventListener(i);
        }
    }

}
