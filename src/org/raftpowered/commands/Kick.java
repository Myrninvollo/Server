package org.raftpowered.commands;

import org.raftpowered.ChatColor;
import org.raftpowered.Command;
import org.raftpowered.CommandSender;
import org.raftpowered.Player;
import org.raftpowered.Raft;

public class Kick extends Command {
	public void process(CommandSender sender, String[] args) {
		if(op(sender)) {
			if(args.length == 1) {
				Player player = Raft.getPlayer(args[0]);
				if(player == null) {
					sender.sendMessage("Couldn't find player.");
				}
				else {
					player.kick("Kicked from the server.");
					sender.sendMessage("Kicked " + player.getName() + ".");
				}
			}
			else if(args.length > 1) {
				Player player = Raft.getPlayer(args[0]);
				if(player == null) {
					sender.sendMessage("Couldn't find player.");
				}
				else {
					String reason = "";
					for(int i = 1; i < args.length; i++) {
						reason += args[i];
						if(i != args.length - 1) reason += " ";
					}
					player.kick(reason);
					sender.sendMessage("Kicked " + player.getName() + " for \"" + reason + "\".");
				}
				
			}
			else {
				sender.sendMessage("Usage: " + getUsage());
			}
		}
		else {
			sender.sendMessage(ChatColor.RED + "You must be OP to use this command.");
		}
	}
	
	public String getUsage() {
		return "/kick <who> [why]";
	}
	
	public String getDescription() {
		return "Kick the player from the server.";
	}
	
	public String getName() {
		return "kick";
	}
}
