package slimespit.slimespit;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.ConsoleCommandSender;

import org.bukkit.plugin.java.JavaPlugin;

public final class SlimeSpit extends JavaPlugin {
    final ConsoleCommandSender console = Bukkit.getServer().getConsoleSender();
    String version = "1.0";

    public void onEnable() {
        this.console.sendMessage(this.getMessageColor("\n \n&8[]=====[&7Enabling SlimeSpit&8]=====[]\n&8| &cInformation:\n&8|   &cName: &7SlimeSpit\n&8|   &cDeveloper: &7R_u_B_i_K / SlimeStudio\n&8|   &cVersion: &7" + this.getVersion() + "\n&8[]======================================[]&r\n "));
        this.getCommand("spit").setExecutor(new Commands(this));
    }

    public void onDisable() {
        this.console.sendMessage(this.getMessageColor("\n \n&8[]=====[&7Disabling SlimeSpit&8]=====[]\n&8| &cInformation:\n&8|   &cName: &7SlimeSpit\n&8|   &cDeveloper: &7R_u_B_i_K / SlimeStudio\n&8|   &cVersion: &7" + this.getVersion() + "\n&8[]======================================[]&r\n "));
    }

    public String getVersion() {
        return this.version;
    }

    public String getMessageColor(String msg) {
        return ChatColor.translateAlternateColorCodes('&', msg);
    }
}