package cz.helios.commands;

import cz.helios.commands.handle.CommandsListener;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;

import java.io.File;

public class SusCommand extends CommandsListener {
    @Override
    public void onGuildMessageReceived(GuildMessageReceivedEvent e) {
        setEvent(e);

        if (isCommand("sus")) {
            Message susMessage = e.getMessage().getReferencedMessage();

            File sus = new File("src/main/java/cz/helios/resource/sus.jpg");

            e.getChannel().sendMessage("Yeah, this message is very sus.").addFile(sus, "sus.jpg").reference(susMessage).queue();

            susMessage.addReaction("L2/09-026").queue();
        }
    }
}
