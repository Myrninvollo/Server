package org.raftpowered.commands;

import org.raftpowered.ChatColor;
import org.raftpowered.Command;
import org.raftpowered.CommandSender;
import org.raftpowered.Player;
import org.raftpowered.Raft;

public class Feed extends Command {
	public void process(CommandSender sender, String[] args) {
		if(op(sender)) {
			if(args.length == 0 && !sender.isPlayer()) {
				sender.sendMessage("Only players can eat.");
			}
			else if(args.length == 0 || (args.length == 1 && args[0].equalsIgnoreCase(sender.getName()))) {
				sender.asPlayer().setFood(20);
				if(sender.asPlayer().getSaturation() < 5)
					sender.asPlayer().addSaturation(5 - sender.asPlayer().getSaturation());
				sender.sendMessage("Bon appetit.");
			}
			else if(args.length == 1) {
				Player target = Raft.getPlayer(args[0]);
				target.setFood(20);
				if(target.getSaturation() < 5) target.addSaturation(5 - target.getSaturation());
				target.sendMessage("Bon appetit.");
				sender.sendMessage("Fed " + target.getName() + ".");
			}
		}
		else {
			sender.sendMessage(ChatColor.RED + "You must be OP to use this command.");
		}
	}
	public String getName() {
		return "feed";
	}
	public String getUsage() {
		return "/feed [who]";
	}
	public String getDescription() {
		return "Feed yourself or a player.";
	}
}
