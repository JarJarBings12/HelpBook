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
	public dynConfig(Core inCore) {
		Core.inCore = inCore;
	}

	
	private static dynFILELIST df;
	private static dynWindowCore dwc;
	/**
	 * @author JarJarBings12
	 * Load the Cache
	 */
	public static void initializeCacheList() {
		
		dwc.INVENTORYS.clear();
		if(df.ca.getList("windows.cache") != null) {
			List INV = df.ca.getList("windows.cache");
			dwc.INVENTORYS.add(INV.toString());	
			return;
		} else {
			System.out.println(util.helpbook + "Window list is empty!");
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