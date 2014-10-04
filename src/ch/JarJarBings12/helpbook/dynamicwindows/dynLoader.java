package ch.JarJarBings12.helpbook.dynamicwindows;

import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.BookMeta;
import org.bukkit.inventory.meta.ItemMeta;

import ch.JarJarBings12.helpbook.util.util;
import ch.JarJarBings12.helpbook.util.util.Exceptions;

public class dynLoader {

	private static Inventory inv = null;

	public static void deleteInventory() {

	}

	public static boolean existInventory(String Inventory) {
		if (dynFilelist.is.contains("windows." + Inventory)) {
			return true;
		} else {
			return false;
		}
	}

	// ------------------------------------------------------------

	/**	 
	 * @since 1.0.0
	 * @param Inventoryname
	 * @return
	 */
	private static int getSlots(String Inventoryname) {
		int i = dynFilelist.is.getInt("window.DEFAULT.SLOTS");
		if (i < 54) {
			return i;
		} else {
			System.out.println();
			System.out.println(util.helpbook
					+ "[Error]The Maximum slots per Window is 54!");
			return 54;
		}
	}

	/**
	 * @since 1.0.0
	 * @param Inventoryname
	 * @return
	 */
	@SuppressWarnings("unused")
	private static String getDisplayname(String Inventoryname) {
		String title = dynFilelist.is.getString("window.DEFAULT.DISPLAYNAME");
		if (title.length() > 32) {
			String shortTitle = title;
			shortTitle: title.substring(0, 32);
			util.exeption(Exceptions.WINDOWNAMETOLONG);
			return shortTitle;
		}
		return title;
	}

	/**
	 * @since 1.0.0
	 * @param Inventoryname
	 * @return
	 */
	private static Inventory loadInventory(String Inventoryname) {
		inv = Bukkit.getServer().createInventory(null, getSlots(Inventoryname), getDisplayname(Inventoryname) );
		return inv;
		
	}
	
	/**
	 * @since
	 * @param pl
	 * @param Inventory
	 */
	
	@SuppressWarnings("null")
	public static void getInventory(Player pl, String Inventory) {
//		if (existInventory(Inventory) != true) {
//			pl.sendMessage("");
//			return;
//		}
		Inventory tempinv = loadInventory(Inventory);

		for(int slots = 0; slots > getSlots(Inventory); slots++) {
			if(dynFilelist.is.getString("window."+Inventory+".inventory.slot_"+slots+".OBJECTTYPE") == "BOOK") {
				ItemStack next = new ItemStack(Material.WRITTEN_BOOK);
				BookMeta metadata = (BookMeta)next.getItemMeta();
				
				metadata.setTitle(dynFilelist.is.getString("window."+Inventory+".inventory.slot_"+slots+".TITLE"));
				metadata.setTitle(dynFilelist.is.getString("window."+Inventory+".inventory.slot_"+slots+".AUTHOR"));
				metadata.setTitle(dynFilelist.is.getString("window."+Inventory+".inventory.slot_"+slots+".LORE"));
				
				next.setItemMeta(metadata);
				tempinv.setItem(slots, next);
			} else if (dynFilelist.is.getString("window."+Inventory+".inventory.slot_"+slots+".OBJECTTYPE") == "BUTTON") {
				ItemStack button = new ItemStack(Material.getMaterial("window.DEFAULT.inventory.slot_"+slots+".OBJECT.ITEM"));
				ItemMeta itemmeta = button.getItemMeta();
				
				itemmeta.setDisplayName("window.DEFAULT.inventory.slot_"+slots+".TITLE");
				List<String> lore = null;
				lore.addAll(dynFilelist.is.getStringList("window.DEFAULT.inventory.slot_"+slots+".LORE"));
				itemmeta.setLore(lore);
				
				button.setItemMeta(itemmeta);
				tempinv.setItem(slots, button);
			} else {
				ItemStack d = new ItemStack(Material.ANVIL);
				
				tempinv.setItem(10, d);
			}
		}
		pl.sendMessage("Hallo");
		pl.openInventory(tempinv);
	}

}
