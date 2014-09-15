package org.raftpowered.commands;

import org.raftpowered.ChatColor;
import org.raftpowered.Command;
import org.raftpowered.CommandSender;
import org.raftpowered.Raft;

public class Stop extends Command {
	public String getName() {
		return "stop";
	}
	public void process(CommandSender sender, String[] args) {
		if(op(sender)) {
			sender.sendMessage("Stopping server...");
			Raft.stopServer();
		}
		else {
			sender.sendMessage(ChatColor.RED + "You must be OP to use this command.");
		}
	}
	public String getUsage() {
		return "/stop";
	}
	public String getDescription() {
		return "Saves and shuts down the server.";
	}
}
