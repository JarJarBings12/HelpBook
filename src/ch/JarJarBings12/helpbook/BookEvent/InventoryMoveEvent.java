package ch.JarJarBings12.helpbook.BookEvent;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryInteractEvent;
import org.bukkit.event.inventory.InventoryMoveItemEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import ch.JarJarBings12.helpbook.Core.Core;

public class InventoryMoveEvent implements Listener {
	public InventoryMoveEvent(Core inCore) {
		inCore.getServer().getPluginManager().registerEvents(this, inCore);
	}
	
	@EventHandler
	public void onInvMove(InventoryClickEvent e) {
		if(e.getSlot() == e.getRawSlot()) {
			Player pl = (Player) e.getWhoClicked();
			if(e.getInventory().getName().contains("§aFAQ")) {
				e.setCancelled(true);
				pl.updateInventory();
				ItemStack item = e.getCurrentItem();}
			}
		}
	
}
