package ch.JarJarBings12.helpbook.Windows.dynListener;

import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.BookMeta;

import ch.JarJarBings12.helpbook.Core.Core;
import ch.JarJarBings12.helpbook.Windows.HBOS;
import ch.JarJarBings12.helpbook.Windows.dynConfig;
import ch.JarJarBings12.helpbook.Windows.dynFILELIST;
import ch.JarJarBings12.helpbook.Windows.dynWindowCore;

public class dynamicWindowMoveEvent implements Listener {
	public dynamicWindowMoveEvent(Core inCore) {
		inCore.getServer().getPluginManager().registerEvents(this, inCore);
	}
	@EventHandler
	public void onInvMove(InventoryClickEvent e) {
		if(dynWindowCore.INHBSystem.containsKey(e.getWhoClicked())) {
			e.setCancelled(true);
		}
		if(e.getCurrentItem() == null) {
			return;
		}
		int rawslot = e.getRawSlot();
		if(dynFILELIST.s.getString("windows.window."+dynWindowCore.INHBSystem.get(e.getWhoClicked())+".ObjList.object"+rawslot+".TYPE") == "BOOK") {
			ItemStack item = new ItemStack(Material.WRITTEN_BOOK);
			BookMeta meta = (BookMeta)item.getItemMeta();
			meta.setTitle("windows.window."+dynWindowCore.INHBSystem.get(e.getWhoClicked())+".ObjList.object"+rawslot+".TITLE");
			meta.setAuthor("windows.window."+dynWindowCore.INHBSystem.get(e.getWhoClicked())+".ObjList.object"+rawslot+".AUTHOR");			
			meta.setPages("windows.window."+dynWindowCore.INHBSystem.get(e.getWhoClicked())+".ObjList.object"+rawslot+".PAGES");
			List<String> lore = dynFILELIST.s.getStringList("windows.window."+dynWindowCore.INHBSystem.get(e.getWhoClicked())+".ObjList.object"+rawslot+".LORE");
			meta.setLore(lore);
			item.setItemMeta(meta);
			e.getWhoClicked().getInventory().addItem(item);
		} else if(dynFILELIST.s.getString("windows.window."+e.getInventory().getName()+".ObjList.object"+rawslot+".TYPE") == "BUTTON") {
			String action = dynFILELIST.s.getString("windows.window."+dynWindowCore.INHBSystem.get(e.getWhoClicked())+".ObjList.object"+rawslot+".ACTION");
			
		}
	}
}
