package ch.JarJarBings12.helpbook.Windows;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Array;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.BookMeta;
import org.bukkit.inventory.meta.ItemMeta;

import ch.JarJarBings12.helpbook.Core.Core;
import ch.JarJarBings12.helpbook.util.util;

public class dynWindowCore {
	/**
	 * @author JarJarBings12
	 */
	public dynWindowCore(Core inCore) {
		Core.inCore = inCore;
		
	}
	
	public static List<String> INVENTORYS = new ArrayList();
	public static HashMap<Player, String> INHBSystem = new HashMap();
}
