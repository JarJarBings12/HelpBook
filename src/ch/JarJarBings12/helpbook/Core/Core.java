package ch.JarJarBings12.helpbook.Core;

import org.bukkit.plugin.java.JavaPlugin;

import ch.JarJarBings12.helpbook.BookEvent.InventoryMoveEvent;
import ch.JarJarBings12.helpbook.Commands.CMDExecuter;
import ch.JarJarBings12.helpbook.i18n.i18n;
import ch.JarJarBings12.helpbook.util.BookStorage;

public class Core extends JavaPlugin {
	
	public static Core inCore;
	private static i18n inI18N;
	private static BookStorage inBookStore;
	public void onEnable() {
		inCore = this;
//		inI18N = new i18n(this);
		CMDExecuter.load_COMMANDS();
		inBookStore = new BookStorage(this);
		getBookStorage().loadBooksFile();
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
}
