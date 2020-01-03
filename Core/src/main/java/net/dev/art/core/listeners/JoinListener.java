package net.dev.art.core.listeners;

import net.dev.art.core.Core;
import net.dev.art.core.libs.abstracts.EventListener;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerJoinEvent;

public class JoinListener extends EventListener {

    @EventHandler
    void event(PlayerJoinEvent event) {
        event.setJoinMessage(null);
    }

}
