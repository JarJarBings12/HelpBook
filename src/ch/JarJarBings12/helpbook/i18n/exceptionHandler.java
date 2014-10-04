package ch.JarJarBings12.helpbook.i18n;

import java.util.Locale;
import java.util.ResourceBundle;

import ch.JarJarBings12.helpbook.Core.Core;

public class exceptionHandler {
	public exceptionHandler(Core inCore) {
		Core.inCore = inCore;
	}
	
	private static ResourceBundle exceptionbundle = null;

	/**
	 * set Language 
	 * Locale = new Locale("<locale>");
	 * @param Need a locale to load the message you can make a locale with >> x = new Locale("<LOCALE>");
	 */
	
	public void setLanguage(Locale locale) {
		exceptionbundle = ResourceBundle.getBundle("exception/exceptions", locale);
	}
	
	public String getException(String exception) {
		String r = exceptionbundle.getString(exception);
		return r;
	}
}
