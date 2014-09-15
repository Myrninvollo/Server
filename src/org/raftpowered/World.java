package org.raftpowered;

import net.minecraft.block.Block;

public class World {
	/**
	 * Use this for anything we don't yet have in the API.
	 * Most things in it require a lot of knowledge on the Minecraft source code.
	 * Try and stay away; things in here may break with updates.
	 */
	public final net.minecraft.world.World NMS;
	
	public World(net.minecraft.world.World NMS) {
		this.NMS = NMS;
	}
	
	/**
	 * Gets the in-game time.
	 * @return Time
	 */
	public long getTime() {
		return NMS.getWorldTime();
	}
	/**
	 * Sets the in-game time.
	 * @param	time	0-23999
	 */
	public void setTime(long time) {
		NMS.setWorldTime(time);
	}
	/**
	 * Gets the world's folder name.
	 * @return World name
	 */
	public String getName() {
		return NMS.getWorldInfo().getWorldName();
	}
	/**
	 * True if raining, false if sunny.
	 * @return Raining
	 */
	public boolean isRaining() {
		return NMS.getWorldInfo().isRaining();
	}
	/**
	 * Sets the weather.
	 * @param	raining	Raining
	 */
	public void setRaining(boolean raining) {
		NMS.getWorldInfo().setRaining(raining);
	}
	/**
	 * Sets the block to the specified type.
	 * @param	x	Position X
	 * @param	y	Position Y
	 * @param	Z	Position Z
	 * @param	id	Block type
	 */
	public void setBlockId(int x, int y, int z, int id) {
		NMS.setBlock(x, y, z, Block.getBlockById(id));
	}
	/**
	 * Gets the block type.
	 * @param	x	Position X
	 * @param	y	Position Y
	 * @param	z	Position Z
	 * @return	Block type
	 */
	public int getBlockId(int x, int y, int z) {
		return Block.getIdFromBlock(NMS.getBlock(x, y, z));
	}
	/**
	 * True if a block can be placed here, false otherwise.
	 * @param	x	Position X
	 * @param	y	Position Y
	 * @param	z	Position Z
	 * @return	In bounds
	 * @see blockIsntAir()
	 */
	public boolean positionOutOfBounds(int x, int y, int z) {
		return !NMS.blockExists(x, y, z);
	}
	/**
	 * True if there is a block here, false otherwise.
	 * @param	x	Position X
	 * @param	y	Position Y
	 * @param	z	Position Z
	 * @return	Isn't air
	 * @see blockExists()
	 */
	public boolean blockExists(int x, int y, int z) {
		return !NMS.isAirBlock(x, y, z);
	}
	/**
	 * The dimension id. (Nether: 0, Overworld: 1, The End: 2)
	 * @return Id
	 */
	public int getDimensionId() {
		return NMS.provider.dimensionId + 1;
	}
}
