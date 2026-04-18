package io.github.miao_2026;

import org.bukkit.plugin.java.JavaPlugin;
import java.io.File;
import java.io.IOException;

import static io.github.miao_2026.LoadCommand.registerAllCommands;

public class RHJ_MAIN extends JavaPlugin {
    @Override
    public void onEnable() {
        for(int _i=0;_i<10;_i++){
            System.out.println("上");
        }
        registerAllCommands();
        File test = new File("test.json");
        try {
            PluginManager.regRunEvent(test);
            PluginManager.executeAllPlugins();
            for(int _i=0;_i<10;_i++){
                System.out.println("下");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
