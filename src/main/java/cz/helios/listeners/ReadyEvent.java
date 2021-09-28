package cz.helios.listeners;

import cz.helios.Config;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nonnull;

public class ReadyEvent extends ListenerAdapter {

    @Override
    public void onReady(net.dv8tion.jda.api.events.ReadyEvent e) {
        e.getJDA().getTextChannelById(Config.get(Config.SavedData.COMMAND)).sendMessage("Jsem online").queue();
        System.out.println("Jsem online.");
    }
}
