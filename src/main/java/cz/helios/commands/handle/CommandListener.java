package cz.helios.commands.handle;

import cz.helios.config.Config;
import cz.helios.commands.TestCommand;
import cz.helios.school.JsonTestingCommand;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class CommandListener extends ListenerAdapter {
    private static final ArrayList<Command> commands = new ArrayList<Command>();
    private static final String prefix = Config.getConfig().getPrefix();
    protected Member sender;

    public CommandListener() {
        commands.add(new TestCommand());
        commands.add(new JsonTestingCommand());
    }
    @Override
    public void onGuildMessageReceived(@NotNull GuildMessageReceivedEvent e) {
        String[] args = e.getMessage().getContentRaw().split(" ");

        if (!args[0].startsWith(prefix)) return;

        String command = args[0].replaceFirst(prefix, "");

        for (Command i : commands) {
            if (i.getName().equalsIgnoreCase(command)) {
                i.invoke(e, args);
                return;
            }
        }
    }
}
