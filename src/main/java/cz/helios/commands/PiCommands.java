package cz.helios.commands;

import cz.helios.ShitConfig;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class PiCommands extends ListenerAdapter {
    public String midfix = "Pi";
    public String[] příkaz;

    public void onGuildMessageReceived(GuildMessageReceivedEvent event) {
        String příkaz[] = event.getMessage().getContentRaw().split(" ");

        /*switch(příkaz[0]) {                                     //Nevim jestli tam ma byt 0!!!!
            case ShitConfig.prefix + midfix + " time":
                time(event);
                break;
        }*/
    }

    public void time(GuildMessageReceivedEvent event) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
    event.getChannel().sendMessage("Pi time:" + dtf.format(now)).queue();
    }

}