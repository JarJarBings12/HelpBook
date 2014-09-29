package ch.JarJarBings12.helpbook.BookEvent;

import java.util.List;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.Sign;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

import ch.JarJarBings12.helpbook.Core.Core;
import ch.JarJarBings12.helpbook.inventory.MainInventory;

public class SignPressEvent implements Listener {
	public SignPressEvent(Core inCore) {
		inCore.getServer().getPluginManager().registerEvents(this, inCore);
	}
	
	@EventHandler
	public void SignPress(PlayerInteractEvent e){
		Player pl = e.getPlayer();
		Action a = e.getAction();
		Block b = e.getClickedBlock();
		if(e.getAction() == a.RIGHT_CLICK_BLOCK) {
			if(b.getState() instanceof Sign) {
				Sign s = (Sign)b.getState();
				if(s.getLine(1).contains("[HelpBook]")) {
					if(!(pl.hasPermission("helpbook.helpbook.sign.use"))) {
						pl.sendMessage(Core.inCore.geti18n().getMessage("noperm"));
						return;
					}
					MainInventory.openMAINWindow(pl);
					return;
				}
			}
		}
	}
}
