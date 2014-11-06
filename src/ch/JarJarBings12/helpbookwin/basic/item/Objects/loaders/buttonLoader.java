package ch.JarJarBings12.helpbookwin.basic.item.Objects.loaders;

import java.util.List;

import org.bukkit.Material;

import ch.JarJarBings12.helpbookwin.basic.files.filelist;
import ch.JarJarBings12.helpbookwin.basic.item.Objects.loaders.typesinterfaces.BookConfigInterface;
import ch.JarJarBings12.helpbookwin.basic.item.Objects.loaders.typesinterfaces.ButtonConfigInterface;
import ch.JarJarBings12.helpbookwin.basic.objects.WinBasic;
import ch.JarJarBings12.helpbookwin.basic.windows.Objects.windowsObj;

public class buttonLoader implements ButtonConfigInterface {
	
	public buttonLoader(WinBasic inWindow) {
		WinBasic.inWindow = inWindow;
	}
	
	@Override
	public String getConfigItemDisplayName(windowsObj w, int Slot) {
		return filelist.s.getString("windows.window."+w.getSystemName()+".ObjList.object."+Slot+".DISPLAYNAME");
	}

	@Override
	public Material getConfigItemMaterial(windowsObj w, int Slot) {
		return Material.getMaterial(filelist.s.getString("windows.window."+w.getSystemName()+".ObjList.object."+Slot+".MATERIAL"));
	}

	@Override
	public boolean getConfigItemEnabled(windowsObj w, int Slot) {
		return filelist.s.getBoolean("windows.window."+w.getSystemName()+".ObjList.object."+Slot+".ENABLED");
	}

	@Override
	public String getConfigItemType(windowsObj w, int Slot) {
		return filelist.s.getString("windows.window."+w.getSystemName()+".ObjList.object."+Slot+".TYPE");
	}

	@Override
	public List<String> getConfigItemLore(windowsObj w, int Slot) {
		return filelist.s.getStringList("windows.window."+w.getSystemName()+".ObjList.object."+Slot+".LORE");
	}

	@Override
	public void setConfigItemDisplayName(windowsObj w, int Slot, String DisplayName) {
		filelist.s.set("windows.window."+w.getSystemName()+".ObjList.object."+Slot+".DISPLAYNAME", DisplayName);
	}

	@Override
	public void setConfigItemMaterial(windowsObj w, int Slot, Material Material) {
		filelist.s.set("windows.window."+w.getSystemName()+".ObjList.object."+Slot+".DISPLAYNAME", Material.name());
		
	}

	@Override
	public void setConfigItemEnabled(windowsObj w, int Slot, String enabled) {
		filelist.s.set("windows.window."+w.getSystemName()+".ObjList.object."+Slot+".DISPLAYNAME", enabled);
	}

	@Override
	public void setConfigItemType(windowsObj w, int Slot, String Type) {
		filelist.s.set("windows.window."+w.getSystemName()+".ObjList.object."+Slot+".DISPLAYNAME", Type);	
	}

	@Override
	public void setConfigItemLore(windowsObj w, int Slot, List<String> Lore) {
		filelist.s.set("windows.window."+w.getSystemName()+".ObjList.object."+Slot+".DISPLAYNAME", Lore);
	}

	@Override
	public String getConfigItemActionType(windowsObj w, int Slot) {
		return filelist.s.getString("windows.window."+w.getSystemName()+".ObjList.object."+Slot+".action.TYPE");
	}

	@Override
	public String getConfigItemActionPermission(windowsObj w, int Slot) {
		return filelist.s.getString("windows.window."+w.getSystemName()+".ObjList.object."+Slot+".action.PERMISSION");
	}

	@Override
	public String getConfigItemActionMessage(windowsObj w, int Slot) {
		return filelist.s.getString("windows.window."+w.getSystemName()+".ObjList.object."+Slot+".aMESSAGE");
	}

	@Override
	public void setConfigItemActionType(windowsObj w, int Slot, String ActionType) {
		filelist.s.set("windows.window."+w.getSystemName()+".ObjList.object."+Slot+".action.TYPE", ActionType);
	}

	@Override
	public void setConfigItemActionPermission(windowsObj w, int Slot, String ActionPermission) {
		filelist.s.set("windows.window."+w.getSystemName()+".ObjList.object."+Slot+".action.PERMISSION", ActionPermission);
	}

	@Override
	public void setConfigItemActionMessage(windowsObj w, int Slot, String ActionMessage) {
		filelist.s.set("windows.window."+w.getSystemName()+".ObjList.object."+Slot+".action.MESSAGE", ActionMessage);
	}

}
