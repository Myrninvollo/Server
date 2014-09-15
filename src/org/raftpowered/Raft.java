package org.raftpowered;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.raftpowered.commands.*;
import org.raftpowered.events.EventListener;
import org.raftpowered.internal.*;
import org.raftpowered.internal.Whitelist;

import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.dedicated.PropertyManager;
import net.minecraft.world.WorldServer;

/**
 * Raft API. xmysterymanx.iloveyou(from.rtainc);
 * @author rtainc
 * @author hintss
 * @author crushh87
 * @author hotkeys
 */
public class Raft extends Properties {
	private static String serverVersion = "1.7.10", APIVersion = "a4";
	private static int protocolVersion = 5;
	private static List<Command> commands = new ArrayList<Command>();
	private static List<EventListener> listeners = new ArrayList<EventListener>();
	
	/**
	 * *Used internally. You won't need this.*
	 */
	public static void onEnable() {
		properties = new PropertyManager(new File("server.properties"));
		Ops.init();
		Bans.init();
		Whitelist.init();
		addCommand(new Help());
		addCommand(new Whois());
		addCommand(new Stop());
		addCommand(new Teleport());
		addCommand(new Kill());
		addCommand(new Feed());
		addCommand(new Kick());
		addCommand(new Op());
		addCommand(new Deop());
		addCommand(new Time());
		addCommand(new PlaySound());
		addCommand(new Ban());
		addCommand(new Unban());
		addCommand(new Plugins());
		//addCommand(new Reload());
		addCommand(new Clear());
		addCommand(new org.raftpowered.commands.Whitelist());
		addCommand(new org.raftpowered.commands.GameMode());
		addListener(new RaftListener());
	}
	/**
	 * *Used internally. You won't need this.*
	 */
	public static void onDisable() {
		for(Plugin plugin : PluginManager.plugins) {
			logInfo("Disabling " + plugin.getName() + " (" + plugin.getVersion() + ")...");
			plugin.onDisable();
		}
	}
	/**
	 * Reloads all plugins, and their commands/listeners.
	 */
	public static void reloadPlugins() {
		for(Plugin plugin : PluginManager.plugins) {
			logInfo("Disabling " + plugin.getName() + " (" + plugin.getVersion() + ")...");
			plugin.onDisable();
		}
		PluginManager.plugins.clear();
		listeners.clear();
		commands.clear();
		PluginManager.init();
	}
	/**
	 * Gets the maximum amount of players this server will hold.
	 * @return
	 */
	public static int getMaxPlayerCount() {
		return MinecraftServer.getServer().getConfigurationManager().getMaxPlayers();
	}
	/**
	 * Gets all commands. Useful for data, debugging, or a help command.
	 * @return
	 */
	public static Command[] getCommands() {
		return commands.toArray(new Command[commands.size()]);
	}
	/**
	 * Gets all listeners. Useful for data, or debugging.
	 * @return
	 */
	public static EventListener[] getListeners() {
		return listeners.toArray(new EventListener[listeners.size()]);
	}
	/**
	 * Gets the plugin closest to the name.
	 * @param name
	 * @return
	 */
	public static Plugin getPlugin(String name) {
		for(Plugin plugin : PluginManager.plugins)
			if(plugin.getName().toLowerCase().startsWith(name.toLowerCase()))
				return plugin;
		return null;
	}
	/**
	 * Gets the plugin by its name.
	 * @param name
	 * @return
	 */
	public static Plugin getPluginExact(String name) {
		for(Plugin plugin : PluginManager.plugins)
			if(plugin.getName().equalsIgnoreCase(name))
				return plugin;
		return null;
	}
	/**
	 * Registers a listener. Make a class that extends 'EventListener,'
	 * and then put in the listeners you need.
	 * @param event
	 */
	public static void addListener(EventListener event) {
		listeners.add(event);
	}
	/**
	 * Registers a command. Make a class that extends 'Command,' 
	 * and then put it here during onEnable() of plugin's main class.
	 * @param command
	 */
	public static void addCommand(Command command) {
		commands.add(command);
	}
	/**
	 * Saves and stops the server.
	 */
	public static void stopServer() {
		MinecraftServer.getServer().initiateShutdown();
	}
	/**
	 * @return Raft API version
	 * @see getServerVersion, getProtocolVersion
	 */
	public static String getAPIVersion() {
		return APIVersion;
	}
	/**
	 * @return Minecraft server version
	 * @see getAPIVersion, getProtocolVersion
	 */
	public static String getServerVersion() {
		return serverVersion;
	}
	/**
	 * @return Minecraft protocol version
	 * @see getServerVersion, getAPIVersion
	 */
	public static int getProtocolVersion() {
		return protocolVersion;
	}
	
	/**
	 * Adds message to console and log file.
	 * @param message
	 * @see logWarning, logError
	 */
	public static void logInfo(String message) {
		MinecraftServer.getServer().logInfo(message);
	}
	
	/**
	 * Adds message to console and log file.
	 * @param message
	 * @see logInfo, logError
	 */
	public static void logWarning(String message) {
		MinecraftServer.getServer().logWarning(message);
	}
	
	/**
	 * Adds message to console and log file.
	 * @param message
	 * @see logInfo, logWarning
	 */
	public static void logError(String message) {
		MinecraftServer.getServer().logSevere(message);
	}
	
	/**
	 * Gets a player by the beginning of its name.
	 * @param name
	 * @return Player
	 */
	public static Player getPlayer(String name) {
		for(EntityPlayerMP entity : MinecraftServer.getServer().getConfigurationManager().playerEntityList)
			if(entity.getCommandSenderName().toLowerCase().startsWith(name.toLowerCase()))
				return new Player(entity);
		return null;
	}
	
	/**
	 * Gets a player by its name.
	 * @param name
	 * @return Player
	 */
	public static Player getPlayerExact(String name) {
		for(EntityPlayerMP entity : MinecraftServer.getServer().getConfigurationManager().playerEntityList)
			if(entity.getCommandSenderName().equalsIgnoreCase(name))
				return new Player(entity);
		return null;
	}
	
	/**
	 * Gets all players on the server.
	 * @return Player array
	 */
	public static Player[] getOnlinePlayers() {
		List<Player> players = new ArrayList<Player>();
		for(EntityPlayerMP entity : MinecraftServer.getServer().getConfigurationManager().playerEntityList)
			players.add(new Player(entity));
		return players.toArray(new Player[players.size()]);
	}
	
	/**
	 * Gets an offline player by its name. (Used for opping/banning/whitelisting.)
	 * @param name
	 * @return OfflinePlayer
	 */
	public static OfflinePlayer getOfflinePlayer(String name) {
		return new OfflinePlayer(name);
	}
	
	/**
	 * Sends a message to all players, console, and log file.
	 * @param message
	 */
	public static void broadcastMessage(String message) {
		logInfo(message);
		for(Player player : getOnlinePlayers())
			player.sendMessage(message);
	}
	
	/**
	 * Gets the amount of players online.
	 * @return Player count
	 */
	public static int getOnlinePlayerCount() {
		return MinecraftServer.getServer().getConfigurationManager().getCurrentPlayerCount();
	}
	
	/**
	 * Gets a world by its name.
	 * @param name
	 * @return World
	 */
	public static World getWorld(String name) {
		for(WorldServer world : MinecraftServer.getServer().worldServers)
			if(world.getWorldInfo().getWorldName().equalsIgnoreCase(name))
				return new World(world);
		return null;
	}
}
