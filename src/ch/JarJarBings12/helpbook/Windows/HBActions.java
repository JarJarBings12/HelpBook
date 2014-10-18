package ch.JarJarBings12.helpbook.Windows;

import org.bukkit.entity.Player;

import ch.JarJarBings12.helpbook.util.util;

public class HBActions {
	/**
	 * @author JarJarBings12
	 */
	
	/**
	 * Open Book
	 */
	public static void runOPENWINDOW(Player pl, String Action) {
		String a = Action.replace("hb_open_window_", "");
		pl.closeInventory();
		if(HBOS.existInventory(a) != true) {
			return;
		}
		dynWindowCore.renderWindow(a, pl);
	}
	
	/**
	 * List all Windows
	 */
	public static void runWINDOWLIST(Player pl) {
		String finalstring = null;
		for (String s : dynWindowCore.INVENTORYS) {
			String c = "o";
			for (int i = 0; i < dynWindowCore.INVENTORYS.size(); i++) {
					finalstring = finalstring + "�6"+s+", ";
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
	
/*/Action Broken/*/
	/**
	 * Run a Action Error
	 * @param Action
	 */
	public static void actionBreake(String Action) {
		System.out.println("@HelpBook.:@WindowActionHandler.:@ActionBroken.:@RUN:>" + Action + "> {Unkown action}");
	}
}
