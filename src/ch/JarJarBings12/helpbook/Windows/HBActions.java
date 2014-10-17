package ch.JarJarBings12.helpbook.Windows;

import org.bukkit.entity.Player;

import ch.JarJarBings12.helpbook.util.util;

public class HBActions {
	public static void runOPENWINDOW(Player pl, String Action) {
		String a = Action.replace("hb_open_window_", "");
		pl.closeInventory();
		if(HBOS.existInventory(a) != true) {
			return;
		}
		dynWindowCore.renderWindow(a, pl);
	}
	
	public static void runWINDOWLIST(Player pl) {
		String finalstring = null;
		for (String s : dynWindowCore.INVENTORYS) {
			String c = "o";
			for (int i = 0; i < dynWindowCore.INVENTORYS.size(); i++) {
				if(c == "o") {
					finalstring = finalstring + "§6"+s+", ";
					c = "w";
				} else {
					finalstring = finalstring + "§f"+s+", ";
					c = "o";
				}
			}
		}
		if(finalstring == null) {
			pl.sendMessage(util.helpbook + "You can chose betwene:");
			pl.sendMessage(util.helpbook + "Empty");
			
		} else {
			pl.sendMessage(util.helpbook + "You can chose betwene:");
			pl.sendMessage(finalstring.replace("[", "").replace("]", "").replace("null", ""));
		}
		
		
	}
	
	public static void runEXECUTECOMMAND(String Action) {
		
	}
}
