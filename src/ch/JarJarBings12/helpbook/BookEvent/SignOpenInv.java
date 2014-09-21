package ch.JarJarBings12.helpbook.BookEvent;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.Sign;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;

import ch.JarJarBings12.helpbook.Core.Core;

public class SignOpenInv implements Listener {
	public SignOpenInv(Core inCore) {
		Core.inCore.getServer().getPluginManager().registerEvents(this, Core.inCore);
	}

	@EventHandler
	public void onSignCreate(BlockPlaceEvent e) {
		Block block = e.getBlock();
		Player pl = e.getPlayer();
		
		if(block.getState() instanceof Sign) {
			Sign s = (Sign)e.getBlock().getState(); 
			if(s.getLine(1).equalsIgnoreCase("[HelpBook]")) {
				if(!(pl.hasPermission("helpbook.helpbook.admin.sign"))) {
					pl.sendMessage(Core.inCore.geti18n().getMessage("noperm"));
					e.getBlock().breakNaturally();
					return;
				} 
				s.setLine(1, ChatColor.translateAlternateColorCodes('&', "&6[HelpBook]"));
			}
		}
	}
}
