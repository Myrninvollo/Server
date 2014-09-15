package org.raftpowered.commands;

import org.raftpowered.ChatColor;
import org.raftpowered.Command;
import org.raftpowered.CommandSender;
import org.raftpowered.Player;
import org.raftpowered.Raft;

public class Clear extends Command {
	public void process(CommandSender sender, String[] args) {
		if(sender.isPlayer()) {
			if(args.length == 0) {
				sender.sendMessage("Inventory cleared.");
				sender.asPlayer().clearInventory();
			}
			else if(args.length == 1) {
				Player player = Raft.getPlayer(args[0]);
				if(player != null) {
					player.clearInventory();
					sender.sendMessage("Cleared " + player.getName() + "'s inventory.");
				}
				else {
					sender.sendMessage(ChatColor.RED + "Couldn't find player!");
				}
			}
		}
		else {
			if(args.length == 1) {
				Player player = Raft.getPlayer(args[0]);
				if(player != null) {
					player.clearInventory();
					sender.sendMessage("Cleared " + player.getName() + "'s inventory.");
				}
				else {
					sender.sendMessage(ChatColor.RED + "Couldn't find player!");
				}
			}
			else {
				sender.sendMessage(ChatColor.RED + "Usage: " + getUsage());
			}
		}
	}
	
	public String getName() {
		return "clear";
	}
	
	public String[] getAliases() {
		return new String[] {"ci", "clearinventory"};
	}
	
	public String getDescription() {
		return "Empty the player's inventory.";
	}
}
