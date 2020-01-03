package net.dev.art.core.listeners;

import net.dev.art.core.libs.abstracts.EventListener;
import org.bukkit.event.EventHandler;
import org.bukkit.event.entity.PlayerDeathEvent;

public class DeathListener extends EventListener {

    @EventHandler
    void event(PlayerDeathEvent event) {
        event.setDeathMessage(null);
        event.getEntity().spigot().respawn();
    }

}
