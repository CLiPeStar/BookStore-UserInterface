package control;

import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import model.Book;

public class BookStoreController {

	private HashMap<String, Book> mapBookStore;

	public BookStoreController() {
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
		if (mapBookStore.containsKey(ISBN)) {
			return mapBookStore.get(ISBN);
		}
		return null;
	}

	public HashMap<String, Book> getBooKStore() {
		return mapBookStore;
	}

	public int getSize() {
		return mapBookStore.size();
	}

}
