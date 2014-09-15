package org.raftpowered;

public class CommandSender {
	private boolean isPlayer = false;
	private Player asPlayer;
	
	/**
	 * Send this player a message.
	 * @param message
	 */
	public void sendMessage(String message) {
		if(isPlayer) asPlayer.sendMessage(message);
		else Raft.logInfo(message);
	}
	
	public CommandSender(String name) {
		asPlayer = Raft.getPlayerExact(name);
		isPlayer = true;
	}
	
	public CommandSender() {}
	
	/**
	 * False if this player is a console/command block.
	 * @return
	 */
	public boolean isPlayer() {
		return isPlayer;
	}
	
	/**
	 * This player's name, or "Server"
	 * @return
	 */
	public String getName() {
		return isPlayer ? asPlayer.getName() : "Server";
	}
	
	/**
	 * Command sender as a Player object, if they are a player, or null.
	 * @return
	 */
	public Player asPlayer() {
		return asPlayer;
	}
}
