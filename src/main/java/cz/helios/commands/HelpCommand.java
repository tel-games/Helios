package cz.helios.commands;

import cz.helios.Helios;
import cz.helios.commands.handle.CommandsListener;
import net.dv8tion.jda.api.MessageBuilder;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;

public class HelpCommand extends CommandsListener {
    @Override
    public void onGuildMessageReceived(GuildMessageReceivedEvent e) {
        setEvent(e);

        if (isCommand("help")) {

            MessageBuilder messaage = new MessageBuilder("Here is your help:\n");
            for (CommandsListener i : Helios.commands) {
                messaage.append(bold(i.getName() + ":"));
                messaage.append(i.getHelp()).append("\n");
            }
            e.getChannel().sendMessage(messaage.build());
        }
    }

    @Override
    public String getHelp() {
        return "Shows you aviable commands.";
    }
}
