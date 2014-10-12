package ch.JarJarBings12.helpbook.Windows;

import java.io.IOException;

import org.bukkit.inventory.Inventory;

public class BuildWindows {
	private static dynFILELIST df;
	
	private static void saveCACHEandSTORAGE() {
		try {
			df.ca.save(df.cache);
			df.s.save(df.storage);
			dynConfig.initializeCacheList();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void BuildNewWindow(int lines, String name) {
		df.ca.set("windows.cache", name);
		df.s.set("windows.window."+name+".displayname", name);
		df.s.set("windows.window."+name+".lines", lines);
		df.s.set("windows.window."+name+".permission", "none");
		
		int x = lines*9;
		
		for(int i = 0; i < x; i++) {
			df.s.set("windows.window."+name+".ObjList.object"+i, "");
		}
		saveCACHEandSTORAGE();
	}
}
