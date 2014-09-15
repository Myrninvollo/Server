package org.raftpowered.commands;

import org.raftpowered.ChatColor;
import org.raftpowered.Command;
import org.raftpowered.CommandSender;
import org.raftpowered.Raft;
import org.raftpowered.World;

public class Weather extends Command {
	public void process(CommandSender sender, String[] args) {
		if(op(sender)) {
			World world;
			if(args.length == 0) {
				if(sender.isPlayer()) {
					world = sender.asPlayer().getLocation().getWorld();
					// get weather
				}
				else {
					sender.sendMessage("Supply a world name.");
				}
			}
			else if(args.length == 1 && ((world = Raft.getWorld(args[0])) != null)) {
				// get weather
			}
			else if(args.length == 1 && (args[0].equalsIgnoreCase("sun") || args[0].equalsIgnoreCase("rain"))) {
				if(sender.isPlayer()) {
					world = sender.asPlayer().getLocation().getWorld();
					// set weather
					sender.sendMessage("Set weather to " + args[0].toLowerCase() + ".");
				}
				else {
					sender.sendMessage("Supply a world name.");
				}
			}
			else if(args.length == 2
					&& ((world = Raft.getWorld(args[0])) != null)
					&& (args[1].equalsIgnoreCase("sun") || args[1].equalsIgnoreCase("rain"))) {
				// set weather
				sender.sendMessage("Set " + world.getName() + " to " + args[1].toLowerCase() + ".");
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
		return "/weather [world] [clear/rain]";
	}
	
	public String getDescription() {
		return "Sets the time in a world.";
	}
	
	public String getName() {
		return "time";
	}
}
