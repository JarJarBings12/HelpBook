package ch.JarJarBings12.helpbook.Windows.dynListener;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerKickEvent;

import ch.JarJarBings12.helpbook.Core.Core;
import ch.JarJarBings12.helpbook.Core.Core;
import ch.JarJarBings12.helpbook.Windows.dynWindowCore;

public class dynamicWindowUserKickEvent implements Listener {
	/**
	 * @author JarJarBings12
	 */
	public dynamicWindowUserKickEvent(Core core) {
		core.getServer().getPluginManager().registerEvents(this, core);
	}
	
	@EventHandler
	public void onPlayerKick(PlayerKickEvent e) {
		if(dynWindowCore.INHBSystem.containsKey(e.getPlayer())) {
			dynWindowCore.INHBSystem.remove(e.getPlayer());
			return;
		} else {
			return;
		}
	}

}
