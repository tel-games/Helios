package cz.helios.config;

public class ConfigModel {
    private String token;
    private String prefix;
    private String adminRole;

    private String devRole;
    private String commandChannelID;

    public String getDevRole() {
        return devRole;
    }

    public String getToken() {
        return token;
    }

    public String getPrefix() {
        return prefix;
    }

    public String getAdminRole() {
        return adminRole;
    }

    public String getCommandChannelID() {
        return commandChannelID;
    }

    public ConfigModel(String token, String prefix, String adminRole, String commandChannelID, String devRole) {
        this.token = token;
        this.prefix = prefix;
        this.adminRole = adminRole;
        this.commandChannelID = commandChannelID;
        this.devRole = devRole;
    }
}
