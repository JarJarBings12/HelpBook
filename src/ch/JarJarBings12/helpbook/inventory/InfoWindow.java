package ch.JarJarBings12.helpbook.inventory;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.ChatColor;
import org.bukkit.DyeColor;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.PluginDescriptionFile;

import ch.JarJarBings12.helpbook.Core.Core;
import ch.JarJarBings12.helpbook.util.ConfigLoader;

public class InfoWindow {
	
	/**
	 * Info Winodw
	 * @author JarJarBings12
	 */
	
	private static Inventory inv = null;
	
	public static void openINFOWindow(Player player) {
		Player pl = player;
		
		inv = pl.getServer().createInventory(null,54 , "§6Plugin Data");
		
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
		List<String> vlore = new ArrayList<String>();
		vlore.add("§fBeta " + Core.inCore.getPluginDescription().getVersion());
		vlore.add("§fCopyright © 2014 JarJarBings12");
		vmeta.setLore(vlore);
		vmeta.setDisplayName("§aVersion");
		v.setItemMeta(vmeta);
		
		ItemStack a = new ItemStack(Material.CARPET, 1, DyeColor.GREEN.getData());
		ItemMeta ameta = a.getItemMeta();
		List<String> alore = new ArrayList<String>();
		alore.add("§fJarJarBings12");
		ameta.setLore(alore);
		ameta.setDisplayName("§2Author");
		a.setItemMeta(ameta);
		
		ItemStack h = new ItemStack(Material.CARPET, 1, DyeColor.LIGHT_BLUE.getData());
		ItemMeta hmeta = h.getItemMeta();
		List<String> hlore = new ArrayList<String>();
		hlore.add("§fwww.unser-minecraft.de");
		hmeta.setLore(hlore);
		hmeta.setDisplayName("§bHomepage");
		h.setItemMeta(hmeta);
		
		ItemStack t = new ItemStack(Material.CARPET, 1, DyeColor.MAGENTA.getData());
		ItemMeta tmeta = t.getItemMeta();
		List<String> tlore = new ArrayList<String>();
		tlore.add("§fnone");
		tmeta.setLore(tlore);
		tmeta.setDisplayName("§9Twitter");
		t.setItemMeta(tmeta);
		
		ItemStack f = new ItemStack(Material.CARPET, 1, DyeColor.BLUE.getData());
		ItemMeta fmeta = f.getItemMeta();
		List<String> flore = new ArrayList<String>();
		flore.add("§fnone");
		fmeta.setLore(flore);
		fmeta.setDisplayName("§8Facebook");
		
		f.setItemMeta(fmeta);
		ItemStack info = new ItemStack(Material.REDSTONE,1);
		ItemMeta infometa = info.getItemMeta();
		infometa.setDisplayName("§3Betateste §f"+Core.inCore.getPluginDescription().getVersion());
		List<String> lore = new ArrayList<String>();
		lore.add("§fCopyright © 2014 JarJarBings12");
		infometa.setLore(lore);
		info.setItemMeta(infometa);
		
		inv.setItem(0, info);
		inv.setItem(7, switchd);
		inv.setItem(9, v);
		inv.setItem(11, a);
		inv.setItem(13, h);
		inv.setItem(15, t);
		inv.setItem(17, f);
		inv.setItem(8, close);
		
		pl.playSound(pl.getLocation(), Sound.HORSE_ARMOR, 1, 1);
		pl.openInventory(inv);
	}
}
