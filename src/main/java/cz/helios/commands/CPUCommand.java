package cz.helios.commands;

import com.profesorfalken.jsensors.JSensors;
import com.profesorfalken.jsensors.model.components.Components;
import com.profesorfalken.jsensors.model.components.Cpu;
import com.profesorfalken.jsensors.model.sensors.Fan;
import com.profesorfalken.jsensors.model.sensors.Temperature;
import cz.helios.commands.handle.CommandsListener;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;

import java.text.ParseException;
import java.util.List;

public class CPUCommand extends CommandsListener {
    @Override
    public void onGuildMessageReceived(GuildMessageReceivedEvent e) {
        setEvent(e);

        if (isCommand("cpu")) {

            Components components = null;
            try {
                components = JSensors.get.components();
            } catch (Exception exception) {
                System.out.println(exception);
            }

            StringBuilder message = new StringBuilder();

            List<Cpu> cpus = components.cpus;
            if (cpus != null) {
                for (final Cpu cpu : cpus) {
                    message.append("Found CPU component: " + cpu.name).append("\n");
                    if (cpu.sensors != null) {
                        message.append("Sensors: \n");

                        //Print temperatures
                        List<Temperature> temps = cpu.sensors.temperatures;
                        for (final Temperature temp : temps) {
                            message.append(temp.name + ": " + temp.value + " C\n");
                        }

                        //Print fan speed
                        List<Fan> fans = cpu.sensors.fans;
                        for (final Fan fan : fans) {
                            message.append(fan.name + ": " + fan.value + " RPM\n");
                        }
                    }
                }
            }

            sendMessageToChannel(message.toString());
        }
    }
}
