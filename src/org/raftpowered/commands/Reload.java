package org.raftpowered.commands;

import org.raftpowered.ChatColor;
import org.raftpowered.Command;
import org.raftpowered.CommandSender;
import org.raftpowered.Raft;

public class Reload extends Command {
	public void process(CommandSender sender, String[] args) {
		if(op(sender)) {
			sender.sendMessage("Reloading all plugins. This may take a while.");
			Raft.reloadPlugins();
			sender.sendMessage(ChatColor.GREEN + "Reload complete!");
		}
		else {
			sender.sendMessage(ChatColor.RED + "You must be OP to use this command.");
		}
	}
	
	public String getName() {
		return "reload";
	}
	
	public String getDescription() {
		return "Reloads all plugins.";
	}
	
	public String getUsage() {
		return "/reload";
	}
}
