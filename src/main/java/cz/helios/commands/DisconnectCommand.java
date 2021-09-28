package cz.helios.commands;

import cz.helios.commands.handle.CommandsListener;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;

public class DisconnectCommand extends CommandsListener {
    @Override
    public void onGuildMessageReceived(GuildMessageReceivedEvent e) {
        setEvent(e);

        if (isCommand(new String[]{"disconnect", "vypadni"})) {
            String[] args = getArgs();
            Member target = e.getMessage().getMentionedMembers().get(0);

            if (!target.getVoiceState().inVoiceChannel()) {
                sendMessageToChannel("**" + target.getEffectiveName() + "** isn't in voice channel right now.");
                return;
            }

            e.getGuild().kickVoiceMember(target).queue();
            sendMessageToChannel("**" + target.getEffectiveName() + "** has been kicked :wink: .");

        }
    }
}
