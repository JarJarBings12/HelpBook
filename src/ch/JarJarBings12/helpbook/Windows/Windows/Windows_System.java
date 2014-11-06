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

import ch.JarJarBings12.helpbook.Core.Core;
import ch.JarJarBings12.helpbook.Windows.dynFILELIST;
import ch.JarJarBings12.helpbook.Windows.dynWindowCore;
import ch.JarJarBings12.helpbookwin.basic.files.filelist;
import ch.JarJarBings12.helpbookwin.basic.item.Objects.loaders.labelLoader;
import ch.JarJarBings12.helpbookwin.basic.item.Objects.loaders.labelObj;
import ch.JarJarBings12.helpbookwin.basic.objects.JObjects;

public class Windows_System extends Windows_Utils {
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
	public static void renderWindow(String Window, Player player) {
		int x = getSlots(Window)*9;
		Inventory tempinv = player.getServer().createInventory(null, x, getDisplayName(Window));
		for (int i = 0; i < x; i++) {
			Material m = Material.getMaterial(dynFILELIST.s.getString("windows.window."+Window+".ObjList.object"+i+".MATERIAL"));
			if(m == Material.WRITTEN_BOOK) {
				ItemStack item = new ItemStack(m);
				BookMeta  meta = (BookMeta)item.getItemMeta();
				meta.setAuthor("windows.window."+Window+".ObjList.object"+i+".AUTHOR");
				meta.setTitle("windows.window."+Window+".ObjList.object"+i+".TITLE");
				List<String> lore = dynFILELIST.s.getStringList("windows.window."+Window+".ObjList.object"+i+".LORE");
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
					List<String> lore = dynFILELIST.s.getStringList("windows.window."+Window+".ObjList.object"+i+".LORE");
					String dn = dynFILELIST.s.getString("windows.window."+Window+".ObjList.object"+i+".DISPLAYNAME");
						meta.setDisplayName(dn);
					System.out.println(m.name());
					meta.setLore(lore);
					item.setItemMeta(meta);
					tempinv.setItem(i, item);
				} catch (NullPointerException e) {
					
				}
			} else {
				System.out.println("@HelpBook.:@WindowRender.:@ErrorCast@"+Window+".ObjList.Object"+i);
				System.out.println("@HelpBook.:@WindowRender.:@INFO.:Pleas Fix the Error for Debug Tippe /helpbook @SlotReport_<SLOT>");
			}
			if((dynFILELIST.s.getBoolean("windows.window."+Window+".windowopensound")) != false ) {
				player.playSound(player.getLocation(), Sound.HORSE_ARMOR, 1, 1);
			}
			player.openInventory(tempinv);
		} 
		System.out.println("@HelpBook.:@WindowRender@Player_"+player.getName());
		dynWindowCore.INHBSystem.put(player, Window);
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
	public static void createNewWindow(String Name, int lines) {
		dynFILELIST.s.set("windows.window."+Name+".DISPLAYNAME", Name);
		dynFILELIST.s.set("windows.window."+Name+".ENABLED", true);
		dynFILELIST.s.set("windows.window."+Name+".WINDOWOPENSOUND", true);
		dynFILELIST.s.set("windows.window."+Name+".LINES", lines);
		dynFILELIST.s.set("windows.window."+Name+".PERMISSION", "none");
		
		int x = lines*9;
		ItemStack d = new ItemStack(Material.AIR);
		for(int i = 0; i < x; i++) {
			
			dynFILELIST.s.set("windows.window."+Name+".ObjList.object"+i+".DISPLAYNAME", "DEFAULT" );
			dynFILELIST.s.set("windows.window."+Name+".ObjList.object"+i+".DISABLED", false);	
			dynFILELIST.s.set("windows.window."+Name+".ObjList.object"+i+".MATERIAL", d.getType().name());	
			dynFILELIST.s.set("windows.window."+Name+".ObjList.object"+i+".TYPE", "BUTTON");		
			dynFILELIST.s.set("windows.window."+Name+".ObjList.object"+i+".LORE", "");	
			dynFILELIST.s.set("windows.window."+Name+".ObjList.object"+i+".ACTION.TYPE", "NONE");
			dynFILELIST.s.set("windows.window."+Name+".ObjList.object"+i+".ACTION.USEPERMISSION", "NONE");
			dynFILELIST.s.set("windows.window."+Name+".ObjList.object"+i+".ACTION.MESSAGE", "NONE");
		}
		registerWindow(Name);
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
	public static void disableWindow(String Name, Boolean enabled) {
		dynFILELIST.s.set("windows.window."+Name+".enabled", enabled);
		System.out.println("2d");
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
	public static void removeWindow(String Name) {
		dynFILELIST.s.set("windows.window."+Name, null);
		unregisterWindow(Name);
		runSave();
	}
	
	
	/**
	 * Enable / Disable a Window
	 * <h3>INFO</h3>
	 * @AUTHOR JarJarBings12
	 * @VERSION 1.0.0
	 * @USAGE Use to Check that the Window exist
	 * @INPUT Window in String Form
	 * @OUTPUT Boolean
	 */
	public static boolean existWindow(String Name) {
		if(dynWindowCore.INVENTORYS.contains(Name)) {
			return true;
		} else {
			return false;
		}
	}
	
/*/Private void /*/
	
	
	/**
	 * Enable / Disable a Window
	 * <h3>INFO</h3>
	 * @AUTHOR JarJarBings12
	 * @VERSION 1.0.0
	 * @USAGE Use to register a Window
	 * @INPUT Window in String Form
	 * @OUTPUT None
	 */
	private static void registerWindow(String Name) {
		dynWindowCore.INVENTORYS.add(Name);
		runSave();
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
	private static void unregisterWindow(String Name) {
		dynWindowCore.INVENTORYS.remove(Name);
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
