package cz.helios;

import cz.helios.commands.*;
import cz.helios.commands.handle.CommandsListener;
import cz.helios.config.Config;
import cz.helios.school.TestCommand;
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
        slashCommands();
        Config.checkFiles();

    }

    public static final CommandsListener[] commands = {new CPUCommand(), new DeleteMessages(), new DisconnectCommand(),
            new StfuCommand(), new SusCommand(), new MongoDBTestCommand(), new HelpCommand(), new ShutdownCommand(),
            new InVoiceChannelCommand(), new TestCommand(), new MembersCounterCommand(), new SlashTestCommand()};

    public static final Object[] listners = {new WhoAmICommand(), new WhatTimeCommand()};

    static void listeners() {

        for (Object i : listners) {
            jda.addEventListener(i);
        }

        for (Object i: commands) {
            jda.addEventListener(i);
        }
    }

    private static void slashCommands() {
        jda.upsertCommand("slash", "Just testing now").queue();
    }

}
