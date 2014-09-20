package ch.JarJarBings12.helpbook.inventory;

import org.bukkit.ChatColor;
import org.bukkit.DyeColor;
import org.bukkit.Material;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.BookMeta;
import org.bukkit.inventory.meta.ItemMeta;

import ch.JarJarBings12.helpbook.util.BookFiles;
import ch.JarJarBings12.helpbook.util.ConfigLoader;

public class MainInventory {
	public enum inventorylist{
		main
	};
	
	private static Inventory inv = null;
	
	/**
	 * 
	 */
	public static void openMAINWindow(Player player) {
		Player pl = player;
		inv = pl.getServer().createInventory(null, 9, ChatColor.translateAlternateColorCodes('&', ConfigLoader.WindowName));
		ItemStack close = new ItemStack(Material.STAINED_GLASS_PANE, 1, DyeColor.SILVER.getData());
		ItemMeta  closemeta = (ItemMeta)close.getItemMeta();
		closemeta.setDisplayName("Nicht verfügbar");
		close.setItemMeta(closemeta);
		
		if(ConfigLoader.book1 !=false) {
			ItemStack book = new ItemStack(Material.WRITTEN_BOOK, 1);
			BookMeta meta = (BookMeta)book.getItemMeta();
			meta.setAuthor(BookFiles.yamlbooks.getString("Book.Book1.Author"));
			meta.setTitle(BookFiles.yamlbooks.getString("Book.Book1.Title"));
			book.setItemMeta(meta);	
			inv.setItem(0, book);
		} else {
			inv.setItem(0, close);
		}
		
		if(ConfigLoader.book2 != false) {
		ItemStack book1 = new ItemStack(Material.WRITTEN_BOOK, 1);
		BookMeta meta1 = (BookMeta)book1.getItemMeta();
		meta1.setAuthor(BookFiles.yamlbooks.getString("Book.Book2.Author"));
		meta1.setTitle(BookFiles.yamlbooks.getString("Book.Book2.Title"));
		book1.setItemMeta(meta1);
		inv.setItem(1, book1);
		} else {
			inv.setItem(1, close);
		}
		
		if(ConfigLoader.book3 != false) {
		ItemStack book2 = new ItemStack(Material.WRITTEN_BOOK, 1);
		BookMeta meta2 = (BookMeta)book2.getItemMeta();
		meta2.setAuthor(BookFiles.yamlbooks.getString("Book.Book3.Author"));
		meta2.setTitle(BookFiles.yamlbooks.getString("Book.Book3.Title"));
		book2.setItemMeta(meta2);
		inv.setItem(2, book2);
		} else {
			inv.setItem(2, close);
		}
		
		if(ConfigLoader.book4 != false) {
		ItemStack book3 = new ItemStack(Material.WRITTEN_BOOK, 1);
		BookMeta meta3 = (BookMeta)book3.getItemMeta();
		meta3.setAuthor(BookFiles.yamlbooks.getString("Book.Book4.Author"));
		meta3.setTitle(BookFiles.yamlbooks.getString("Book.Book4.Title"));
		book3.setItemMeta(meta3);
		inv.setItem(3, book3);
		} else {
			inv.setItem(3, close);
		}
		
		if(ConfigLoader.book5 != false) {
		ItemStack book4 = new ItemStack(Material.WRITTEN_BOOK, 1);
		BookMeta meta4 = (BookMeta)book4.getItemMeta();
		meta4.setAuthor(BookFiles.yamlbooks.getString("Book.Book5.Author"));
		meta4.setTitle(BookFiles.yamlbooks.getString("Book.Book5.Title"));
		book4.setItemMeta(meta4);
		inv.setItem(4, book4);
		} else {
			inv.setItem(4, close);
		}
		
		if(ConfigLoader.book6 != false) {
		ItemStack book5 = new ItemStack(Material.WRITTEN_BOOK, 1);
		BookMeta meta5= (BookMeta)book5.getItemMeta();
		meta5.setAuthor(BookFiles.yamlbooks.getString("Book.Book6.Author"));
		meta5.setTitle(BookFiles.yamlbooks.getString("Book.Book6.Title"));
		book5.setItemMeta(meta5);
		inv.setItem(5, book5);
		} else {
			inv.setItem(5, close);
		}
		
		if(ConfigLoader.book7 != false) {
			ItemStack book6 = new ItemStack(Material.WRITTEN_BOOK, 1);
			BookMeta meta6 = (BookMeta)book6.getItemMeta();
			meta6.setAuthor(BookFiles.yamlbooks.getString("Book.Book7.Author"));
			meta6.setTitle(BookFiles.yamlbooks.getString("Book.Book7.Title"));
			book6.setItemMeta(meta6);
			inv.setItem(6, book6);
		} else {
			inv.setItem(6, close);
		}
		
		if(ConfigLoader.book8 != false) {
		ItemStack book7 = new ItemStack(Material.WRITTEN_BOOK, 1);
		BookMeta meta7 = (BookMeta)book7.getItemMeta();
		meta7.setAuthor(BookFiles.yamlbooks.getString("Book.Book8.Author"));
		meta7.setTitle(BookFiles.yamlbooks.getString("Book.Book8.Title"));
		book7.setItemMeta(meta7);
		inv.setItem(7, book7);
		} else {
			inv.setItem(7, close);
		}
		
		if(ConfigLoader.book9 != false) {
		ItemStack book8 = new ItemStack(Material.WRITTEN_BOOK, 1);
		BookMeta meta8 = (BookMeta)book8.getItemMeta();
		meta8.setAuthor(BookFiles.yamlbooks.getString("Book.Book9.Author"));
		meta8.setTitle(BookFiles.yamlbooks.getString("Book.Book9.Title"));
		book8.setItemMeta(meta8);
		
		inv.setItem(8, book8);
		} else {
			inv.setItem(8, close);
		}
		pl.openInventory(inv);
	}
}
