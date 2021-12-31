package cz.helios.commands;

import cz.helios.commands.handle.Command;
import net.dv8tion.jda.api.entities.Role;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;

import java.util.List;

public class TestCommand extends Command {
    @Override
    public String getName() {
        return "test";
    }

    @Override
    public String[] getAliases() {
        return new String[0];
    }

    @Override
    public String getHelp() {
        return "Basic testing comamnd";
    }

    @Override
    public List<Role> roles() {
        return null;
    }

    @Override
    public void invoke(GuildMessageReceivedEvent e, String[] args) {
        e.getChannel().sendMessage("Name of this class - " + this.getClass().getSimpleName()).queue();
    }
}
