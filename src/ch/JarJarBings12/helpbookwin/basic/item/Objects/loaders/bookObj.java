package ch.JarJarBings12.helpbookwin.basic.item.Objects.loaders;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Material;

public class bookObj {
	private final String WINDOW;
	private int SLOT;
	private String TYPE;
	private boolean ENABLED;
	private String TITLE;
	private String AUTHOR;
	private List<String> PAGES = new ArrayList();
	private List<String> LORE = new ArrayList();
	
	public bookObj(String WINDOW, int Slot, String Type, boolean enabled, String Title, String Author, List<String> Pages, List<String> Lore) {
		this.WINDOW = WINDOW;
		this.SLOT = Slot;
		this.ENABLED = enabled; 
		this.TYPE = Type;
		this.LORE = Lore;
	}
	
	public int getSlot() {
		return this.SLOT;
	}
	
	public void setBookAtSlot(int Slot) {
		this.SLOT = Slot;
	}
	
	public String getType() {
		return this.TYPE;
	}
	
	public void setType(String Type) {
		this.TYPE = Type;
	}
	
	public boolean isEnabled() {
		return this.isEnabled();
	}
	
	public void isEnabled(boolean Enabled) {
		this.ENABLED = Enabled;
	}

	public String getTitle()  {
		return this.TITLE;
	}
	
	public void setTitle(String Title) {
		this.TITLE = Title;
	}
	
	public String getAuthor() {
		return this.AUTHOR;
	}
	
	public void setAuthor(String Author) {
		this.AUTHOR = Author;
	}
	
	public List<String> getPages() {
		return this.PAGES;
	}
	
	public void setPages(List<String> Pages) {
		this.PAGES = Pages;
	}
	
	public List<String> getLore() {
		return this.LORE;
	}
	
	public void setLore(List<String> Lore) {
		this.LORE = Lore;
	}
	
}
