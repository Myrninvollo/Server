package org.raftpowered;

public class Item {
	/**
	 * Use this for anything we don't yet have in the API.
	 * Most things in it require a lot of knowledge on the Minecraft source code.
	 * Try and stay away; things in here may break with updates.
	 */
	public final net.minecraft.item.Item NMS;
	
	public Item(net.minecraft.item.Item NMS) {
		this.NMS = NMS;
	}
	
	/**
	 * Gets this item's name.
	 * @return Name
	 * @see ItemStack.getDisplayName()
	 */
	public String getName() {
		return NMS.getUnlocalizedName();
	}
	
	/**
	 * Gets this item's id.
	 * @return Id
	 * @deprecated Mojang wants to use names, not ids.
	 */
	@Deprecated
	public int getId() {
		return net.minecraft.item.Item.getIdFromItem(NMS);
	}
	
	/**
	 * Finds an item by its name.
	 * @param name
	 * @return Item
	 * @see getById()
	 */
	public static Item getByName(String name) {
		return new Item((net.minecraft.item.Item) net.minecraft.item.Item.itemRegistry.getObject(name));
	}
	
	/**
	 * @param id
	 * @return Item
	 * @deprecated Mojang wants to use names, not ids.
	 */
	@Deprecated
	public static Item getById(int id) {
		return new Item(net.minecraft.item.Item.getItemById(id));
	}
}
