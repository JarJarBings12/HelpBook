package ch.JarJarBings12.helpbookwin.basic.item.Objects.loaders;

import java.util.List;

import org.bukkit.Material;

import com.avaje.ebeaninternal.server.jmx.MAdminAutofetch;

public class labelObj {
	private final String WINDOW;
	private int SLOT;
	private boolean ENABLED;
	private Material MATERIAL;
	private String DISPLAYNAME;
	private List<String> LORE;
	
	public labelObj(String Window, int Slot, boolean Enabled, Material material, String DisplayName, List<String> Lore) {
		this.WINDOW = Window;
		this.SLOT = Slot;
		this.ENABLED = Enabled;
		this.MATERIAL = material;
		this.DISPLAYNAME = DisplayName;
		this.LORE = Lore;
	}
	
	public int getSlot() {
		return this.SLOT;
	}
	
	public void setSlot(int Slot) {
		this.SLOT = Slot;
	}
	
	public boolean isEnabled() {
		return this.ENABLED;
	}
	
	public void isEnabled(boolean Enabled) {
		this.ENABLED = Enabled;
	}
	
	public Material getMaterial() {
		return this.MATERIAL;
	}
	
	public void setMaterial(Material material) {
		this.MATERIAL = material;
	}
	
	public String getDisplayName() {
		return this.DISPLAYNAME;
	}
	
	public void setDisplayName(String Name) {
		this.DISPLAYNAME = Name;
	}
	
	public List<String> getLore() {
		return this.LORE;
	}
	
	public void setLore(List<String> Lore) {
		this.LORE = Lore;
	}
}
