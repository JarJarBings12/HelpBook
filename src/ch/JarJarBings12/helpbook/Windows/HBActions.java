package ch.JarJarBings12.helpbook.Windows;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.omg.CORBA.portable.RemarshalException;

import ch.JarJarBings12.helpbook.util.util;

public class HBActions {
	/**
	 * @author JarJarBings12
	 */
	
	/**
	 * Open Book
	 */
	/**
	 * List all Windows
	 */
	public static void runWINDOWLIST(Player pl) {
		String finalstring = null;
		for (String s : dynWindowCore.INVENTORYS) {
			String c = "o";
			for (int i = 0; i < dynWindowCore.INVENTORYS.size(); i++) {
					finalstring = finalstring + "§6"+s+", ";
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
	
	/**
	 * Run Command
	 */
	
/*/Action Broken/*/
	/**
	 * Run a Action Error
	 * @param Action
	 */
	public static void actionBreake(String Action) {
		System.out.println("@HelpBook.:@WindowActionHandler.:@ActionBroken.:@RUN:>" + Action + "> {Unkown action}");
	}
}
