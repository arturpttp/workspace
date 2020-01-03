package net.dev.art.core.libs.abstracts;

import net.dev.art.core.Core;
import net.dev.art.core.libs.CoreLib;
import org.bukkit.command.*;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractCommand extends Command implements TabCompleter, CoreLib {

    public JavaPlugin plugin;

    public static List<AbstractCommand> COMMAND_MAP = new ArrayList<>();

    public AbstractCommand(String name) {
        super(name);
        COMMAND_MAP.add(this);
    }

    public AbstractCommand(String name, String description, String usageMessage, List<String> aliases) {
        super(name, description, usageMessage, aliases);
        COMMAND_MAP.add(this);
    }

    public Player getPlayer(CommandSender sender) {
        if (!(sender instanceof Player)) {
            Core.instance.prefixed("§cCommand only for players!");
            return null;
        }
        return (Player) sender;
    }

    public void addAliase(String aliase) {
        List<String> aliases = getAliases();
        aliases.add(aliase);
        setAliases(aliases);
    }

    public abstract boolean execute(CommandSender sender, String lb, String[] args);

    @Override
    public List<String> onTabComplete(CommandSender commandSender, Command command, String s, String[] strings) {
        return null;
    }

    public void register(JavaPlugin plugin) {
        this.plugin = plugin;
        CommandMap map = getCommandMap();
        map.register(getName(), this);
    }

    public void register() {
        register(JavaPlugin.getPlugin(Core.class));
    }

}
