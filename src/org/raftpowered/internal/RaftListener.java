package org.raftpowered.internal;

import org.raftpowered.Raft;
import org.raftpowered.events.EventListener;
import org.raftpowered.events.PlayerLoginEvent;

public class RaftListener extends EventListener {
	public PlayerLoginEvent onPlayerLogin(PlayerLoginEvent event) {
		if(Bans.contains(event.getPlayer().getName())
				|| Bans.contains(event.getPlayer().getUUID().toString())
				|| Bans.contains(event.getAddress().toString())) {
			event.setCancelled(true);
			event.setReason("You have been banned from this server.");
		}
		else if(!event.getPlayer().isOp()
				&& Raft.getWhitelistEnabled()
				&& !Whitelist.contains(event.getPlayer().getName())) {
			event.setCancelled(true);
			event.setReason("You are not on the whitelist for this server.");
		}
		return event;
	}
}
