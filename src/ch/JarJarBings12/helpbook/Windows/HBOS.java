package ch.JarJarBings12.helpbook.Windows;

import java.io.IOException;

import org.bukkit.Material;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.BookMeta;
import org.bukkit.inventory.meta.ItemMeta;

public class HBOS {
	
	private static void save() {
		try {
			dynFILELIST.s.save(dynFILELIST.storage);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	/**
	 * <h3>INFO</h3>
	 * @AUTHOR JarJarBings12
	 * @VERSION 1.0.0
	 * @DATE 12.10.14
	 * <h3>PROPERTIES</h3>
	 * @USAGE Set a Slots of a Window
	 * @INPUT Integer and Inventory
	 * @OUTPUT None
	 */
	public static void setSlotValue(String inv, int lines) {
		if(dynFILELIST.s.getInt("windows.window."+inv+".lines") < lines) {
			int oldlines = dynFILELIST.s.getInt("windows.window."+inv+".lines");
			int newlines = lines*9;
			for (int i = oldlines; i < newlines; i++) {
				dynFILELIST.s.set("windows.window."+inv+".ObjList.object"+i, "");
				save();
			}
			System.out.println("@HelpBook.:@");
		}
	}
	
	/**
	 * <h3>INFO</h3>
	 * @AUTHOR JarJarBings12
	 * @VERSION 1.0.0
	 * @DATE 12.10.14
	 * <h3>PROPERTIES</h3>
	 * @USAGE Set the Display name of a Window
	 * @INPUT Display name and Inventory
	 * @OUTPUT None 
	 */
	public static void setDisplayName(String name, String inv) {
		dynFILELIST.s.set("windows.window."+inv+".displayname", name);
		save();
	}
	
	/**
	 * <h3>INFO</h3>
	 * @AUTHOR JarJarBings12
	 * @VERSION 1.0.0
	 * @DATE 12.10.14
	 * <h3>PROPERTIES</h3>
	 * @USAGE Set a Item stack at a Slot
	 * @INPUT Inventory, Slot and ItemStack
	 * @OUTPUT None 
	 */
	public static void setAsSlot(String inv, int slot, ItemStack item) {
		int maxslot = dynFILELIST.s.getInt("windows.window."+inv+".lines")*9;
		if(item.getType() == Material.WRITTEN_BOOK) {
			BookMeta meta = (BookMeta)item.getItemMeta();
			dynFILELIST.s.set("windows.window."+inv+".ObjList.object"+slot+".TYPE", "BOOK");
			dynFILELIST.s.set("windows.window."+inv+".ObjList.object"+slot+".TITLE", meta.getTitle());
			dynFILELIST.s.set("windows.window."+inv+".ObjList.object"+slot+".AUTHOR", meta.getAuthor());
			dynFILELIST.s.set("windows.window."+inv+".ObjList.object"+slot+".PAGES", meta.getPages());
			dynFILELIST.s.set("windows.window."+inv+".ObjList.object"+slot+".LORE", meta.getLore());
		} else {
			ItemMeta meta = (ItemMeta)item.getItemMeta();
			dynFILELIST.s.set("windows.window."+inv+".ObjList.object"+slot+".TYPE", "ITEM");
			dynFILELIST.s.set("windows.window."+inv+".ObjList.object"+slot+".MATERIAL", item.getType().name());
			dynFILELIST.s.set("windows.window."+inv+".ObjList.object"+slot+".DISPLAYNAME", meta.getDisplayName());
			dynFILELIST.s.set("windows.window."+inv+".ObjList.object"+slot+".ENCHANTMENTS", meta.getEnchants());
			dynFILELIST.s.set("windows.window."+inv+".ObjList.object"+slot+".LORE", meta.getLore());
		}
	}
	
	/**
	 * <h3>INFO</h3>
	 * @AUTHOR JarJarBings12
	 * @VERSION 1.0.0
	 * @DATE 12.10.14
	 * <h3>PROPERTIES</h3>
	 * @USAGE Do Inv exist
	 * @INPUT Inventory
	 * @OUTPUT boolean 
	 */
	public static boolean existInventory(String inv) {
		if(dynFILELIST.s.getString("windows.window."+inv) != null) {
			return true;
		} else {
			return false;
		}
		
	}
	
}
