package ch.JarJarBings12.helpbook.inventory;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.BookMeta;

public class MainInventory {
	public enum inventorylist{
		main
	};
	
	private static Inventory inv = null;
	
	public static void openInventory(Player player, inventorylist inventory) {
		Player pl = player;
		inv = pl.getServer().createInventory(null, 9, " §aFAQ Unser Minecraft de");
		
		ItemStack book = new ItemStack(Material.WRITTEN_BOOK, 1);
		BookMeta meta = (BookMeta)book.getItemMeta();
		meta.setAuthor("Unser-Minecraft.de");
		meta.setTitle("HelpBook1");
		book.setItemMeta(meta);
		
		ItemStack book1 = new ItemStack(Material.WRITTEN_BOOK, 1);
		BookMeta meta1 = (BookMeta)book1.getItemMeta();
		meta1.setAuthor("Unser-Minecraft.de");
		meta1.setTitle("HelpBook1");
		book1.setItemMeta(meta);
		
		ItemStack book2 = new ItemStack(Material.WRITTEN_BOOK, 1);
		BookMeta meta2 = (BookMeta)book2.getItemMeta();
		meta2.setAuthor("Unser-Minecraft.de");
		meta2.setTitle("HelpBook1");
		book2.setItemMeta(meta);
		
		ItemStack book3 = new ItemStack(Material.WRITTEN_BOOK, 1);
		BookMeta meta3 = (BookMeta)book3.getItemMeta();
		meta3.setAuthor("Unser-Minecraft.de");
		meta3.setTitle("HelpBook1");
		book3.setItemMeta(meta3);
		
		ItemStack book4 = new ItemStack(Material.WRITTEN_BOOK, 1);
		BookMeta meta4 = (BookMeta)book4.getItemMeta();
		meta4.setAuthor("Unser-Minecraft.de");
		meta4.setTitle("HelpBook1");
		book4.setItemMeta(meta4);
		
		ItemStack book5 = new ItemStack(Material.WRITTEN_BOOK, 1);
		BookMeta meta5= (BookMeta)book5.getItemMeta();
		meta5.setAuthor("Unser-Minecraft.de");
		meta5.setTitle("HelpBook1");
		book5.setItemMeta(meta5);
		
		ItemStack book6 = new ItemStack(Material.WRITTEN_BOOK, 1);
		BookMeta meta6 = (BookMeta)book.getItemMeta();
		meta6.setAuthor("Unser-Minecraft.de");
		meta6.setTitle("HelpBook1");
		book6.setItemMeta(meta6);
		
		ItemStack book7 = new ItemStack(Material.WRITTEN_BOOK, 1);
		BookMeta meta7 = (BookMeta)book7.getItemMeta();
		meta7.setAuthor("Unser-Minecraft.de");
		meta7.setTitle("HelpBook1");
		book7.setItemMeta(meta7);
		
		ItemStack book8 = new ItemStack(Material.WRITTEN_BOOK, 1);
		BookMeta meta8 = (BookMeta)book8.getItemMeta();
		meta8.setAuthor("Unser-Minecraft.de");
		meta8.setTitle("HelpBook1");
		book8.setItemMeta(meta);
		
		inv.setItem(0, book);
		inv.setItem(1, book1);
		inv.setItem(2, book2);
		inv.setItem(3, book3);
		inv.setItem(4, book4);
		inv.setItem(5, book5);
		inv.setItem(6, book6);
		inv.setItem(7, book7);
		inv.setItem(8, book8);
		
		pl.openInventory(inv);
	}
}
