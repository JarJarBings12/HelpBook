package ch.JarJarBings12.helpbook.BookEvent;

import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerEditBookEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import ch.JarJarBings12.helpbook.Core.Core;
import ch.JarJarBings12.helpbook.util.ConfigLoader;

public class PlayerBookOpen implements Listener {
	public PlayerBookOpen(Core inCore) {
		inCore.getServer().getPluginManager().registerEvents(this, inCore);
	}ddd
	@EventHandler
	public void playerOpenBook(PlayerInteractEvent e) {
		Player pl = (Player) e.getPlayer();
		if(e.getAction() == e.getAction().RIGHT_CLICK_AIR || e.getAction() == e.getAction().RIGHT_CLICK_BLOCK) {
			if(pl.getItemInHand().getType() == Material.WRITTEN_BOOK) {
				pl.playSound(pl.getLocation(), Sound.HORSE_SADDLE, 1, 1);
			}
		}
	}
}
