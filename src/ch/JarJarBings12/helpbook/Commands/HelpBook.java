package ch.JarJarBings12.helpbook.Commands;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import ch.JarJarBings12.helpbook.Core.Core;
import ch.JarJarBings12.helpbook.inventory.InfoWindow;
import ch.JarJarBings12.helpbook.inventory.MainInventory;
import ch.JarJarBings12.helpbook.inventory.MainInventory.inventorylist;
import ch.JarJarBings12.helpbook.util.BookStorage;
import ch.JarJarBings12.helpbook.util.ConfigLoader;

public class HelpBook implements CommandExecutor {
	public HelpBook(Core inCore) {
		Core.inCore = inCore;
	}
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (!cmd.getName().equalsIgnoreCase("HelpBook")) return true;
		if (!(sender instanceof Player)) {
			return true;
		}
		Player pl = (Player) sender;
		if (!(pl.hasPermission("helpbook.helpbook"))) {
			pl.sendMessage(Core.inCore.geti18n().getMessage("noperm"));
			return true;
		}

		if (args.length == 0) {
			MainInventory.openMAINWindow(pl);
			pl.sendMessage(Core.inCore.geti18n().getMessage("openhelpbook"));
			return true;
		}
		
		if(args.length == 1) {
			if(!(pl.hasPermission("helpbook.helpbook.info"))) {
				pl.sendMessage(Core.inCore.geti18n().getMessage("noperm"));
				return true;
			}
			if(args[0].equalsIgnoreCase("info")) {
				InfoWindow.openINFOWindow(pl);
				return true;
			}			
			
		}
		/**
		 * How to use section
		 * If a User tipped /helpbook admin setBookAtSlot this Section say the User how he must use the Command alsow:
		 * ./helpbook admin setBookAtSlot <slot> 
		 * 
		 */
		if (args.length == 2) {
			if (args[0].equalsIgnoreCase("admin")) {
				if (!(pl.hasPermission("helpbook.helpbook.admin"))) {
					pl.sendMessage(Core.inCore.geti18n().getMessage("noperm"));
					return true;
				}

				if (args[1].equalsIgnoreCase("setTitle")) {
					pl.sendMessage(Core.inCore.geti18n().getMessage("titleargument"));
					return true;
				} else if (args[1].equalsIgnoreCase("setAuthor")) {
					pl.sendMessage(Core.inCore.geti18n().getMessage("authorargument"));
					return true;
				} else if (args[1].equalsIgnoreCase("setBookAtSlot")) {
					pl.sendMessage(Core.inCore.geti18n().getMessage("tohighnummber"));
					return true;
				} else if (args[1].equalsIgnoreCase("turnmode")) {
					pl.sendMessage(Core.inCore.geti18n().getMessage("pleassaybook"));
					return true;
				} else if (args[1].equalsIgnoreCase("setWindowName")) {
					pl.sendMessage(Core.inCore.geti18n().getMessage("pleassetaname"));
					return true;
				} else if (args[1].equalsIgnoreCase("getRawBook")) {
					if(pl.getItemInHand().getType() == Material.WRITTEN_BOOK) {
						pl.getInventory().addItem(Core.inCore.getBookStorage().editBook(pl.getItemInHand()));
						pl.sendMessage(Core.inCore.geti18n().getMessage("getrawbook"));
						return true;
					} else {
						pl.sendMessage(Core.inCore.geti18n().getMessage("pleaswritebook"));
						return true;
					}
				}else {
					pl.sendMessage(Core.inCore.geti18n().getMessage("unkowncommand"));
					return true;
				}
			}
		}

		/**
		 * Main Command Section for 3 arguments 
		 * in this Section all Commands registered they have three arguments.
		 * You can say that a User can use Only /helpbook admin setTitle or one of the other Commands.
		 */
		
		if (args.length == 3) {
			if (!(pl.hasPermission("helpbook.helpbook.admin"))) {
				pl.sendMessage(Core.inCore.geti18n().getMessage("noperm"));
				return true;
			}
			if (args[0].equalsIgnoreCase("admin")) {

				if (args[1].equalsIgnoreCase("setTitle")) {
					if (pl.getItemInHand().getType() == Material.WRITTEN_BOOK) {
						Core.inCore.getBookStorage().setTitle(pl.getItemInHand(), args[2]);
						pl.sendMessage(Core.inCore.geti18n().getMessage("titleset"));
						return true;
					} else {
						pl.sendMessage(Core.inCore.geti18n().getMessage("nobook"));
						return true;
					}

				} else if (args[1].equalsIgnoreCase("setAuthor")) {
					if (pl.getItemInHand().getType() == Material.WRITTEN_BOOK) {
						Core.inCore.getBookStorage().setAuthor(pl.getItemInHand(), args[2]);
						pl.sendMessage(Core.inCore.geti18n().getMessage("authorset"));
						return true;
					} else {
						pl.sendMessage(Core.inCore.geti18n().getMessage("nobook"));
						return true;
					}
				} else if (args[1].equalsIgnoreCase("setBookAtSlot")) {
					if (pl.getItemInHand().getType() == Material.WRITTEN_BOOK) {
						int i = Integer.parseInt(args[2]);
						Core.inCore.getBookStorage().addBook(i,pl.getItemInHand(), pl);
						return true;
					} else {
						pl.sendMessage(Core.inCore.geti18n().getMessage("nobook"));
						return true;
					}
				} else if (args[1].equalsIgnoreCase("setWindowName")) {
					if(args[2].length() > 32) {
						pl.sendMessage(Core.inCore.geti18n().getMessage("windownametolong"));
						return true;
					}
						ConfigLoader.setWindowName(args[2].toString());
						pl.sendMessage(Core.inCore.geti18n().getMessage("windownameset").replace("%name", ConfigLoader.WindowName));
						return true;
				} else {	
					
				}
			}
		}
		/*
		 * Main Command Section for fore arguments
		 */
		if (args.length == 4) {
			if (args[0].equalsIgnoreCase("admin")) {
				if (args[1].equalsIgnoreCase("turnmode")) {
					int slot = Integer.parseInt(args[2]);

					if (slot > 9 || slot < 0) {
						pl.sendMessage(Core.inCore.geti18n().getMessage("tohighnummber"));
						return true;
					}

					if (args[3].equalsIgnoreCase("on") || args[3].equalsIgnoreCase("enable") || args[3].equalsIgnoreCase("ture")) {
						
						ConfigLoader.setBookBool(slot, true);
						pl.sendMessage(Core.inCore.geti18n().getMessage("bookchange").replace("%status", "auf§a an§f"));
						return true;
					} else if (args[3].equalsIgnoreCase("off") || args[3].equalsIgnoreCase("disable") || args[3].equalsIgnoreCase("false")) {
						ConfigLoader.setBookBool(slot, false);
						pl.sendMessage(Core.inCore.geti18n().getMessage("bookchange").replace("%status", "auf§c aus§f"));
						return true;
					} else {
						pl.sendMessage(Core.inCore.geti18n().getMessage("useonoffelse"));
						pl.sendMessage("         §6on,§f off,§6 enable,§f disable,§6 ture,§f false");
						return true;
					}
				}
			}
		}
		return true;
	}
}
