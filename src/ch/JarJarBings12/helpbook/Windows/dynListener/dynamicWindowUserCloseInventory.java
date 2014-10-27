package ch.JarJarBings12.helpbook.Windows.dynListener;

import org.bukkit.Effect;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.event.player.PlayerInventoryEvent;

import ch.JarJarBings12.helpbook.Core.Core;
import ch.JarJarBings12.helpbook.Windows.HBActions;
import ch.JarJarBings12.helpbook.Windows.dynConfig;
import ch.JarJarBings12.helpbook.Windows.dynWindowCore;

public class dynamicWindowUserCloseInventory implements Listener {
	/**
	 * @author JarJarBings12
	 */
	public dynamicWindowUserCloseInventory(Core core) {
		core.getServer().getPluginManager().registerEvents(this, core);
	}
	
	@EventHandler
	public void onPlayerCloseInventory(InventoryCloseEvent e) {
		if(dynWindowCore.INHBSystem.containsKey(e.getPlayer())) {
			dynWindowCore.INHBSystem.remove(e.getPlayer());
			Player pl = (Player)e.getPlayer();
			return;
		} else {
			return;
		}
	}
}
