package ch.JarJarBings12.helpbookwin.basic.logger;

public enum BasicLog {
	INFO("[INFO]", 0),
	
	DEBUG("[DEBUG]", 10),
	
	WARNING("[WARNING]", 20),
	
	CRITICAL("[CRITICAL]",30 ),
	
	ERROR("[ERROR]", 40);
	
	private String PREFIX;
	private int LEVEL;
	
	private BasicLog(String Prefix, int Level) {
		this.PREFIX = Prefix;
		this.LEVEL = Level;
	}
	
	public String write(String Message) {
		return PREFIX+Message;
		
	}
	
	public String getPrefix() {
		return this.PREFIX;
	}
	
	public int getLevel() {
		return this.LEVEL;
	}
	
}
