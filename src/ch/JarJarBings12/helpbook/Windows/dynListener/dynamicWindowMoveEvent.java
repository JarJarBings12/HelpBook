package ch.JarJarBings12.helpbook.Windows.dynListener;

import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryInteractEvent;

import ch.JarJarBings12.helpbook.Core.Core;
import ch.JarJarBings12.helpbook.Windows.HBOS;
import ch.JarJarBings12.helpbook.Windows.dynConfig;
import ch.JarJarBings12.helpbook.Windows.dynFILELIST;
import ch.JarJarBings12.helpbook.Windows.dynWindowCore;

public class dynamicWindowMoveEvent implements Listener {
	public dynamicWindowMoveEvent(Core inCore) {
		inCore.getServer().getPluginManager().registerEvents(this, inCore);
	}
	@EventHandler
	public void onInvMove(InventoryClickEvent e) {
		if(e.getCurrentItem() == null) {
			return;
		}
		if(dynWindowCore.INHBSystem.containsKey(e.getWhoClicked())) {
			e.setCancelled(true);
		}
	}
}
