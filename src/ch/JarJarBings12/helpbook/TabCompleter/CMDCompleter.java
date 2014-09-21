package ch.JarJarBings12.helpbook.TabCompleter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;

import com.google.common.collect.Lists;

public class CMDCompleter implements TabCompleter {

	/**
	 * Command Tab Completer 
	 */

	public List<String> onTabComplete(CommandSender sender, Command cmd, String label, String[] args) {
		List<String> noargs = Arrays.asList("admin", "info");
		List<String> admin = Arrays.asList("setTitle", "setAuthor", "setBookAtSlot", "turnmode", "setWindowName", "getrawbook");
		List<String> turn = Arrays.asList("turnmode");
		List<String> slot = Arrays.asList("1","2","3","4","5","6","7","8","9");
		List<String> status = Arrays.asList("on","true","off","false");
		List<String> finallist = Lists.newArrayList();
		
		if(args.length == 1) {
			if(!(sender.hasPermission("helpbook.helpbook.admin"))) {
				return finallist;
			}
			for (String s : noargs) {
				if(s.startsWith(args[0]))
				finallist.add(s);
			}
			return finallist;
		}
		
		if(args.length == 2) {
			for(String s : admin) {
				if(s.startsWith(args[1])) {
					finallist.add(s);
				}
			}
			return finallist;
		}
		
		if(args.length == 3) {
			for(String s : slot) {
				if(s.startsWith(args[2])) {
					finallist.add(s);
				}
			}
			return finallist;
		}
		if(args.length == 4) {
			for(String s : status) {
				if(s.startsWith(args[3])) {
					finallist.add(s);
				}
			}
			return finallist;
		}

		
		return null;
	}

}
