package slimespit.slimespit;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.ConsoleCommandSender;

import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;

public final class SlimeSpit extends JavaPlugin {
    final ConsoleCommandSender console = Bukkit.getServer().getConsoleSender();
    String version = "2.0";

    public void onEnable() {
        File file = new File("plugins/SlimeSpit");
        file.mkdir();

        File config = new File("plugins/SlimeSpit/config.yml");
        if(!config.exists()) {
            getConfig().options().copyDefaults(true);
            saveDefaultConfig();
        }

        this.console.sendMessage(this.getMessageColor("\n \n&8[]=====[&aEnabling SlimeSpit&8]=====[]\n&8| &cInformation:\n&8|   &cName: &7SlimeSpit\n&8|   &cDeveloper: &7R_u_B_i_K / SlimeStudio\n&8|   &cVersion: &7" + this.getVersion() + "\n&8[]======================================[]&r\n "));
        this.getCommand("spit").setExecutor(new Commands(this));
        this.getCommand("spitreload").setExecutor(new CommandReload(this));
    }

    public void onDisable() {
        this.console.sendMessage(this.getMessageColor("\n \n&8[]=====[&aDisabling SlimeSpit&8]=====[]\n&8| &cInformation:\n&8|   &cName: &7SlimeSpit\n&8|   &cDeveloper: &7R_u_B_i_K / SlimeStudio\n&8|   &cVersion: &7" + this.getVersion() + "\n&8[]======================================[]&r\n "));
    }

    public String getVersion() {
        return this.version;
    }

    public String getMessageColor(String msg) {
        return ChatColor.translateAlternateColorCodes('&', msg);
    }
}