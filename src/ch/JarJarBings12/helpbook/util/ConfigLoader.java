package ch.JarJarBings12.helpbook.util;

import java.io.IOException;
import java.util.HashMap;

import org.bukkit.Bukkit;

import com.avaje.ebean.config.dbplatform.HsqldbPlatform;

public class ConfigLoader {
	public static boolean book1, book2, book3, book4, book5, book6, book7, book8, book9;
	public static String WindowName;
	public static HashMap<String, Integer> booklist = new HashMap<>();
	private static void save_book() {
		try {
			BookFiles.yamlbooks.save(BookFiles.books);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void setBooleans() {
		book1 = BookFiles.yamlbooks.getBoolean("Book.Book1.enable");
		book2 = BookFiles.yamlbooks.getBoolean("Book.Book2.enable");
		book3 = BookFiles.yamlbooks.getBoolean("Book.Book3.enable");
		book4 = BookFiles.yamlbooks.getBoolean("Book.Book4.enable");
		book5 = BookFiles.yamlbooks.getBoolean("Book.Book5.enable");
		book6 = BookFiles.yamlbooks.getBoolean("Book.Book6.enable");
		book7 = BookFiles.yamlbooks.getBoolean("Book.Book7.enable");
		book8 = BookFiles.yamlbooks.getBoolean("Book.Book8.enable");
		book9 = BookFiles.yamlbooks.getBoolean("Book.Book9.enable");		
	}
	
	public static void setBookNames() {
		for(int i = 1; i < 9; i++ ) {
			booklist.put(BookFiles.yamlbooks.getString("Book.Book"+i+".Title"), i);
		}
	}
	
	public static boolean getBookBool(int book) {
		if(book < 9 || book == 0) {
			return false;
		}
		if(book == 1 ) {
			return book1;
		} else if (book == 2) {
			return book2;
		} else if (book == 3) {
			return book3;
		} else if (book == 4) {
			return book4;
		} else if (book == 5) {
			return book5;
		} else if (book == 6) {
			return book6;
		} else if (book == 7) {
			return book7;
		} else if (book == 8) {
			return book8;
		} else if (book == 9) {
			return book9;
		} else {
			return false;
		}
	}
	
	
	public static void setBookBool(int book, boolean status) {
		if(book > 9) {
			Bukkit.broadcastMessage("Test");
			setBooleans();
		}
		if(book == 1 ) {
			BookFiles.yamlbooks.set("Book.Book1.enable", status);
			save_book();
			setBooleans();
		} else if (book == 2) {
			BookFiles.yamlbooks.set("Book.Book2.enable", status);
			save_book();
			setBooleans();
		} else if (book == 3) {
			BookFiles.yamlbooks.set("Book.Book3.enable", status);
			save_book();
			setBooleans();
		} else if (book == 4) {
			BookFiles.yamlbooks.set("Book.Book4.enable", status);
			save_book();
			setBooleans();
		} else if (book == 5) {
			BookFiles.yamlbooks.set("Book.Book5.enable", status);
			save_book();
			setBooleans();
		} else if (book == 6) {
			BookFiles.yamlbooks.set("Book.Book6.enable", status);
			save_book();
			setBooleans();
		} else if (book == 7) {
			BookFiles.yamlbooks.set("Book.Book7.enable", status);
			save_book();
			setBooleans();
		} else if (book == 8) {
			BookFiles.yamlbooks.set("Book.Book8.enable", status);
			save_book();
			setBooleans();
		} else if (book == 9) {
			BookFiles.yamlbooks.set("Book.Book9.enable", status);
			save_book();
			setBooleans();
		} else {
			setBooleans();
		}
	}
	
	public static Integer getBookInteger(String title) {
		int titleint;
		titleint = booklist.get(title);
		return titleint;
	}
	
	public static void setWindowName(String NewWindowName) {
		BookFiles.yamlbooks.set("HelpBook.Window.Name", NewWindowName);
		WindowName = NewWindowName;
		save_book();
	}
}
