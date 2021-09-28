package cz.helios.commands;

import cz.helios.commands.handle.CommandsListener;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;


public class StfuCommand extends CommandsListener {
    @Override
    public void onGuildMessageReceived(GuildMessageReceivedEvent e) { // This command ain't done. Don't add this class as event listener!!!
        setEvent(e);

        if (isCommand(new String[]{"stfu", "mute"})) {
            String[] args = getArgs();
            Member sender = e.getMember();
            Member target = e.getMessage().getMentionedMembers().get(0);

            target.mute(true); // TODO Done this.

        }
    }

    @Override
    public String getHelp() {
        return "Mute member";
    }
}
