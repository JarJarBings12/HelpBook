package ch.JarJarBings12.helpbook.Core;

import java.util.Locale;

import org.bukkit.Material;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.java.JavaPlugin;

import ch.JarJarBings12.helpbook.BookEvent.InventoryMoveEvent;
import ch.JarJarBings12.helpbook.BookEvent.PlayerBookOpen;
import ch.JarJarBings12.helpbook.BookEvent.SignPressEvent;
import ch.JarJarBings12.helpbook.Commands.CMDExecuter;
import ch.JarJarBings12.helpbook.NotificationCenter.NotificationCenterC;
import ch.JarJarBings12.helpbook.i18n.exceptionHandler;
import ch.JarJarBings12.helpbook.i18n.i18n;
import ch.JarJarBings12.helpbook.util.BookFiles;
import ch.JarJarBings12.helpbook.util.BookStorage;
import ch.JarJarBings12.helpbook.util.ConfigLoader;
import ch.JarJarBings12.helpbook.util.util;
import ch.JarJarBings12.helpbook.util.util.Exceptions;
public class Core extends JavaPlugin {
	/**
	 * @author JarJarBings12
	 */
	public static Core inCore;
	private static i18n inI18N;
	private static exceptionHandler inException;
	private static BookStorage inBookStore;
	private static ConfigLoader inConfigLoader;
	
	public static PluginDescriptionFile desc;
	
	public void onEnable() {
		
		System.out.println("[UserHelper]Load UserHelper" );
//Define the Variables
		
		inCore = this;
		inI18N = new i18n(this);
		inBookStore = new BookStorage(this);
		desc = this.getDescription();
		inConfigLoader = new ConfigLoader(this);
		
//Load Book File
		getBookStorage().load_BookFile();
		
//Load Language
		
		String slocale = BookFiles.yamlbooks.getString("HelpBook.Language");
		Locale locale = new Locale(slocale);
		
		geti18n().setLanguage(locale);		

//Load Exceptions
		
		Locale exception = new Locale("en");	
		
//Load Book File 
		
		getConfigLoader().setBooleans();
		getConfigLoader().setBookNames();
		getConfigLoader().update_WINDOWTITLE();

//Load Buttons
		
	
//Load Events
		
		SignPressEvent evSigenTAGCreate = new SignPressEvent(this);
		InventoryMoveEvent evIME = new InventoryMoveEvent(this);	
		PlayerBookOpen evPBO = new PlayerBookOpen(this);
		

//Load Commands
		
		CMDExecuter.load_COMMANDS();
		
//Test loader

	}
	

	public void onDisable() {
	}
	
	public i18n geti18n() {
		return inI18N;
	}
	
	public exceptionHandler getExeptionHandler() {
		return inException;
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
