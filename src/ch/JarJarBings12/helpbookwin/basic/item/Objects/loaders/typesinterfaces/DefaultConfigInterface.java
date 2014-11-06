package ch.JarJarBings12.helpbookwin.basic.item.Objects.loaders.typesinterfaces;

import java.util.List;

import org.bukkit.Material;

import ch.JarJarBings12.helpbookwin.basic.windows.Objects.windowsObj;

public interface DefaultConfigInterface {

	public String getConfigItemDisplayName(windowsObj w, int Slot); 
	public Material getConfigItemMaterial(windowsObj w, int Slot); 
	public boolean getConfigItemEnabled(windowsObj w, int Slot); 
	public String getConfigItemType(windowsObj w, int Slot); 
	public List<String> getConfigItemLore(windowsObj w, int Slot); 
	
	public void setConfigItemDisplayName(windowsObj w, int Slot, String DisplayName); 
	public void setConfigItemMaterial(windowsObj w, int Slot, Material Material); 
	public void setConfigItemEnabled(windowsObj w, int Slot, String Type); 
	public void setConfigItemType(windowsObj w, int Slot, String Type); 
	public void setConfigItemLore(windowsObj w, int Slot, List<String> Lore); 
}
