package org.raftpowered;

import java.util.UUID;

import org.raftpowered.internal.Bans;
import org.raftpowered.internal.Ops;
import org.raftpowered.internal.Whitelist;

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
	 * True if the player is banned, false otherwise.
	 * @return Banned
	 */
	public boolean isBanned() {
		return Bans.contains(getName());
	}
	/**
	 * Enables or disables ban.
	 * @param	banned	Banned
	 */
	public void setBanned(boolean banned) {
		if(banned) Bans.add(getName());
		else Bans.remove(getName());
	}
	/**
	 * True if the player is whitelisted, false otherwise.
	 * @return Whitelisted
	 * @see Raft.getWhitelistEnabled()
	 */
	public boolean isWhitelisted() {
		return Whitelist.contains(getName());
	}
	/**
	 * Enables or disables whitelisting.
	 * @param	whitelisted	Whitelisted
	 */
	public void setWhitelisted(boolean whitelisted) {
		if(whitelisted) Whitelist.add(getName());
		else Whitelist.remove(getName());
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
