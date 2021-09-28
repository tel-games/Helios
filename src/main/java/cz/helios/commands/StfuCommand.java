package cz.helios.commands;

import cz.helios.commands.handle.CommandsListener;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;


public class StfuCommand extends CommandsListener {
    @Override
    public void onGuildMessageReceived(GuildMessageReceivedEvent e) { // This command ain't done. Don't add this class as event listener!!!
        setEvent(e);

        if (isCommand(new String[]{"stfu", "mute"})) {
            Member target = e.getMessage().getMentionedMembers().get(0);

            if (!target.getVoiceState().isGuildMuted())
                target.mute(true).queue();
            else
                target.mute(false).queue();
        }
    }

    @Override
    public String getHelp() {
        return "Mute member";
    }
}
