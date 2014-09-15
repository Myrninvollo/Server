package org.raftpowered;

public class ItemStack {
	/**
	 * Use this for anything we don't yet have in the API.
	 * Most things in it require a lot of knowledge on the Minecraft source code.
	 * Try and stay away; things in here may break with updates.
	 */
	public final net.minecraft.item.ItemStack NMS;
	
	public ItemStack(net.minecraft.item.ItemStack NMS) {
		this.NMS = NMS;
	}
	
	/**
	 * @param	item		Item
	 * @param	Quantity	Amount of item
	 * @param	Data		Item type
	 */
	public ItemStack(Item item, int Quantity, int Data) {
		NMS = new net.minecraft.item.ItemStack(item.NMS, Quantity, Data);
	}
	
	/**
	 * Gets the amount of items in this stack.
	 * @return Amount of items
	 */
	public int getQuantity() {
		return NMS.stackSize;
	}
	/**
	 * Sets the amount of items in this stack.
	 * @param	quantity	Amount of items
	 */
	public void setQuantity(int quantity) {
		NMS.stackSize = quantity;
	}
	/**
	 * Gets the display name. Null if unnamed.
	 * @return Display name
	 */
	public String getDisplayName() {
		return NMS.hasDisplayName() ? NMS.getDisplayName() : null;
	}
	/**
	 * Sets the display name.
	 * @param	name	New name
	 */
	public void setDisplayName(String name) {
		NMS.setStackDisplayName(name);
	}
	/**
	 * Gets the item in the stack.
	 * @return Item
	 */
	public Item getItem() {
		return new Item(NMS.getItem());
	}
	/**
	 * Adds enchantment at level.
	 * @param	type	Enchantment
	 * @param	level	Strength
	 */
	public void addEnchantment(Enchantment type, int level) {
		NMS.addEnchantment(type.NMS, level);
	}
	/**
	 * Sets how damaged the item is.
	 * @param damage
	 */
	public void setDamage(int damage) {
		NMS.setItemDamage(damage);
	}
	/**
	 * Gets how damaged the item is.
	 * @return
	 */
	public int getDamage() {
		return NMS.getItemDamage();
	}
	/**
	 * Gets how damaged this item can be before breaking.
	 * @return
	 */
	public int getMaxDamage() {
		return NMS.getMaxDamage();
	}
	/**
	 * Gets the maximum stack size.
	 * @return
	 */
	public int getMaxQuantity() {
		return NMS.getMaxStackSize();
	}
	/**
	 * Gets the repair cost for this item.
	 * @return
	 */
	public int getRepairCost() {
		return NMS.getRepairCost();
	}
	/**
	 * Sets the repair cost for this item.
	 * @param cost
	 */
	public void setRepairCost(int cost) {
		NMS.setRepairCost(cost);
	}
}
