package ch.JarJarBings12.helpbook.dynamicwindows;

import java.io.File;

import org.bukkit.configuration.file.YamlConfiguration;

public class dynFilelist {
	public static File dynConfig = new File("plugins/HelpBook/Storage", "dynConfig.yml");
	public static YamlConfiguration dc = YamlConfiguration.loadConfiguration(dynConfig);
	
	public static File invStorage = new File("plugins/HelpBook/Storage", "invStorage.yml");
	public static YamlConfiguration is = YamlConfiguration.loadConfiguration(invStorage);
	
	public static File cache = new File("plugins/HelpBook/Storage", "Cache.yml");
	public static YamlConfiguration c = YamlConfiguration.loadConfiguration(cache);
}
