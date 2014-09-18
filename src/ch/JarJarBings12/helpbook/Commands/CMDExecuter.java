package ch.JarJarBings12.helpbook.Commands;

import ch.JarJarBings12.helpbook.Core.Core;
import ch.JarJarBings12.helpbook.TabCompleter.CMDCompleter;


public class CMDExecuter {
	public static void load_COMMANDS() {
		HelpBook uc = new HelpBook(Core.inCore);
		Core.inCore.getCommand("HelpBook").setExecutor(uc);
		Core.inCore.getCommand("HelpBook").setTabCompleter(new CMDCompleter());
	}
}
