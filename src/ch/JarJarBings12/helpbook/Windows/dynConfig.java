package ch.JarJarBings12.helpbook.Windows;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import ch.JarJarBings12.helpbook.Core.Core;
import ch.JarJarBings12.helpbook.util.util;

public class dynConfig {
	
	/**
	 * @author JarJarBings12
	 * Load the Cache
	 */
	
	public dynConfig(Core inCore) {
		Core.inCore = inCore;
	}
	
/*/File Saver/*/

	/**
	 * Save the Cache File	
	 */
	public static void saveCache() {
		List windowstosave = new ArrayList();
		for(String w : dynWindowCore.INVENTORYS) {
			windowstosave.add(w);
		}
		try {
			dynFILELIST.ca.save(dynFILELIST.cache);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Save the Storage
	 */
	public static void saveStorage() {
		try {
			dynFILELIST.s.save(dynFILELIST.storage);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
/*/File initialize/*/
	
	/**
	 * Initialize the Window Cache
	 */
	public static void initializeCacheList() {
		
		dynWindowCore.INVENTORYS.clear();
		
		if(dynFILELIST.ca.getList("windows.cache") != null) {
			List INV = dynFILELIST.ca.getList("windows.cache");
			for(Object w : INV) {
				dynWindowCore.INVENTORYS.add(w.toString());
			}
			return;
		} else {
			System.out.println(util.helpbook + "Window list is empty!");
		}
		
	}
	
/*/File Create/*/	
	
	/**
	 * Create Cache File
	 */
	public void createCACHE() {
		
		dynFILELIST.ca.addDefault("windows.cache", "");
		
		try {
			dynFILELIST.ca.options().copyDefaults(true);
			dynFILELIST.ca.save(dynFILELIST.cache);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	/**
	 * Create Configuration File
	 */
	public void createCONFIG() {
		
		dynFILELIST.co.addDefault("options.storage.cache.OPTIONS.folder", "plugins/HelpBook/STORAGE");
		dynFILELIST.co.addDefault("options.storage.cache.OPTIONS.ReadByStart", true);
		dynFILELIST.co.addDefault("options.storage.config.OPTIONS.folder", "plugins/HelpBook/STORAGE/CONFIG");
		dynFILELIST.co.addDefault("options.storage.storage.OPTIONS.folder", "plugins/HelpBook/STORAGE/STORAGE");
		dynFILELIST.co.addDefault("options.storage.storage.OPTIONS.AllowErrorTracker", "");
		
		try {
			dynFILELIST.co.options().copyDefaults(true);
			dynFILELIST.co.save(dynFILELIST.config);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	/**
	 * Create Storage File
	 */
	public void createSTORAG() {
		try {
			dynFILELIST.s.options().copyDefaults(true);
			dynFILELIST.s.save(dynFILELIST.storage);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}