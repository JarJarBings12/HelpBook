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
	public static ArrayList<String> inwindow = new ArrayList<>();
	
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
				inwindow.add(pl.getName());
			} else if (m == Material.AIR) {
				ItemStack item = new ItemStack(Material.AIR);
				tempinv.setItem(i, item);
				inwindow.add(pl.getName());
			} else if (m != Material.WRITTEN_BOOK){
				try {
					ItemStack item = new ItemStack(Material.getMaterial(m.name()));
					ItemMeta  meta = (ItemMeta)item.getItemMeta();
					List<String> lore = dynFILELIST.s.getStringList("windows.window."+inv+".ObjList.object"+i+".LORE");
					String dn = dynFILELIST.s.getString("windows.window."+inv+".ObjList.object"+i+".DISPLAYNAME");
						meta.setDisplayName(dn);
					System.out.println(m.name());
					meta.setLore(lore);
					item.setItemMeta(meta);
					inwindow.add(pl.getName());
					tempinv.setItem(i, item);
				} catch (NullPointerException e) {
					
				}
				
			} else {
				System.out.println("@HelpBook.:@WindowRender.:@ErrorCast@"+inv+".ObjList.Object"+i);
				System.out.println("@HelpBook.:@WindowRender.:@INFO.:Pleas Fix the Error for Debug Tippe /helpbook @SlotReport_<SLOT>");
			}
			pl.openInventory(tempinv);
		} 
		System.out.println("@HelpBook.:@WindowRender@Player_"+pl.getName());
		INHBSystem.put(pl, inv);
		inwindow.add(pl.getName());
	}
}
