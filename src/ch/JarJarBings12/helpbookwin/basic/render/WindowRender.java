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
		
		/* w = Window */
		windowsObj w = Window;
		
		/* x = lines*9 */
		int x = w.getLines()*9;
		
		/* Create a Virtual Inventory x = lines w.getDisplayName() get the Name of the Window */
		Inventory TempInv = pl.getServer().createInventory(null, x, w.getDisplayName());
		
		/* Create the Default Item Stack */
		ItemStack leer = new ItemStack(Material.AIR);
		
		/* Go from 0 to max 54 and list all Item Object's into the Window */
		for(int i = 0; i < x; i++) {
			
			/* Create a boolean for it is be use for check is this Slot enabled */
			boolean enabled = filelist.s.getBoolean("windows.window."+w.getSystemName()+".ObjList.object"+i+".ENABLED");
			
			/* Check is Slot Enabled */
			if(enabled == true) {
				
				/* Get the Type of the Slot out of the Configuration */
				String TYPE = filelist.s.getString("windows.window."+w.getSystemName()+".ObjList.object"+i+".TYPE");
				
				/* If the Slot is a Button */
				if(TYPE.equals("BUTTON")) {
			
					String mat = filelist.s.getString("windows.window."+w.getSystemName()+".ObjList.object"+i+".MATERIAL");
					Material m = Material.getMaterial(mat);
					
						/* If the Material is Air skip the Meta options */
						if(m == Material.AIR) {
							TempInv.setItem(i, leer);
						} else {
							ItemStack item = new ItemStack(m);
							ItemMeta meta = (ItemMeta)item.getItemMeta();
							meta.setDisplayName(filelist.s.getString("windows.window."+w.getSystemName()+".ObjList.object"+i+".DISPLAYNAME"));
							meta.setDisplayName(filelist.s.getString("windows.window."+w.getSystemName()+".ObjList.object"+i+".LORE"));
							item.setItemMeta(meta);
							TempInv.setItem(i, item);	
						}		
				
				/* If the Slot Type is a Label */
				} else if (TYPE ==  "LABEL") {				
					
					String mat = filelist.s.getString("windows.window."+w.getSystemName()+".ObjList.object"+i+".MATERIAL");
					Material m = Material.getMaterial(mat);
					
						/* If the Material is Air skip the Meta options */
						if(m == Material.AIR) {
							TempInv.setItem(i, leer);
						} else {
							ItemStack item = new ItemStack(m);
							ItemMeta meta = (ItemMeta)item.getItemMeta();
							meta.setDisplayName(filelist.s.getString("windows.window."+w.getSystemName()+".ObjList.object"+i+".DISPLAYNAME"));
							meta.setDisplayName(filelist.s.getString("windows.window."+w.getSystemName()+".ObjList.object"+i+".LORE"));
							item.setItemMeta(meta);
							TempInv.setItem(i, item);	
						}
				
				/* If the Slot Type is a Book */
				} else if (TYPE==  "BOOK") {
					ItemStack book = new ItemStack(Material.WRITTEN_BOOK);
					BookMeta meta =(BookMeta) book.getItemMeta();
					meta.setAuthor(filelist.s.getString("windows.window."+w.getSystemName()+".ObjList.object"+i+".AUTHOR"));
					meta.setTitle(filelist.s.getString("windows.window."+w.getSystemName()+".ObjList.object"+i+".TITLE"));
					meta.setLore(filelist.s.getStringList("windows.window."+w.getSystemName()+".ObjList.object"+i+".LORE"));
					book.setItemMeta(meta);
					TempInv.setItem(i, book);
				
				/* If the Slot Type is Unknown */
				} else {
					TempInv.setItem(i, leer);
				}
			
			/* If the Slot is Disabled */
			} else {
				TempInv.setItem(i, leer);
			}
			
			/* Check have the Window a Enable Sound or not. */
			if((filelist.s.getBoolean("windows.window."+Window+".OPENSOUND")) != false ) {
				pl.playSound(pl.getLocation(), Sound.HORSE_ARMOR, 1, 1);
			}
			
			/* Open the TempInv and Open it. */
			pl.openInventory(TempInv);
		}
	}
}