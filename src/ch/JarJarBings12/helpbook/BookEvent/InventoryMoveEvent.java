package ch.JarJarBings12.helpbook.BookEvent;

import java.time.DayOfWeek;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.DyeColor;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryInteractEvent;
import org.bukkit.event.inventory.InventoryMoveItemEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.BookMeta;
import org.bukkit.inventory.meta.ItemMeta;

import ch.JarJarBings12.helpbook.Core.Core;
import ch.JarJarBings12.helpbook.inventory.InfoWindow;
import ch.JarJarBings12.helpbook.util.BookFiles;
import ch.JarJarBings12.helpbook.util.ConfigLoader;

public class InventoryMoveEvent implements Listener {
	public InventoryMoveEvent(Core inCore) {
		inCore.getServer().getPluginManager().registerEvents(this, inCore);
	}
	@EventHandler
	public void onInvMove(InventoryClickEvent e) {
		if(e.getCurrentItem() == null) {
			return;
		}
		if(e.getSlot() == e.getRawSlot()) {
			Player pl = (Player) e.getWhoClicked();
			if(e.getInventory().getName().contains(ChatColor.translateAlternateColorCodes('&', ConfigLoader.WindowName))) {
				e.setCancelled(true);
				pl.updateInventory();
				ItemStack item = e.getCurrentItem();
				}
			}

//Main Inventory
		
		if(e.getInventory().getName().contains(ChatColor.translateAlternateColorCodes('&', ConfigLoader.WindowName))) {
			ItemStack item = e.getCurrentItem();
			if(item.getType() == Material.WRITTEN_BOOK) {
				Player pl = (Player)e.getWhoClicked();
				BookMeta metadata = (BookMeta)item.getItemMeta();
				if(pl.getInventory().contains(Core.inCore.getBookStorage().getBook(metadata.getTitle()))) {
					pl.sendMessage(Core.inCore.geti18n().getMessage("coontainsbook"));
					pl.playSound(pl.getLocation(), Sound.NOTE_PLING, 1, 1);
					pl.playSound(pl.getLocation(), Sound.ITEM_PICKUP, 1, 1);
					pl.playSound(pl.getLocation(), Sound.FIZZ, 1, 1);
					pl.playSound(pl.getLocation(), Sound.NOTE_BASS_DRUM, 1, 1);
				} else {
					pl.getInventory().addItem(Core.inCore.getBookStorage().getBook(metadata.getTitle()));
					pl.playSound(pl.getLocation(), Sound.ITEM_PICKUP, 1, 1);
					pl.sendMessage(Core.inCore.geti18n().getMessage("givebookmessage").replace("%buch", ChatColor.translateAlternateColorCodes('&', metadata.getTitle())));
			
				}
			} else {
			}
		}

//Plugin Inventory
		
		if(e.getSlot() == e.getRawSlot()) {
			Player pl = (Player) e.getWhoClicked();
			if(e.getInventory().getName().contains("§6Plugin Data")) {
				e.setCancelled(true);
				pl.updateInventory();
			}
		}
		if(e.getInventory().getName().equalsIgnoreCase("§6Plugin Data")) {
			ItemStack item = e.getCurrentItem();
			ItemMeta itemmeta = item.getItemMeta();
			if(item.getType() != Material.CARPET || item.getType() != Material.STAINED_GLASS_PANE) {
				e.setCancelled(true);
			}
			Player pl = (Player)e.getWhoClicked();
			if(item.getType() == Material.CARPET || item.getType() == Material.STAINED_GLASS_PANE) {
				if(itemmeta.getDisplayName().equalsIgnoreCase("§aVersion")) {
					pl.sendMessage("§aVersion: §f"+Core.inCore.getPluginDescription().getVersion());
					pl.sendMessage("Copyright © 2014 JarJarBings12");
				} else if (itemmeta.getDisplayName().equalsIgnoreCase("§2Author")) {
					pl.sendMessage("§2Author: §fJarJarBings12");
				} else if (itemmeta.getDisplayName().equalsIgnoreCase("§bHomepage")) {
					pl.sendMessage("§bHomepage: §fwww.unser-minecraft.de");
				} else if (itemmeta.getDisplayName().equalsIgnoreCase("§9Twitter")) {
					pl.sendMessage("§9Twitter:");
				} else if (itemmeta.getDisplayName().equalsIgnoreCase("§1Facebook")) {
					pl.sendMessage("§1Facebook:");
				} else if (itemmeta.getDisplayName().equalsIgnoreCase("§4Close")) {
					pl.closeInventory();
				} else if (itemmeta.getDisplayName().equalsIgnoreCase("§2Switch to FAQ")){
					pl.closeInventory();
					pl.chat("/helpbook");
				}
			}
		}
		
	}	
}
