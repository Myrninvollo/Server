package org.raftpowered.commands;

import org.raftpowered.ChatColor;
import org.raftpowered.Command;
import org.raftpowered.CommandSender;
import org.raftpowered.Player;
import org.raftpowered.Raft;
import org.raftpowered.internal.Bans;

public class Ban extends Command {
	public void process(CommandSender sender, String[] args) {
		if(op(sender)) {
			if(args.length == 1) {
				Player player = Raft.getPlayer(args[0]);
				if(player != null) args[0] = player.getName();
				if(!Bans.contains(args[0])) {
					Bans.add(args[0]);
					sender.sendMessage("Banned " + args[0] + ".");
				}
				else {
					sender.sendMessage(args[0] + " is already banned.");
				}
			}
			else {
				sender.sendMessage(ChatColor.RED + "Usage: " + getUsage());
			}
		}
		else {
			sender.sendMessage(ChatColor.RED + "You must be OP to use this command.");
		}
	}
	
	public String getUsage() {
		return "/ban <who>";
	}
	
	public String getDescription() {
		return "Bans a player or IP.";
	}
	
	public String getName() {
		return "ban";
	}
}
