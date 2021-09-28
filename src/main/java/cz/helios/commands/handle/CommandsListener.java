package cz.helios.commands.handle;

import cz.helios.Config;
import net.dv8tion.jda.api.entities.MessageChannel;
import net.dv8tion.jda.api.entities.TextChannel;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import javax.annotation.Nonnull;

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
        // if (Main.check(e)) return false; // TODO Change this check.

        if (getArgs()[0].toLowerCase().equalsIgnoreCase(Config.get(Config.SavedData.PREFIX) + command))
            return true;
        return false;
    }

    protected boolean isCommand(String[] aliases) {

        for (String i : aliases) {
            if (isCommand(i))
                return true;
        }

        return false;
    }

    protected MessageChannel getChannel() {
        return e.getMessage().getChannel();
    }
}
