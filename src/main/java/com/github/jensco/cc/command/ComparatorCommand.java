package com.github.jensco.cc.command;

import com.github.jensco.cc.PlayerCheckerInterface;
import org.bukkit.Bukkit;
import org.bukkit.command.*;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class ComparatorCommand implements CommandExecutor, TabCompleter {

    private final PlayerCheckerInterface checker;

    public ComparatorCommand(PlayerCheckerInterface checker) {
        this.checker = checker;
    }

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (!hasPermission(sender) || !isPlayer(sender)) return true;
        Player player = (Player) sender;

        String fullCommand = String.join(" ", args);
        String[] parts = fullCommand.split("\\|\\|");

        if (parts.length != 2) {
            sender.sendMessage("Use: /cc <javacommand> || <bedrockcommand>");
            return true;
        }

        boolean isBedrock = checker.isBedrock(player.getUniqueId());
        String toExecute = isBedrock ? parts[1].trim() : parts[0].trim();

        boolean success = Bukkit.dispatchCommand(player, toExecute);

        if (!success) {
            player.sendMessage("Something went wrong while using CommandComparator");
        }
        return true;
    }

    @Override
    public List<String> onTabComplete(@NotNull CommandSender sender, @NotNull Command command, @NotNull String alias, @NotNull String[] args) {
        String full = String.join(" ", args);
        List<String> completions = new ArrayList<>();

        if (!full.contains("||")) {
            completions.add("say Hello from Java");
            completions.add("msg @a Java message");
        } else {
            completions.add("tellraw @a \"Hello Bedrock\"");
            completions.add("title @a title Bedrock!");
        }

        return completions;
    }

    private boolean hasPermission(@NotNull CommandSender sender) {
        if (!sender.hasPermission("commandcomparator.use")) {
            sender.sendMessage("§cYou do not have permission to use this command.");
            return false;
        }
        return true;
    }

    private boolean isPlayer(CommandSender sender) {
        if (!(sender instanceof Player)) {
            sender.sendMessage("This command is only for players!");
            return false;
        }
        return true;
    }

}
