package ch.JarJarBings12.helpbook.util.update;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.MalformedURLException;
import java.net.URL;










import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import ch.JarJarBings12.helpbook.Core.Core;
import ch.JarJarBings12.helpbook.util.util;

public class updateservice {
	
	private static URL filesFeed;
	private static String p_VERSION;
	private static updatephase phase;
	
	public updateservice(String url) {
		try {
			filesFeed = new URL("https://www.dropbox.com/s/ik09w3hjjhoil3g/version.xml?dl=0");
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
	}
	
	public static void updateCheck() {
		try {
			phase = updatephase.CHECK_VERSION;
			InputStream input = filesFeed.openConnection().getInputStream();
			Document document = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(input);
			
			Node itemelement = document.getElementsByTagName("item").item(0);
			NodeList children = itemelement.getChildNodes();
			
			p_VERSION = children.item(1).getTextContent().replace("[a-zA-Z ]", "").replace("_", "");
			
			if (p_VERSION != Core.inCore.getPluginDescription().getVersion()) {
				phase = updatephase.UPDATE_AVIBLE;
			} else {
				phase = updatephase.UPDATE_NOT_AVIBLE;
			}
		} catch (IOException e) {
			e.printStackTrace();
			phase = updatephase.WEBSITE_NOT_AVIBLE;
		} catch (SAXException e) {
			e.printStackTrace();
			phase = updatephase.WEBSITE_NOT_AVIBLE;
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
			phase = updatephase.WEBSITE_NOT_AVIBLE;
		}
		
	}
	
}
