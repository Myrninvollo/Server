package org.raftpowered.events;

public class CancellableEvent {
	private boolean cancelled = false;
	
	public boolean getCancelled() {
		return cancelled;
	}
	
	public void setCancelled(boolean cancelled) {
		this.cancelled = cancelled;
	}
}
