package ch.JarJarBings12.helpbookwin.basic.windows.Objects;

import java.io.File;
import java.io.IOException;
import java.util.List;

import ch.JarJarBings12.helpbook.Core.Core;
import ch.JarJarBings12.helpbookwin.basic.files.filelist;
import ch.JarJarBings12.helpbookwin.basic.objects.JObjects;
import ch.JarJarBings12.helpbookwin.basic.objects.WinBasic;

public class windowsObjLoader implements WinConfigInterface {
	
	public windowsObjLoader(WinBasic inWindow) {
		WinBasic.inWindow = inWindow;
	}
	public windowsObjLoader(Core core) {
		Core.inCore = core;
	}
	public void initializeCacheList() {
		JObjects.cache.clear();
		if(filelist.ca.getList("windows.cache") != null) {
			List INV = filelist.ca.getList("windows.cache");
			for(Object w : INV) {
				JObjects.cache.add(w.toString());
			}
			return;
		} else {
			System.out.println("[HelpBook:@HelpBookWinBasic]Windows list is Empty");
		}
	}
	/*Load all Window Objects out of the Storage. */
	public void loadWindowObjects() {
		for(String ws : JObjects.cache) {
			windowsObj w = new windowsObj(ws, getConfigWindowDisplayName(ws), getConfigPermission(ws), getConfigWindowLines(ws), getConfigWindowEnabled(ws), getConfigWindowOpenSound(ws));
			JObjects.windows.add(w);
		}
	}
	
	/* Save all Window Objects in the Storage
	 * this is doing all X mins and on Stop or reload of the Server.
	 * Or you add a Command*/
	public void saveWindowObjects() {
		for(windowsObj o : JObjects.windows) {
			setConfigWindowDisplayName(o);
			setConfigWindowEnabled(o);
			setConfigWindowLines(o);
			setConfigWindowOpenSound(o);
			setConfigPermission(o);
			try {
				filelist.s.save(filelist.storage);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	/* Get the Display Name of a Window*/
	@Override
	public String getConfigWindowDisplayName(String Window) {
		return filelist.s.getString("windows.window."+Window+".DISPLAYNAME");
	}
	
	/* Get how much Lines this Window have */
	@Override
	public int getConfigWindowLines(String Window) {
		return filelist.s.getInt("windows.window."+Window+".LINES");
	}
	
	/* Get is this Window Enabled */
	@Override
	public boolean getConfigWindowEnabled(String Window) {
		return filelist.s.getBoolean("windows.window."+Window+".ENABLED");
	}
	
	/* Get is Open Sound for this Window Enabled*/
	@Override
	public boolean getConfigWindowOpenSound(String Window) {
		return filelist.s.getBoolean("windows.window."+Window+".WINDOWOPENSOUND");
	}
	
	/* Get the Permission of a Window you can set it with */
	@Override
	public String getConfigPermission(String Window) {
		return filelist.s.getString("windows.window."+Window+".PERMISSION");
	}

	/* Set the DisplayName of a Window*/
	@Override
	public void setConfigWindowDisplayName(windowsObj w) {
		filelist.s.getString("windows.window."+w.getSystemName()+".DISPLAYNAME", w.getDisplayName());
	}
	
	/* Set the Lines of a Window*/
	@Override
	public void setConfigWindowLines(windowsObj w) {
		filelist.s.set("windows.window."+w.getSystemName()+".LINES", w.getLines());
	}

	/* Set Windows is Enabled on true or false*/
	@Override
	public void setConfigWindowEnabled(windowsObj w) {
		filelist.s.getBoolean("windows.window."+w.getSystemName()+".ENABLED", w.isEnabled());
	}
	
	/* Set the Window Open Sound on false or true*/
	@Override
	public void setConfigWindowOpenSound(windowsObj w) {
		filelist.s.set("windows.window."+w.getSystemName()+".WINDOWOPENSOUND", w.hasOpenSound());
		
	}

	@
	/* Set the Permission of a Window */
	Override
	public void setConfigPermission(windowsObj w) {
		filelist.s.set("windows.window."+w.getSystemName()+".PERMISSION", w.getPermission());
	}
}
