package ch.JarJarBings12.helpbookwin.basic.item.Objects.loaders.typesinterfaces;

import java.util.List;

import javax.swing.text.MaskFormatter;

import org.bukkit.Material;

import ch.JarJarBings12.helpbookwin.basic.windows.Objects.windowsObj;

public interface ButtonConfigInterface extends DefaultConfigInterface {
	
	/* Methods to read Objects out of the Configuration */
	public String getConfigItemActionType(windowsObj w, int Slot); 
	public String getConfigItemActionPermission(windowsObj w, int Slot); 
	public String getConfigItemActionMessage(windowsObj w, int Slot); 
	
	/* Methods to write the Object Data into the Configuration */
	public void setConfigItemActionType(windowsObj w, int Slot, String ActionType); 
	public void setConfigItemActionPermission(windowsObj w, int Slot, String ActionPermission); 
	public void setConfigItemActionMessage(windowsObj w, int Slot, String ActionMessage); 
	

}
