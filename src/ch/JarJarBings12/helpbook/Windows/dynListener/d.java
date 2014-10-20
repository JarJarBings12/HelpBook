package ch.JarJarBings12.helpbook.Windows.dynListener;

import org.bukkit.Effect;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.craftbukkit.v1_7_R3.metadata.PlayerMetadataStore;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

import ch.JarJarBings12.helpbook.Core.Core;

public class d implements Listener {
	public d(Core inCore) {
		inCore.getServer().getPluginManager().registerEvents(this, inCore);
	}
	
	public static double high = 0.0;
	@EventHandler
	public void dd(PlayerMoveEvent e) {
		Player pl = (Player)e.getPlayer();
			double x;
			double y = pl.getLocation().getY();
			double z;
			
			

			for (double i = 0.0; i < 360; i += 1.0) {
				double angle = i * Math.PI / 180;
				x = (int) (pl.getLocation().getX()) + 5* Math.cos(angle);
//				y = (int) (pl.getLocation().getY()) + 5* Math.cosh(angle);
				z = (int) (pl.getLocation().getZ()) + 5* Math.sin(angle);
				Location l = new Location(pl.getWorld(), x, y+high, z);
				pl.getWorld().playEffect(l, Effect.SMOKE, 1);
			}
	}
}
