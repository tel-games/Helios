package cz.helios.listeners;

import cz.helios.ShitConfig;
import net.dv8tion.jda.api.events.guild.member.GuildMemberJoinEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class JointEvent extends ListenerAdapter {

    @Override
    public void onGuildMemberJoin(GuildMemberJoinEvent event) {
        event.getGuild().getTextChannelById(ShitConfig.infoTextChannelID).sendMessage("Ahoooj-jak-se-mas").queue();
    }
}
