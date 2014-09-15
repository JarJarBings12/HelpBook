package ch.JarJarBings12.helpbook.NotificationCenter;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;

import ch.JarJarBings12.helpbook.Core.Core;

public class NotificationCenterC {
	public NotificationCenterC(Core inCore) {
		Core.inCore = inCore;
	}
	
	/**
	 * Not Colored
	 */
	
	public static final NotificationCenterC WARNING = new NotificationCenterC(Core.inCore.geti18n().getMessage("WARNING"));
	public static final NotificationCenterC INFO = new NotificationCenterC(Core.inCore.geti18n().getMessage("INFO"));
	public static final NotificationCenterC ERROR = new NotificationCenterC(Core.inCore.geti18n().getMessage("ERROR"));
	public static final NotificationCenterC IMPORTANT = new NotificationCenterC(Core.inCore.geti18n().getMessage("IMPORTANT"));
	public static final NotificationCenterC CRITICAL = new NotificationCenterC(Core.inCore.geti18n().getMessage("CRITICAL"));
	public static final NotificationCenterC UCONEMY = new NotificationCenterC(Core.inCore.geti18n().getMessage("UCONEMY"));
	public static final NotificationCenterC NONE = new NotificationCenterC(" ");
	
	private String prefix;
	
	public NotificationCenterC(String prefix) {
		this.prefix = prefix;
	}	
	/**
	 * 
	 * @param prefix
	 * @param message
	 * @return Return a String with a Message (Contains not a Alternative Color translate)
	 */
	private String craftCONSOLEMessage(String prefix, String message) {
		message = "[UConemy]"+prefix+message;
		return message;	
	}
	
	public void consoleNOTE(String message) {
		System.out.println(craftCONSOLEMessage(prefix, message));
	}
}
