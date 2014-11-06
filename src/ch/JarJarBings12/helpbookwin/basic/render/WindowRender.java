package ch.JarJarBings12.helpbookwin.basic.render;

import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.BookMeta;
import org.bukkit.inventory.meta.ItemMeta;

import ch.JarJarBings12.helpbook.Core.Core;
import ch.JarJarBings12.helpbookwin.basic.files.filelist;
import ch.JarJarBings12.helpbookwin.basic.objects.JObjects;
import ch.JarJarBings12.helpbookwin.basic.windows.Objects.windowsObj;

public class WindowRender {
	public WindowRender(Core inCore) {
		Core.inCore = inCore;
	}
	public void renderWindow(windowsObj Window, Player pl) {
//		Inventory tempinv = pl.getServer().createInventory(null, JObjects.getWindowByName(name).getLines()*9, JObjects.getWindowByName(name).getDisplayName());
		windowsObj w = Window;
		Inventory TempInv = pl.getServer().createInventory(null, w.getLines()*9, w.getDisplayName());
		ItemStack leer = new ItemStack(Material.APPLE);
		for(int i = 0; i < w.getLines()*9; i++) {
			if(filelist.s.getBoolean("windows.window."+w.getSystemName()+".ObjList.object"+i+".ENABLED") == true) {
				if(filelist.s.getString("windows.window."+w.getSystemName()+".ObjList.object"+i+".TYPE") ==  "BUTTON") {
					Material m = Material.getMaterial(filelist.s.getString("windows.window."+w.getSystemName()+".ObjList.object"+i+".MATERIAL"));
					ItemStack item = new ItemStack(m);
					ItemMeta meta = (ItemMeta)item.getItemMeta();
					meta.setDisplayName(filelist.s.getString("windows.window."+w.getSystemName()+".ObjList.object"+i+".DISPLAYNAME"));
					meta.setDisplayName(filelist.s.getString("windows.window."+w.getSystemName()+".ObjList.object"+i+".LORE"));
					item.setItemMeta(meta);
					TempInv.setItem(i, item);
				} else if (filelist.s.getString("windows.window."+w.getSystemName()+".ObjList.object"+i+".TYPE") ==  "LABEL") {
					Material m = Material.getMaterial(filelist.s.getString("windows.window."+w.getSystemName()+".ObjList.object"+i+".MATERIAL"));
					ItemStack item = new ItemStack(m);
					ItemMeta meta = (ItemMeta)item.getItemMeta();
					meta.setDisplayName(filelist.s.getString("windows.window."+w.getSystemName()+".ObjList.object"+i+".DISPLAYNAME"));
					meta.setDisplayName(filelist.s.getString("windows.window."+w.getSystemName()+".ObjList.object"+i+".LORE"));
					item.setItemMeta(meta);
					TempInv.setItem(i, item);
				} else if (filelist.s.getString("windows.window."+w.getSystemName()+".ObjList.object"+i+".TYPE") ==  "BOOK") {
					ItemStack book = new ItemStack(Material.WRITTEN_BOOK);
					BookMeta meta =(BookMeta) book.getItemMeta();
					meta.setAuthor(filelist.s.getString("windows.window."+w.getSystemName()+".ObjList.object"+i+".AUTHOR"));
					meta.setTitle(filelist.s.getString("windows.window."+w.getSystemName()+".ObjList.object"+i+".TITLE"));
					meta.setLore(filelist.s.getStringList("windows.window."+w.getSystemName()+".ObjList.object"+i+".LORE"));
					book.setItemMeta(meta);
					TempInv.setItem(i, book);
				} else {
					System.out.println();
					TempInv.setItem(i, leer);
				}
			} else {
				System.out.println("Nicht an");
				TempInv.setItem(i, leer);
			}
			if((filelist.s.getBoolean("windows.window."+Window+".OPENSOUND")) != false ) {
				pl.playSound(pl.getLocation(), Sound.HORSE_ARMOR, 1, 1);
			}
			pl.openInventory(TempInv);
		}
	}
	
	private windowsObj getWinObject(String Name) {
		for (windowsObj w : JObjects.windows) {
			if(w.getSystemName() == Name) {
				return w;
			}
		}
		return null;
	}
	
	
}
