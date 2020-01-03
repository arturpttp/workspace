package net.dev.art.core.libs;

import java.util.HashMap;

public abstract class PluginStyle {

    public String name, prefix;

    public PluginStyle(String name, String prefix) {
        this.name = name;
        this.prefix = prefix;
    }

    public abstract HashMap<String, String> messages();

    public String getMessage(String path) {
        return messages().getOrDefault(path, "§cMessage '§f" + path + "§c' is not defined!");
    }

    public String getName() {
        return name;
    }

    public String getPrefix() {
        return prefix;
    }

    public PluginStyle setPrefix(String prefix) {
        this.prefix = prefix;
        return this;
    }
}
