package ch.JarJarBings12.helpbook.Commands;

import ch.JarJarBings12.helpbook.Core.Core;


public class CMDExecuter {
	/**
	 * @author JarJarBings12
	 */
	public static void load_COMMANDS() {
//		HelpBook uc = new HelpBook(Core.inCore);
		HelpBook uc = new HelpBook(Core.inCore);
		Core.inCore.getCommand("HelpBook").setExecutor(uc);
//		Core.inCore.getCommand("HelpBook").setTabCompleter(new CMDCompleter());
	}  
}
