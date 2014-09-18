package ch.JarJarBings12.helpbook.util;

import java.io.IOException;
import java.util.HashMap;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.BookMeta;

import ch.JarJarBings12.helpbook.Core.Core;
import ch.JarJarBings12.helpbook.NotificationCenter.NotificationCenterC;

public class BookStorage {
	public BookStorage(Core inCore) {
		Core.inCore = inCore;
	}
	public void save_book() {
		try {
			BookFiles.yamlbooks.save(BookFiles.books);
			NotificationCenterC.INFO.consoleNOTE(Core.inCore.geti18n().getMessage("overwritebook"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void load_BookFile() {
		BookFiles.yamlbooks.addDefault("Book.Book1.enable", true);
		BookFiles.yamlbooks.addDefault("Book.Book1.Title", "TestBook");
		BookFiles.yamlbooks.addDefault("Book.Book1.Author", "TestBook");
		BookFiles.yamlbooks.addDefault("Book.Book1.Pages", "");
		
		BookFiles.yamlbooks.addDefault("Book.Book2.enable", true);
		BookFiles.yamlbooks.addDefault("Book.Book2.Title", "TestBook");
		BookFiles.yamlbooks.addDefault("Book.Book2.Author", "TestBook");
		BookFiles.yamlbooks.addDefault("Book.Book2.Pages", "");
		
		BookFiles.yamlbooks.addDefault("Book.Book3.enable", true);
		BookFiles.yamlbooks.addDefault("Book.Book3.Title", "TestBook");
		BookFiles.yamlbooks.addDefault("Book.Book3.Author", "TestBook");
		BookFiles.yamlbooks.addDefault("Book.Book3.Pages", "");
		
		BookFiles.yamlbooks.addDefault("Book.Book4.enable", true);
		BookFiles.yamlbooks.addDefault("Book.Book4.Title", "TestBook");
		BookFiles.yamlbooks.addDefault("Book.Book4.Author", "TestBook");
		BookFiles.yamlbooks.addDefault("Book.Book4.Pages", "");
		
		BookFiles.yamlbooks.addDefault("Book.Book5.enable", true);
		BookFiles.yamlbooks.addDefault("Book.Book5.Title", "TestBook");
		BookFiles.yamlbooks.addDefault("Book.Book5.Author", "TestBook");
		BookFiles.yamlbooks.addDefault("Book.Book5.Pages", "");
		
		BookFiles.yamlbooks.addDefault("Book.Book6.enable", true);
		BookFiles.yamlbooks.addDefault("Book.Book6.Title", "TestBook");
		BookFiles.yamlbooks.addDefault("Book.Book6.Author", "TestBook");
		BookFiles.yamlbooks.addDefault("Book.Book6.Pages", "");
		
		BookFiles.yamlbooks.addDefault("Book.Book7.enable", true);
		BookFiles.yamlbooks.addDefault("Book.Book7.Title", "TestBook");
		BookFiles.yamlbooks.addDefault("Book.Book7.Author", "TestBook");
		BookFiles.yamlbooks.addDefault("Book.Book7.Pages", "");
		
		BookFiles.yamlbooks.addDefault("Book.Book8.enable", true);
		BookFiles.yamlbooks.addDefault("Book.Book8.Title", "TestBook");
		BookFiles.yamlbooks.addDefault("Book.Book8.Author", "TestBook");
		BookFiles.yamlbooks.addDefault("Book.Book8.Pages", "");
		
		BookFiles.yamlbooks.addDefault("Book.Book9.enable", true);
		BookFiles.yamlbooks.addDefault("Book.Book9.Title", "TestBook");
		BookFiles.yamlbooks.addDefault("Book.Book9.Author", "TestBook");
		BookFiles.yamlbooks.addDefault("Book.Book9.Pages", "");
		
		try {
			BookFiles.yamlbooks.options().copyDefaults(true);
			BookFiles.yamlbooks.save(BookFiles.books);
		} catch (Exception e) {
			
		}
	}
	
	public void addBook(int BookSlot, ItemStack rawbook, Player pl) {
		ItemStack book = new ItemStack(rawbook);
		if(!(book.getType() == Material.WRITTEN_BOOK)) {
			pl.sendMessage(Core.inCore.geti18n().getMessage(""));
		}
		
		BookMeta metadata = (BookMeta)book.getItemMeta();
		if(BookSlot < 9) {
			pl.sendMessage(Core.inCore.geti18n().getMessage(""));
		}
		
		BookFiles.yamlbooks.set("Book.Book"+BookSlot+".Title", metadata.getTitle());
		BookFiles.yamlbooks.set("Book.Book"+BookSlot+".Author", metadata.getAuthor());
		BookFiles.yamlbooks.set("Book.Book"+BookSlot+".Pages", metadata.getPages());
	}
	
	public ItemStack getBook(int rawbook) {
		ItemStack book = new ItemStack(Material.WRITTEN_BOOK);
		BookMeta metadata = (BookMeta)book.getItemMeta();
		
		metadata.setTitle(BookFiles.yamlbooks.getString("Book.Book"+rawbook+".Title"));
		metadata.setAuthor(BookFiles.yamlbooks.getString("Book.Book"+rawbook+".Author"));
		metadata.setAuthor(BookFiles.yamlbooks.getString("Book.Book"+rawbook+".Pages"));
		book.setItemMeta(metadata);
		
		return book;
	}
	
	public ItemStack setTitle(ItemStack book, String Title) {
		BookMeta metadata = (BookMeta)book.getItemMeta();
		metadata.setTitle(Title.length() < 16 ? Title : Title.substring(0, 16));
		book.setItemMeta(metadata);
		return book;
	}
	public ItemStack setAuthor(ItemStack book, String Author){
		BookMeta metadata = (BookMeta)book.getItemMeta();
		metadata.setAuthor(Author.length() < 16 ? Author : Author.substring(0, 16));
		book.setItemMeta(metadata);
		return book;
	}
}