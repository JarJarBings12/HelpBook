package ch.JarJarBings12.helpbook.Core;

import java.util.Locale;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.java.JavaPlugin;

import ch.JarJarBings12.helpbook.BookEvent.InventoryMoveEvent;
import ch.JarJarBings12.helpbook.BookEvent.PlayerBookOpen;
import ch.JarJarBings12.helpbook.BookEvent.SignPressEvent;
import ch.JarJarBings12.helpbook.Commands.CMDExecuter;
import ch.JarJarBings12.helpbook.NotificationCenter.NotificationCenterC;
import ch.JarJarBings12.helpbook.Windows.BuildWindows;
import ch.JarJarBings12.helpbook.Windows.HBOS;
import ch.JarJarBings12.helpbook.Windows.dynConfig;
import ch.JarJarBings12.helpbook.Windows.dynFILELIST;
import ch.JarJarBings12.helpbook.Windows.dynWindowCore;
import ch.JarJarBings12.helpbook.Windows.dynListener.dynamicWindowUserKickEvent;
import ch.JarJarBings12.helpbook.Windows.dynListener.dynamicWindowUserQuitEvent;
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
	private static dynConfig inDynConfig;
	public static PluginDescriptionFile desc;
	
	public void onEnable() {
		
		System.out.println("[UserHelper]Load UserHelper" );
//Define the Variables
		
		inCore = this;
		inI18N = new i18n(this);
		inBookStore = new BookStorage(this);
		desc = this.getDescription();
		inConfigLoader = new ConfigLoader(this);
		inDynConfig = new dynConfig(this);
		
		System.out.println(util.helpbook + "[Info]Load Config...");
		inDynConfig.createCACHE();
		inDynConfig.createCONFIG();
		inDynConfig.createSTORAG();
		
//Load Book File
		getBookStorage().load_BookFile();
		
//Load Language
		
		System.out.println(util.helpbook + "[Info]Setup Language...");
		String slocale = BookFiles.yamlbooks.getString("HelpBook.Language");
		Locale locale = new Locale(slocale);
		
		geti18n().setLanguage(locale);		
		
//Load Book File 
		
		getConfigLoader().setBooleans();
		getConfigLoader().setBookNames();
		getConfigLoader().update_WINDOWTITLE();

//Load Buttons
		
	
//Load Events
		System.out.println(util.helpbook + "[Info]Start Listeners...");
		SignPressEvent evSigenTAGCreate = new SignPressEvent(this);
		InventoryMoveEvent evIME = new InventoryMoveEvent(this);	
		PlayerBookOpen evPBO = new PlayerBookOpen(this);
		
		dynamicWindowUserKickEvent evDWUK = new dynamicWindowUserKickEvent(this);
		dynamicWindowUserQuitEvent evWUQ  = new dynamicWindowUserQuitEvent(this);
		
//Load Commands
		System.out.println(util.helpbook + "[Info]Prepare Commands...");
		CMDExecuter.load_COMMANDS();
		
//Test loader
		ItemStack d = new ItemStack(Material.BUCKET);
		Player pl = Bukkit.getPlayer("TEST");
		HBOS.setAsSlot("TEST", "BUTTON", 1, d, pl);
		if(!(dynFILELIST.co.getBoolean("options.storage.cache.OPTIONS.ReadByStart") != true)) {
			System.out.println(util.helpbook + "[Info]Windows cache don't load by start!");
			return;
		} else {
			System.out.println(util.helpbook + "[Info]Save Window names into Ram...");
			dynConfig.initializeCacheList();
		}
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
