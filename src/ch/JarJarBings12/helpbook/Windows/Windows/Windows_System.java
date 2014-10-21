package ch.JarJarBings12.helpbook.Windows.Windows;

import java.io.IOException;
import java.util.List;

import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.BookMeta;
import org.bukkit.inventory.meta.ItemMeta;

import ch.JarJarBings12.helpbook.Windows.dynFILELIST;
import ch.JarJarBings12.helpbook.Windows.dynWindowCore;

public class Windows_System {
	/**
	 * @author JarJarBings12
	 * @since 21.10.1014
	 */
	
	/**
	 * Enable / Disable a Window
	 * <h3>INFO</h3>
	 * @AUTHOR JarJarBings12
	 * @VERSION 1.0.0
	 * @USAGE Use to disable a Window
	 * @INPUT Window name and Player (Object)
	 * @OUTPUT None
	 */
	public static void renderWindow(String inv, Player pl) {
		int x = getSlots(inv)*9;
		Inventory tempinv = pl.getServer().createInventory(null, x, getDisplayName(inv));
		for (int i = 0; i < x; i++) {
			Material m = Material.getMaterial(dynFILELIST.s.getString("windows.window."+inv+".ObjList.object"+i+".MATERIAL"));
			if(m == Material.WRITTEN_BOOK) {
				ItemStack item = new ItemStack(m);
				BookMeta  meta = (BookMeta)item.getItemMeta();
				meta.setAuthor("windows.window."+inv+".ObjList.object"+i+".AUTHOR");
				meta.setTitle("windows.window."+inv+".ObjList.object"+i+".TITLE");
				List<String> lore = dynFILELIST.s.getStringList("windows.window."+inv+".ObjList.object"+i+".LORE");
				meta.setLore(lore);
				item.setItemMeta(meta);
				tempinv.setItem(i, item);
			} else if (m == Material.AIR) {
				ItemStack item = new ItemStack(Material.AIR);
				tempinv.setItem(i, item);
			} else if (m != Material.WRITTEN_BOOK){
				try {
					ItemStack item = new ItemStack(Material.getMaterial(m.name()));
					ItemMeta  meta = (ItemMeta)item.getItemMeta();
					List<String> lore = dynFILELIST.s.getStringList("windows.window."+inv+".ObjList.object"+i+".LORE");
					String dn = dynFILELIST.s.getString("windows.window."+inv+".ObjList.object"+i+".DISPLAYNAME");
						meta.setDisplayName(dn);
					System.out.println(m.name());
					meta.setLore(lore);
					item.setItemMeta(meta);
					tempinv.setItem(i, item);
				} catch (NullPointerException e) {
					
				}
				
			} else {
				System.out.println("@HelpBook.:@WindowRender.:@ErrorCast@"+inv+".ObjList.Object"+i);
				System.out.println("@HelpBook.:@WindowRender.:@INFO.:Pleas Fix the Error for Debug Tippe /helpbook @SlotReport_<SLOT>");
			}
			if((dynFILELIST.s.getBoolean("windows.window."+inv+".windowopensound")) != false ) {
				pl.playSound(pl.getLocation(), Sound.HORSE_ARMOR, 1, 1);
			}
			pl.openInventory(tempinv);
		} 
		System.out.println("@HelpBook.:@WindowRender@Player_"+pl.getName());
		dynWindowCore.INHBSystem.put(pl, inv);
	}
	
	/**
	 * Enable / Disable a Window
	 * <h3>INFO</h3>
	 * @AUTHOR JarJarBings12
	 * @VERSION 1.0.0
	 * @USAGE Use to Create a Window
	 * @INPUT lines and Window name
	 * @OUTPUT None
	 */
	public static void createNewWindow(int lines, String name) {
		dynFILELIST.s.set("windows.window."+name+".displayname", name);
		dynFILELIST.s.set("windows.window."+name+".enabled", true);
		dynFILELIST.s.set("windows.window."+name+".windowopensound", true);
		dynFILELIST.s.set("windows.window."+name+".lines", lines);
		dynFILELIST.s.set("windows.window."+name+".permission", "none");
		
		int x = lines*9;
		ItemStack d = new ItemStack(Material.AIR);
		for(int i = 0; i < x; i++) {
			dynFILELIST.s.set("windows.window."+name+".ObjList.object"+i+".DISPLAYNAME", "DEFAULT" );
			dynFILELIST.s.set("windows.window."+name+".ObjList.object"+i+".MATERIAL", d.getType().name());	
			dynFILELIST.s.set("windows.window."+name+".ObjList.object"+i+".TYPE", "BUTTON");		
			dynFILELIST.s.set("windows.window."+name+".ObjList.object"+i+".LORE", "");	
			dynFILELIST.s.set("windows.window."+name+".ObjList.object"+i+".ACTION.TYPE", "NONE");
			dynFILELIST.s.set("windows.window."+name+".ObjList.object"+i+".ACTION.USEPERMISSION", "NONE");
			dynFILELIST.s.set("windows.window."+name+".ObjList.object"+i+".ACTION.MESSAGE", "NONE");
		}
		registerWindow(name);
		runSave();
	}
	
	
	
	
/*/Window Until Method's/*/
	
/*/Public void/*/
	
	
	/**
	 * Enable / Disable a Window
	 * <h3>INFO</h3>
	 * @AUTHOR JarJarBings12
	 * @VERSION 1.0.0
	 * @USAGE Use to disable a Window
	 * @INPUT Window in String form and Boolean
	 * @OUTPUT None
	 */
	public static void disableWindow(String name, boolean enabled) {
		dynWindowCore.WINDOWS.put(name, enabled);
		dynFILELIST.s.set("windows.window."+name+".enabled", enabled);
		runSave();
	}
	
	
	/**
	 * Enable / Disable a Window
	 * <h3>INFO</h3>
	 * @AUTHOR JarJarBings12
	 * @VERSION 1.0.0
	 * @USAGE Use to Remove a Window
	 * @INPUT Window in String Form
	 * @OUTPUT None
	 */
	public static void removeWindow(String name) {
		dynFILELIST.s.set("windows.window."+name, null);
		unregisterWindow(name);
		runSave();
	}
	

/*/Private void /*/
	
	
	/**
	 * Enable / Disable a Window
	 * <h3>INFO</h3>
	 * @AUTHOR JarJarBings12
	 * @VERSION 1.0.0
	 * @USAGE Use to Check that the Window exist
	 * @INPUT Window in String Form
	 * @OUTPUT Boolean
	 */
	private static boolean existWindow(String name) {
		if(dynWindowCore.INVENTORYS.contains(name)) {
			return true;
		} else {
			return false;
		}
	}
	
	
	/**
	 * Enable / Disable a Window
	 * <h3>INFO</h3>
	 * @AUTHOR JarJarBings12
	 * @VERSION 1.0.0
	 * @USAGE Use to register a Window
	 * @INPUT Window in String Form
	 * @OUTPUT None
	 */
	private  static void registerWindow(String name) {
		dynWindowCore.INVENTORYS.add(name);
	}
	
	
	/**
	 * Enable / Disable a Window
	 * <h3>INFO</h3>
	 * @AUTHOR JarJarBings12
	 * @VERSION 1.0.0
	 * @USAGE Use to unregister a Window
	 * @INPUT Window in String Form
	 * @OUTPUT None
	 */
	private  static void unregisterWindow(String name) {
		dynWindowCore.INVENTORYS.remove(name);
	}
	
	private static int getSlots(String inv) {
		return dynFILELIST.s.getInt("windows.window."+inv+".lines");
		
	}
	
	private static String getDisplayName(String inv) {
		return dynFILELIST.s.getString("windows.window."+inv+".displayname");
	}
	
	/**
	 * Save Task
	 */
	private static void runSave() {
		try {
			dynFILELIST.ca.save(dynFILELIST.cache);
			dynFILELIST.s.save(dynFILELIST.storage);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
