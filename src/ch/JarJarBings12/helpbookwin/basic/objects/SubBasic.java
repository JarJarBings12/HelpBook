package ch.JarJarBings12.helpbookwin.basic.objects;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

import ch.JarJarBings12.helpbook.Core.Core;
import ch.JarJarBings12.helpbookwin.basic.files.filelist;
import ch.JarJarBings12.helpbookwin.basic.windows.Objects.windowsObj;

public class SubBasic {

	public SubBasic(Core inCore) {
		Core.inCore = inCore;
	}

	/* Create a Window */
	public void createWindow(String Name, int Lines) {
		windowsObj obj = new windowsObj(Name, Name, "none", Lines, true, true);

		JObjects.windows.add(obj);

		filelist.s.set("windows.window." + Name + ".DISPLAYNAME", Name);
		filelist.s.set("windows.window." + Name + ".ENABLED", true);
		filelist.s.set("windows.window." + Name + ".OPENSOUN", true);
		filelist.s.set("windows.window." + Name + ".LINES", Lines);
		filelist.s.set("windows.window." + Name + ".PERMISSION", "none");

		ItemStack d = new ItemStack(Material.AIR);

		for (int i = 0; i < Lines * 9; i++) {
			filelist.s.set("windows.window." + Name + ".ObjList.object" + i + ".TYPE", "LABEL");
			filelist.s.set("windows.window." + Name + ".ObjList.object" + i + ".ENABLED", true);
			filelist.s.set("windows.window." + Name + ".ObjList.object" + i + ".DISPLAYNAME", "DEFAULT");
			filelist.s.set("windows.window." + Name + ".ObjList.object" + i + ".MATERIAL", d.getType().name());
			filelist.s.set("windows.window." + Name + ".ObjList.object" + i + ".LORE", null);
		}
		save();
		JObjects.cache.add(Name);
	}

	/* Update the Lines of a Window */
	public void updateLines(String Window, int lines) {
		if(queryWindowList(Window) == null) {
			return;
		}
		
		ItemStack d = new ItemStack(Material.AIR);
		int currentlines = queryWindowList(Window).getLines();
		if(currentlines < lines) {
			for(int i = currentlines; i < lines; i++) {
				filelist.s.set("windows.window." + Window + ".ObjList.object" + i + ".TYPE", "LABEL");
				filelist.s.set("windows.window." + Window + ".ObjList.object" + i + ".ENABLED", true);
				filelist.s.set("windows.window." + Window + ".ObjList.object" + i + ".DISPLAYNAME", "DEFAULT");
				filelist.s.set("windows.window." + Window + ".ObjList.object" + i + ".MATERIAL", d.getType().name());
				filelist.s.set("windows.window." + Window + ".ObjList.object" + i + ".LORE", null);
			}
		}
		System.out.println(queryWindowList(Window).getLines());
		queryWindowList(Window).setLines(lines);
		System.out.println(queryWindowList(Window).getLines());
		save();
	}
	
	/* delete a Window complete */
	public void deletWindow(windowsObj window) {
		filelist.s.set("windows.window." + window.getSystemName(), null);
		JObjects.cache.remove(window.getSystemName());
		save();
	}

	/* Query the Window list for the Object of a Window
	 * When no Window exist with this Window Return null
	 * otherwise it return the Window Object */
	public windowsObj queryWindowList(String WindowName) {
		for(windowsObj wo : JObjects.windows) {
			if(wo.getSystemName() == WindowName) {
				return wo;
			}
		}
		return null;
	}
	
	/* Save all Configurations */
	private void save() {
		try {
			filelist.s.save(filelist.storage);
			filelist.ca.save(filelist.cache);
			filelist.co.save(filelist.config);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}