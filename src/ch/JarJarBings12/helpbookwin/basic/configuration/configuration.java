package ch.JarJarBings12.helpbookwin.basic.configuration;

import ch.JarJarBings12.helpbookwin.basic.files.filelist;

public class configuration {
	public void createConfig() {
		
		filelist.co.addDefault("helpbook.windows.remove.RemoveOnlyOutOfCache", false);
		filelist.co.addDefault("helpbook.windows.backup.timed.enabled", true);
		filelist.co.addDefault("helpbook.windows.backup.timed.interval", 600);
		filelist.co.addDefault("helpbook.windows.backup.timed.broadcast", false);
		filelist.co.addDefault("helpbook.windows.baclup.timed.broadcast.message", "§6[WinBasic]§fBackup Book Storage.");
	}
}
