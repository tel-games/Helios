package cz.helios.commands;

import cz.helios.commands.handle.CommandsListener;
import net.dv8tion.jda.api.MessageBuilder;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;

import java.util.List;

public class InVoiceChannelCommand extends CommandsListener {
    @Override
    public void onGuildMessageReceived(GuildMessageReceivedEvent e) {
        setEvent(e);

        if (isCommand("voice")) {

            List<Member> members = e.getGuild().getMembers();
            MessageBuilder message = new MessageBuilder("Members in voice chats:");

            for (Member i : members) {
                if (i.getVoiceState().inVoiceChannel())
                    message.append(i);
            }

            e.getChannel().sendMessage(message.build());
        }
    }
}
