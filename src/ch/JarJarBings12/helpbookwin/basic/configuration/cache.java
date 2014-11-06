package ch.JarJarBings12.helpbookwin.basic.configuration;

import java.io.IOException;

import ch.JarJarBings12.helpbookwin.basic.files.filelist;

public class cache {
	public static void createCache() {
		filelist.ca.addDefault("windows.cache", "");
		try {
			filelist.ca.save(filelist.storage);
		} catch (IOException  e) {
			e.printStackTrace();
		}
	}
}
