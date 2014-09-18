package ch.JarJarBings12.helpbook.Commands;

import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import ch.JarJarBings12.helpbook.Core.Core;
import ch.JarJarBings12.helpbook.inventory.MainInventory;
import ch.JarJarBings12.helpbook.inventory.MainInventory.inventorylist;
import ch.JarJarBings12.helpbook.util.BookStorage;

public class HelpBook implements CommandExecutor {
	public HelpBook(Core inCore) {
		Core.inCore = inCore;
	}

	public boolean onCommand(CommandSender sender, Command cmd, String label, String[]  args) {
		if(!cmd.getName().equalsIgnoreCase("HelpBook")) return true;
		if(!(sender instanceof Player)) {
			
		}
		Player pl = (Player)sender;
		if(!(pl.hasPermission("helpbook.helpbook"))) {
			
		}
		if(args.length == 0) {
		MainInventory.openInventory(pl, inventorylist.main);
		}
		if(args.length == 3) {
			if(pl.hasPermission("helpbook.helpbook.admin")) {
				if(args[0].equalsIgnoreCase("admin")) {
					if(args[1].equalsIgnoreCase("addBook")) {
						ItemStack inhand = pl.getItemInHand();
						if(inhand.getType() != Material.WRITTEN_BOOK) {
							pl.sendMessage("NO");
						} else {
							pl.sendMessage("YES");
						}
					} else if (args[1].equalsIgnoreCase("deleteBook")) {
					} else {
						
					}
				}	
			} else {
				
			}	
		}
		return true;
	}
}
