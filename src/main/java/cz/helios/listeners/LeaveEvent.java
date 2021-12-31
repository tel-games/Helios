package cz.helios.listeners;

import cz.helios.config.old.Config;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.TextChannel;
import net.dv8tion.jda.api.events.guild.member.GuildMemberRemoveEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.util.Random;

public class LeaveEvent extends ListenerAdapter {

    private final String[] messages = {
            "[member] nás opustil :(",
            "Kam zmizel [member]? Aha, on odešel.",
            "[member] nás leavnul.",
            "[member] leavnul tento server.",
    };

    @Override
    public void onGuildMemberRemove(GuildMemberRemoveEvent event) {
        Member m = event.getMember();
        TextChannel infoChannnel = event.getGuild().getTextChannelById(Config.get(Config.SavedData.INFO));

        Random r = new Random();
        int x = r.nextInt(messages.length); // Vygeneruje náhodné číslo v rozmezí 0 - déla messages.

        infoChannnel.sendMessage(messages[x].replaceFirst("[member]", m.getEffectiveName())).queue(); // Pošle zprávu do definovaného kanálu.
    }
}