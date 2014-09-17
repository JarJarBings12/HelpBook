package ch.JarJarBings12.helpbook.util;

import java.io.IOException;
import java.util.HashMap;

import ch.JarJarBings12.helpbook.Core.Core;

public class BookStorage {

	private HashMap<Integer, String>

	public void setupBookFile() {
		BookFiles.yamlbooks.addDefault("Books.LastBookID", 1);
		
	}
	
	public void saveBooks() {
		try {
			 BookFiles.yamlbooks.save(BookFiles.books);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void update_INDEX() {
		
	}
	
	public void addBook() {
		saveBooks();1
	}
}
