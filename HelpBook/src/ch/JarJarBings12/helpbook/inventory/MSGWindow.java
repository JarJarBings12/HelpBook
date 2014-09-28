package ch.JarJarBings12.helpbook.inventory;

import java.util.ArrayList;
import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.DyeColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import ch.JarJarBings12.helpbook.Core.Core;

public class MSGWindow {
	/**
	 * @author JarJarBings12
	 */
	public static HashMap<Player, ItemStack> MSGWINDOWLIST = new HashMap<>();
	private static Inventory inv = null;
	public enum BUTTON {
		YES, NO, CANCCLE,
		YESNO, YESNOCANCCLE
	}
	public enum EXEPTION {
		INFO, WARNING, ERROR, QUESTION
	}
//-----
	private static ItemStack yes = new ItemStack(Material.STAINED_GLASS_PANE, 1, DyeColor.GREEN.getData());
	private static ItemMeta ymete = yes.getItemMeta();
//-----
	private static ItemStack no = new ItemStack(Material.STAINED_GLASS_PANE, 1, DyeColor.GREEN.getData());
	private static ItemMeta nometa = no.getItemMeta();
//-----
	private static ItemStack canccle = new ItemStack(Material.STAINED_GLASS_PANE, 1, DyeColor.GREEN.getData());
	private static ItemMeta cameta = canccle.getItemMeta();
//-----
	
	public static void openMSGHandler(Player player, BUTTON button, EXEPTION exeption, String Frage, ItemStack item) {
		inv = player.getServer().createInventory(null, 18, craftWINDOWExeption(exeption)  + Frage);
		craftBUTTONS(button);
		MSGWINDOWLIST.put(player, item);
		player.openInventory(inv);
	}
	
	
	private static void craftBUTTONS(BUTTON buttons) {
		if(buttons == BUTTON.YES) {
			inv.setItem(12, yes);
		} else if (buttons == BUTTON.NO) {
			inv.setItem(13, no);
		} else if (buttons == BUTTON.YESNO) {
			inv.setItem(12, yes);
			inv.setItem(13, no);
		} else if (buttons == BUTTON.CANCCLE) {
			inv.setItem(14, canccle);
		} else if (buttons == BUTTON.YESNOCANCCLE) {
			inv.setItem(12, yes);
			inv.setItem(13, no);
			inv.setItem(14, canccle);
		} else {
			
		}
	}
	
	private static String craftWINDOWExeption(EXEPTION exeption) {
		if(exeption == EXEPTION.ERROR) {
			String error = "§4[!]§f";
			return error;
		} else if (exeption == EXEPTION.WARNING) {
			String warn = "§6[!]§f";
			return warn;
		} else if (exeption == EXEPTION.INFO) {
			String info = "§1[i]§f";
			return info;
		} else if (exeption == EXEPTION.QUESTION) {
			String quest = "§2[?]§f";
			return quest;
		} else {
			String info = "§1[i]§f";
			return info;
		}
	}
	
	
	public static void msgyes(ItemStack item, Player pl) {
		pl.sendMessage("Add Item to inv");
		pl.getInventory().addItem(item);
		removeMSGLIST(pl);
	}
	
	public static void msgno(Player pl) {
		pl.sendMessage("Not Item add");
		removeMSGLIST(pl);
	}
	
	public static void msgcanccle(Player pl) {
		pl.sendMessage("Not Item to Inv");
		removeMSGLIST(pl);
	}
	
	public static void load_BUTTONS() {
		cameta.setDisplayName("§Cancel");
		canccle.setItemMeta(cameta);
		ymete.setDisplayName("§2Yes");
		yes.setItemMeta(ymete);
		nometa.setDisplayName("§4No");
		no.setItemMeta(nometa);
	}
	
	private static void removeMSGLIST(Player player) {
		MSGWINDOWLIST.remove(player);
	}
}
