package ct.rhj;

import org.bukkit.block.CommandBlock;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.checkerframework.checker.nullness.qual.NonNull;

import java.io.File;
import java.io.IOException;

import static org.bukkit.Bukkit.getLogger;

public class cmd_rhj implements CommandExecutor {
    @Override
    public boolean onCommand(@NonNull CommandSender commandSender, @NonNull Command command, @NonNull String s, String @NonNull [] args) {
        // 禁止命令方块使用
        if (commandSender instanceof CommandBlock) {
            commandSender.sendMessage("禁止在命令方块中使用此命令");
            return false;
        }

        // 参数数量验证
        if (args.length < 2) {
            commandSender.sendMessage("§c使用格式: /rhj [load/unload] <插件文件路径>");
            return false;
        }

        File pluginFile = new File(args[1]);
        if (!pluginFile.exists() & args[0].equalsIgnoreCase("load")) {
            commandSender.sendMessage("§c指定的插件文件不存在: " + args[1]);
            return false;
        }

        try {
            switch (args[0].toLowerCase()) {
                case "unload":
                    try {
                        getLogger().info("卸载插件: " + args[1]);
                        PluginManager.removePlugin(args[1]); // 传递文件名作为插件名称
                        commandSender.sendMessage("§a已卸载插件: " + args[1]);
                    } catch (IllegalStateException e) {
                        commandSender.sendMessage("§c卸载插件失败: " + e.getMessage());
                    }
                    break;

                case "load":
                    try {
                        PluginManager.regRunEvent(pluginFile);
                        commandSender.sendMessage("§a已加载插件: " + args[1]);
                    } catch (IOException e) {
                        commandSender.sendMessage("§c加载插件失败: " + e.getMessage());
                    }
                    break;

                default:
                    commandSender.sendMessage("§c未知的子命令: " + args[0]);
                    return false;
            }
        } catch (Exception e) {
            commandSender.sendMessage("§c文件操作失败: " + e.getMessage());
            getLogger().severe("插件管理器异常: " + e.getMessage());
            return false;
        }
        return true;
    }

    @SuppressWarnings("unused")
    private void GUI() {}
}
