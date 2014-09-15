package org.raftpowered.commands;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.raftpowered.ChatColor;
import org.raftpowered.Command;
import org.raftpowered.CommandSender;
import org.raftpowered.Plugin;
import org.raftpowered.PluginManager;
import org.raftpowered.Raft;

public class Plugins extends Command {
	public void process(CommandSender sender, String[] args) {
		if(op(sender)) {
			List<String> names = new ArrayList<String>();
			for(Plugin plugin : PluginManager.plugins) names.add(plugin.getName());
			if(args.length == 0) {
				sender.sendMessage("Plugins (" + PluginManager.pluginCount + "): " + StringUtils.join(names, ", "));
			}
			else {
				Plugin plugin = Raft.getPlugin(args[0]);
				if(plugin != null) sender.sendMessage(plugin.getName() + " (" + plugin.getVersion() + "): " + plugin.getDescription());
				else sender.sendMessage(ChatColor.RED + "No such plugin, " + args[0]);
			}
		}
		else {
			sender.sendMessage(ChatColor.RED + "You must be OP to use this command.");
		}
	}
	
	public String getName() {
		return "plugins";
	}
	
	public String[] getAliases() {
		return new String[] {"pl"};
	}
	
	public String getDescription() {
		return "A list of plugins installed.";
	}
}
