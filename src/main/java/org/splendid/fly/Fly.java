package org.splendid.fly;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class Fly extends JavaPlugin implements CommandExecutor {

    @Override
    public void onEnable() {
        // Actions to perform when the plugin is enabled
        getLogger().info("Fly plugin enabled!");

        // Register the command
        getCommand("fly").setExecutor(this);
    }

    @Override
    public void onDisable() {
        // Actions to perform when the plugin is disabled
        getLogger().info("Fly plugin disabled!");
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        // Actions to perform when the command is executed
        if (command.getName().equalsIgnoreCase("fly")) {
            if (sender instanceof Player) {
                Player player = (Player) sender;

                // Toggle flight if player has "fly.admin" permission
                if (player.hasPermission("fly.admin")) {
                    if (player.getAllowFlight()) {
                        player.setAllowFlight(false);
                        player.sendMessage("Flight disabled.");
                    } else {
                        player.setAllowFlight(true);
                        player.sendMessage("Flight enabled.");
                    }
                } else {
                    player.sendMessage("You don't have permission to use this command!");
                }
            } else {
                sender.sendMessage("This command can only be used by players!");
            }

            return true;
        }

        return false;
    }
}
