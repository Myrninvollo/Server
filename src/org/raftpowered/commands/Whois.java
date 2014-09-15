package org.raftpowered.commands;

import org.raftpowered.ChatColor;
import org.raftpowered.Command;
import org.raftpowered.CommandSender;
import org.raftpowered.Player;
import org.raftpowered.Raft;

public class Whois extends Command {
	public String getName() {
		return "whois";
	}
	public void process(CommandSender sender, String[] args) {
		if(op(sender)) {
			Player player;
			if(args.length == 0) {
				sender.sendMessage(ChatColor.RED + "Usage: " + getUsage());
			}
			else if((player = Raft.getPlayer(args[0])) != null) {
				sender.sendMessage(player.getName() + " (" + player.getIP() + ", " + (player.isOp() ? "OP" : "Not OP") + ")");
				sender.sendMessage((player.getFlying() ? "Flying" : "Grounded") + " (" + (player.getCanFly() ? "Able to fly" : "Unable to fly") + ")");
				sender.sendMessage(player.getHealth() + " Health");
				sender.sendMessage(player.getFood() + " Food");
				sender.sendMessage(player.getSaturation() + " Saturation");
				sender.sendMessage(player.getPing() + "ms Ping");
				sender.sendMessage(player.getArrowCount() + " Arrows Stuck in Body");
				sender.sendMessage(player.getLocation().getBlockX() + "," + player.getLocation().getBlockY() + "," + player.getLocation().getBlockZ());
				sender.sendMessage("UUID: " + player.getUUID());
				sender.sendMessage("EID: " + player.getEntityId());
			}
			else {
				sender.sendMessage("Player not found!");
			}
		}
		else {
			sender.sendMessage(ChatColor.RED + "You must be OP to use this command.");
		}
	}
	public String getDescription() {
		return "Stats on the player.";
	}
	public String getUsage() {
		return "/whois <name>";
	}
}
