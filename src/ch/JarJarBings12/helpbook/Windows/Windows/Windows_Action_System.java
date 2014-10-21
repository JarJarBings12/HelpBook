package ch.JarJarBings12.helpbook.Windows.Windows;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import ch.JarJarBings12.helpbook.Windows.HBActions;
import ch.JarJarBings12.helpbook.Windows.dynFILELIST;
import ch.JarJarBings12.helpbook.Windows.dynWindowCore;

public class Windows_Action_System {
	
	public static void runAction(Player pl, int slot) {
		String a = getActionBySlot(pl, slot);
		if(a.contains("hb_open_window_")) {
			Windows_System.renderWindow(getWindowByAction(a), pl);
		} else if(a.contains("hb_close_window")) {
			pl.closeInventory();
		} else if(a.contains("hb_give_item")) {
			
		} else if(a.contains("hb_cmd_")) {
			
		} else {
			HBActions.actionBreake(a);
		}
	}
	
	public static void setActionAtWindowObj(String Window, int slot, String Action) {
		
	}
	
	public static void removeActionFromWindowObj(String Window, int slot, String Action) {
		
	}
	
/*/Action Until/*/
	private static boolean hasActionBySlot(Player pl, int slot) {
		String temp = dynFILELIST.s.getString("windows.window."+dynWindowCore.INHBSystem.get(pl)+".ObjList.object"+slot+".ACTION.TYPE");
		if (temp != " " || temp != null) {
			return true;
		} else {
			return false;
		}
	}
	
	private static String getActionBySlot(Player pl, int slot) {
		String temp = "noaction";
		if(hasActionBySlot(pl, slot) != false) {
			
		}
		return temp;
	}
	
	private static String getWindowByAction(String action) {
		for (String i : dynWindowCore.INVENTORYS) {
			if(action.contains(i)) {
				return i;
			}
		}
		return "DEFAULT";
	}
	
//	public static void runEXECUTECOMMAND(String Action, Player pl) {
//		String cmd = "/helpbook_print_no_command_error";
//		boolean console = false;
//	/*/Define Player/*/
//		if(Action.contains("CONSOLE")) {
//			console = true;
//		} else if (pl.isOnline()) {
//			console = false;
//		} else {
//			actionBreake(Action);
//			System.out.println("@HelpBook.:@WindowActionHandler.:@Error:> {No Player Object found!}");
//			return;
//		}
//	/*/Define Command/*/
//		String temp = Action;
//			temp.replace("hb_cmd_CONSOLE_", "");
//			temp.replace("hb_cmd_PLAYER_", "");
//		cmd = temp.replace("_", " ");
//	/*/Run Command/*/
//		if(console = true) {
//			Bukkit.getServer().dispatchCommand(pl, cmd);
//		} else {
//			pl.sendMessage("/"+cmd);
//		}
//	}
}
