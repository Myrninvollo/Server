package org.raftpowered;

public class Location {
	private double x, y, z;
	private float pitch = 0, yaw = 0;
	private World world;
	
	public Location(World world, double posX, double posY, double posZ) {
		this.world = world;
		this.x = posX;
		this.y = posY;
		this.z = posZ;
	}
	
	public Location(World world, double posX, double posY, double posZ, float pitch, float yaw) {
		this.world = world;
		this.x = posX;
		this.y = posY;
		this.z = posZ;
		this.pitch = pitch;
		this.yaw = yaw;
	}
	
	public World getWorld() {
		return world;
	}
	public double getX() {
		return x;
	}
	public double getY() {
		return y;
	}
	public double getZ() {
		return z;
	}
	public int getBlockX() {
		return (int) x;
	}
	public int getBlockY() {
		return (int) y;
	}
	public int getBlockZ() {
		return (int) z;
	}
	public float getPitch() {
		return pitch;
	}
	public float getYaw() {
		return yaw;
	}
	public void setX(double x) {
		this.x = x;
	}
	public void setY(double y) {
		this.y = y;
	}
	public void setZ(double z) {
		this.z = z;
	}
	public void setPitch(float pitch) {
		this.pitch = pitch;
	}
	public void setYaw(float yaw) {
		this.yaw = yaw;
	}
}
