package ch.JarJarBings12.helpbook.Core;

import java.util.Locale;

import org.bukkit.plugin.java.JavaPlugin;

import ch.JarJarBings12.helpbook.BookEvent.InventoryMoveEvent;
import ch.JarJarBings12.helpbook.BookEvent.SignPressEvent;
import ch.JarJarBings12.helpbook.Commands.CMDExecuter;
import ch.JarJarBings12.helpbook.NotificationCenter.NotificationCenterC;
import ch.JarJarBings12.helpbook.i18n.i18n;
import ch.JarJarBings12.helpbook.util.BookStorage;
import ch.JarJarBings12.helpbook.util.ConfigLoader;

public class Core extends JavaPlugin {
	
	public static Core inCore;
	private static i18n inI18N;
	private static BookStorage inBookStore;
	private static ConfigLoader inConfigLoader;
	
	public void onEnable() {

		inCore = this;
		inI18N = new i18n(this);
		inBookStore = new BookStorage(this);
		inConfigLoader = new ConfigLoader(this);
		
		Locale locale = new Locale("de");
		geti18n().setLanguage(locale);
		getBookStorage().load_BookFile();
		
		getConfigLoader().setBooleans();
		getConfigLoader().setBookNames();
		getConfigLoader().update_WINDOWTITLE();
		
		SignPressEvent evSigenTAGCreate = new SignPressEvent(this);
		CMDExecuter.load_COMMANDS();
		InventoryMoveEvent ev = new InventoryMoveEvent(this);		
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
}
