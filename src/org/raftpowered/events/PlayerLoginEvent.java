package org.raftpowered.events;

import java.net.SocketAddress;

import org.raftpowered.OfflinePlayer;

public class PlayerLoginEvent extends CancellableEvent {
	private SocketAddress address;
	private OfflinePlayer player;
	private String reason = "Failed to join server.";
	
	public PlayerLoginEvent(SocketAddress address, OfflinePlayer player) {
		this.address = address;
		this.player = player;
	}
	
	/**
	 * The player's IP.
	 * @return
	 */
	public SocketAddress getAddress() {
		return address;
	}
	
	/**
	 * The player who is joining.
	 * @return
	 */
	public OfflinePlayer getPlayer() {
		return player;
	}
	
	/**
	 * Get the reason for the kick.
	 * @return
	 */
	public String getReason() {
		return reason;
	}
	
	/**
	 * Set the reason for the kick.
	 * (Default if cancelled: "Failed to join server.")
	 * @param reason
	 */
	public void setReason(String reason) {
		this.reason = reason;
	}
}
