package ch.JarJarBings12.helpbook.dynamicwindows;

import java.io.File;

import org.bukkit.configuration.file.YamlConfiguration;

import ch.JarJarBings12.helpbook.Core.Core;

public class dynwinyml {
	private dynwinyml(Core inCore) {
		Core.inCore = inCore;
	}
	private static File dbyml = new File("plugins/YML/Test", "TEST.yml");
	private static YamlConfiguration d = YamlConfiguration.loadConfiguration(dbyml);
	
	public static void test() {
	d.addDefault("Window.name", "TEst");
	d.addDefault("Window.slots", 9);
	d.addDefault("Window.slot.slot1.enable", true);
	d.addDefault("Window.slot.slot1.title", "Empty");
	d.addDefault("Window.slot.slot1.author", "Empty");
	d.addDefault("Window.slot.slot1.Pages", "");
	
	}
}
