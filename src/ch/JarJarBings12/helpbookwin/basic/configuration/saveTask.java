package ch.JarJarBings12.helpbookwin.basic.configuration;

import org.bukkit.Bukkit;

import ch.JarJarBings12.helpbookwin.basic.logger.BasicLog;
import ch.JarJarBings12.helpbookwin.basic.objects.WinBasic;
import ch.JarJarBings12.helpbookwin.basic.windows.Objects.windowsObjLoader;

public class saveTask {
	public void runSaveTask(int time) {
		Bukkit.getServer().getScheduler().scheduleSyncRepeatingTask(<Core>, new Runnable() {
			public void run() {
				WinBasic.inWindow.getWindowLoader().saveWindowObjects();
			}
		}, 0, 20*time);
	}
}
