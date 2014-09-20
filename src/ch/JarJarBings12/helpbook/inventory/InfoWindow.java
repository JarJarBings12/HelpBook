package ch.JarJarBings12.helpbook.inventory;

import org.bukkit.ChatColor;
import org.bukkit.DyeColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import ch.JarJarBings12.helpbook.util.ConfigLoader;

public class InfoWindow {
	private static Inventory inv = null;
	
	public static void openINFOWindow(Player player) {
		Player pl = player;
		
		inv = pl.getServer().createInventory(null, 18, "§6Plugin Data");
		
		ItemStack close = new ItemStack(Material.STAINED_GLASS_PANE, 1, DyeColor.RED.getData());
		ItemMeta closemeta = close.getItemMeta();
		closemeta.setDisplayName("§4Close");
		close.setItemMeta(closemeta);
		
		ItemStack switchd = new ItemStack(Material.STAINED_GLASS_PANE, 1, DyeColor.GREEN.getData());
		ItemMeta switchmeta = switchd.getItemMeta();
		switchmeta.setDisplayName("§2Switch to FAQ");
		switchd.setItemMeta(switchmeta);
		
		ItemStack v = new ItemStack(Material.CARPET, 1, DyeColor.LIME.getData());
		ItemMeta vmeta = v.getItemMeta();
		vmeta.setDisplayName("§aVersion");
		v.setItemMeta(vmeta);
		ItemStack a = new ItemStack(Material.CARPET, 1, DyeColor.GREEN.getData());
		ItemMeta ameta = a.getItemMeta();
		ameta.setDisplayName("§2Author");
		a.setItemMeta(ameta);
		ItemStack h = new ItemStack(Material.CARPET, 1, DyeColor.LIGHT_BLUE.getData());
		ItemMeta hmeta = h.getItemMeta();
		hmeta.setDisplayName("§bHomepage");
		h.setItemMeta(hmeta);
		ItemStack t = new ItemStack(Material.CARPET, 1, DyeColor.MAGENTA.getData());
		ItemMeta tmeta = t.getItemMeta();
		tmeta.setDisplayName("§9Twitter");
		t.setItemMeta(tmeta);
		ItemStack f = new ItemStack(Material.CARPET, 1, DyeColor.BLUE.getData());
		ItemMeta fmeta = f.getItemMeta();
		fmeta.setDisplayName("§1Facebook");
		f.setItemMeta(fmeta);
		
		inv.setItem(7, switchd);
		inv.setItem(9, v);
		inv.setItem(11, a);
		inv.setItem(13, h);
		inv.setItem(15, t);
		inv.setItem(17, f);
		inv.setItem(8, close);
		
		
		pl.openInventory(inv);
	}
}
