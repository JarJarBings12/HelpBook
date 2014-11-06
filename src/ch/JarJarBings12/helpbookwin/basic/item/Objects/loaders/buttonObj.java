package ch.JarJarBings12.helpbookwin.basic.item.Objects.loaders;

import java.util.List;

import org.bukkit.Material;

public class buttonObj {
	private final String SYSTEMWINNAME;
	private int SLOT;
	private String DISPLAYNAME;
	private Material MATERIAL;
	private boolean ENABLED;
	private String TYPE;
	private List<String> LORE;
	private String ATYPE;
	private String APERMISSION;
	private String AMESSAGE;
	
	public buttonObj(String SystemWindowName, int Slot, String DisplayName, Material Material, Boolean isenabled, String Type, List<String> Lore, String AType, String APermission, String AMessage) {
		this.SYSTEMWINNAME = SystemWindowName;
		this.SLOT = Slot;
		this.DISPLAYNAME = DisplayName;
		this.MATERIAL = Material;
		this.ENABLED = isenabled; 
		this.TYPE = Type;
		this.LORE = Lore;
		this.ATYPE = AType;
		this.APERMISSION = APermission;
		this.AMESSAGE = AMessage;
	}
	
	public String getDisplayName() {
		return this.DISPLAYNAME;
	}

	public void setDisplayName(String DisplayName) {
		this.DISPLAYNAME = DisplayName;
	}

	public int getSlot() {
		return this.SLOT;
	}

	public void setSlot(int Slot) {
		this.SLOT = Slot;
	}

	public String getType() {
		return this.TYPE;
	}

	public void setType(String Type) {
		this.TYPE = Type;
	}

	public List<String> getLore() {
		return this.LORE;
	}

	public void setLore(List<String> Lore) {
		this.LORE = Lore;
	}
	
	public String getActionType() {
		return this.ATYPE;
	}

	public void setActionType(String Action) {
		this.ATYPE = Action;
	}

	public String getActionPermission() {
		return this.APERMISSION;
	}

	public void setActionPerission(String Permission) {
		this.APERMISSION = Permission;
	}

	public String getActionMessage() {
		return this.AMESSAGE;
	}

	public void setActionMessage(String Message) {
		this.AMESSAGE = Message;
	}
	public Material getMaterial() {
		return this.MATERIAL;
	}

	public void setMaterial(Material Material) {
		this.MATERIAL = Material;
		
	}

	public boolean isEnabled() {
		return this.ENABLED;
	}
	
	public void isEnabled(boolean Enabled) {
		this.ENABLED = Enabled;
	}
}
