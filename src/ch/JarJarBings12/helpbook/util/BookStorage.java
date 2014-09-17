package ch.JarJarBings12.helpbook.util;

import java.awt.print.Book;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.BookMeta;

import com.mysql.jdbc.Buffer;

import ch.JarJarBings12.helpbook.Core.Core;
import ch.JarJarBings12.helpbook.NotificationCenter.NotificationCenterC;

public class BookStorage {
	public static final int max_title_length = 16;
	public static final int max_author_lenght = 16;
	
	private static int id = 0;
	private HashMap<String, Integer> nameindex = new HashMap<>();
	private ArrayList<Integer> index = new ArrayList<Integer>();
	
	public BookStorage(Core inCore) {
		Core.inCore = inCore;
	}
	
	/**
	 * Save all Books
	 */
	private void saveBooks() {
		try {
			BookFiles.yamlbooks.save(BookFiles.books);
		} catch (IOException e) {		
		}
	}
	
	/**
	 * Load HelpBook.yml
	 */
	public void loadBooksFile() {
		BookFiles.yamlbooks.addDefault("Books.ID", 1);
		saveBooks();
		try  {
			BookFiles.yamlbooks.options().copyDefaults(true);
			BookFiles.yamlbooks.save(BookFiles.books);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Update the Index
	 */
	private void update_INDEX() {
		for(String id : BookFiles.yamlbooks.getConfigurationSection("Book").getKeys(false)) {
			index.add(Integer.valueOf(Integer.parseInt(id)));
			nameindex.put(BookFiles.yamlbooks.getString("Book."+id+".Title"), Integer.valueOf(Integer.parseInt(id)));
		}
	}

	/**
	 * get new Book id 
	 * @return
	 */
	private int getINDEXID() {
		int id = BookFiles.yamlbooks.getInt("Books.ID");
		
	    if (id > 0) {
			BookFiles.yamlbooks.set("Books.ID", Integer.valueOf(id + 1));
	        saveBooks();
	      }
		return id;
	}
	
	private int getID(String book) {
		if(nameindex.containsKey(book)) {
			Bukkit.broadcastMessage("Delete");
			return ((Integer) nameindex.get(book)).intValue();
		}
	    try {
	      int result = Integer.parseInt(book);
			Bukkit.broadcastMessage("Delete");
	      if (result < this.index.size() + 1)
	  		Bukkit.broadcastMessage("Delete");
	        return ((Integer)this.index.get(result -1)).intValue();
	    }
	    catch (NumberFormatException e) {
	    }
		return -1;
	}
	
	public void addBook(ItemStack book) {
		int id = getINDEXID();
		
		BookMeta metadata = (BookMeta)book.getItemMeta();
		
		BookFiles.yamlbooks.set("Book."+id+ ".Title" , metadata.getTitle());
		BookFiles.yamlbooks.set("Book."+id+ ".Author", metadata.getAuthor());
		BookFiles.yamlbooks.set("Book."+id+ ".Pages" , metadata.getPages());
		saveBooks();
		update_INDEX();
	}
	
	public boolean deleteBook(String book) {
		int id = '1'; //getID(book);
		if(id < 0) {
			return false;
		}
		BookFiles.yamlbooks.set("Book."+id, null);
		Bukkit.broadcastMessage("Delete");
		saveBooks();
		update_INDEX();
		return true;
	}
}
