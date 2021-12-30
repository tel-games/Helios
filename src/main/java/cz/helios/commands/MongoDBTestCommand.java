package cz.helios.commands;

import cz.helios.commands.handle.CommandsListener;
import cz.helios.config.Roles;
import cz.helios.mongodb.MongoDB;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;

public class MongoDBTestCommand extends CommandsListener {
    @Override
    public void onGuildMessageReceived(GuildMessageReceivedEvent e) {
        setEvent(e);

        if (isCommand(new String[]{"mongodb"}) && checkByRole(Roles.developerRole())) {

            System.out.println("Logging...");
            try {
                MongoDB.logMember(e.getMember());
            } catch (Exception ex) {
                ex.printStackTrace();
            }
            e.getChannel().sendMessage("You have benn logged into database.");
        }
    }
}
