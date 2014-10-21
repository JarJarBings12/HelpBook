package ch.JarJarBings12.helpbook.Windows.Windows;

import java.io.IOException;

import ch.JarJarBings12.helpbook.Core.Core;
import ch.JarJarBings12.helpbook.Windows.dynFILELIST;
import ch.JarJarBings12.helpbook.inventory.MainInventory.inventorylist;

public class Windows_Save_Task {
	
	public static void start_SaveTask(long delay) {
		Core.inCore.getServer().getScheduler().scheduleSyncRepeatingTask(Core.inCore, new Runnable() {
			
			@Override
			public void run() {
				try {
					dynFILELIST.s.save(dynFILELIST.storage);
					dynFILELIST.ca.save(dynFILELIST.cache);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}, 0L, delay);
	}
	
}
