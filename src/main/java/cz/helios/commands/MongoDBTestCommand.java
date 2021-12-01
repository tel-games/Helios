package cz.helios.commands;

import cz.helios.commands.handle.CommandsListener;
import cz.helios.config.Roles;
import cz.helios.mongodb.MongoDB;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;

public class MongoDBTestCommand extends CommandsListener {
    @Override
    public void onGuildMessageReceived(GuildMessageReceivedEvent e) {
        setEvent(e);

        if (isCommand(new String[]{"mongodb", "database"}) && checkByRole(Roles.developerRole())) {

            try {
                MongoDB.logMember(e.getMember(), e.getGuild());
            } catch (Exception ex) {
                e.getChannel().sendMessage("You have benn loogged into database.");
                System.out.println(ex.getMessage());
            }
        }
    }
}
