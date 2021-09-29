package cz.helios.commands;

import cz.helios.commands.handle.CommandsListener;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.MessageChannel;
import net.dv8tion.jda.api.entities.MessageHistory;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;

import java.util.List;

public class DeleteMessages extends CommandsListener {
    @Override
    public void onGuildMessageReceived(GuildMessageReceivedEvent e) {
        setEvent(e);

        if (isCommand(new String[]{"del", "mazac", "rm"})) {
            int count = Integer.parseInt(getArgs()[1]);
            MessageChannel channel = getChannel();

            MessageHistory history = new MessageHistory(channel);
            List<Message> mags = history.retrievePast(count+1).complete();

            for (Message i : mags) {
                channel.deleteMessageById(i.getId()).queue();
            }

            sendMessageToChannel("Last **" + count + "** messages has been deleted.");
        }
    }
}
