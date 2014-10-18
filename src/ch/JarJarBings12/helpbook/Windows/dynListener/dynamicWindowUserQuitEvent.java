package ch.JarJarBings12.helpbook.Windows.dynListener;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

import ch.JarJarBings12.helpbook.Core.Core;
import ch.JarJarBings12.helpbook.Windows.dynWindowCore;

public class dynamicWindowUserQuitEvent implements Listener {
	/**
	 * @author JarJarBings12
	 */
	public dynamicWindowUserQuitEvent(Core inCore) {
		inCore.getServer().getPluginManager().registerEvents(this, inCore);
	}
	
	@EventHandler
	public void onPlayerLeave(PlayerQuitEvent e) {
		if(dynWindowCore.INHBSystem.containsKey(e.getPlayer())) {
			dynWindowCore.INHBSystem.remove(e.getPlayer());
			return;
		} else {
			return;
		}  
	}
	

}
