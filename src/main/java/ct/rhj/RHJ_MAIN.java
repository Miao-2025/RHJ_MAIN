package ct.rhj;

import org.bukkit.plugin.java.JavaPlugin;

public class RHJ_MAIN extends JavaPlugin {
    @Override
    public void onEnable() {
        getCommand("rhj").setExecutor(new cmd_rhj());
    }
    @Override
    public void onDisable() {
        PluginManager.onDisable();
    }
}
