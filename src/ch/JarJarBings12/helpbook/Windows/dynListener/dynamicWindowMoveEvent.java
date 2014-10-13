package ch.JarJarBings12.helpbook.Windows.dynListener;

import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

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
		if(!(dynWindowCore.INHBSystem.containsKey(e.getWhoClicked()))) {
			e.setCancelled(false);
			return;
		} else {
			if(e.getCurrentItem() == null) {
				return;
			}
			String nameofinventory = dynWindowCore.INHBSystem.get(e.getWhoClicked());
			int clickedslot = e.getRawSlot();
			
			String action = HBOS.getSlotAction(dynWindowCore.INHBSystem.get(e.getWhoClicked()), clickedslot);
		}
	}
}
