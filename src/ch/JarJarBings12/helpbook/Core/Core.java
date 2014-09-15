package ch.JarJarBings12.helpbook.Core;

import org.bukkit.plugin.java.JavaPlugin;

import ch.JarJarBings12.helpbook.i18n.i18n;

public class Core extends JavaPlugin {
	
	public static Core inCore;
	private static i18n inI18N;
	
	public void onEnable() {
		inCore = this;
		inI18N = new i18n(this);
	}
	
	public void onDisable() {
		
	}
	
	public i18n geti18n() {
		return inI18N;
	}
}
