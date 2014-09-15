package org.raftpowered;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import net.minecraft.network.Packet;
import net.minecraft.network.play.server.S02PacketChat;
import net.minecraft.network.play.server.S29PacketSoundEffect;
import net.minecraft.network.play.server.S2BPacketChangeGameState;
import net.minecraft.util.ChatComponentTranslation;
import net.minecraft.util.DamageSource;

public class Player extends OfflinePlayer {
	/**
	 * Use this for anything we don't yet have in the API.
	 * Most things in it require a lot of knowledge on the Minecraft source code.
	 * Try and stay away; things in here may break with updates.
	 */
	public final net.minecraft.entity.player.EntityPlayerMP NMS;
	
	/**
	 * Gets player object via EntityPlayerMP.
	 * @param	NMS	EntityPlayerMP
	 */
	public Player(net.minecraft.entity.player.EntityPlayerMP NMS) {
		super(NMS.getCommandSenderName());
		this.NMS = NMS;
	}
	/**
	 * Gets the player's gamemode.
	 * @return GameMode
	 */
	public GameMode getGameMode() {
		return GameMode.get(NMS.theItemInWorldManager.getGameType().getID() + "");
	}
	/**
	 * Sets the player's gamemode.
	 * @param mode
	 */
	public void setGameMode(GameMode mode) {
		NMS.theItemInWorldManager.setGameType(mode.NMS);
		NMS.fallDistance = 0;
		sendPacket(new S2BPacketChangeGameState(3, mode.getId()));
	}
	/**
	 * Sends a packet. Use with caution!
	 * @param packet
	 */
	public void sendPacket(Packet packet) {
		NMS.playerNetServerHandler.sendPacket(packet);
	}
	/**
	 * Plays a sound effect.
	 * @param	name	Sound effect
	 * @param	x		Position X
	 * @param	y		Position Y
	 * @param	z		Position Z
	 * @param	volume	Volume of the sound
	 * @param	pitch	Pitch of the sound
	 */
	public void playSoundEffect(String name, double x, double y, double z, float volume, float pitch) {
		sendPacket(new S29PacketSoundEffect(name, x, y, z, volume, pitch));
	}
	/**
	 * Gets the player's Mojang ID. (Used for name changes.)
	 * @return UUID
	 * @see getName
	 */
	public UUID getUUID() {
		return NMS.getUniqueID();
	}
	/**
	 * Gets the player's world, position, and rotation.
	 * @return
	 */
	public Location getLocation() {
		return new Location(new World(NMS.worldObj), NMS.posX, NMS.posY, NMS.posZ, NMS.cameraPitch, NMS.cameraYaw);
	}
	/**
	 * Applies damage. (Will be replaced soon!)
	 * @param	source	Where the attack came from.
	 * @param	amount	How much damage to take.
	 */
	public void applyDamageTemp(DamageSource source, float amount) {
		NMS.attackEntityFrom(source, amount);
	}
	/**
	 * Kicks the player off of the server.
	 * @param	message	Message to display.
	 */
	public void kick(String message) {
		NMS.playerNetServerHandler.kickPlayerFromServer(message);
	}
	/**
	 * Sets the player's world, position, and rotation. (World untested!)
	 * @param	location	New location
	 */
	public void setLocation(Location location) {
		NMS.mountEntity(null);
		NMS.setWorld(location.getWorld().NMS);
		NMS.playerNetServerHandler.setPlayerLocation(location.getX(), location.getY(), location.getZ(), location.getPitch(), location.getYaw());
	}
	/**
	 * Gets the player's health.
	 * @return Health
	 */
	public float getHealth() {
		return NMS.getHealth();
	}
	/**
	 * Gets the player's food level.
	 * @return Food level
	 */
	public int getFood() {
		return NMS.getFoodStats().getFoodLevel();
	}
	/**
	 * Sets the player's food level.
	 * @param	food	0 to 20
	 */
	public void setFood(int food) {
		NMS.getFoodStats().addStats(food, 0);
	}
	/**
	 * Gets the player's saturation.
	 * @return Saturation
	 */
	public float getSaturation() {
		return NMS.getFoodStats().getSaturationLevel();
	}
	/**
	 * Adds to the player's saturation.
	 * @param	saturation	Amount to add
	 */
	public void addSaturation(float saturation) {
		NMS.getFoodStats().addStats(NMS.getFoodStats().getFoodLevel(), saturation);
	}
	/**
	 * True if the player is flying, false if they are walking.
	 * @return
	 */
	public boolean getFlying() {
		return NMS.capabilities.isFlying;
	}
	/**
	 * Enables or disables flymode.
	 * @param	flying	Fly mode
	 */
	public void setFlying(boolean flying) {
		NMS.capabilities.isFlying = flying;
	}
	/**
	 * True if the player can enable fly mode, false otherwise.
	 * @return Can fly
	 */
	public boolean getCanFly() {
		return NMS.capabilities.allowFlying;
	}
	/**
	 * Sets if the player can enable fly mode.
	 * @param canFly
	 */
	public void setCanFly(boolean canFly) {
		//if(!canFly) setFlying(false);
		NMS.capabilities.allowFlying = canFly;
	}
	/**
	 * Gets the player's ping in ms.
	 * @return Ping
	 */
	public int getPing() {
		return NMS.ping;
	}
	/**
	 * Gets the player's IP address.
	 * @return IP
	 */
	public String getIP() {
		return NMS.getPlayerIP();
	}
	/**
	 * Gets the amount of arrows in the player's body.
	 * @return Arrow count
	 */
	public int getArrowCount() {
		return NMS.getArrowCountInEntity();
	}
	/**
	 * Gets the Minecraft entity ID.
	 * @return Entity id
	 */
	public int getEntityId() {
		return NMS.getEntityId();
	}
	/**
	 * Sends a chat message to the player.
	 * @param	message	Message to send.
	 */
	public void sendMessage(String message) {
		sendPacket(new S02PacketChat(new ChatComponentTranslation(message)));
	}
	/**
	 * The level of the player.
	 * @return XP
	 */
	public int getXPLevel() {
		return NMS.experienceLevel;
	}
	/**
	 * The total amount of XP of the player.
	 * @return XP
	 */
	public int getXPTotal() {
		return NMS.experienceTotal;
	}
	/**
	 * The amount of XP in the player's XP bar.
	 * @return XP
	 */
	public float getXPInBar() {
		return NMS.experience;
	}
	/**
	 * The maximum XP the player's bar will hold. (Adds 10 each level.)
	 * @return XP
	 */
	public int getXPBarCap() {
		return NMS.xpBarCap();
	}
	/**
	 * Adds experience points. Levels and levelups are calculated automatically.
	 * @param xp
	 */
	public void addXPTotal(int xp) {
		NMS.addExperience(xp);
	}
	/**
	 * Adds experience levels. Does not change amount in XP bar.
	 * @param xp
	 */
	public void addXPLevel(int xp) {
		NMS.addExperienceLevel(xp);
	}
	/**
	 * Clear this player's inventory.
	 */
	public void clearInventory() {
		clearInventory(null, -1);
	}
	/**
	 * Clear this player's inventory of the specified item.
	 * @param item
	 */
	public void clearInventory(Item item) {
		clearInventory(item, -1);
	}
	/**
	 * Clear this player's inventory of the specified amount of the specified item.
	 * @param item
	 * @param amount
	 */
	public void clearInventory(Item item, int amount) {
		NMS.inventory.clearInventory(item == null ? null : item.NMS, amount);
		NMS.inventoryContainer.detectAndSendChanges();
	}
	/**
	 * Add the ItemStack to this player's inventory.
	 * @param	stack	Items to add
	 * @return	False if there was not enough room.
	 */
	public boolean addToInventory(ItemStack stack) {
		boolean success = NMS.inventory.addItemStackToInventory(stack.NMS);
		NMS.inventoryContainer.detectAndSendChanges();
		return success;
	}
	/**
	 * Player's inventory (36 stacks.) *INVENTORY SYSTEM INCOMPLETE*
	 * @return ItemStack array
	 */
	public ItemStack[] getInventory() {
		List<ItemStack> inventory = new ArrayList<ItemStack>();
		for(net.minecraft.item.ItemStack stack : NMS.inventory.mainInventory)
			inventory.add(new ItemStack(stack));
		return inventory.toArray(new ItemStack[inventory.size()]);
	}
	/**
	 * The currently held ItemStack. *INVENTORY SYSTEM INCOMPLETE*
	 * @return ItemStack
	 */
	public ItemStack getHeldItem() {
		return getInventory()[NMS.inventory.currentItem];
	}
}
