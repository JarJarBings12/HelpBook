package ch.JarJarBings12.helpbook.i18n;

import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

import ch.JarJarBings12.helpbook.Core.Core;

public class exceptionLoader {
	public exceptionLoader(Core inCore) {
		Core.inCore = inCore;
	}
	
	private static ResourceBundle exceptionBundle = null;
	
	public void setExceptionBundle() {
		Locale locale = new Locale("en");
		exceptionBundle = ResourceBundle.getBundle("exception/exception", locale);
	}
	
	public List<String> getException() {
		return null;
	}
}
