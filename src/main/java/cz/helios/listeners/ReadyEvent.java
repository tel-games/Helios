package cz.helios.listeners;

import cz.helios.config.Config;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class ReadyEvent extends ListenerAdapter {

    @Override
    public void onReady(net.dv8tion.jda.api.events.ReadyEvent e) {
        e.getJDA().getTextChannelById(Config.get(Config.SavedData.COMMAND)).sendMessage("Jsem online").queue();
        System.out.println("Jsem online.");
    }
}
