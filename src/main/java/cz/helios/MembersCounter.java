package cz.helios;

import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.TextChannel;

public class MembersCounter {
    public static void countMembers(Guild server, TextChannel channel) {
        final int count = server.getMemberCount();
        channel.createCopy().setName("Members: " + count);
        channel.delete();
    }
}
