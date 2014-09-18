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
			
		}
		
		if(args.length == 2) {
			if(args[0].equalsIgnoreCase("admin")) {
				if(!(pl.hasPermission(""))) {
					
				}
				
				if(args[1].equalsIgnoreCase("setTitle")) {
					pl.sendMessage("rr");
				} else if(args[1].equalsIgnoreCase("setAuthor")) {
					pl.sendMessage("rr");
				} else {
					pl.sendMessage("err");
				}
			}
		}
		
		if(args.length == 3) {
			if(args[0].equalsIgnoreCase("admin")) {
				if(!(pl.hasPermission(""))) {
					
				}
				
				if(args[1].equalsIgnoreCase("setTitle")) {
					if(pl.getItemInHand().getType() == Material.WRITTEN_BOOK) {
						Core.inCore.getBookStorage().setTitle(pl.getItemInHand(), args[2]);	
					}
					
				} else if(args[1].equalsIgnoreCase("setAuthor")) {
					if(pl.getItemInHand().getType() != Material.WRITTEN_BOOK) {
						
					}
					Core.inCore.getBookStorage().setAuthor(pl.getItemInHand(), args[2]);
				} else {
					pl.sendMessage("");
				}
			}
		}
		
		
		
		return true;
	}
}
