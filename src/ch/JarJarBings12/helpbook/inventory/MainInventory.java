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
		inv = pl.getServer().createInventory(null, 9, "                    §aFAQ");
		
		ItemStack book = new ItemStack(Material.WRITTEN_BOOK, 1);
		BookMeta meta = (BookMeta)book.getItemMeta();
//		meta.setAuthor("TEST");
		meta.setTitle("Tst");
		book.setItemMeta(meta);
		
		inv.setItem(4, book);
		
		pl.openInventory(inv);
	}
}
