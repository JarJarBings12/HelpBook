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
import ch.JarJarBings12.helpbook.Windows.BuildWindows;
import ch.JarJarBings12.helpbook.Windows.HBOS;
import ch.JarJarBings12.helpbook.Windows.dynConfig;
import ch.JarJarBings12.helpbook.Windows.dynFILELIST;
import ch.JarJarBings12.helpbook.Windows.dynWindowCore;
import ch.JarJarBings12.helpbook.Windows.Windows.Windows_Action_System;
import ch.JarJarBings12.helpbook.Windows.Windows.Windows_System;
import ch.JarJarBings12.helpbook.Windows.Windows.Windows_Utils;
import ch.JarJarBings12.helpbook.Windows.dynListener.dynamicWindowMoveEvent;
import ch.JarJarBings12.helpbook.Windows.dynListener.dynamicWindowUserCloseInventory;
import ch.JarJarBings12.helpbook.Windows.dynListener.dynamicWindowUserKickEvent;
import ch.JarJarBings12.helpbook.Windows.dynListener.dynamicWindowUserQuitEvent;
import ch.JarJarBings12.helpbook.i18n.i18n;
import ch.JarJarBings12.helpbook.util.BookFiles;
import ch.JarJarBings12.helpbook.util.BookStorage;
import ch.JarJarBings12.helpbook.util.ConfigLoader;
import ch.JarJarBings12.helpbook.util.util;
import ch.JarJarBings12.helpbookwin.basic.configuration.cache;
import ch.JarJarBings12.helpbookwin.basic.configuration.storage;
import ch.JarJarBings12.helpbookwin.basic.item.Objects.loaders.buttonLoader;
import ch.JarJarBings12.helpbookwin.basic.item.Objects.loaders.labelLoader;
import ch.JarJarBings12.helpbookwin.basic.objects.JObjects;
import ch.JarJarBings12.helpbookwin.basic.objects.SubBasic;
import ch.JarJarBings12.helpbookwin.basic.objects.WinBasic;
import ch.JarJarBings12.helpbookwin.basic.render.WindowRender;
import ch.JarJarBings12.helpbookwin.basic.windows.Objects.windowsObj;
import ch.JarJarBings12.helpbookwin.basic.windows.Objects.windowsObjLoader;

public class Core extends JavaPlugin {
	/**
	 * @author JarJarBings12
	 */
	public static Core inCore;
	
	private static i18n inI18N;
	
	private static windowsObjLoader w;
	
	private static BookStorage inBookStore;
	
	private static ConfigLoader inConfigLoader;
	
	private static dynConfig inDynConfig;
	
	public static PluginDescriptionFile desc;
	
	public static windowsObjLoader d;
	public static WindowRender dd;

	
	private static SubBasic sb;
	/*Startup*/
	@Override
	public void onEnable() {
		inCore = this;
		dd = new WindowRender(this);
		d = new windowsObjLoader(this);
	
		inI18N = new i18n(this);
		
		inBookStore = new BookStorage(this);
		
		desc = this.getDescription();
		
		inConfigLoader = new ConfigLoader(this);
		
		inDynConfig = new dynConfig(this);
		
		inDynConfig.createCACHE();
		
		inDynConfig.createCONFIG();
		
		inDynConfig.createSTORAG();
		
		
		sb = new SubBasic(this);
		sb.createWindow("HALLO", 1);
		sb.createWindow("1", 1);
		sb.createWindow("2", 1);
		storage.createStorage();
		getBookStorage().load_BookFile();
		/* Get Language of of the Configuration */
		String slocale = BookFiles.yamlbooks.getString("HelpBook.Language");
		
		/* Define new Locale */
		Locale locale = new Locale(slocale);

		d.initializeCacheList();
		d.loadWindowObjects();
		for(windowsObj w : JObjects.windows) {
			System.out.println(w.getDisplayName());
		}
		/* Load Language */
		geti18n().setLanguage(locale);		
		
		/* Load */	
		dynamicWindowMoveEvent evWME = new dynamicWindowMoveEvent(this);
		
		/* Execute all Commands */
		CMDExecuter.load_COMMANDS();
		
	}
	
	/*Shutdown*/
	@Override
	public void onDisable() {
		System.out.println(util.helpbook + "[Info]Save Window and Cache Storage.");
		cache.saveCacheToFile();
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
