package model;

import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class BookStore {

//	private ArrayList<Book> arrayBookStore;
	private HashMap<String, Book> mapBookStore;

	public BookStore() {
		super();
		this.mapBookStore = new HashMap<String, Book>();

	}

	public HashMap<String, Book> getHasBookStore() {
		return mapBookStore;
	}

	public void addBook(String ISBN, Book book) {
		mapBookStore.put(ISBN, book);
	}

	public void deleteBook(String ISBN) {
		mapBookStore.remove(ISBN);
	}

	public Book searchBook(String ISBN) {
		for (int i = 0; i < mapBookStore.size(); i++) {
			if (mapBookStore.get(i).getIsbn().equals(ISBN)) {
				return mapBookStore.get(i);
			}
		}
		return null;
	}

	public HashMap<String, Book> getLibreria() {
		return mapBookStore;
	}

	public int getSize() {
		return mapBookStore.size();
	}
	

}
