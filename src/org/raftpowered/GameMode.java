package org.raftpowered;

import net.minecraft.world.WorldSettings.GameType;

public enum GameMode {
	SURVIVAL(0),
	CREATIVE(1),
	ADVENTURE(2);
	
	/**
	 * This is probably useless to you. FYI.
	 */
	public GameType NMS;
	GameMode(int id) {
		NMS = GameType.getByID(id);
	}
	
	public int getId() {
		return NMS.getID();
	}
	
	public String getName() {
		return NMS.getName();
	}
	
	public static GameMode get(String name) {
		if(name.equalsIgnoreCase("survival") || name.equalsIgnoreCase("0") || name.equalsIgnoreCase("s"))
			return SURVIVAL;
		else if(name.equalsIgnoreCase("creative") || name.equalsIgnoreCase("1") || name.equalsIgnoreCase("c"))
			return CREATIVE;
		else if(name.equalsIgnoreCase("adventure") || name.equalsIgnoreCase("2") || name.equalsIgnoreCase("a"))
			return ADVENTURE;
		else return null;
	}
}
