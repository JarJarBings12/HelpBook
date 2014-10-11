package ch.JarJarBings12.helpbook.Windows;

import org.bukkit.inventory.Inventory;

public class BuildWindows {
	private static dynFILELIST df;
	
	public static void BuildNewWindow(int lines, String name) {
		df.ca.set("windows.cache", name);
		df.s.set("windows.window."+name+".displayname", name);
		df.s.set("windows.window."+name+".lines", lines);
		df.s.set("windows.windwo."+name+".permission", "none");
	}
	
	
	
}
