package org.raftpowered;

public abstract class Command {
	public abstract void process(CommandSender sender, String[] args);
	public abstract String getName();
	public String[] getAliases() {
		return new String[0];
	}
	public String getUsage() {
		return "No usage info.";
	}
	public String getDescription() {
		return "No description.";
	}
	public String[] getTabCompletions(CommandSender sender, String[] args) {
		return new String[0];
	}
	
	
	/**
	 * True if this player is OP.
	 * @param sender
	 * @return
	 */
	public boolean op(CommandSender sender) {
		return !sender.isPlayer() || sender.asPlayer().isOp();
	}
}
