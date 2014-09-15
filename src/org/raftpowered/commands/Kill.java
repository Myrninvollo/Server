package org.raftpowered.commands;

import org.raftpowered.ChatColor;
import org.raftpowered.Command;
import org.raftpowered.CommandSender;
import org.raftpowered.Player;
import org.raftpowered.Raft;

import net.minecraft.util.DamageSource;

public class Kill extends Command {
	public String getName() {
		return "kill";
	}
	public void process(CommandSender sender, String[] args) {
		if(op(sender)) {
			if(args.length == 0 && !sender.isPlayer()) {
				sender.sendMessage("Only players can suicide.");
			}
			else if(args.length == 0 || (args.length == 1 && args[0].equalsIgnoreCase(sender.getName()))) {
				sender.sendMessage("Goodbye cruel world.");
				sender.asPlayer().applyDamageTemp(DamageSource.outOfWorld, Float.MAX_VALUE);
			}
			else if(args.length == 1) {
				Player target = Raft.getPlayer(args[0]);
				if(target == null) sender.sendMessage("Couldn't find player.");
				else target.applyDamageTemp(sender.isPlayer()
						? DamageSource.causePlayerDamage(sender.asPlayer().NMS)
						: DamageSource.outOfWorld, Float.MAX_VALUE);
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
		return "/kill [who]";
	}
	public String getDescription() {
		return "Kills the player.";
	}
}
