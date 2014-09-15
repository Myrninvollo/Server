package org.raftpowered.commands;

import org.raftpowered.ChatColor;
import org.raftpowered.Command;
import org.raftpowered.CommandSender;
import org.raftpowered.Player;
import org.raftpowered.Raft;

public class GameMode extends Command {
	public void process(CommandSender sender, String[] args) {
		if(op(sender)) {
			if(sender.isPlayer()) {
				if(args.length > 0) {
					org.raftpowered.GameMode mode = org.raftpowered.GameMode.get(args[0]);
					if(mode == null) {
						sender.sendMessage(ChatColor.RED + "No such gamemode \"" + args[0] + "\".");
					}
					else {
						Player player;
						if(args.length == 1) player = sender.asPlayer();
						else player = Raft.getPlayer(args[1]);
						if(player == null) sender.sendMessage(ChatColor.RED + "Couldn't find player!");
						else player.setGameMode(mode);
					}
				}
				else {
					sender.sendMessage(ChatColor.RED + "Usage: " + getUsage());
				}
			}
			else {
				if(args.length > 1) {
					org.raftpowered.GameMode mode = org.raftpowered.GameMode.get(args[0]);
					if(mode == null) {
						sender.sendMessage(ChatColor.RED + "No such gamemode \"" + args[0] + "\".");
					}
					else {
						Player player = Raft.getPlayer(args[1]);
						if(player == null) sender.sendMessage(ChatColor.RED + "Couldn't find player!");
						else player.setGameMode(mode);
					}
				}
				else {
					sender.sendMessage(ChatColor.RED + "Usage: " + getUsage());
				}
			}
		}
		else {
			sender.sendMessage(ChatColor.RED + "You must be OP to use this command.");
		}
	}
	
	public String getName() {
		return "gamemode";
	}
	
	public String[] getAliases() {
		return new String[] {"gm", "mode"};
	}
	
	public String getUsage() {
		return "/gamemode <mode> [player]";
	}
	
	public String getDescription() {
		return "Sets the player's gamemode.";
	}
}
