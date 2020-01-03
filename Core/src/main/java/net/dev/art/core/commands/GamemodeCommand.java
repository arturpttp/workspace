package net.dev.art.core.commands;

import net.dev.art.core.Core;
import net.dev.art.core.libs.abstracts.AbstractCommand;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

public class GamemodeCommand extends AbstractCommand {

    public GamemodeCommand() {
        super("gamemode");
        addAliase("gm");
    }

    @Override
    public boolean execute(CommandSender sender, String lb, String[] args) {
        return false;
    }

}
