package cz.helios.school;

import com.google.gson.Gson;
import cz.helios.commands.handle.CommandsListener;
import cz.helios.commands.handle.ICommand;
import cz.helios.config.Roles;
import cz.helios.school.models.Member;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class TestCommand extends CommandsListener implements ICommand {
    private static final File json = new File("src/main/java/cz/helios/school/users.helios");
    @Override
    public void onGuildMessageReceived(GuildMessageReceivedEvent e) {
        setEvent(e);
        if (isCommand("json") && checkByRole(Roles.developerRole())) {
            net.dv8tion.jda.api.entities.Member sender = e.getMember();
            Member member = new Member(sender.getEffectiveName(), sender.getId(), e.getMessage().getContentRaw().split(" ")[1], sender.getTimeJoined().toString());
            Gson gson = new Gson();
            try {
                json.createNewFile();
                Writer writer = new FileWriter(json, true);
                gson.toJson(member, writer);
                writer.flush();
                writer.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }

        }
    }

}