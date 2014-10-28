package ch.JarJarBings12.helpbook.util;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import net.minecraft.server.v1_7_R3.IBlockAccess;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.BookMeta;

import ch.JarJarBings12.helpbook.Core.Core;

public class BookStorage {
	/**
	 * @author JarJarBings12
	 */
	public BookStorage(Core inCore) {
		Core.inCore = inCore;
	}
	
	/**
	 * Try to save the Book File
	 */
	
	public void save_book() {
		try {
			BookFiles.yamlbooks.save(BookFiles.books);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
//-----
	
	/**
	 * Setup the Default configuration  
	 * @author JarJarBings12
	 */
	
	public void load_BookFile() {
		BookFiles.yamlbooks.addDefault("HelpBook.Language", "en");
		BookFiles.yamlbooks.addDefault("HelpBook.Window.Name", "§aFAQ");
		
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
	
//-----
	
	/**
	 * reset a Book slot by a Integer 
	 * If you delete a Book slot it is deletet it can't be undo 
	 * @author JarJarBings12
	 */
	public void resetBook(int BookSlot) {
		BookFiles.yamlbooks.addDefault("Book.Book"+BookSlot+".enable", true);
		BookFiles.yamlbooks.addDefault("Book.Book"+BookSlot+".Title", "TestBook");
		BookFiles.yamlbooks.addDefault("Book.Book"+BookSlot+".Author", "TestBook");
		BookFiles.yamlbooks.addDefault("Book.Book"+BookSlot+".Pages", "");
		save_book();
		Core.inCore.getConfigLoader().setBookNames();
	}
	
//-----
	
	/**
	 * add a Book by a @param Integer with a @param ItemStack and a @param Player.
	 * @author JarJarBings12
	 */
	public void addBook(int BookSlot, ItemStack rawbook, Player pl) {
		ItemStack book = new ItemStack(rawbook);
		
		BookMeta metadata = (BookMeta)book.getItemMeta();
		if(BookSlot > 9) {
			pl.sendMessage(Core.inCore.geti18n().getMessage("tohighnummber"));
		}
		
		BookFiles.yamlbooks.set("Book.Book"+BookSlot+".Title", ChatColor.translateAlternateColorCodes('&', metadata.getTitle()));
		BookFiles.yamlbooks.set("Book.Book"+BookSlot+".Author", ChatColor.translateAlternateColorCodes('&', metadata.getAuthor()));
		BookFiles.yamlbooks.set("Book.Book"+BookSlot+".Pages", metadata.getPages());
		String slot = "" + BookSlot; 
		pl.sendMessage(Core.inCore.geti18n().getMessage("savebookas").replace("%slot", slot));
		save_book();
		Core.inCore.getConfigLoader().setBookNames();
	}
	
//-----
	
	/**
	 * get a Book by a @param BookTitle and @return ItemStack.
	 * @author JarJarBings12
	 */
	public ItemStack getBook(String booktitle) {
		int i = ConfigLoader.getBookInteger(booktitle);
		ItemStack book = new ItemStack(Material.WRITTEN_BOOK);
		BookMeta metadata = (BookMeta)book.getItemMeta();
		
		metadata.setTitle(BookFiles.yamlbooks.getString("Book.Book"+i+".Title"));
		metadata.setAuthor(BookFiles.yamlbooks.getString("Book.Book"+i+".Author"));
		metadata.setPages(BookFiles.yamlbooks.getStringList("Book.Book"+i+".Pages"));
		book.setItemMeta(metadata);
		
		return book;
	}
	
//-----	
	
	/**
	 * set a Book title with a @param ItemStack and a @param title.
	 * @author JarJarBings12
	 */
	public ItemStack setTitle(ItemStack book, String Title) {
		
		BookMeta metadata = (BookMeta)book.getItemMeta();
		metadata.setTitle(Title.length() < 16 ? Title : Title.substring(0, 16));
		book.setItemMeta(metadata);
		return book;
		
	}
	
//-----
	
	/**
	 * set the Author of a Book with ha @param ItemStack and a @param Author.
	 * @return ItemStack
	 * @author JarJarBings12   
	 */
	public ItemStack setAuthor(ItemStack book, String Author){
		BookMeta metadata = (BookMeta)book.getItemMeta();
		metadata.setAuthor(Author.length() < 16 ? Author : Author.substring(0, 16));
		book.setItemMeta(metadata);
		return book;
	}
	
//-----
	
	/**
	 * 
	 * Give you a Writable Book with @param ItemStack.
	 * @return ItemStack
	 */
	public ItemStack editBook(ItemStack book) {
		ItemStack unsavebook = new ItemStack(Material.BOOK_AND_QUILL);
		
		BookMeta metadataold = (BookMeta)book.getItemMeta();
		BookMeta metadatanew = (BookMeta)unsavebook.getItemMeta();
		
		metadatanew.setPages(metadataold.getPages());
		unsavebook.setItemMeta(metadatanew);
		return unsavebook;
	}
}