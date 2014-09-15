package org.raftpowered;

public abstract class Plugin {
	public void onEnable() {}
	public void onDisable() {}
	public abstract String getName();
	public abstract String getVersion();
	public abstract String getDescription();
}
