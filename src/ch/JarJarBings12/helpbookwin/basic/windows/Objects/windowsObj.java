package ch.JarJarBings12.helpbookwin.basic.windows.Objects;

import org.bukkit.Location;

import ch.JarJarBings12.helpbookwin.basic.files.filelist;
import ch.JarJarBings12.helpbookwin.basic.item.Objects.loaders.bookObj;
import ch.JarJarBings12.helpbookwin.basic.item.Objects.loaders.buttonLoader;

public class windowsObj implements WindowsInterface {
	private final String SYSTEMNAME;
	private String DISPLAYNAME;
	private String PERMISSION;
	private int LINES;
	private boolean ENABLED;
	private boolean OPENSOUND;
	
	public windowsObj(String SystemName, String DisplayName, String Permission, int lines, boolean Enabled, boolean OpenSound) {
		this.SYSTEMNAME = SystemName;
		this.DISPLAYNAME = DisplayName;
		this.PERMISSION = Permission;
		this.LINES = lines;
		this.ENABLED = Enabled;
		this.OPENSOUND = OpenSound;
	}
	
	/* Get the System Name of a Window this Name you can't change! </br>
	 * You can only change it when the Server isn't running if you change it when the </br>
	 * the Server is Running it will override by Stop the Server.*/
	@Override
	public String getSystemName() {
		return this.SYSTEMNAME;
	}
	
	/* Get the Display Name of a Window this Name you can change</br>
	 * to rename a Window use the <h4>setDisplayName</h4> Method you see the Change not after </br>
	 * you use the Method the plugin save ale Changes in by Stop the Server. */
	@Override
	public String getDisplayName() {
		return this.DISPLAYNAME;
	}
	
	/* Get the Permission of a Window you can change the Permission with </br>
	 * <h4>setPermission</h4> Method the changes in the Files you can see after the Server is reload or stop*/
	@Override
	public String getPermission() {
		return this.PERMISSION;
	}
	
	/* Get the Lines of a Window you can change the Lines of a Window with </br>
	 * <h4>setLines</4> the Max Lines you can have is 6 Lines (54 Slots) the </br>
	 * changes you can see after the Server is reloading or stop */
	@Override
	public int getLines() {
		return this.LINES;
	}
	
	/* Check is a Window Enabled or Disabled */
	@Override
	public boolean isEnabled() {
		return this.ENABLED;
	}
	
	/* Set Enabled or Disabled*/
	@Override 
	public void isEnabled(boolean Enabled) {
		this.ENABLED = Enabled;
	}
	
	/* Check have a Window a OpenSound or not*/
	@Override
	public boolean hasOpenSound() {
		return this.OPENSOUND;
	}
	
	/* Set a the Windows OpenSound Enabled or Disabled */
	@Override
	public void hasOpenSound(boolean Enabled) {
		this.OPENSOUND = Enabled;
	}
	
	/* Set the DisplayName of a Window */
	@Override
	public void setDisplayName(String DisplayName) {	
		this.DISPLAYNAME = DisplayName;
	}
	
	/* Set the Permission to Open a Window */
	@Override
	public void setPermission(String Permission) {
		this.PERMISSION = Permission;
	}
	
	/* Set the Lines of a Window max 6 Lines*/
	@Override
	public void setLines(int Lines) {
		this.LINES = Lines;
	}	
	
}
