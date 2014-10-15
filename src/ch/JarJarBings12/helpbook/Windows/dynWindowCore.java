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

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.BookMeta;
import org.bukkit.inventory.meta.ItemMeta;

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
	
	public static void renderWindow(String inv, Player pl) {
		int x = getSlots(inv)*9;
		Inventory tempinv = pl.getServer().createInventory(null, x, inv);
		for (int i = 0; i < x; i++) {
			Material m = Material.getMaterial(dynFILELIST.s.getString("windows.window."+inv+".ObjList.object"+i+".MATERIAL"));
			if(m == Material.WRITTEN_BOOK) {
				ItemStack item = new ItemStack(m);
				BookMeta  meta = (BookMeta)item.getItemMeta();
				meta.setAuthor("windows.window."+inv+".ObjList.object"+i+".AUTHOR");
				meta.setTitle("windows.window."+inv+".ObjList.object"+i+".TITLE");
				List<String> lore = dynFILELIST.s.getStringList("windows.window."+inv+".ObjList.object"+i+".LORE");
				meta.setLore(lore);
				item.setItemMeta(meta);
				tempinv.setItem(i, item);
			} else if (m != Material.WRITTEN_BOOK){
				ItemStack item = new ItemStack(m);
				ItemMeta  meta = (ItemMeta)item.getItemMeta();
				List<String> lore = dynFILELIST.s.getStringList("windows.window."+inv+".ObjList.object"+i+".LORE");
				meta.setDisplayName(dynFILELIST.s.getString("windows.window."+inv+".ObjList.object"+i+".DISPLAYNAME"));
				meta.setLore(lore);
				item.setItemMeta(meta);
				tempinv.setItem(i, item);
			} else {
				System.out.println("@HelpBook.:@WindowRender.:@ErrorCast@"+inv+".ObjList.Object"+i);
				System.out.println("@HelpBook.:@WindowRender.:@INFO.:Pleas Fix the Error for Debug Tippe /helpbook @SlotReport_<SLOT>");
			}
		} 
		INHBSystem.put(pl, inv);
		pl.openInventory(tempinv);
		Bukkit.broadcastMessage(INHBSystem.toString());
		System.out.println("@HelpBook.:@WindowRender@Player_"+pl.getName());
	}
}
