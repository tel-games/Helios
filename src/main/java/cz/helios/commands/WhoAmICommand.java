package cz.helios.commands;

import cz.helios.ShitConfig;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class WhoAmICommand extends ListenerAdapter {
    @Override
    public void onGuildMessageReceived(GuildMessageReceivedEvent event) {
        String[] args = event.getMessage().getContentRaw().split(" ");

        if (args[0].equalsIgnoreCase(ShitConfig.prefix + "whoami")) {
            event.getChannel().sendMessage(event.getMember().getEffectiveName()).queue();
        }
    }
}
