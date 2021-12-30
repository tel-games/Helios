package cz.helios.commands;

import cz.helios.commands.handle.CommandsListener;
import net.dv8tion.jda.api.events.interaction.ButtonClickEvent;
import net.dv8tion.jda.api.events.interaction.SlashCommandEvent;
import net.dv8tion.jda.api.interactions.components.Button;

public class SlashTestCommand extends CommandsListener {
    @Override
    public void onSlashCommand(SlashCommandEvent e) {
        if (e.getName().equals("slash")) {
            e.reply("Click this button bellow")
                    .addActionRow(
                            Button.primary("hello", "Click me"),
                            Button.success("connect", "Connect to voice channel")
                    ).queue();
        }
    }

    @Override
    public void onButtonClick(ButtonClickEvent e) {
        if (e.getComponentId().equals("slash")) {
            e.reply("button works!!! :rofl:");
        }
    }
}
