package ch.JarJarBings12.helpbook.Windows.dynListener;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.event.player.PlayerInventoryEvent;

import ch.JarJarBings12.helpbook.Core.Core;
import ch.JarJarBings12.helpbook.Windows.dynConfig;
import ch.JarJarBings12.helpbook.Windows.dynWindowCore;

public class dynamicWindowUserCloseInventory implements Listener {
	public dynamicWindowUserCloseInventory(Core inCore) {
		inCore.getServer().getPluginManager().registerEvents(this, inCore);
	}
	
	@EventHandler
	public void onPlayerCloseInventory(InventoryCloseEvent e) {
		if(dynWindowCore.INHBSystem.containsKey(e.getPlayer())) {
			dynWindowCore.INHBSystem.remove(e.getPlayer());
		}
	}
}