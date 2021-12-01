package cz.helios.commands;

import cz.helios.Helios;
import cz.helios.commands.handle.CommandsListener;
import cz.helios.commands.handle.ICommand;
import cz.helios.config.Roles;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;

public class ShutdownCommand extends CommandsListener implements ICommand {

    @Override
    public void onGuildMessageReceived(GuildMessageReceivedEvent e) {
        setEvent(e);

        if (isCommand(new String[]{"shutdown", "vypnout"}) && checkByRole(Roles.developerRole())) {

            sendMessageToChannel("Goodbye, see you later :wink: .");
            Helios.jda.shutdown();
            System.exit(0);
        }
    }

    @Override
    public String getHelp() {
        return "Shutdown bot host program.";
    }
}
