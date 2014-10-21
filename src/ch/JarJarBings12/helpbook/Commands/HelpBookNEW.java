package ch.JarJarBings12.helpbook.Commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import ch.JarJarBings12.helpbook.Core.Core;
import ch.JarJarBings12.helpbook.Windows.dynWindowCore;
import ch.JarJarBings12.helpbook.Windows.Windows.Windows_System;
import ch.JarJarBings12.helpbook.Windows.Windows.Windows_Utils;
import ch.JarJarBings12.helpbook.inventory.InfoWindow;
import ch.JarJarBings12.helpbook.util.util;

public class HelpBookNEW implements CommandExecutor {
	public HelpBookNEW(Core inCore) {
		Core.inCore = inCore;
	}
	
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(!(cmd.getName().equalsIgnoreCase("HelpBook"))) return true;
		if(!(sender instanceof Player)) return true;
		Player pl = (Player)sender;
		if(args.length == 0) {
			
			return true;
		}
		
		if(args.length == 1) {
			if(args[0].equalsIgnoreCase("admin") || args[1].equalsIgnoreCase("a")) {
				if(!(pl.hasPermission("helpbook.admin"))) {
					Core.inCore.geti18n().getMessage("noperm");
					return true;
				}
				pl.sendMessage(util.helpbook + "§f~~~~~~~~~~~~§c[HelpBook]§f~~~~~~~~~~~~");
				pl.sendMessage(util.helpbook + "§fHelpBook > admin > §ainfo");
				pl.sendMessage(util.helpbook + "§c/HelpBook admin §3windows §f> Commands for Windows");
				pl.sendMessage(util.helpbook + "§c/HelpBook admin §3item    §f> List of Commands for Items");
				pl.sendMessage(util.helpbook + "§c/HelpBook admin §3config §f> Commands to edit the Config");
				pl.sendMessage(util.helpbook + "§c/HelpBook admin §3reload §f> Reload HelpBook");
				return true;
			} else if (args[0].equalsIgnoreCase("info")) {
				InfoWindow.openINFOWindow(pl);
				return true;
			} else {
				pl.sendMessage(util.helpbook + "§f~~~~~~~~~~~~§c[HelpBook]§f~~~~~~~~~~~~");
				pl.sendMessage(util.helpbook + "§fHelpBook > §ahelp");
				pl.sendMessage(util.helpbook + "§c/HelpBook §f>Open Main Window");
				pl.sendMessage(util.helpbook + "§c/HelpBook admin §f> Admin Commands");
				pl.sendMessage(util.helpbook + "§c/HelpBook info §f> Open Info Window");
				pl.sendMessage(util.helpbook + "§c/HelpBook edit §f> Book Edit Commands");
				pl.sendMessage(util.helpbook + "§f~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");	
				return true;
			}
		}
		
		if(args.length == 2) {
			if(args[1].equalsIgnoreCase("windows") || args[1].equalsIgnoreCase("w")) {
				pl.sendMessage(util.helpbook + "§f~~~~~~~~~~~~§c[HelpBook]§f~~~~~~~~~~~~");
				pl.sendMessage(util.helpbook + "§fHelpBook > admin > windows > §ahelp");
				pl.sendMessage(util.helpbook + "§c/HelpBook admin windows §3list §f>List all Windows ");
				pl.sendMessage(util.helpbook + "§c/HelpBook admin windows §3create  §f>Add a Window ");
				pl.sendMessage(util.helpbook + "§c/HelpBook admin windows §3disable §f>Disable a Window ");
				pl.sendMessage(util.helpbook + "§c/HelpBook admin windows §3remove  §f>Remove a Window");
				pl.sendMessage(util.helpbook + "§c/HelpBook admin windows §3reset   §f>Reset a Window ");
				return true;
			} else if (args[1].equalsIgnoreCase("item") || args[1].equalsIgnoreCase("i")) {
				pl.sendMessage(util.helpbook + "§f~~~~~~~~~~~~§c[HelpBook]§f~~~~~~~~~~~~");
				pl.sendMessage(util.helpbook + "§fHelpBook > admin > item > §aHelp");
				pl.sendMessage(util.helpbook + "§c/HelpBook admin item §3addToWindow §f>Add a Item to a Window ");
				pl.sendMessage(util.helpbook + "§c/HelpBook admin item §3setItemAtWindowSlot §f> Set a Item to a Window Slot");
				pl.sendMessage(util.helpbook + "§c/HelpBook admin item §3disableItemFromWindowSlot §f> disable a Item from a Slot");
				pl.sendMessage(util.helpbook + "§c/HelpBook admin item §3removeItemFromWindowSlot §f> Remove a Item from a Slot");
				pl.sendMessage(util.helpbook + "§cFor Item Actions Type: /HelpBook admin item action");
				return true;
			} else if (args[1].equalsIgnoreCase("config") || args[1].equalsIgnoreCase("c")) {
				pl.sendMessage(util.helpbook + "§f~~~~~~~~~~~~§c[HelpBook]§f~~~~~~~~~~~~");
				pl.sendMessage(util.helpbook + "§c/HelpBook admin config setautosave <true/false>");
				pl.sendMessage(util.helpbook + "§c/HelpBook admin config setautosaverepeteall <min>");
				return true;
			} else if (args[1].equalsIgnoreCase("reload") || args[1].equalsIgnoreCase("r")) {
				return true;
			}
		}
		
		
		if(args.length == 3) {
			if(args[2].equalsIgnoreCase("list")) {
				/*/WINDOW/*/
				if(pl.hasPermission("helpbook.admin.windows.list")) {
					pl.sendMessage(Core.inCore.geti18n().getMessage("noperm"));
					return true;
				}
				Windows_Utils.listWindows(pl);
				
			} else if(args[2].equalsIgnoreCase("create")) {
				/*/WINDOW/*/
				if(pl.hasPermission("helpbook.admin.windows.create")) {
					pl.sendMessage(Core.inCore.geti18n().getMessage("noperm"));
					return true;
				}
				pl.sendMessage(util.helpbook + "/HelpBook admin windows create <name> <lines(1-9)>");
			} else if(args[2].equalsIgnoreCase("disable")) {
				/*/WINDOW/*/
				if(pl.hasPermission("helpbook.admin.windows.disable")) {
					pl.sendMessage(Core.inCore.geti18n().getMessage("noperm"));
					return true;
				}
				pl.sendMessage(util.helpbook + "/HelpBook admin windows disable <name> <disabled(true/false)>");
			} else if(args[2].equalsIgnoreCase("remove")) {
				/*/WINDOW/*/
				if(pl.hasPermission("helpbook.admin.windows.remove")) {
					pl.sendMessage(Core.inCore.geti18n().getMessage("noperm"));
					return true;
				}
				pl.sendMessage(util.helpbook + "/HelpBook admin windows remove <name>");
			} else if(args[2].equalsIgnoreCase("reset")) {
				/*/WINDOW/*/
				if(pl.hasPermission("helpbook.admin.windows.reset")) {
					pl.sendMessage(Core.inCore.geti18n().getMessage("noperm"));
					return true;
				}
			} else if(args[2].equalsIgnoreCase("addToWindoow")) {
			} else if(args[2].equalsIgnoreCase("setItemAtWindowSlot")) {
			} else if(args[2].equalsIgnoreCase("disableItemFromWindowSlot")) {
			} else if(args[2].equalsIgnoreCase("removeItemFromWindowSlot")) {
			} else if(args[2].equalsIgnoreCase("setautosave")) {
			} else if(args[2].equalsIgnoreCase("setautosaverepeteall")) {
				
			} else {
				pl.sendMessage(util.helpbook + "§f~~~~~~~~~~~~§c[HelpBook]§f~~~~~~~~~~~~");
				pl.sendMessage(util.helpbook + "§fHelpBook > admin > §ainfo");
				pl.sendMessage(util.helpbook + "§c/HelpBook admin §3windows §f> Commands for Windows");
				pl.sendMessage(util.helpbook + "§c/HelpBook admin §3item    §f> List of Commands for Items");
				pl.sendMessage(util.helpbook + "§c/HelpBook admin §3config §f> Commands to edit the Config");
				pl.sendMessage(util.helpbook + "§c/HelpBook admin §3reload §f> Reload HelpBook");
			}
		}
		
		return true;
	}
}
