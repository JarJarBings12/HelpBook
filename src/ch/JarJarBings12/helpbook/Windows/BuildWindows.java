package ch.JarJarBings12.helpbook.Windows;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.bukkit.Material;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import ch.JarJarBings12.helpbook.inventory.MainInventory.inventorylist;

public class BuildWindows {
	private static dynFILELIST df;
	
	public static void saveCACHEandSTORAGE() {
		try {
			df.ca.save(df.cache);
			df.s.save(df.storage);
			dynConfig.initializeCacheList();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void BuildNewWindow(int lines, String name) {
		dynWindowCore.INVENTORYS.add(name);
		df.s.set("windows.window."+name+".displayname", name);
		df.s.set("windows.window."+name+".enabled", true);
		df.s.set("windows.window."+name+".windowopensound", true);
		df.s.set("windows.window."+name+".lines", lines);
		df.s.set("windows.window."+name+".permission", "none");
		
		int x = lines*9;
		ItemStack d = new ItemStack(Material.AIR);
		for(int i = 0; i < x; i++) {
			df.s.set("windows.window."+name+".ObjList.object"+i+".DISPLAYNAME", "dd" );
			df.s.set("windows.window."+name+".ObjList.object"+i+".MATERIAL", d.getType().name());	
			df.s.set("windows.window."+name+".ObjList.object"+i+".TYPE", "BUTTON");		
			df.s.set("windows.window."+name+".ObjList.object"+i+".LORE", "");	
			df.s.set("windows.window."+name+".ObjList.object"+i+".ACTION.TYPE", "NONE");
			df.s.set("windows.window."+name+".ObjList.object"+i+".ACTION.USEPERMISSION", "NONE");
			df.s.set("windows.window."+name+".ObjList.object"+i+".ACTION.MESSAGE", "NONE");
		}
		
		saveCACHEandSTORAGE();
	}
}
