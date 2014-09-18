package ch.JarJarBings12.helpbook.util;

import java.io.IOException;
import java.util.HashMap;

import ch.JarJarBings12.helpbook.Core.Core;

public class BookStorage {
	public BookStorage(Core inCore) {
		Core.inCore = inCore;
	}
	
	public void load_BookFile() {
		BookFiles.yamlbooks.addDefault("Book.Book1.enable", true);
		BookFiles.yamlbooks.addDefault("Book.Book1.Title", "TestBook");
		BookFiles.yamlbooks.addDefault("Book.Book1.Author", "TestBook");
		BookFiles.yamlbooks.addDefault("Book.Book1.Pages", "");
		
		BookFiles.yamlbooks.addDefault("Book.Book2.enable", true);
		BookFiles.yamlbooks.addDefault("Book.Book2.Title", "TestBook");
		BookFiles.yamlbooks.addDefault("Book.Book2.Author", "TestBook");
		BookFiles.yamlbooks.addDefault("Book.Book2.Pages", "");
		
		BookFiles.yamlbooks.addDefault("Book.Book3.enable", true);
		BookFiles.yamlbooks.addDefault("Book.Book3.Title", "TestBook");
		BookFiles.yamlbooks.addDefault("Book.Book3.Author", "TestBook");
		BookFiles.yamlbooks.addDefault("Book.Book3.Pages", "");
		
		BookFiles.yamlbooks.addDefault("Book.Book4.enable", true);
		BookFiles.yamlbooks.addDefault("Book.Book4.Title", "TestBook");
		BookFiles.yamlbooks.addDefault("Book.Book4.Author", "TestBook");
		BookFiles.yamlbooks.addDefault("Book.Book4.Pages", "");
		
		BookFiles.yamlbooks.addDefault("Book.Book5.enable", true);
		BookFiles.yamlbooks.addDefault("Book.Book5.Title", "TestBook");
		BookFiles.yamlbooks.addDefault("Book.Book5.Author", "TestBook");
		BookFiles.yamlbooks.addDefault("Book.Book5.Pages", "");
		
		BookFiles.yamlbooks.addDefault("Book.Book6.enable", true);
		BookFiles.yamlbooks.addDefault("Book.Book6.Title", "TestBook");
		BookFiles.yamlbooks.addDefault("Book.Book6.Author", "TestBook");
		BookFiles.yamlbooks.addDefault("Book.Book6.Pages", "");
		
		BookFiles.yamlbooks.addDefault("Book.Book7.enable", true);
		BookFiles.yamlbooks.addDefault("Book.Book7.Title", "TestBook");
		BookFiles.yamlbooks.addDefault("Book.Book7.Author", "TestBook");
		BookFiles.yamlbooks.addDefault("Book.Book7.Pages", "");
		
		BookFiles.yamlbooks.addDefault("Book.Book8.enable", true);
		BookFiles.yamlbooks.addDefault("Book.Book8.Title", "TestBook");
		BookFiles.yamlbooks.addDefault("Book.Book8.Author", "TestBook");
		BookFiles.yamlbooks.addDefault("Book.Book8.Pages", "");
		
		BookFiles.yamlbooks.addDefault("Book.Book9.enable", true);
		BookFiles.yamlbooks.addDefault("Book.Book9.Title", "TestBook");
		BookFiles.yamlbooks.addDefault("Book.Book9.Author", "TestBook");
		BookFiles.yamlbooks.addDefault("Book.Book9.Pages", "");
		
		try {
			BookFiles.yamlbooks.options().copyDefaults(true);
			BookFiles.yamlbooks.save(BookFiles.books);
		} catch (Exception e) {
			
		}
	}
}
