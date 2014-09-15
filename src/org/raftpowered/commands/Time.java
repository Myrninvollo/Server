package org.raftpowered.commands;

import org.raftpowered.ChatColor;
import org.raftpowered.Command;
import org.raftpowered.CommandSender;
import org.raftpowered.Raft;
import org.raftpowered.World;

public class Time extends Command {
	public void process(CommandSender sender, String[] args) {
		if(op(sender)) {
			World world;
			if(args.length == 0) {
				if(sender.isPlayer()) {
					world = sender.asPlayer().getLocation().getWorld();
					sender.sendMessage("Time: " + world.getTime());
				}
				else {
					sender.sendMessage("Supply a world name.");
				}
			}
			else if(args.length == 1 && ((world = Raft.getWorld(args[0])) != null)) {
				sender.sendMessage(world.getName() + "'s time: " + world.getTime());
			}
			else if(args.length == 1 && (args[0].equalsIgnoreCase("day") || args[0].equalsIgnoreCase("night"))) {
				if(sender.isPlayer()) {
					world = sender.asPlayer().getLocation().getWorld();
					world.setTime(args[0].equalsIgnoreCase("day") ? 1000 : 13000);
					sender.sendMessage("Set time to " + (args[0].equalsIgnoreCase("day") ? "day" : "night") + ".");
				}
				else {
					sender.sendMessage("Supply a world name.");
				}
			}
			else if(args.length == 1 && isNumeric(args[0])) {
				if(sender.isPlayer()) {
					world = sender.asPlayer().getLocation().getWorld();
					world.setTime(Long.parseLong(args[0]));
					sender.sendMessage("Set time to " + world.getTime());
				}
				else {
					sender.sendMessage("Supply a world name.");
				}
			}
			else if(args.length == 2
					&& ((world = Raft.getWorld(args[0])) != null)
					&& (args[1].equalsIgnoreCase("day") || args[1].equalsIgnoreCase("night"))) {
				world.setTime(args[1].equalsIgnoreCase("day") ? 1000 : 13000);
				sender.sendMessage("Set " + world.getName() + " to " + (args[1].equalsIgnoreCase("day") ? "day" : "night") + ".");
			}
			else if(args.length == 2
					&& ((world = Raft.getWorld(args[0])) != null)
					&& isNumeric(args[1])) {
				world.setTime(Long.parseLong(args[1]));
				sender.sendMessage("Set " + world.getName() + " to " + Long.parseLong(args[1]) + ".");
			}
			else {
				sender.sendMessage(ChatColor.RED + "Usage: " + getUsage());
			}
		}
		else {
			sender.sendMessage(ChatColor.RED + "You must be OP to use this command.");
		}
	}
	
	private boolean isNumeric(String number) {
		try {
			Long.parseLong(number);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}
	
	public String getUsage() {
		return "/time [world] [day/night/ticks]";
	}
	
	public String getDescription() {
		return "Sets the time in a world.";
	}
	
	public String getName() {
		return "time";
	}
}
