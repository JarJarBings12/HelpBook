package ch.JarJarBings12.helpbookwin.basic.item.Objects.loaders.typesinterfaces;

import java.util.List;

import ch.JarJarBings12.helpbookwin.basic.item.Objects.loaders.bookObj;
import ch.JarJarBings12.helpbookwin.basic.windows.Objects.windowsObj;

public interface BookConfigInterface {
	public boolean isEnabled(windowsObj w, int Slot);
	public String getConfigBookAuthor(windowsObj w, int Slot);
	public String getConfigBookTitle(windowsObj w, int Slot);
	public List<String> getConfigBookPages(windowsObj w, int Slot);
	public List<String> getConfigBookLore(windowsObj w, int Slot);
	public void isEnabled(windowsObj w, int Slot, boolean Enabled);
	public void setConfigBookAuthor(windowsObj w, bookObj book, int Slot);
	public void setConfigBookTitle(windowsObj w, bookObj book, int Slot);
	public void setConfigBookPages(windowsObj w, bookObj book, int Slot);
	public void setConfigBookLore(windowsObj w, bookObj book, int Slot);
}
