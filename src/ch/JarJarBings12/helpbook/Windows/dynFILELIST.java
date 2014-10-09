package ch.JarJarBings12.helpbook.Windows;

import java.io.File;

import org.bukkit.configuration.file.YamlConfiguration;

public class dynFILELIST {
	public static File cache = new File("plugins/HelpBook/STORAGE", "cache.yml");
	public static File config = new File("plugins/HelpBook/STORAGE/CONFIG", "config.yml");
	public static File storage = new File("plugins/HelpBook/STORAGE/STORAGE", "storage.yml");
	public static File log      = new File("plugins/HelpBook/log", "log.txt");
	
	public static YamlConfiguration ca = YamlConfiguration.loadConfiguration(cache);
	public static YamlConfiguration co = YamlConfiguration.loadConfiguration(config);
	public static YamlConfiguration s  = YamlConfiguration.loadConfiguration(storage);
}
