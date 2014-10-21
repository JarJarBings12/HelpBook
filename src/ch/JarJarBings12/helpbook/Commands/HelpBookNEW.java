package ch.JarJarBings12.helpbook.Commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import ch.JarJarBings12.helpbook.Core.Core;
import ch.JarJarBings12.helpbook.Windows.dynWindowCore;
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
			dynWindowCore.renderWindow("DEFAULT", pl);
			return true;
		}
		if(args.length == 1) {
			if(args[0].equalsIgnoreCase("admin")) {
				if(!(pl.hasPermission("helpbook.admin"))) {
					Core.inCore.geti18n().getMessage("noperm");
					return true;
				}
				pl.sendMessage(util.helpbook + "§f~~~~~~~~~~~~§c[HelpBook]§f~~~~~~~~~~~~");
				pl.sendMessage(util.helpbook + "§c/HelpBook admin §3windows §f> List of all Commands for Windows");
				pl.sendMessage(util.helpbook + "§c/HelpBook admin §3item   §f> List of all Commands for Windows and Items");
				pl.sendMessage(util.helpbook + "§c/HelpBook admin §3config §f> Commands to edit the Config");
				pl.sendMessage(util.helpbook + "§c/HelpBook admin §3reload §f> Reload HelpBook");
				return true;
			} else if (args[0].equalsIgnoreCase("info")) {
				InfoWindow.openINFOWindow(pl);
				return true;
			} else {
				pl.sendMessage(util.helpbook + "§f~~~~~~~~~~~~§c[HelpBook]§f~~~~~~~~~~~~");
				pl.sendMessage(util.helpbook + "§c/HelpBook §f>Open Main Window");
				pl.sendMessage(util.helpbook + "§c/HelpBook admin §f> Admin Commands");
				pl.sendMessage(util.helpbook + "§c/HelpBook info §f> Open Info Window");
				pl.sendMessage(util.helpbook + "§c/HelpBook edit §f> Book Edit Commands");
				pl.sendMessage(util.helpbook + "§f~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");	
				return true;
			}
		}
		
		if(args.length == 2) {
			if(args[1].equalsIgnoreCase("windows")) {
				pl.sendMessage(util.helpbook + "§f~~~~~~~~~~~~§c[HelpBook]§f~~~~~~~~~~~~");
				return true;
			} else if (args[1].equalsIgnoreCase("item")) {
				pl.sendMessage(util.helpbook + "§f~~~~~~~~~~~~§c[HelpBook]§f~~~~~~~~~~~~");
				return true;
			} else if (args[1].equalsIgnoreCase("config")) {
				pl.sendMessage(util.helpbook + "§f~~~~~~~~~~~~§c[HelpBook]§f~~~~~~~~~~~~");
				return true;
			} else if (args[1].equalsIgnoreCase("reload")) {
				return true;
			}
		}
		
		return true;
	}
}
