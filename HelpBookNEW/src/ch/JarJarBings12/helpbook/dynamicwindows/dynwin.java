package ch.JarJarBings12.helpbook.dynamicwindows;

import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

import ch.JarJarBings12.helpbook.Core.Core;

public class dynwin {
	public dynwin(Core inCore) {
		Core.inCore = inCore;
	}
	private static Inventory inv = null;
	
	public void craftDynWindow(String name, int Slots, String ClassName, Player pl) {
		inv = pl.getServer().createInventory(null, Slots, name);
		craftInvSlots();
		
	}

	private void craftInvSlots() {
		
	}
}
