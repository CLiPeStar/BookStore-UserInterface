package control;

import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import model.Book;
import model.Thematic;

public class BookStoreController {

	private HashMap<String, Book> mapBookStore;

	public BookStoreController() {
		super();
		this.mapBookStore = new HashMap<String, Book>();
	}

	public HashMap<String, Book> getHasBookStore() {
		return mapBookStore;
	}

	public void addBook(String ISBN, String isbn, String title, String author, String editorial, float price,
			String format, String state, int units, Thematic thematic) {
		mapBookStore.put(ISBN, new Book(isbn, title, author, editorial, price, format, state, units, thematic));
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

	public Book getValue(String isbnSelected) {
		return mapBookStore.get(isbnSelected);
	}

	public String getInfoBook(String iSBN) {
		return searchBook(iSBN).toString();
	}

	public int getBookUnits(String iSBN) {
		return searchBook(iSBN).getUnits();
	}

	public DefaultTableModel fillTable() {
		String columName[] = { "TITLE", "ISBN", "AUTHOR", "EDITORIAL", "FORMAT", "STATE", "PRICE", "UNITS",
				"Thematic" };
		String[][] tableRow = new String[getSize()][columName.length];
		int i = 0;

		for (HashMap.Entry<String, Book> entry : getBooKStore().entrySet()) {

			tableRow[i][1] = entry.getKey();
			tableRow[i][0] = entry.getValue().getTitle();
			tableRow[i][2] = entry.getValue().getAuthor();
			tableRow[i][3] = entry.getValue().getEditorial();
			tableRow[i][4] = entry.getValue().getFormat();
			tableRow[i][5] = entry.getValue().getState();
			tableRow[i][6] = String.valueOf(entry.getValue().getPrice());
			tableRow[i][7] = String.valueOf(entry.getValue().getUnits());
			tableRow[i][8] = entry.getValue().getThematic().name();
			i++;
		}
		DefaultTableModel tablaCompleta = new DefaultTableModel(tableRow, columName);
		return tablaCompleta;
	}

}
