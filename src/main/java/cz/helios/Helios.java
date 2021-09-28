package cz.helios;

import cz.helios.commands.CPU;
import cz.helios.commands.WhatTimeCommand;
import cz.helios.commands.WhoAmICommand;
import cz.helios.listeners.ReadyEvent;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Activity;

import javax.security.auth.login.LoginException;

public class Helios {

    static JDA jda;
    public static void main(String[] args) {
        try {
            jda = JDABuilder.createDefault(Config.secretConfig.get(Config.secretConfig.SecredSavedData.TOKEN)).build(); // Vytvoří objekt jda a připojí se na server pomocí tokenu.
        } catch (LoginException e) {
            e.printStackTrace();
        }

        jda.getPresence().setActivity(Activity.playing("JDA development")); // Nastaví status jako že se koukná na něco.
        listeners();


    }

    static void listeners() {
        Object[] listners = {new WhoAmICommand(), new WhatTimeCommand(), new ReadyEvent(), new CPU()};

        for (Object i : listners) {
            jda.addEventListener(i);
        }
    }

}
