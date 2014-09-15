package org.raftpowered.commands;

import org.raftpowered.ChatColor;
import org.raftpowered.Command;
import org.raftpowered.CommandSender;
import org.raftpowered.Player;
import org.raftpowered.Raft;
import org.raftpowered.internal.Bans;

public class Unban extends Command {
	public void process(CommandSender sender, String[] args) {
		if(op(sender)) {
			if(args.length == 1) {
				Player player = Raft.getPlayer(args[0]);
				if(player != null) args[0] = player.getName();
				if(Bans.contains(args[0])) {
					Bans.remove(args[0]);
					sender.sendMessage("Unbanned " + args[0] + ".");
				}
				else {
					sender.sendMessage(args[0] + " wasn't banned.");
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
	
	public String getUsage() {
		return "/unban <who>";
	}
	
	public String[] getAliases() {
		return new String[] {"pardon"};
	}
	
	public String getDescription() {
		return "Unbans a player or IP.";
	}
	
	public String getName() {
		return "unban";
	}
}
