package ch.JarJarBings12.helpbook.Windows;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Array;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.BookMeta;

import ch.JarJarBings12.helpbook.Core.Core;
import ch.JarJarBings12.helpbook.util.util;

public class dynWindowCore {
	public dynWindowCore(Core inCore) {
		Core.inCore = inCore;
	}
	
	public static List<String> INVENTORYS = new ArrayList();
	public static HashMap<Player, String> INHBSystem = new HashMap();
	
	public static void ShowWindow(Player pl, String INV) {
		INHBSystem.put(pl, INV);
	}
	
	public static void StartOS() {
		if(dynFILELIST.s.getString("windows.window.default") == null) {
			BuildWindows.BuildNewWindow(3, "DEFAULT");
		}
	}	
	
	
	private static int getSlots(String inv) {
		return dynFILELIST.s.getInt("windows.window."+inv+".lines");
	}
	
	private static String getDisplayName(String inv) {
		return dynFILELIST.s.getString("windows.window."+inv+".displayname");
	}
	
	public static void loadInv(Player pl) {
		int x = getSlots(INHBSystem.get(pl))*9;
		Inventory tempinv = pl.getServer().createInventory(null, x, getDisplayName(INHBSystem.get(pl)));
		for(int i = 0; i < x; i++) {
			if((dynFILELIST.s.getString("windows.window."+INHBSystem.get(pl)+".ObjList.object"+i) == "book")) {
				ItemStack item = new ItemStack(Material.WRITTEN_BOOK);
				BookMeta bookmeta = (BookMeta)item.getItemMeta();
				bookmeta.setTitle("windows.window."+INHBSystem.get(pl)+".ObjList.object"+i+".TITLE");
				bookmeta.setAuthor("windows.window."+INHBSystem.get(pl)+".ObjList.object"+i+".AUTHOR");
				List<String> book = dynFILELIST.s.getStringList("windows.window."+INHBSystem.get(pl)+".ObjList.object"+i+".LORE");
				bookmeta.setLore(book);
				item.setItemMeta(bookmeta);
				tempinv.setItem(i, item);
			
			}
		}
	}
}
