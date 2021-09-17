package slimespit.slimespit;

import java.util.Iterator;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import slimespit.slimespit.SlimeSpit;

public class Commands implements CommandExecutor {
    private final SlimeSpit plugin;

    public Commands(SlimeSpit plugin) {
        this.plugin = plugin;
    }

    public boolean onCommand(CommandSender commandSender, Command command, String label, String[] args) {
        if (args.length == 0) {
            return false;
        } else {
            String name = args[0];
            Player recPlayer = Bukkit.getPlayer(name);
            Player sendPlayer = (Player)commandSender;
            if (recPlayer == null) {
                commandSender.sendMessage(name + " не онлайн!");
                return true;
            } else {
                assert sendPlayer != null;

                Location sendLoc = sendPlayer.getLocation();
                Location recLoc = recPlayer.getLocation();
                double distance = sendLoc.distance(recLoc);
                if (distance >= 5.0D) {
                    sendPlayer.sendMessage(ChatColor.RED + name + " стоит слишком далеко ");
                    return true;
                } else {
                    double radius = 100.0D;

                    Player p;
                    for(Iterator var15 = Bukkit.getOnlinePlayers().iterator(); var15.hasNext(); p.playSound(p.getLocation(), Sound.ENTITY_LLAMA_SPIT, 1.0F, 1.0F)) {
                        p = (Player)var15.next();
                        if (p.getLocation().distance(sendLoc) < radius) {
                            p.sendMessage(ChatColor.YELLOW + sendPlayer.getName() + ChatColor.GRAY + " харкнул в " + ChatColor.YELLOW + recPlayer.getName());
                        }
                    }

                    return true;
                }
            }
        }
    }
}