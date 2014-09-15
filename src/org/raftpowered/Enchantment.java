package org.raftpowered;

import net.minecraft.enchantment.*;

public enum Enchantment {
	PROTECTION(new EnchantmentProtection(0, 10, 0)),
	FIRE_PROTECTION(new EnchantmentProtection(1, 5, 1)),
	FEATHER_FALLING(new EnchantmentProtection(2, 5, 2)),
	BLAST_PROTECTION(new EnchantmentProtection(3, 2, 3)),
	PROJECTILE_PROTECTION(new EnchantmentProtection(4, 5, 4)),
	RESPIRATION(new EnchantmentOxygen(5, 2)),
	AQUA_AFFINITY(new EnchantmentWaterWorker(6, 2)),
	THORNS(new EnchantmentThorns(7, 1)),
	SHARPNESS(new EnchantmentDamage(16, 10, 0)),
	SMITE(new EnchantmentDamage(17, 5, 1)),
	BANE_OF_ARTHROPODS(new EnchantmentDamage(18, 5, 2)),
	KNOCKBACK(new EnchantmentKnockback(19, 5)),
	FIRE_ASPECT(new EnchantmentFireAspect(20, 2)),
	LOOTING(new EnchantmentLootBonus(21, 2, EnumEnchantmentType.weapon)),
	EFFICIENCY(new EnchantmentDigging(32, 10)),
	SILK_TOUCH(new EnchantmentUntouching(33, 1)),
	UNBREAKING(new EnchantmentDurability(34, 5)),
	FORTUNE(new EnchantmentLootBonus(35, 2, EnumEnchantmentType.digger)),
	POWER(new EnchantmentArrowDamage(48, 10)),
	PUNCH(new EnchantmentArrowKnockback(49, 2)),
	FLAME(new EnchantmentArrowFire(50, 2)),
	INFINITY(new EnchantmentArrowInfinite(51, 1)),
	LUCK_OF_THE_SEA(new EnchantmentLootBonus(61, 2, EnumEnchantmentType.fishing_rod)),
	LURE(new EnchantmentFishingSpeed(62, 2, EnumEnchantmentType.fishing_rod));
	
	/**
	 * Use this for anything we don't yet have in the API.
	 * Most things in it require a lot of knowledge on the Minecraft source code.
	 * Try and stay away; things in here may break with updates.
	 */
	public final net.minecraft.enchantment.Enchantment NMS;
	Enchantment(net.minecraft.enchantment.Enchantment NMS) {
		this.NMS = NMS;
	}
}
