package ch.JarJarBings12.helpbook.Windows.dynListener;

import java.awt.Desktop.Action;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.BookMeta;

import ch.JarJarBings12.helpbook.Core.Core;
import ch.JarJarBings12.helpbook.Windows.HBActions;
import ch.JarJarBings12.helpbook.Windows.HBOS;
import ch.JarJarBings12.helpbook.Windows.dynConfig;
import ch.JarJarBings12.helpbook.Windows.dynFILELIST;
import ch.JarJarBings12.helpbook.Windows.dynWindowCore;
import ch.JarJarBings12.helpbook.Windows.Windows.Windows_Action_System;

public class dynamicWindowMoveEvent implements Listener {
	/**
	 * @author JarJarBings12
	 */
	public dynamicWindowMoveEvent(Core core2) {
		core2.getServer().getPluginManager().registerEvents(this, core2);
	}
	@EventHandler
	public void onInvMove(InventoryClickEvent e) {
		if(e.getCurrentItem() == null) {
			return;
		}
		int rawslot = e.getRawSlot();
		Player pl = (Player) e.getWhoClicked();
		String type = dynFILELIST.s.getString("windows.window."+dynWindowCore.INHBSystem.get(e.getWhoClicked())+".ObjList.object"+rawslot+".TYPE"); 
		switch (type) {
		case "BUTTON":
			Windows_Action_System.runAction(pl, rawslot);
			e.setCancelled(true);
			break;
		case "BOOK":
			ItemStack item = new ItemStack(Material.WRITTEN_BOOK);
			BookMeta meta = (BookMeta)item.getItemMeta();
			meta.setTitle("windows.window."+dynWindowCore.INHBSystem.get(e.getWhoClicked())+".ObjList.object"+rawslot+".TITLE");
			meta.setAuthor("windows.window."+dynWindowCore.INHBSystem.get(e.getWhoClicked())+".ObjList.object"+rawslot+".AUTHOR");			
			meta.setPages("windows.window."+dynWindowCore.INHBSystem.get(e.getWhoClicked())+".ObjList.object"+rawslot+".PAGES");
			List<String> lore = dynFILELIST.s.getStringList("windows.window."+dynWindowCore.INHBSystem.get(e.getWhoClicked())+".ObjList.object"+rawslot+".LORE");
			meta.setLore(lore);
			item.setItemMeta(meta);
			e.getWhoClicked().getInventory().addItem(item);
			e.setCancelled(true);
			break;
		    
		default:
			System.out.println("@HelpBook.:@GetClickedObject.:@"+dynWindowCore.INHBSystem.get(pl)+".:Object"+rawslot);
			System.out.println("@HelpBook.:@Caused by.:@ObjectActionType{unkown}");
			break;
		}
		if(dynWindowCore.INHBSystem.containsKey(e.getWhoClicked())) {
			e.setCancelled(true);
		}
	}
}
