package cz.helios.commands.handle;

import cz.helios.config.Config;
import net.dv8tion.jda.api.entities.MessageChannel;
import net.dv8tion.jda.api.entities.Role;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class CommandsListener extends ListenerAdapter {
    /**
     * This class can be use like ListenerAdapter, but it comes with special feathers specially for commands.
     */

    private GuildMessageReceivedEvent e;

    public void setEvent(GuildMessageReceivedEvent e) {
        this.e = e;
    }
    public String getHelp() {
        return "Help not specified";
    }

    protected String[] getArgs() {
        return e.getMessage().getContentRaw().split(" ");
    }

    protected String[] getSmartArgs() {
        return e.getMessage().getContentRaw().replaceFirst(getArgs()[0], "").split(" ");
    }

    public String getName() {
        return getClass().getSimpleName();
    }

    protected String getDisplayName() {
        return e.getMember().getEffectiveName();
    }

    protected boolean sendMessageToChannel(String message) {
        if (message == null) return false;
        e.getChannel().sendMessage(message).queue();
        return true;
    }

    protected boolean isCommand(String command) {

        return getArgs()[0].toLowerCase().equalsIgnoreCase(Config.get(Config.SavedData.PREFIX) + command);
    }

    protected boolean isCommand(String[] aliases) {

        for (String i : aliases) {
            if (isCommand(i))
                return true;
        }

        return false;
    }

    protected boolean checkByRole(Role role) {
        if (!e.getMember().getRoles().contains(role)) {
            sendMessageToChannel("You don't have permissions to do that.");
            return false;
        }
        return true;
    }

    protected MessageChannel getChannel() {
        return e.getMessage().getChannel();
    }

    protected String bold(String input) {
        return "**" + input + "**";
    }
}
