package org.raftpowered;

import net.minecraft.server.MinecraftServer;
import net.minecraft.server.dedicated.PropertyManager;

public class Properties {
	protected static PropertyManager properties;
	
	/**
	 * Server port.
	 * @return
	 */
	public static int getPort() {
		return properties.getIntProperty("server-port", 25565);
	}
	/**
	 * Active upon next reboot.
	 * @param port
	 */
	public static void setPort(int port) {
		properties.setProperty("server-port", port);
	}
	/**
	 * Server IP.
	 * @return
	 */
	public static String getIP() {
		return properties.getStringProperty("server-ip", "");
	}
	/**
	 * Active upon next reboot.
	 * @param ip
	 */
	public static void setIP(String ip) {
		properties.setProperty("server-ip", ip);
	}
	/**
	 * Online mode.
	 * @return
	 */
	public static boolean isOnlineMode() {
		return properties.getBooleanProperty("online-mode", true);
	}
	/**
	 * Active upon next reboot.
	 * @param online
	 */
	public static void setOnlineMode(boolean online) {
		properties.setProperty("online-mode", online);
	}
	/**
	 * Spawn animals.
	 * @return
	 */
	public static boolean getSpawnAnimals() {
		return properties.getBooleanProperty("spawn-animals", true);
	}
	/**
	 * Active upon next reboot.
	 * @param animals
	 */
	public static void setSpawnAnimals(boolean animals) {
		properties.setProperty("spawn-animals", animals);
	}
	/**
	 * Spawn NPCs.
	 * @return
	 */
	public static boolean getSpawnNPCs() {
		return properties.getBooleanProperty("spawn-npcs", true);
	}
	/**
	 * Active upon next reboot.
	 * @param npcs
	 */
	public static void setSpawnNPCs(boolean npcs) {
		properties.setProperty("spawn-npcs", npcs);
	}
	/**
	 * Allow PvP.
	 * @return
	 */
	public static boolean getAllowPvP() {
		return properties.getBooleanProperty("pvp", true);
	}
	/**
	 * Active upon next reboot.
	 * @param pvp
	 */
	public static void setAllowPvP(boolean pvp) {
		properties.setProperty("pvp", pvp);
	}
	/**
	 * Allow flight.
	 * @return
	 */
	public static boolean getAllowFlight() {
		return properties.getBooleanProperty("allow-flight", true);
	}
	/**
	 * Active upon next reboot.
	 * @param flight
	 */
	public static void setAllowFlight(boolean flight) {
		properties.setProperty("allow-flight", flight);
	}
	/**
	 * Server resource pack.
	 * @return
	 */
	public static String getResourcePack() {
		return properties.getStringProperty("resource-pack", "");
	}
	/**
	 * Active upon next reboot.
	 * @param pack
	 */
	public static void setResourcePack(String pack) {
		properties.setProperty("resource-pack", pack);
	}
	/**
	 * Message of the day.
	 * @return
	 */
	public static String getMOTD() {
		return properties.getStringProperty("resource-pack", "");
	}
	/**
	 * Active upon next reboot.
	 * @param motd
	 */
	public static void setMOTD(String motd) {
		properties.setProperty("motd", motd);
	}
	/**
	 * Default GameMode.
	 * @return
	 */
	public static GameMode getDefaultGameMode() {
		return GameMode.get(properties.getIntProperty("gamemode", GameMode.SURVIVAL.getId()) + "");
	}
	/**
	 * Active upon next reboot.
	 * @param mode
	 */
	public static void setDefaultGameMode(GameMode mode) {
		properties.setProperty("gamemode", mode.getId());
	}
	/**
	 * Force default GameMode.
	 * @return
	 */
	public static boolean getForceGameMode() {
		return properties.getBooleanProperty("force-gamemode", false);
	}
	/**
	 * Active upon next reboot.
	 * @param force
	 */
	public static void setForceGameMode(boolean force) {
		properties.setProperty("force-gamemode", force);
	}
	/**
	 * Idle timeout (Disabled: 0)
	 * @return
	 */
	public static int getPlayerIdleTimeout() {
		return properties.getIntProperty("player-idle-timeout", 0);
	}
	/**
	 * Active upon next reboot.
	 * @param idle
	 */
	public static void setPlayerIdleTimeout(int idle) {
		properties.setProperty("player-idle-timeout", idle);
	}
	/**
	 * Difficulty (Peaceful: 0, Easy: 1, Normal: 2, Hard: 3)
	 * @return
	 */
	public static int getDifficulty() {
		return properties.getIntProperty("difficulty", 1);
	}
	/**
	 * Active upon next reboot.
	 * @param difficulty
	 */
	public static void setDifficulty(int difficulty) {
		properties.setProperty("difficulty", difficulty);
	}
	/**
	 * Generate structures.
	 * @return
	 */
	public static boolean getGenerateStructures() {
		return properties.getBooleanProperty("generate-structures", true);
	}
	/**
	 * Active upon next reboot.
	 * @param generate
	 */
	public static void setGenerateStructures(boolean generate) {
		properties.setProperty("generate-structures", generate);
	}
	/**
	 * Hardcore mode.
	 * @return
	 */
	public static boolean getHardcore() {
		return properties.getBooleanProperty("hardcore", false);
	}
	/**
	 * Active upon reboot.
	 * @param hardcore
	 */
	public static void setHardcore(boolean hardcore) {
		properties.setProperty("hardcore", hardcore);
	}
	/**
	 * Snooper enabled.
	 * @return
	 */
	public static boolean getSnooperEnabled() {
		return properties.getBooleanProperty("snooper-enabled", true);
	}
	/**
	 * Active upon next reboot.
	 * @param snooper
	 */
	public static void setSnooperEnabled(boolean snooper) {
		properties.setProperty("snooper-enabled", snooper);
	}
	/**
	 * Allow nether.
	 * @return
	 */
	public static boolean getAllowNether() {
		return properties.getBooleanProperty("allow-nether", true);
	}
	/**
	 * Active upon next reboot.
	 * @param nether
	 */
	public static void setAllowNether(boolean nether) {
		properties.setProperty("allow-nether", nether);
	}
	/**
	 * Spawn monsters.
	 * @return
	 */
	public static boolean getSpawnMonsters() {
		return properties.getBooleanProperty("spawn-monsters", true);
	}
	/**
	 * Active upon next reboot.
	 * @param monsters
	 */
	public static void setSpawnMonsters(boolean monsters) {
		properties.setProperty("spawn-monsters", monsters);
	}
	/**
	 * Enable remote control.
	 * @return
	 */
	public static boolean getEnableRCON() {
		return properties.getBooleanProperty("enable-rcon", false);
	}
	/**
	 * Active upon next reboot.
	 * @param rcon
	 */
	public static void setEnableRCON(boolean rcon) {
		properties.setProperty("hardcore", rcon);
	}
	/**
	 * Enable queries.
	 * @return
	 */
	public static boolean getEnableQuery() {
		return properties.getBooleanProperty("enable-query", false);
	}
	/**
	 * Active upon next reboot.
	 * @param query
	 */
	public static void setEnableQuery(boolean query) {
		properties.setProperty("enable-query", query);
	}
	/**
	 * Maximum build height.
	 * @return
	 */
	public static int getMaxBuildHeight() {
		return properties.getIntProperty("max-build-height", 256);
	}
	/**
	 * Active upon next reboot.
	 * @param height
	 */
	public static void setMaxBuildHeight(int height) {
		properties.setProperty("max-build-height", height);
	}
	/**
	 * Seed for level generator.
	 * @return
	 */
	public static String getLevelSeed() {
		return properties.getStringProperty("level-seed", "");
	}
	/**
	 * Active upon next reboot.
	 * @param seed
	 */
	public static void setLevelSeed(String seed) {
		properties.setProperty("level-seed", seed);
	}
	/**
	 * Type of level.
	 * @return
	 */
	public static String getLevelType() {
		return properties.getStringProperty("level-type", "DEFAULT");
	}
	/**
	 * Active upon next reboot.
	 * @param type
	 */
	public static void setLevelType(String type) {
		properties.setProperty("level-type", type);
	}
	/**
	 * Settings for level generator.
	 * @return
	 */
	public static String getGeneratorSettings() {
		return properties.getStringProperty("generator-settings", "");
	}
	/**
	 * Active upon next reboot.
	 * @param settings
	 */
	public static void setGeneratorSettings(String settings) {
		properties.setProperty("generator-settings", settings);
	}
	/**
	 * Whitelist enabled.
	 * @return
	 */
	public static boolean getWhitelistEnabled() {
		return MinecraftServer.getServer().getConfigurationManager().isWhiteListEnabled()
				|| properties.getBooleanProperty("white-list", false);
	}
	/**
	 * Active immediately.
	 * @param whitelist
	 */
	public static void setWhitelistEnabled(boolean whitelist) {
		MinecraftServer.getServer().getConfigurationManager().setWhiteListEnabled(whitelist);
		properties.setProperty("white-list", whitelist);
	}
}
