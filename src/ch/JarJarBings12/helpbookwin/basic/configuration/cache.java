package ch.JarJarBings12.helpbookwin.basic.configuration;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import ch.JarJarBings12.helpbookwin.basic.files.filelist;
import ch.JarJarBings12.helpbookwin.basic.objects.JObjects;

public class cache {
	public static void createCache() {
		filelist.ca.addDefault("windows.cache", "");
		try {
			filelist.ca.save(filelist.storage);
		} catch (IOException  e) {
			e.printStackTrace();
		}
	}
	
	public static void saveCacheToFile() {
		List cachToSave = new ArrayList();
		for(String w : JObjects.cache) {
			cachToSave.add(w);
		}
		filelist.ca.set("windows.cache", cachToSave);
		try {
			filelist.ca.save(filelist.cache);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
