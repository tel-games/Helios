package cz.helios.commands;

import cz.helios.MembersCounter;
import cz.helios.commands.handle.CommandsListener;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;

public class MembersCounterCommand extends CommandsListener {
    @Override
    public void onGuildMessageReceived(GuildMessageReceivedEvent event) {
        setEvent(event);
        if (isCommand("counter")) {
            MembersCounter.countMembers(event.getGuild(), event.getGuild().getTextChannelById("892395686417555468"));
        }
    }
}
