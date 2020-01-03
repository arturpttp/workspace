package net.dev.art.core;

import net.dev.art.core.commands.GamemodeCommand;
import net.dev.art.core.libs.CoreStyle;
import net.dev.art.core.libs.PluginCore;
import net.dev.art.core.libs.mysql.MysqlConnection;

import java.sql.SQLException;

public class Core extends PluginCore {

    public static Core instance;
    public static final CoreStyle STYLE = new CoreStyle();
    public static MysqlConnection CONNECTION;
    public Core() {
        super("Core", STYLE, Core.class);
    }

    @Override
    public void onLoad() {
        prefixed("Loading plugin");
        CONNECTION = new MysqlConnection("plugins");
    }

    @Override
    public void onEnable() {
        instance = this;
        try {
            register();
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            CONNECTION.open();
            prefixed("Mysql iniciado!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        prefixed("Plugin loaded");
    }

    @Override
    public void onDisable() {
        try {
            CONNECTION.close();
            prefixed("Mysql fechado!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        prefixed("Plugin disabled");
    }

}
