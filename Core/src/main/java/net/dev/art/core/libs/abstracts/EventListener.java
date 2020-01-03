package net.dev.art.core.libs.abstracts;

import net.dev.art.core.Core;
import net.dev.art.core.libs.CoreLib;
import org.bukkit.Bukkit;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.List;

public abstract class EventListener implements Listener, CoreLib {

    public JavaPlugin plugin;
    public static List<EventListener> LISTENER_MAP = new ArrayList<>();

    public void register(JavaPlugin plugin) {
        this.plugin = plugin;
        LISTENER_MAP.add(this);
        Bukkit.getPluginManager().registerEvents(this, plugin);
    }

    public void register() {
        register(JavaPlugin.getPlugin(Core.class));
    }


}
