package org.raftpowered.commands;

import org.raftpowered.ChatColor;
import org.raftpowered.Command;
import org.raftpowered.CommandSender;
import org.raftpowered.Raft;
import org.raftpowered.internal.Ops;

public class Op extends Command {
	public void process(CommandSender sender, String[] args) {
		if(op(sender)) {
			if(args.length == 1) {
				if(!Ops.contains(args[0])) {
					Ops.add(args[0]);
					sender.sendMessage("Opped " + args[0].toLowerCase() + ".");
					if(Raft.getPlayerExact(args[0]) != null)
						Raft.getPlayerExact(args[0]).sendMessage(ChatColor.YELLOW + "You are now OP!");
				}
				else {
					sender.sendMessage(args[0] + " was already an op.");
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
		return "/op <who>";
	}
	
	public String getDescription() {
		return "Make the player an operator.";
	}
	
	public String getName() {
		return "op";
	}
}
