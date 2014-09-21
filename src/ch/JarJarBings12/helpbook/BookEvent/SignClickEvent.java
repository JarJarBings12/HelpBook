package ch.JarJarBings12.helpbook.BookEvent;

import org.bukkit.Material;
import org.bukkit.block.Sign;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;

import ch.JarJarBings12.helpbook.Core.Core;
import ch.JarJarBings12.helpbook.inventory.MainInventory;

public class SignClickEvent implements Listener{
	public SignClickEvent(Core inCore) {
		Core.inCore.getServer().getPluginManager().registerEvents(this, Core.inCore);
	}

	@EventHandler
	public void onSignClick(PlayerInteractEvent e) {
		Player pl = e.getPlayer();
		if(e.getClickedBlock().getState() instanceof Sign) {
			Sign s = (Sign)e.getClickedBlock().getState();
			if(s.getLine(1).equalsIgnoreCase("[HelpBook]")) {
				MainInventory.openMAINWindow(pl);
			}
		}
	}
}
