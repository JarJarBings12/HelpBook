package ch.JarJarBings12.helpbook.BookEvent;

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

import ch.JarJarBings12.helpbook.Core.Core;
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
			if(e.getInventory().getName().contains(BookFiles.yamlbooks.getString("HelpBook.Window.Name"))) {
				e.setCancelled(true);
				pl.updateInventory();
				ItemStack item = e.getCurrentItem();}
			}
		ItemStack item = e.getCurrentItem();
		if(e.getInventory().getName().contains("HelpBook.Window.Name")) {
			if(item.getType() == Material.WRITTEN_BOOK) {
				
				Player pl = (Player)e.getWhoClicked();
				BookMeta metadata = (BookMeta)item.getItemMeta();
				pl.getInventory().addItem(Core.inCore.getBookStorage().getBook(metadata.getTitle()));
				pl.updateInventory();
			}	
		}
	}	
}
