package org.raftpowered.commands;

import org.raftpowered.Command;
import org.raftpowered.CommandSender;
import org.raftpowered.Raft;

public class Help extends Command {
	public String getName() {
		return "help";
	}
	public void process(CommandSender sender, String[] args) {
		for(Command command : Raft.getCommands()) sender.sendMessage(command.getName() + ": " + command.getDescription());
	}
	public String getUsage() {
		return "/help [page]";
	}
	public String getDescription() {
		return "Displays available commands.";
	}
}
