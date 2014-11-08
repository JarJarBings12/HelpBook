package ch.JarJarBings12.helpbookwin.basic.configuration;

import java.io.File;
import java.io.IOException;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

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
