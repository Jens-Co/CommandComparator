package com.github.jensco.cc;

import com.github.jensco.cc.command.ComparatorCommand;
import com.github.jensco.cc.player_api.FloodgatePlayerChecker;
import com.github.jensco.cc.player_api.GeyserPlayerChecker;
import org.bukkit.command.PluginCommand;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.logging.Logger;

public final class CommandComparator extends JavaPlugin {

    @Override
    public void onEnable() {
        Logger logger = getLogger();
        PlayerCheckerInterface checker;
        Plugin floodgate = getServer().getPluginManager().getPlugin("floodgate");
        Plugin geyser = getServer().getPluginManager().getPlugin("Geyser-Spigot");

        if (floodgate != null && floodgate.isEnabled()) {
            checker = new FloodgatePlayerChecker();
        } else if (geyser != null && geyser.isEnabled()) {
            checker = new GeyserPlayerChecker();
        } else {
            logger.severe("Could not find Floodgate or Geyser. Disabling...");
            getServer().getPluginManager().disablePlugin(this);
            return;
        }

        PluginCommand cc = getCommand("cc");
        if (cc == null) {
            logger.severe("Command 'cc' not found in plugin.yml!");
            getServer().getPluginManager().disablePlugin(this);
            return;
        }
        cc.setExecutor(new ComparatorCommand(checker));
        cc.setTabCompleter(new ComparatorCommand(checker));
    }


    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
