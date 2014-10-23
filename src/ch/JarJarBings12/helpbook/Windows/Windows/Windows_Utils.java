package ch.JarJarBings12.helpbook.Windows.Windows;

import java.io.IOException;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.BookMeta;
import org.bukkit.inventory.meta.ItemMeta;

import ch.JarJarBings12.helpbook.Windows.BuildWindows;
import ch.JarJarBings12.helpbook.Windows.dynFILELIST;
import ch.JarJarBings12.helpbook.util.util;

public class Windows_Utils {
	public static void startAutoSave() {
		if(dynFILELIST.co.getBoolean("options.autosave.enabled") == true) {
			int min = dynFILELIST.co.getInt("options.autosave.saveallXmin");
			long savetaskafter = min*60L;
			Windows_Save_Task.start_SaveTask(savetaskafter);
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
	public static void setSlotValue(String Window, int lines) {
		if(dynFILELIST.s.getInt("windows.window."+Window+".lines") < lines) {
			ItemStack d = new ItemStack(Material.AIR);
			int oldlines = dynFILELIST.s.getInt("windows.window."+Window+".lines");
			int newlines = lines*9;
			for (int i = oldlines; i < newlines; i++) {
				dynFILELIST.s.set("windows.window."+Window+".ObjList.object"+i+".TYPE", "BUTTON");
				dynFILELIST.s.set("windows.window."+Window+".ObjList.onject"+i+".DISPLAYNAME", d.getItemMeta().getDisplayName());
				dynFILELIST.s.set("windows.window."+Window+".ObjList.object"+i+".MATERIAL", d.getType().name());			
				dynFILELIST.s.set("windows.window."+Window+".ObjList.object"+i+".ACTION.TYPE", "NONE");
				dynFILELIST.s.set("windows.window."+Window+".ObjList.object"+i+".ACTION.USEPERMISSION", "NONE");
				dynFILELIST.s.set("windows.window."+Window+".ObjList.object"+i+".ACTION.MESSAGE", "NONE");
				runSave();
			}
		}
	}
	
	/**
	 * <h3>INFO</h3>
	 * @AUTHOR JarJarBings12
	 * @VERSION 1.0.0
	 * @DATE 12.10.14
	 * <h3>PROPERTIES</h3>
	 * @USAGE get the Slots of the Window
	 * @INPUT Name of the Window
	 * @OUTPUT Slots
	 */
	public static int getSlots(String Window) {
		return dynFILELIST.s.getInt("windows.window."+Window+".lines");
		
	}
	
	/**
	 * <h3>INFO</h3>
	 * @AUTHOR JarJarBings12
	 * @VERSION 1.0.0
	 * @DATE 12.10.14
	 * <h3>PROPERTIES</h3>
	 * @USAGE Set the Display name of a Window
	 * @INPUT Name of the Inventory
	 * @OUTPUT Display name 
	 */
	public static String getDisplayName(String Window) {
		return dynFILELIST.s.getString("windows.window."+Window+".displayname");
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
	public static void setDisplayName(String DisplayName, String Window) {
		dynFILELIST.s.set("windows.window."+Window+".displayname", DisplayName);
		runSave();
	}
	
	/**
	 * <h3>INFO</h3>
	 * @AUTHOR JarJarBings12
	 * @VERSION 1.0.0
	 * @DATE 12.10.14
	 * <h3>PROPERTIES</h3>
	 * @USAGE Reset Window
	 * @INPUT Window
	 * @OUTPUT None 
	 */
	public static void resetWindow(String window) {
		dynFILELIST.s.set("windows.window."+window, null);
		BuildWindows.BuildNewWindow(2, window);
		runSave();
	}
	
	public static void listWindows(Player pl) {
		
	}
	
	public static boolean getBooleanByString(String string) {
		if(string.equalsIgnoreCase("true")) {
			return true;
		} else if(string.equalsIgnoreCase("false")) {
			return false;
		} else {
			System.out.println(util.helpbook + "Can't get Boolean by String");
			return false;
		}
	}
	
	private static void runSave() {
		try {
			dynFILELIST.s.save(dynFILELIST.storage);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
