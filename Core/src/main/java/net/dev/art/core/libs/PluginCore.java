package net.dev.art.core.libs;

import net.dev.art.core.libs.abstracts.AbstractCommand;
import net.dev.art.core.libs.abstracts.EventListener;
import org.bukkit.plugin.java.JavaPlugin;

public abstract class PluginCore extends JavaPlugin implements CoreLib {

    public PluginStyle style;
    public String name;
    public Class<? extends PluginCore> plugin;

    public PluginCore(String name, PluginStyle style, Class<? extends PluginCore> plugin) {
        this.name = name;
        this.style = style;
        this.plugin = plugin;
    }

    public void prefixed(String msg) {
        console(style.prefix + msg);
    }

    public void register() throws Exception {
        String pkg = plugin.getPackage().toString().replace("package ", "");
        JavaPlugin pl = JavaPlugin.getPlugin(plugin);
        for (Class cls : API.getClassesForPackage(pl, pkg)) {
            if (EventListener.class.isAssignableFrom(cls) && cls != EventListener.class) {
                EventListener cz = (EventListener) cls.newInstance();
                cz.register(pl);
                console("§bEventAPI §8» §fLoading events in class: " + cls.getSimpleName());
            }
            if (AbstractCommand.class.isAssignableFrom(cls) && cls != AbstractCommand.class) {
                AbstractCommand cz = (AbstractCommand) cls.newInstance();
                cz.register(pl);
                console("§bCommandAPI §8» §fLoading command: " + cz.getName());
            }
        }
    }
}
