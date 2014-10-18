package ch.JarJarBings12.helpbook.util;

import java.io.File;

import org.bukkit.configuration.file.YamlConfiguration;

public class BookFiles {
	/**
	 * @author JarJarBings12
	 */
	public static File books = new File("plugins/HelpBook/","helpbooks.yml");
	public static YamlConfiguration yamlbooks = YamlConfiguration.loadConfiguration(books);
}
