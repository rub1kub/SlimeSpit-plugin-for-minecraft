package slimespit.slimespit;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class CommandReload implements CommandExecutor {

    private SlimeSpit plugin;

    public CommandReload(SlimeSpit plugin){
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (!sender.hasPermission("spit.reload")) {
            sender.sendMessage(plugin.getConfig().getString("messages.commands.donthaveperrm").replace("&","§"));
            return true;
        }
        plugin.reloadConfig();
        sender.sendMessage(plugin.getConfig().getString("messages.commands.reload").replace("&","§"));
        return true;
    }
}
