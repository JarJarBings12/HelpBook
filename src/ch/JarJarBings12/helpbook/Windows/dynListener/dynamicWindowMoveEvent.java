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
import ch.JarJarBings12.helpbookwin.basic.configuration.cache;
import ch.JarJarBings12.helpbookwin.basic.objects.JObjects;

public class dynamicWindowMoveEvent implements Listener {
	/**
	 * @author JarJarBings12
	 */
	
	/* Class Constructor */
	public dynamicWindowMoveEvent(Core inCore) {
		inCore.getServer().getPluginManager().registerEvents(this, inCore);
	}
	
	/** 
	 * Event Handler section
	 * Event Type: Inventory Click Event 
	 * {@link InventoryClickEvent}
	 * */
	@EventHandler
	public void onInvMove(InventoryClickEvent e) {
		
		/* Window instance of a Existing HelpBook Window */
		if(!(JObjects.cache.contains(e.getInventory().getName()))) {
			return;
		}
		
		/* Check is Item Null when true break the Listener */
		if(e.getCurrentItem() == null) {
			return;
		}
		
		/* Get the Clicked Slot (In Raw Slot) */
		int rawslot = e.getRawSlot();
		
		/* Get the type of the Button HelpBook need this to send it to the 
		 * Right Action Handler */
		String type = dynFILELIST.s.getString("windows.window."+e.getInventory().getName()+".ObjList.object"+rawslot+".TYPE"); 
		
		/* Switch between the Slot Types
		 * - Button > Support HelpBook Actions.
		 * - Label > It's like a Button but is don't Support Actions.
		 * - Book > Support the Book Meta. */
		switch (type) {

		case "BUTTON":
			//TODO Add the Action
			// Windows_Action_System.runAction(pl, rawslot);
			System.out.println("DEBUG");
			e.setCancelled(true);
			break;
			
		case "BOOK":
			/* Add the  Clicked Book to the Player Inventory */
			ItemStack item = new ItemStack(Material.WRITTEN_BOOK);
			BookMeta meta = (BookMeta) item.getItemMeta();
			meta.setTitle("windows.window."+e.getInventory().getName()+".ObjList.object"+rawslot+".TITLE");
			meta.setAuthor("windows.window."+e.getInventory().getName()+".ObjList.object"+rawslot+".AUTHOR");
			meta.setPages("windows.window."+e.getInventory().getName()+".ObjList.object"+rawslot+".PAGES");
			List<String> lore = dynFILELIST.s.getStringList("windows.window."+e.getInventory().getName()+".ObjList.object"+rawslot+".LORE");
			meta.setLore(lore);
			item.setItemMeta(meta);
			e.getWhoClicked().getInventory().addItem(item);
			e.setCancelled(true);
			break;

		default:
			/* If it is a unknown Type of Slot it Play out this */
			//TODO Find a better option
			System.out.println("@HelpBook.:@GetClickedObject.:@"+e.getInventory().getName()+".:Object"+ rawslot);
			System.out.println("@HelpBook.:@Caused by.:@ObjectActionType{unkown}");
			break;
		}
	}
}
