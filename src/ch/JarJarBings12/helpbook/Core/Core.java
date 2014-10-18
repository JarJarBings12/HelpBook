package ch.JarJarBings12.helpbook.Core;

import java.util.ArrayList;
import java.util.List;
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
import ch.JarJarBings12.helpbook.Windows.dynListener.dynamicWindowMoveEvent;
import ch.JarJarBings12.helpbook.Windows.dynListener.dynamicWindowUserCloseInventory;
import ch.JarJarBings12.helpbook.Windows.dynListener.dynamicWindowUserKickEvent;
import ch.JarJarBings12.helpbook.Windows.dynListener.dynamicWindowUserQuitEvent;
import ch.JarJarBings12.helpbook.i18n.i18n;
import ch.JarJarBings12.helpbook.util.BookFiles;
import ch.JarJarBings12.helpbook.util.BookStorage;
import ch.JarJarBings12.helpbook.util.ConfigLoader;
import ch.JarJarBings12.helpbook.util.util;

public class Core extends JavaPlugin {
	/**
	 * @author JarJarBings12
	 */
	public static Core inCore;
	private static i18n inI18N;
	private static BookStorage inBookStore;
	private static ConfigLoader inConfigLoader;
	private static dynConfig inDynConfig;
	public static PluginDescriptionFile desc;
	
	public void onEnable() {
			System.out.println("[UserHelper]Load UserHelper" );
	//Define Variables
		inCore = this;
		inI18N = new i18n(this);
		inBookStore = new BookStorage(this);
		desc = this.getDescription();
		inConfigLoader = new ConfigLoader(this);
		inDynConfig = new dynConfig(this);
		
			System.out.println(util.helpbook + "[Info]Load Config...");
	//Setup Configurations and Storage
		inDynConfig.createCACHE();
		inDynConfig.createCONFIG();
		inDynConfig.createSTORAG();
			System.out.println(util.helpbook + "[Info]Load Book Files...");
	//Load Book Storage
		getBookStorage().load_BookFile();
		
			System.out.println(util.helpbook + "[Info]Setup Language...");
	//Load Language
		String slocale = BookFiles.yamlbooks.getString("HelpBook.Language");
		Locale locale = new Locale(slocale);
		geti18n().setLanguage(locale);		
		
			System.out.println(util.helpbook + "[Info]Setup Config Datas");	
	//Setup Booleanas 
		getConfigLoader().setBooleans();
		getConfigLoader().setBookNames();
		getConfigLoader().update_WINDOWTITLE();
		
			System.out.println(util.helpbook + "[Info]Start Listeners...");
	//Setup Listeners
		SignPressEvent evSigenTAGCreate = new SignPressEvent(this);
		InventoryMoveEvent evIME = new InventoryMoveEvent(this);	
		PlayerBookOpen evPBO = new PlayerBookOpen(this);
			
		dynamicWindowUserKickEvent evDWUK = new dynamicWindowUserKickEvent(this);
		dynamicWindowUserQuitEvent evWUQ  = new dynamicWindowUserQuitEvent(this);
		dynamicWindowMoveEvent evWME = new dynamicWindowMoveEvent(this);
		dynamicWindowUserCloseInventory evWUCI= new dynamicWindowUserCloseInventory(this);
			System.out.println(util.helpbook + "[Info]Prepare Commands...");
			dynConfig.initializeCacheList();
	//Setup Commands
		CMDExecuter.load_COMMANDS();
		
		if(!(dynFILELIST.co.getBoolean("options.storage.cache.OPTIONS.ReadByStart") != true)) {
			System.out.println(util.helpbook + "[Info]Windows cache don't load by start!");
			return;
		} else {
			System.out.println(util.helpbook + "[Info]Save Window names into Ram...");
			dynConfig.initializeCacheList();
		}
	}
	

	public void onDisable() {
		System.out.println(util.helpbook + "[Info]Save Window and Cache Storage.");
		dynWindowCore.INVENTORYS.add("d");
		dynConfig.saveCache();
		dynConfig.saveStorage();
	}
	
/*/Class returns/*/
	
	/**
	 * Return Language Class
	 * @ClassPath ch.JarJarBings12.helpbook.i18n.i18n
	 */
	public i18n geti18n() {
		return inI18N;
	}
	
	/**
	 * Return BookStorage Class
	 * @ClassPath ch.JarJarBings12.helpbook.util.BookStorage
	 */
	public BookStorage getBookStorage() {
		return inBookStore;
	}
	
	/**
	 * Return Configuration Loader
	 *@ClassPath ch.JarJarBings12.helpbook.util.ConfigLoader
	 */
	public ConfigLoader getConfigLoader() {
		return inConfigLoader;
	}
	
	/**
	 * Return Configuration Loader
	 *@ClassPath plugin.yml
	 */
	public PluginDescriptionFile getPluginDescription() {
		return desc;
	}
}
