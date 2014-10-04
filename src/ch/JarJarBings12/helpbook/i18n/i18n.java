package ch.JarJarBings12.helpbook.i18n;

import java.util.Locale;
import java.util.ResourceBundle;

import ch.JarJarBings12.helpbook.Core.Core;

public class i18n {
	public i18n(Core inCore) {
		Core.inCore = inCore;
	}
	
	/**
	 * Language manager
	 * Show: i18n.*.properties
	 */
	
	private static ResourceBundle bundle = ResourceBundle.getBundle("i18n/messages");
	private static String activelang = null;

	/**
	 * set Language 
	 * Locale = new Locale("<locale>");
	 * @param Need a locale to load the message you can make a locale with >> x = new Locale("<LOCALE>");
	 */
	
	public void setLanguage(Locale locale) {
		bundle = ResourceBundle.getBundle("i18n/messages", locale);
		activelang = locale.toString();
	}
	
	/**
	 * return the active language
	 * @return Return the active language in a string form.
	 * @param No parameters
	 */
	
	public String getLanguage() {
		return activelang;
	}
	
	/**
	 * 
	 * @param Need a key word
	 * @return Return the message of the key 
	 */
	
	public String getMessage(String key) {
		String r = bundle.getString(key);
		return "§6[HelpBook]§f"+r;
	}
	
	/**
	 * 
	 * @param Need a key of a message
	 * @return Return a boolean True = key word exist false = contain this key not
	 */
	
	public boolean containsKey(String key) {
		return bundle.containsKey(key);
	}
}
