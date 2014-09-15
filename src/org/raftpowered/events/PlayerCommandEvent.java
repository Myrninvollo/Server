package org.raftpowered.events;

import org.raftpowered.CommandSender;

public class PlayerCommandEvent extends CancellableEvent {
	private CommandSender sender;
	private String command;
	private String[] arguments;
	
	public PlayerCommandEvent(CommandSender sender, String command, String[] arguments) {
		this.sender = sender;
		this.command = command;
		this.arguments = arguments;
	}
	
	/**
	 * Player that sent the command.
	 * @return Player
	 */
	public CommandSender getSender() {
		return sender;
	}
	
	/**
	 * Command sent (all lower case, no slash.)
	 * @return Command
	 */
	public String getCommand() {
		return command;
	}
	
	/**
	 * Arguments sent after command.
	 * @return Arguments
	 */
	public String[] getArguments() {
		return arguments;
	}
}
