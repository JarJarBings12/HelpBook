package ch.JarJarBings12.helpbook.Commands;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import ch.JarJarBings12.helpbook.Core.Core;
import ch.JarJarBings12.helpbook.inventory.MainInventory;
import ch.JarJarBings12.helpbook.inventory.MainInventory.inventorylist;
import ch.JarJarBings12.helpbook.util.BookStorage;
import ch.JarJarBings12.helpbook.util.ConfigLoader;

public class HelpBook implements CommandExecutor {
	public HelpBook(Core inCore) {
		Core.inCore = inCore;
	}

	public boolean onCommand(CommandSender sender, Command cmd, String label, String[]  args) {
		if(!cmd.getName().equalsIgnoreCase("HelpBook")) return true;
		if(!(sender instanceof Player)) {
			
		}
		Player pl = (Player)sender;
		if(!(pl.hasPermission("helpbook.helpbook"))) {
			
		}
		
		if(args.length == 0) {
			MainInventory.openInventory(pl, inventorylist.main);
			pl.sendMessage(Core.inCore.geti18n().getMessage("openhelpbook"));
		}
		
		if(args.length == 2) {
			if(args[0].equalsIgnoreCase("admin")) {
				if(!(pl.hasPermission(""))) {
					
				}
				
				if(args[1].equalsIgnoreCase("setTitle")) {
					pl.sendMessage(Core.inCore.geti18n().getMessage("titleargument"));
				} else if(args[1].equalsIgnoreCase("setAuthor")) {
					pl.sendMessage(Core.inCore.geti18n().getMessage("authorargument"));
				} else if(args[1].equalsIgnoreCase("setBookAtSlot")) {
					pl.sendMessage(Core.inCore.geti18n().getMessage("tohighnummber"));
				} else if(args[1].equalsIgnoreCase("turnmode")) {
					Bukkit.broadcastMessage("Test");
					pl.sendMessage(Core.inCore.geti18n().getMessage("pleassaybook"));
				} else {
					pl.sendMessage(Core.inCore.geti18n().getMessage("unkowncommand"));
				}
			}
		}
		
		if(args.length == 3) {
			if(args[0].equalsIgnoreCase("admin")) {
				if(!(pl.hasPermission("helpbook.helpbook.admin"))) {
					
				}
				
				if(args[1].equalsIgnoreCase("setTitle")) {
					if(pl.getItemInHand().getType() == Material.WRITTEN_BOOK) {
						Core.inCore.getBookStorage().setTitle(pl.getItemInHand(), args[2]);	
						pl.sendMessage(Core.inCore.geti18n().getMessage("titleset"));
						return true;
					} else {
						pl.sendMessage(Core.inCore.geti18n().getMessage("nobook"));
						return true;
					}
					
				} else if(args[1].equalsIgnoreCase("setAuthor")) {
					if(pl.getItemInHand().getType() == Material.WRITTEN_BOOK) {
						Core.inCore.getBookStorage().setAuthor(pl.getItemInHand(), args[2]);
						pl.sendMessage(Core.inCore.geti18n().getMessage("authorset"));		
						return true;
					} else {
						pl.sendMessage(Core.inCore.geti18n().getMessage("nobook"));		
						return true;
					}
				} else if(args[1].equalsIgnoreCase("setBookAtSlot")) {
					if(pl.getItemInHand().getType() == Material.WRITTEN_BOOK) {
						int i = Integer.parseInt(args[2]);
						Core.inCore.getBookStorage().addBook(i, pl.getItemInHand(), pl);
						return true;
					} else {
						pl.sendMessage(Core.inCore.geti18n().getMessage("nobook"));
						return true;
					}
//				} else if(args[1].equalsIgnoreCase("turnmode")) {
//					
//					int i = Integer.parseInt(args[2]);
//					if(i > 9 || i < 0) {
//						pl.sendMessage(Core.inCore.geti18n().getMessage("tohighnummber"));
//					}
//					Core.inCore.getBookStorage().setTURNMODUS(i);
//					if(ConfigLoader.getBookBool(i) == true) {
//						pl.sendMessage(Core.inCore.geti18n().getMessage("bookchange").replace("%status", "auf§a an§f "));
//					} else {
//						pl.sendMessage(Core.inCore.geti18n().getMessage("bookchange").replace("%status", "auf§4 aus§f "));
//					}
				
				} else {
					
				}
			}
		}
		if(args.length == 4) {
			if(args[0].equalsIgnoreCase("admin")) {
				if(args[1].equalsIgnoreCase("turnmode")) {
					
					
					int slot = Integer.parseInt(args[2]);
					
					
					if(slot > 9 || slot < 0) {
						pl.sendMessage(Core.inCore.geti18n().getMessage("tohighnummber"));
					}

					if(args[3].equalsIgnoreCase("on") || args[3].equalsIgnoreCase("enable") || args[3].equalsIgnoreCase("ture")) {
						
						ConfigLoader.setBookBool(slot, true);
						pl.sendMessage(Core.inCore.geti18n().getMessage("bookchange").replace("%status", "auf§b an §f"));
						
					} else if(args[3].equalsIgnoreCase("off") || args[3].equalsIgnoreCase("disable") || args[3].equalsIgnoreCase("false")) {
						
						ConfigLoader.setBookBool(slot, false);
						
						pl.sendMessage(Core.inCore.geti18n().getMessage("bookchange").replace("%status", "auf§4 aus §f"));
						
					} else {
						
						pl.sendMessage(Core.inCore.geti18n().getMessage("useonoffelse"));
					}
				}
			}
		}
		
		
		
		return true;
	}
}
