package ch.JarJarBings12.helpbook.Windows;

import java.io.IOException;

import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

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
		if(dynFILELIST.s.getInt("windows.window."+inv+".lines") < lines)
		dynFILELIST.s.set("windows.window."+inv+".lines", lines);
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
