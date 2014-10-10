package ch.JarJarBings12.helpbook.Windows;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import ch.JarJarBings12.helpbook.Core.Core;

public class dynConfig {
	public dynConfig(Core inCore) {
		Core.inCore = inCore;
	}
	
	public static List<String> INVENTORYS = new ArrayList();
	
	private static dynFILELIST df;
	
	public static void loadConfig() {
		INVENTORYS.clear();
		if(df.ca.getStringList("windows.cache") != null) {
			
			for (String s : df.ca.getStringList("windows.cache")) {
				INVENTORYS.add(s);
			}
		}
	}
	
	public static void save() {
		
	}
	
	public void createCACHE() {
		df.ca.addDefault("windows.cache", "test0");
		try {
			dynFILELIST.ca.options().copyDefaults(true);
			dynFILELIST.ca.save(dynFILELIST.cache);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void createCONFIG() {
		df.co.addDefault("options.storage.cache.OPTIONS.folder", "plugins/HelpBook/STORAGE");
		df.co.addDefault("options.storage.cache.OPTIONS.ReadByStart", true);
		df.co.addDefault("options.storage.config.OPTIONS.folder", "plugins/HelpBook/STORAGE/CONFIG");
		df.co.addDefault("options.storage.storage.OPTIONS.folder", "plugins/HelpBook/STORAGE/STORAGE");
		try {
			dynFILELIST.co.options().copyDefaults(true);
			dynFILELIST.co.save(dynFILELIST.config);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void createSTORAG() {
		try {
			dynFILELIST.s.options().copyDefaults(true);
			dynFILELIST.s.save(dynFILELIST.storage);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}