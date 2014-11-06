package ch.JarJarBings12.helpbookwin.basic.windows.Objects;

public interface WindowsInterface {
	public String getSystemName();
	public String getDisplayName();
	public String getPermission();
	public int getLines();
	public boolean isEnabled();
	public void isEnabled(boolean Enabled);
	public boolean hasOpenSound();
	public void hasOpenSound(boolean Enabled);
	public void setDisplayName(String DisplayName);
	public void setPermission(String Permission);
	public void setLines(int Lines);
}
