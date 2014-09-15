package org.raftpowered.commands;

import org.raftpowered.ChatColor;
import org.raftpowered.Command;
import org.raftpowered.CommandSender;
import org.raftpowered.Location;
import org.raftpowered.Player;
import org.raftpowered.Raft;

public class Teleport extends Command {
	public void process(CommandSender sender, String[] args) {
		if(op(sender)) {
			if((args.length == 1 || args.length ==3) && !sender.isPlayer()) {
				sender.sendMessage("Only players can teleport.");
			}
			else if(args.length == 1) {
				Player target = Raft.getPlayer(args[0]);
				if(target != null) {
					sender.asPlayer().setLocation(target.getLocation());
					sender.sendMessage("Teleported to " + target.getName());
				}
				else {
					sender.sendMessage("Couldn't find player.");
				}
			}
			else if(args.length == 2) {
				Player source = Raft.getPlayer(args[0]), target = Raft.getPlayer(args[1]);
				if(source == null) {
					sender.sendMessage("Couldn't find player 1.");
				}
				else if(target == null) {
					sender.sendMessage("Couldn't find player 2.");
				}
				else {
					source.setLocation(target.getLocation());
					source.sendMessage("Teleport to " + target.getName() + ".");
					sender.sendMessage("Teleported " + source.getName() + " to " + target.getName() + ".");
				}
			}
			else if(args.length == 3) {
				if(isNumeric(args[0]) && isNumeric(args[1]) && isNumeric(args[2])) {
					Location target = new Location(sender.asPlayer().getLocation().getWorld(), Double.parseDouble(args[0]), Double.parseDouble(args[1]), Double.parseDouble(args[2]));
					sender.asPlayer().setLocation(target);
					sender.sendMessage("Teleported to " + target.getBlockX() + "," + target.getBlockY() + "," + target.getBlockZ() + ".");
				}
				else {
					sender.sendMessage("X, Y, and Z must be numbers.");
				}
			}
			else if(args.length == 4) {
				Player source = Raft.getPlayer(args[0]);
				if(source == null) {
					sender.sendMessage("Couldn't find player.");
				}
				else if(isNumeric(args[0]) && isNumeric(args[1]) && isNumeric(args[2])) {
					Location target = new Location(source.getLocation().getWorld(), Double.parseDouble(args[0]), Double.parseDouble(args[1]), Double.parseDouble(args[2]));
					source.setLocation(target);
					source.sendMessage("Teleported to " + target.getBlockX() + "," + target.getBlockY() + "," + target.getBlockZ() + ".");
					sender.sendMessage("Teleported " + source.getName() + " to " + target.getBlockX() + "," + target.getBlockY() + "," + target.getBlockZ() + ".");
				}
				else {
					sender.sendMessage("X, Y, and Z must be numbers.");
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
	
	private boolean isNumeric(String number) {
		try {
			Double.parseDouble(number);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}
	
	public String getUsage() {
		return "/teleport [who] <to> [OR] /teleport [who] <x> <y> <z>";
	}
	
	public String getDescription() {
		return "Teleports players to locations or other players.";
	}
	
	public String getName() {
		return "teleport";
	}
	
	public String[] getAliases() {
		return new String[] { "tp" };
	}
}
