package cz.helios.commands.handle;

import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;

public interface ICommand {
    public void onGuildMessageReceived(GuildMessageReceivedEvent e);

    public String getHelp();
}
