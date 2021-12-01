package cz.helios.commands;

import cz.helios.commands.handle.CommandsListener;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;

public class School extends CommandsListener {
    @Override
    public void onGuildMessageReceived(GuildMessageReceivedEvent event) {
        String[] příkaz = event.getMessage().getContentRaw().split(" ");

       String prefix = ";school";
       String prefix1 = ";rozvrh";

        if (příkaz[0] == prefix)
        {
            if (příkaz[1] == prefix1)
            {
                switch (příkaz[2])
                {
                    case "gjk":
                        event.getChannel().sendMessage("< 08:30 [Fyz] 09:15 >< 09:25 [HSt] 10:10 >< 10:20 [ M ] 10:05 >< 09:25 [Zem] 10:10 >< 09:20 [---] 10:05 >< 09:15 [Čj ] 10:00 >< 09:10 [Děj] 10:55 >< 09:00 [Děj] 10:45 >").queue();
                        event.getChannel().sendMessage("< 08:30 [Čj ] 09:15 >< 09:25 [ M ] 10:10 >< 10:20 [Aj ] 10:05 >< 09:25 [Inf] 10:10 >< 09:20 [Inf] 10:05 >< 09:15 [Nj ] 10:00 >< 09:10 [Lab] 10:55 >< 09:00 [Lab] 10:45 >").queue();
                        event.getChannel().sendMessage("< 08:30 [Tv ] 09:15 >< 09:25 [Tv ] 10:10 >< 10:20 [Aj ] 10:05 >< 09:25 [Ev ] 10:10 >< 09:20 [Ev ] 10:05 >< 09:15 [Nj ] 10:00 >< 09:10 [Ch ] 10:55 >").queue();
                        event.getChannel().sendMessage("< 08:30 [Bio] 09:15 >< 09:25 [Ch ] 10:10 >< 10:20 [Zem] 10:05 >< 09:25 [ M ] 10:10 >< 09:20 [---] 10:05 >< 09:15 [H/M] 10:00 >").queue();
                        event.getChannel().sendMessage("< 08:30 [Čj ] 09:15 >< 09:25 [Tv ] 10:10 >< 10:20 [Aj ] 10:05 >< 09:25 [Nj ] 10:10 >< 09:20 [Fyz] 10:05 >< 09:15 [-/U] 10:00 >< 09:10 [ÚDJ] 10:55 >").queue();
                        break;
                    case "gkb":
                        event.getChannel().sendMessage("Sorry. Data not found.").queue();
                        break;
                    case "ssps":
                        event.getChannel().sendMessage("Error 404").queue();
                        break;
                    default:
                        event.getChannel().sendMessage("School not found").queue();
                        break;


                }
            }


        }
    }
}
//to je asi ftip
