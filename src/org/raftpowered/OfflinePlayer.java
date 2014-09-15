package org.raftpowered;

import java.util.UUID;

import org.raftpowered.internal.Ops;

public class OfflinePlayer {
	private String name;
	private UUID uuid;
	
	public OfflinePlayer(String name) {
		this.name = name;
	}
	
	public OfflinePlayer(String name, UUID uuid) {
		this.name = name;
		this.uuid = uuid;
	}
	
	/**
	 * True if the player is an operator, false otherwise.
	 * @return Op
	 */
	public boolean isOp() {
		return Ops.contains(getName());
	}
	/**
	 * Enables or disables operator status.
	 * @param	op	Operator
	 */
	public void setOp(boolean op) {
		if(op) Ops.add(getName());
		else Ops.remove(getName());
	}
	/**
	 * Gets the player's username.
	 * @return	Name
	 * @see getUUID
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * This only works in certain places. Try not to use it!
	 * @return
	 */
	public UUID getUUID() {
		return uuid;
	}
}
