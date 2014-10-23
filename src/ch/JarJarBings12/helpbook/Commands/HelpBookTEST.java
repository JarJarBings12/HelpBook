package ch.JarJarBings12.helpbook.Commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import ch.JarJarBings12.helpbook.Core.Core;
import ch.JarJarBings12.helpbook.Windows.Windows.Windows_Item;
import ch.JarJarBings12.helpbook.Windows.Windows.Windows_System;
import ch.JarJarBings12.helpbook.Windows.Windows.Windows_Utils;
import ch.JarJarBings12.helpbook.util.util;

public class HelpBookTEST implements CommandExecutor {
	public HelpBookTEST(Core inCore) {
		Core.inCore = inCore;
	}

	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (!(cmd.getName().equalsIgnoreCase("HelpBook")))
			return true;
		if (!(sender instanceof Player))
			return true;
		Player pl = (Player) sender;
		if (args.length == 0) {

			return true;
		}
		if(args.length == 2) {
			if(args[2].equalsIgnoreCase("windows") || args[2].equalsIgnoreCase("w")) {
				return true;
			}
			else if (args[2].equalsIgnoreCase("item") || args[2].equalsIgnoreCase("i")) {
				return true;
			}
			else if (args[2].equalsIgnoreCase("config") || args[2].equalsIgnoreCase("c")) {
				return true;	
			} 
			else if (args[2].equalsIgnoreCase("reload")){
				return true;
			}
		}
		if(args.length == 3) {
			if(args[2].equalsIgnoreCase("list")) {
				if(!(pl.hasPermission("helpbook.admin.windows.list"))) {
					pl.sendMessage(Core.inCore.geti18n().getMessage("noperm"));
					return true;
				}
				Windows_System.listWindows(pl);
				return true;
			}
		}
		if(args.length == 4) {
			if(args[2].equalsIgnoreCase("remove")) {
				if(!(pl.hasPermission("helpbook.admin.windows.remove"))) {
					pl.sendMessage(Core.inCore.geti18n().getMessage("noperm"));
					return true;
				}
				if (Windows_System.existWindow(args[3].toString()) == false) {
					pl.sendMessage(Core.inCore.geti18n().getMessage("windownotexist").replace("%window", args[3].toString()));
					return true;
				}
			}
			else if(args[2].equalsIgnoreCase("reset")) {
				if(!(pl.hasPermission("helpbook.admin.windows.reset"))) {
					pl.sendMessage(Core.inCore.geti18n().getMessage("noperm"));
					return true;
				}
				if (Windows_System.existWindow(args[3].toString()) == false) {
					pl.sendMessage(Core.inCore.geti18n().getMessage("windownotexist").replace("%window", args[3].toString()));
					return true;
				}
				Windows_System.removeWindow(args[3].toString());
			}
			else {
				
			}
		}
		if(args.length == 5) {
			if (args[2].equalsIgnoreCase("create")) {
				if(!(pl.hasPermission("helpbook.admin.windows.create"))) {
					pl.sendMessage(Core.inCore.geti18n().getMessage("noperm"));
					return true;
				}
				if (Windows_System.existWindow(args[3].toString()) == true) {
					pl.sendMessage(Core.inCore.geti18n().getMessage("windowexist").replace("%window", args[3].toString()));
					return true;
				}
				int s = Integer.parseInt(args[4].toString());
				if (s > 9) {
					pl.sendMessage(util.helpbook + "/HelpBook admin windows create <name> <lines(1-9)>");
					return true;
				}
				Windows_System.createNewWindow(args[3].toString(), s);
				pl.sendMessage(Core.inCore.geti18n().getMessage("windowcreate").replace("%window", args[3].toString()));
				return true;
			} 
			else if(args[2].equalsIgnoreCase("disable")) {
				if(!(pl.hasPermission("helpbook.admin.windows.disable"))) {
					pl.sendMessage(Core.inCore.geti18n().getMessage("noperm"));
					return true;
				}
				if (Windows_System.existWindow(args[3].toString()) == false) {
					pl.sendMessage(Core.inCore.geti18n().getMessage("windownotexist").replace("%window", args[3].toString()));
					return true;
				}
				if(args[4].equalsIgnoreCase("false")) {
					pl.sendMessage(Core.inCore.geti18n().getMessage("windowenabled").replace("%boolean", "§cdisabled"));
					Windows_System.disableWindow(args[3], false);
					return true;
				} else if(args[4].equalsIgnoreCase("true") ){
					pl.sendMessage(Core.inCore.geti18n().getMessage("windowenabled").replace("%boolean", "§aenabled"));
					Windows_System.disableWindow(args[3], true);
					return true;
				} else {
					pl.sendMessage(util.helpbook + "/HelpBook admin window enabled <window> <true/false>");
					return true;
				}
			}
			else {
				
			}
		}
		
		if(args.length == 6) {
			if(args[2].equalsIgnoreCase("setItemAtWindow")) {
				if(!(pl.hasPermission("helpbook.admin.item.setitematwindow"))) {
					pl.sendMessage(Core.inCore.geti18n().getMessage("noperm"));
					return true;
				}
				int s = Integer.parseInt(args[4].toString());
				Windows_Item.setItemAsWindowSlot(args[3].toString(), args[3].toString(), s, pl.getItemInHand(), pl);
				return true;
			}
			else if(args[2].equalsIgnoreCase("disableWindowSlot")) {
				if(!(pl.hasPermission("helpbook.admin.item.disableitemfromwindowslot"))) {
					pl.sendMessage(Core.inCore.geti18n().getMessage("noperm"));
					return true;
				}
				if(Windows_System.existWindow(args[3].toString()) == false) {
					pl.sendMessage(Core.inCore.geti18n().getMessage("windownotexist"));
					return true;
				}
				int i = Integer.parseInt(args[4].toString());
				boolean disabled = Windows_Utils.getBooleanByString(args[5].toString());
				Windows_Item.disableWindowSlot(args[3].toString(), i, disabled);				
				return true;
			}
		}
		return true;
	}
}
