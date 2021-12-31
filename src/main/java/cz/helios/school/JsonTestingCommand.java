package cz.helios.school;

import com.google.gson.Gson;
import cz.helios.commands.handle.Command;
import cz.helios.school.models.Member;
import net.dv8tion.jda.api.entities.Role;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.List;

public class JsonTestingCommand extends Command {
    @Override
    public String getName() {
        return "json";
    }

    @Override
    public String[] getAliases() {
        return new String[0];
    }

    @Override
    public String getHelp() {
        return null;
    }

    @Override
    public List<Role> roles() {
        return null;
    }

    @Override
    public void invoke(GuildMessageReceivedEvent e, String[] args) {
        final File json = new File("src/main/java/cz/helios/school/users.helios");
        net.dv8tion.jda.api.entities.Member sender = e.getMember();
        Member member = new Member(sender.getEffectiveName(), sender.getId(), e.getMessage().getContentRaw().split(" ")[1], sender.getTimeJoined().toString());
        Gson gson = new Gson();
        try {
            json.createNewFile();
            Writer writer = new FileWriter(json, true);
            gson.toJson(member, writer);
            writer.write("\n");
            writer.flush();
            writer.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
