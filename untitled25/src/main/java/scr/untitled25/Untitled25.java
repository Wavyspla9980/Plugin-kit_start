package scr.untitled25;

import org.bukkit.plugin.java.JavaPlugin;

public final class Untitled25 extends JavaPlugin {

    @Override
    public void onEnable() {
      getCommand("kit").setExecutor(new Commands_kit());

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
