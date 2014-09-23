package ch.JarJarBings12.helpbook.BookEvent;

import java.time.DayOfWeek;

import org.bukkit.ChatColor;
import org.bukkit.DyeColor;
import org.bukkit.Material;
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
import ch.JarJarBings12.helpbook.inventory.MSGWindow;
import ch.JarJarBings12.helpbook.util.BookFiles;
import ch.JarJarBings12.helpbook.util.ConfigLoader;

public class InventoryMoveEvent implements Listener {
	public InventoryMoveEvent(Core inCore) {
		inCore.getServer().getPluginManager().registerEvents(this, inCore);
	}
	
	@EventHandler
	public void onInvMove(InventoryClickEvent e) {
		if(e.getSlot() == e.getRawSlot()) {
			Player pl = (Player) e.getWhoClicked();
			if(e.getInventory().getName().contains(ChatColor.translateAlternateColorCodes('&', ConfigLoader.WindowName))) {
				e.setCancelled(true);
				pl.updateInventory();
				ItemStack item = e.getCurrentItem();
				}
			}
		
		ItemStack item = e.getCurrentItem();
		if(e.getInventory().getName().contains(ChatColor.translateAlternateColorCodes('&', ConfigLoader.WindowName))) {
			if(item.getType() == Material.WRITTEN_BOOK) {
				
				Player pl = (Player)e.getWhoClicked();
				BookMeta metadata = (BookMeta)item.getItemMeta();
				if(pl.getInventory().contains(Core.inCore.getBookStorage().getBook(metadata.getTitle()))) {
					pl.sendMessage(Core.inCore.geti18n().getMessage("coontainsbook"));
					return;
				}
				pl.getInventory().addItem(Core.inCore.getBookStorage().getBook(metadata.getTitle()));
				pl.updateInventory();
				pl.sendMessage(Core.inCore.geti18n().getMessage("givebookmessage").replace("%buch", ChatColor.translateAlternateColorCodes('&', metadata.getTitle())));
			}
		}

		if(e.getSlot() == e.getRawSlot()) {
			Player pl = (Player) e.getWhoClicked();
			if(e.getInventory().getName().contains("§6Plugin Data")) {
				e.setCancelled(true);
				pl.updateInventory();
			}
		}
		if(e.getInventory().getName().equalsIgnoreCase("§6Plugin Data")) {
			ItemMeta itemmeta = item.getItemMeta();
			if(item.getType() != Material.CARPET || item.getType() != Material.STAINED_GLASS_PANE) {
				e.setCancelled(true);
			}
			Player pl = (Player)e.getWhoClicked();
			if(item.getType() == Material.CARPET || item.getType() == Material.STAINED_GLASS_PANE) {
				if(itemmeta.getDisplayName().equalsIgnoreCase("§aVersion")) {
					pl.sendMessage("§aVersion: §f1.2.25");
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
		Player pl = (Player)e.getWhoClicked();
		if(MSGWindow.MSGWINDOWLIST.containsKey(pl)) {
			ItemStack gpane = new ItemStack(Material.STAINED_GLASS_PANE);
			ItemMeta metapane = (ItemMeta)item.getItemMeta();
			if(metapane.getDisplayName().contains("Yes")) {
				MSGWindow.msgyes(item, pl);
			} else if (metapane.getDisplayName().contains("No")) {
				MSGWindow.msgno(pl);
			} else if (metapane.getDisplayName().contains("Cancel")) {
				MSGWindow.msgcanccle(pl);
			}
			e.setCancelled(true);
		}
		
	}	
}
