package ch.JarJarBings12.helpbook.dynamicwindows;

import java.io.PrintWriter;
import java.nio.file.FileStore;

import ch.JarJarBings12.helpbook.util.util;

public class dynConfig {
	public static void genConfig() {
		dynFilelist.dc.addDefault("options.window.defaultenable", true);
		dynFilelist.dc.addDefault("options.window.name.translatealternativecloor", true);
		dynFilelist.dc.addDefault("options.window.single.permissions", false);
		
		dynFilelist.dc.addDefault("options.system.notification.msg.cantsave", true);
		dynFilelist.dc.addDefault("options.system.notification.console.cantsave", true);
		dynFilelist.dc.addDefault("options.system.notification.broadcast.cantsave", false);
		
		dynFilelist.dc.addDefault("options.system.notification.msg.saved", true);
		dynFilelist.dc.addDefault("options.system.notification.console.saved", true);
		dynFilelist.dc.addDefault("options.system.notification.broadcast.saved", false);
		
		try {
			dynFilelist.dc.options().copyDefaults(true);
			dynFilelist.dc.save(dynFilelist.dynConfig);
		} catch (Exception e) {
			System.err.println(util.helpbook + "Error by saving the Default dynamic Config!");
			e.printStackTrace();
		}
	}
	
	public static void genDefaultInv() {
		dynFilelist.is.addDefault("window.DEFAULT.DISPLAYNAME", "Default_INFO");
		dynFilelist.is.addDefault("winodw.DEFAULT.PERMISSIONS", "info");
		dynFilelist.is.addDefault("window.DEFAULT.SLOTS", 9);
		dynFilelist.is.addDefault("window.DEFAULT.inventory.slot_1.ENABLED", true);
		dynFilelist.is.addDefault("window.DEFAULT.inventory.slot_1.OBJECTTYPE", "BOOK");
		dynFilelist.is.addDefault("window.DEFAULT.inventory.slot_1.TITLE", "TEST");
		dynFilelist.is.addDefault("window.DEFAULT.inventory.slot_1.AUTHOR", "AUTHOR");
		dynFilelist.is.addDefault("window.DEFAULT.inventory.slot_1.LORE", "");
		dynFilelist.is.addDefault("window.DEFAULT.inventory.slot_1.PAGES", "");
		
//		dynFilelist.is.addDefault("window.DEFAULT.inventory.slot_1.PERMISSION", "perm_NONE");
//		dynFilelist.is.addDefault("window.DEFAULT.inventory.slot_1.ACTIONTYPE", "action_BUTTON");
//		dynFilelist.is.addDefault("window.DEFAULT.inventory.slot_1.ACTIONTYPE.ACTION", "send_MESSAGE");
//		dynFilelist.is.addDefault("window.DEFAULT.inventory.slot_1.ACTIONTYPE.MESSAGE", "Hello_This_Is_A_Test");
	
		dynFilelist.is.addDefault("window.DEFAULT.inventory.slot_2.ENABLED", true);
		dynFilelist.is.addDefault("window.DEFAULT.inventory.slot_2.OBJECTTYPE", "BUTTON");
		dynFilelist.is.addDefault("window.DEFAULT.inventory.slot_2.OBJECT.ITEM", "STONE");
		dynFilelist.is.addDefault("window.DEFAULT.inventory.slot_2.ACTIONTYPE", "action_INVOPEN");
		dynFilelist.is.addDefault("window.DEFAULT.inventory.slot_2.ACTIONTYPE.ACTION", "TEST");
		dynFilelist.is.addDefault("window.DEFAULT.inventory.slot_2.TITLE", "TEST");
		dynFilelist.is.addDefault("window.DEFAULT.inventory.slot_2.LORE", "");
		
		
		try {
			dynFilelist.is.options().copyDefaults(true);
			dynFilelist.is.save(dynFilelist.invStorage);
		} catch (Exception e) {
			System.err.println(util.helpbook + "Error by saving the Default Inventory!");
			e.printStackTrace();
		}
	}
	
	public static void createCache() {
		dynFilelist.c.addDefault("winodw", "DEFAULT");
		dynFilelist.c.addDefault("winodw.DEFAULT.enable", true);
		
		try {
			dynFilelist.c.options().copyDefaults(true);
			dynFilelist.c.save(dynFilelist.cache);
		} catch (Exception e) {
			System.err.println(util.helpbook + "Error by create the Cache!");
			e.printStackTrace();
		}	
	}
}
