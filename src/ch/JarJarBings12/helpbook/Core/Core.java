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
		inCore = this;
		inI18N = new i18n(this);
		inBookStore = new BookStorage(this);
		desc = this.getDescription();
		inConfigLoader = new ConfigLoader(this);
		inDynConfig = new dynConfig(this);
		inDynConfig.createCACHE();
		inDynConfig.createCONFIG();
		inDynConfig.createSTORAG();
		
		getBookStorage().load_BookFile();

		String slocale = BookFiles.yamlbooks.getString("HelpBook.Language");
		Locale locale = new Locale(slocale);
		geti18n().setLanguage(locale);		

//		SignPressEvent evSigenTAGCreate = new SignPressEvent(this);
//		InventoryMoveEvent evIME = new InventoryMoveEvent(this);	
//		PlayerBookOpen evPBO = new PlayerBookOpen(this);
//			
//		dynamicWindowUserKickEvent evDWUK = new dynamicWindowUserKickEvent(this);
//		dynamicWindowUserQuitEvent evWUQ  = new dynamicWindowUserQuitEvent(this);
//		dynamicWindowMoveEvent evWME = new dynamicWindowMoveEvent(this);
//		dynamicWindowUserCloseInventory evWUCI= new dynamicWindowUserCloseInventory(this);
		
		
		
		CMDExecuter.load_COMMANDS();
	}
	

	public void onDisable() {
		System.out.println(util.helpbook + "[Info]Save Window and Cache Storage.");
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
