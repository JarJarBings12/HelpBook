package ch.JarJarBings12.helpbook.Windows.Windows;

import java.io.IOException;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.BookMeta;
import org.bukkit.inventory.meta.ItemMeta;

import ch.JarJarBings12.helpbook.Windows.dynConfig;
import ch.JarJarBings12.helpbook.Windows.dynFILELIST;
import ch.JarJarBings12.helpbook.Windows.dynListener.d;

public class Windows_Item {
	
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
	public static void setItemAsWindowSlot(String Window, String ObjType, int WindowSlot, ItemStack newItemStack, Player player) {
		int maxslot = dynFILELIST.s.getInt("windows.window."+Window+".lines")*9;
		int slot = WindowSlot-1;
		
		if(ObjType.equalsIgnoreCase("BOOK")) {
			if(!(newItemStack.getType() == Material.WRITTEN_BOOK)) {
				return;
			}
			BookMeta meta = (BookMeta)newItemStack.getItemMeta();
			Material m = newItemStack.getType();
			dynFILELIST.s.set("windows.window."+Window+".ObjList.object"+slot+".MATERIAL", m.name());
			dynFILELIST.s.set("windows.window."+Window+".ObjList.object"+slot+".TYPE", "BOOK");
			dynFILELIST.s.set("windows.window."+Window+".ObjList.object"+slot+".TITLE", meta.getTitle());
			dynFILELIST.s.set("windows.window."+Window+".ObjList.object"+slot+".AUTHOR", meta.getAuthor());
			dynFILELIST.s.set("windows.window."+Window+".ObjList.object"+slot+".PAGES", meta.getPages());
			dynFILELIST.s.set("windows.window."+Window+".ObjList.object"+slot+".LORE", meta.getLore());
			runSave();
		} else if (ObjType.equalsIgnoreCase("BUTTON")) {
			ItemMeta meta = newItemStack.getItemMeta();
			Material m = newItemStack.getType();
			if(meta.getDisplayName() == null) {
				meta.setDisplayName(m.name());
			}
			dynFILELIST.s.set("windows.window."+Window+".ObjList.object"+slot+".DISPLAYNAME", meta.getDisplayName());
			dynFILELIST.s.set("windows.window."+Window+".ObjList.object"+slot+".TYPE", "BUTTON");
			dynFILELIST.s.set("windows.window."+Window+".ObjList.object"+slot+".MATERIAL", m.name());
			dynFILELIST.s.set("windows.window."+Window+".ObjList.object"+slot+".ACTION", "none");
			dynFILELIST.s.set("windows.window."+Window+".ObjList.object"+slot+".ACTION.MESSAGE", "none");
			dynFILELIST.s.set("windows.window."+Window+".ObjList.object"+slot+".ACTION.GIVE", "none");
			dynFILELIST.s.set("windows.window."+Window+".ObjList.object"+slot+".LORE", meta.getLore());
			runSave();
		} else {
			player.sendMessage(ObjType + " is not Avible");
		}
		
	}
	public static void disableWindowSlot(String Window, int slot, boolean disabled) {
		int sslot = slot-1;
		dynFILELIST.s.set("windows.window."+Window+".ObjList."+"object"+sslot+".DISABLED", disabled);
		dynConfig.saveStorage();
	}
	
	private static void runSave() {
		try {
			dynFILELIST.s.save(dynFILELIST.storage);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
