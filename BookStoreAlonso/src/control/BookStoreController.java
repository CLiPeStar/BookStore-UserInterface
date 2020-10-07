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
			return getValue(ISBN);
		}
		return null;
	}

	public HashMap<String, Book> getBooKStore() {
		return mapBookStore;
	}

	public int getSize() {
		return mapBookStore.size();
	}

	public void eraseDrives(String isbnSelected, int i) {
		getValue(isbnSelected).changeValueUnitsDelete(i);

	}

	public void addUnits(String isbnSelected, int i) {
		getValue(isbnSelected).changeValueUnitsAdd(i);

	}

	public int checkUnits(String isbnSelected, int selection) {
		if (getValue(isbnSelected).getUnits() <= selection) {
			return getValue(isbnSelected).getUnits();
		}
		return selection;
	}

	private Book getValue(String isbnSelected) {
		return mapBookStore.get(isbnSelected);
	}

}
