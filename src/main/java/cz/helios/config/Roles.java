package cz.helios.config;

import cz.helios.Helios;
import net.dv8tion.jda.api.entities.Role;

public class Roles {

    public static Role developerRole() {
        return Helios.jda.getRoleById(Config.get(Config.SavedData.DEVELOPERCH));
    }

    /*public static boolean checkPermsByRole(Member member, Role checkedRole) {
        return member.getRoles().contains(checkedRole);
    }*/
}
