package ch.JarJarBings12.helpbook.Core;

import java.util.Locale;

import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.java.JavaPlugin;

import ch.JarJarBings12.helpbook.BookEvent.InventoryMoveEvent;
import ch.JarJarBings12.helpbook.BookEvent.PlayerBookOpen;
import ch.JarJarBings12.helpbook.BookEvent.SignPressEvent;
import ch.JarJarBings12.helpbook.Commands.CMDExecuter;
import ch.JarJarBings12.helpbook.NotificationCenter.NotificationCenterC;
import ch.JarJarBings12.helpbook.i18n.i18n;
import ch.JarJarBings12.helpbook.inventory.MSGWindow;
import ch.JarJarBings12.helpbook.util.BookFiles;
import ch.JarJarBings12.helpbook.util.BookStorage;
import ch.JarJarBings12.helpbook.util.ConfigLoader;

public class Core extends JavaPlugin {
	
	public static Core inCore;
	private static i18n inI18N;
	private static BookStorage inBookStore;
	private static ConfigLoader inConfigLoader;
	
	public static PluginDescriptionFile desc;
	
	public void onEnable() {

		inCore = this;
		inI18N = new i18n(this);
		inBookStore = new BookStorage(this);
		desc = this.getDescription();
		inConfigLoader = new ConfigLoader(this);
		getBookStorage().load_BookFile();
		
		String slocale = BookFiles.yamlbooks.getString("HelpBook.Language");
		Locale locale = new Locale(slocale);
		geti18n().setLanguage(locale);
		
		getConfigLoader().setBooleans();
		getConfigLoader().setBookNames();
		getConfigLoader().update_WINDOWTITLE();
		MSGWindow.load_BUTTONS();
		
		SignPressEvent evSigenTAGCreate = new SignPressEvent(this);
		CMDExecuter.load_COMMANDS();
		InventoryMoveEvent evIME = new InventoryMoveEvent(this);	
		PlayerBookOpen evPBO = new PlayerBookOpen(this);
	}
	
	public void onDisable() {
	}
	
	public i18n geti18n() {
		return inI18N;
	}
	
	public BookStorage getBookStorage() {
		return inBookStore;
	}
	
	public ConfigLoader getConfigLoader() {
		return inConfigLoader;
	}
	
	public PluginDescriptionFile getPluginDescription() {
		return desc;
	}
}
