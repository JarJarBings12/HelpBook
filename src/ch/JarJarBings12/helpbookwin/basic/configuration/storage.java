package ch.JarJarBings12.helpbookwin.basic.configuration;

import java.io.IOException;

import ch.JarJarBings12.helpbookwin.basic.files.filelist;

public class storage {
	public static void createStorage() {
		try {
			filelist.s.options().copyDefaults(true);
			filelist.s.save(filelist.storage);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
