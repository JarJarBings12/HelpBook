package ch.JarJarBings12.helpbook.Windows;

import java.io.IOException;
import java.util.List;

import net.minecraft.server.v1_7_R3.Item;

import org.bukkit.Material;
import org.bukkit.entity.Player;
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
			ItemStack d = new ItemStack(Material.AIR);
			int oldlines = dynFILELIST.s.getInt("windows.window."+inv+".lines");
			int newlines = lines*9;
			for (int i = oldlines; i < newlines; i++) {
				dynFILELIST.s.set("windows.window."+inv+".ObjList.object"+i+".TYPE", "BUTTON");
				dynFILELIST.s.set("windows.window."+inv+".ObjList.onject"+i+".DISPLAYNAME", d.getItemMeta().getDisplayName());
				dynFILELIST.s.set("windows.window."+inv+".ObjList.object"+i+".MATERIAL", d.getType().name());			
				dynFILELIST.s.set("windows.window."+inv+".ObjList.object"+i+".ACTION.TYPE", "NONE");
				dynFILELIST.s.set("windows.window."+inv+".ObjList.object"+i+".ACTION.USEPERMISSION", "NONE");
				dynFILELIST.s.set("windows.window."+inv+".ObjList.object"+i+".ACTION.MESSAGE", "NONE");
				save();
			}
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
	public static void setAsSlot(String inv, String Type,  int slots, ItemStack item, Player pl) {
		int maxslot = dynFILELIST.s.getInt("windows.window."+inv+".lines")*9;
		int slot = slots-1;
		if(Type.equalsIgnoreCase("BOOK")) {
			if(!(item.getType() == Material.WRITTEN_BOOK)) {
				return;
			}
			BookMeta meta = (BookMeta)item.getItemMeta();
			Material m = item.getType();
			dynFILELIST.s.set("windows.window."+inv+".ObjList.object"+slot+".MATERIAL", m.name());
			dynFILELIST.s.set("windows.window."+inv+".ObjList.object"+slot+".TYPE", "BOOK");
			dynFILELIST.s.set("windows.window."+inv+".ObjList.object"+slot+".TITLE", meta.getTitle());
			dynFILELIST.s.set("windows.window."+inv+".ObjList.object"+slot+".AUTHOR", meta.getAuthor());
			dynFILELIST.s.set("windows.window."+inv+".ObjList.object"+slot+".PAGES", meta.getPages());
			dynFILELIST.s.set("windows.window."+inv+".ObjList.object"+slot+".LORE", meta.getLore());
			save();
		} else if (Type.equalsIgnoreCase("BUTTON")) {
			ItemMeta meta = item.getItemMeta();
			Material m = item.getType();
			if(meta.getDisplayName() == null) {
				meta.setDisplayName(m.name());
			}
			dynFILELIST.s.set("windows.window."+inv+".ObjList.object"+slot+".DISPLAYNAME", meta.getDisplayName());
			dynFILELIST.s.set("windows.window."+inv+".ObjList.object"+slot+".TYPE", "BUTTON");
			dynFILELIST.s.set("windows.window."+inv+".ObjList.object"+slot+".MATERIAL", m.name());
			dynFILELIST.s.set("windows.window."+inv+".ObjList.object"+slot+".ACTION", "none");
			dynFILELIST.s.set("windows.window."+inv+".ObjList.object"+slot+".ACTION.MESSAGE", "none");
			dynFILELIST.s.set("windows.window."+inv+".ObjList.object"+slot+".ACTION.GIVE", "none");
			dynFILELIST.s.set("windows.window."+inv+".ObjList.object"+slot+".LORE", meta.getLore());
			save();
		} else if (Type.equalsIgnoreCase("TOOL")) {
			ItemMeta meta =item.getItemMeta();
			Material m = item.getType();
			List<String> lore = meta.getLore();
			String displayname = meta.getDisplayName();
			dynFILELIST.s.set("windows.window."+inv+".ObjList.object"+slot+".DISPLAYNAME", displayname);
			dynFILELIST.s.set("windows.window."+inv+".ObjList.object"+slot+".TYPE", "TOOL");
			dynFILELIST.s.set("windows.window."+inv+".ObjList.object"+slot+".MATERIAL", m.name());
			dynFILELIST.s.set("windows.window."+inv+".ObjList.object"+slot+".LORE", lore);
			save();
		} else {
			pl.sendMessage(Type + " is not Avible");
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
	
	/**
	 * <h3>INFO</h3>
	 * @AUTHOR JarJarBings12
	 * @VERSION 1.0.0
	 * @DATE 12.10.14
	 * <h3>PROPERTIES</h3>
	 * @USAGE Disable a Window
	 * @INPUT Window and a Boolean
	 * @OUTPUT None 
	 */
	public static void disableWindow(String Window, Boolean enabled) {
		dynFILELIST.s.set("windows.window."+Window+".enabled", enabled);
		save();
	}
	
	/**
	 * <h3>INFO</h3>
	 * @AUTHOR JarJarBings12
	 * @VERSION 1.0.0
	 * @DATE 12.10.14
	 * <h3>PROPERTIES</h3>
	 * @USAGE Remove a Window
	 * @INPUT Window
	 * @OUTPUT None 
	 */
	public static void removeWindow(String window) {
		dynFILELIST.s.set("windows.window."+window, null);
		save();
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
		save();
	}
	
	
	public static String getSlotAction(String inv, int slot) {
		return dynFILELIST.s.getString("windows.window."+inv+".ObjList.object"+slot+".ACTION.TYPE");
	}
	
	/**
	 * Actions
	 * 
	 * @show_X_window Open window X
	 * @close_USER_windoow / Close the window of "USER"
	 * @give_ITEM_USER / Give a User a Item
	 * @HelpBook_give_BOOK_USER
	 * @HelpBook_send_MESSAGE_USER
	 * @HelpBook_send_INFO
	 */
	
}
