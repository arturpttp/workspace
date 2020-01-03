package net.dev.art.core.libs;

import org.bukkit.Bukkit;
import org.bukkit.command.CommandMap;
import org.bukkit.craftbukkit.v1_8_R3.CraftServer;

import java.lang.reflect.Field;

public interface CoreLib {

    default CoreLib console(String msg) {
        Bukkit.getConsoleSender().sendMessage(msg);
        return this;
    }

    default CommandMap getCommandMap() {
        try {
            if (Bukkit.getServer() instanceof CraftServer) {
                final Field f = CraftServer.class.getDeclaredField("commandMap");
                f.setAccessible(true);
                return (CommandMap) f.get(Bukkit.getServer());
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return null;
    }

}
