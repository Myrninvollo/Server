package org.raftpowered.commands;

import org.raftpowered.ChatColor;
import org.raftpowered.Command;
import org.raftpowered.CommandSender;
import org.raftpowered.Player;
import org.raftpowered.Raft;

public class PlaySound extends Command {
	public String getName() {
		return "playsound";
	}
	public void process(CommandSender sender, String[] args) {
		if(op(sender)) {
			Player player = null;
			double x = 0, y = 0, z = 0;
			float volume = 1, pitch = 1;
			String sound = "";
			
			if(sender.isPlayer()) {
				if(args.length == 1) {
					sound = args[0];
					player = sender.asPlayer();
					x = player.getLocation().getX();
					y = player.getLocation().getY();
					z = player.getLocation().getZ();
				}
				
				else if(args.length == 4) {
					if(isNumeric(args[1]) && isNumeric(args[2]) && isNumeric(args[3])) {
						sound = args[0];
						player = sender.asPlayer();
						x = Double.parseDouble(args[1]);
						y = Double.parseDouble(args[2]);
						z = Double.parseDouble(args[3]);
					}
					else {
						sender.sendMessage(ChatColor.RED + "Usage: " + getUsage());
					}
				}
				else if(args.length == 6) {
					if(isNumeric(args[1]) && isNumeric(args[2]) && isNumeric(args[3])) {
						if(isNumeric(args[4]) && isNumeric(args[5])) {
							sound = args[0];
							player = sender.asPlayer();
							x = Double.parseDouble(args[1]);
							y = Double.parseDouble(args[2]);
							z = Double.parseDouble(args[3]);
							volume = Float.parseFloat(args[4]);
							pitch = Float.parseFloat(args[5]);
						}
						else {
							sender.sendMessage(ChatColor.RED + "Usage: " + getUsage());
						}
					}
					else {
						sender.sendMessage(ChatColor.RED + "Usage: " + getUsage());
					}
				}
				else if(args.length == 2) {
					sound = args[0];
					player = Raft.getPlayer(args[1]);
					if(player != null) {
						x = player.getLocation().getX();
						y = player.getLocation().getY();
						z = player.getLocation().getZ();
					}
					else {
						sender.sendMessage("Couldn't find player!");
					}
				}
				else if(args.length == 5) {
					if(isNumeric(args[2]) && isNumeric(args[3]) && isNumeric(args[4])) {
						sound = args[0];
						player = Raft.getPlayer(args[1]);
						if(player != null) {
							x = player.getLocation().getX();
							y = player.getLocation().getY();
							z = player.getLocation().getZ();
						}
						else {
							sender.sendMessage(ChatColor.RED + "Usage: " + getUsage());
						}
						x = Double.parseDouble(args[2]);
						y = Double.parseDouble(args[3]);
						z = Double.parseDouble(args[4]);
					}
					else {
						sender.sendMessage(ChatColor.RED + "Usage: " + getUsage());
					}
				}
				else if(args.length == 7) {
					if(isNumeric(args[2]) && isNumeric(args[3]) && isNumeric(args[4])) {
						if(isNumeric(args[5]) && isNumeric(args[6])) {
							sound = args[0];
							player = Raft.getPlayer(args[1]);
							if(player != null) {
								x = player.getLocation().getX();
								y = player.getLocation().getY();
								z = player.getLocation().getZ();
							}
							else {
								sender.sendMessage("Couldn't find player!");
							}
							x = Double.parseDouble(args[1]);
							y = Double.parseDouble(args[2]);
							z = Double.parseDouble(args[3]);
							volume = Float.parseFloat(args[4]);
							pitch = Float.parseFloat(args[5]);
						}
						else {
							sender.sendMessage(ChatColor.RED + "Usage: " + getUsage());
						}
					}
					else {
						sender.sendMessage(ChatColor.RED + "Usage: " + getUsage());
					}
				}
				else {
					sender.sendMessage(ChatColor.RED + "Usage: " + getUsage());
				}
			}
			else {
				if(args.length == 2) {
					sound = args[0];
					player = Raft.getPlayer(args[1]);
					if(player != null) {
						x = player.getLocation().getX();
						y = player.getLocation().getY();
						z = player.getLocation().getZ();
					}
					else {
						sender.sendMessage("Couldn't find player!");
					}
				}
				else if(args.length == 5) {
					if(isNumeric(args[2]) && isNumeric(args[3]) && isNumeric(args[4])) {
						sound = args[0];
						player = Raft.getPlayer(args[1]);
						if(player != null) {
							x = player.getLocation().getX();
							y = player.getLocation().getY();
							z = player.getLocation().getZ();
						}
						else {
							sender.sendMessage(ChatColor.RED + "Usage: " + getUsage());
						}
						x = Double.parseDouble(args[2]);
						y = Double.parseDouble(args[3]);
						z = Double.parseDouble(args[4]);
					}
					else {
						sender.sendMessage(ChatColor.RED + "Usage: " + getUsage());
					}
				}
				else if(args.length == 7) {
					if(isNumeric(args[2]) && isNumeric(args[3]) && isNumeric(args[4])) {
						if(isNumeric(args[5]) && isNumeric(args[6])) {
							sound = args[0];
							player = Raft.getPlayer(args[1]);
							if(player != null) {
								x = player.getLocation().getX();
								y = player.getLocation().getY();
								z = player.getLocation().getZ();
							}
							else {
								sender.sendMessage("Couldn't find player!");
							}
							x = Double.parseDouble(args[1]);
							y = Double.parseDouble(args[2]);
							z = Double.parseDouble(args[3]);
							volume = Float.parseFloat(args[4]);
							pitch = Float.parseFloat(args[5]);
						}
						else {
							sender.sendMessage(ChatColor.RED + "Usage: " + getUsage());
						}
					}
					else {
						sender.sendMessage(ChatColor.RED + "Usage: " + getUsage());
					}
				}
			}
			
			if(player != null) player.playSoundEffect(sound, x, y, z, volume, pitch);
		}
		else {
			sender.sendMessage(ChatColor.RED + "You must be OP to use this command.");
		}
	}
	private boolean isNumeric(String number) {
		try {
			Double.parseDouble(number);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}
	public String getUsage() {
		return "/playsound <sound> [player] [x y z] [volume pitch]";
	}
	public String getDescription() {
		return "Plays a sound.";
	}
}
