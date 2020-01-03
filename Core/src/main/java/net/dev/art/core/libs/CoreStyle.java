package net.dev.art.core.libs;

import net.dev.art.core.libs.PluginStyle;

import java.util.HashMap;

public class CoreStyle extends PluginStyle {

    public CoreStyle() {
        super("Core", "§6Core §a» §f");
    }

    @Override
    public HashMap<String, String> messages() {
        HashMap<String, String> map = new HashMap<>();
        map.put("onlyPlayers", "§cThis command is only for players!");
        map.put("noPermission", "§cYou don't have permission to use this command!");
        return map;
    }
}
