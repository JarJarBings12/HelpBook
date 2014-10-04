package ch.JarJarBings12.helpbook.util;

import ch.JarJarBings12.helpbook.Core.Core;

public class util {
	public static String helpbook = "[HelpBook]";
	
	public enum Exceptions {
		SIZETOHIGE, SIZETOLOW, PERMISSIONSEXECUTEERROR, OBJECTEXECUTE, MESSAGEECECUTE, ACTIONTYPEEXECUTE, ACTIONEXECUTE, 
		NAMEEXECUTE, WINDOWNAMETOLONG
	};
	
	private enum reloadstatus {
		RUN, ISRUN, ERROR
	};
	
	public static void exeption(Exceptions Exception) {
		System.out.println(helpbook+"[Error]"+ Core.inCore.getExeptionHandler().getException(Exception.toString()));
	}
	
}
