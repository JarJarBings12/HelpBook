package ch.JarJarBings12.helpbookwin.basic.objects;

import ch.JarJarBings12.helpbookwin.basic.item.Objects.loaders.bookLoader;
import ch.JarJarBings12.helpbookwin.basic.item.Objects.loaders.buttonLoader;
import ch.JarJarBings12.helpbookwin.basic.item.Objects.loaders.labelLoader;
import ch.JarJarBings12.helpbookwin.basic.windows.Objects.windowsObjLoader;

public class WinBasic {
	
	public static WinBasic inWindow;
	
	private static windowsObjLoader winload;
	
	private static bookLoader bookload;
	
	private static labelLoader labelload;
	
	private static buttonLoader buttonload;
	
	public void setUp() {
		
		winload = new windowsObjLoader(this);		
		bookload = new bookLoader(this);	
		labelload = new labelLoader(this);
		buttonload = new buttonLoader(this);
		
	}

	public windowsObjLoader getWindowLoader() {
		return this.winload;
	}
	
	public bookLoader getBookLoader() {
		return this.bookload;
	}
	
	public labelLoader getLabelLoader() {
		return this.labelload;
	}
	
	public buttonLoader getButtonLoader() {
		return this.buttonload;
	}
	
}
