package ch.JarJarBings12.helpbookwin.basic.windows.Objects;

public interface WinConfigInterface {
	public String getConfigWindowDisplayName(String Window);
	public int getConfigWindowLines(String Window);
	public boolean getConfigWindowEnabled(String Window);
	public boolean getConfigWindowOpenSound(String Window);
	public String getConfigPermission(String Window);
	
	public void setConfigWindowDisplayName(windowsObj w);
	public void setConfigWindowLines(windowsObj w);
	public void setConfigWindowEnabled(windowsObj w);
	public void setConfigWindowOpenSound(windowsObj w);
	public void setConfigPermission( windowsObj w);
}
