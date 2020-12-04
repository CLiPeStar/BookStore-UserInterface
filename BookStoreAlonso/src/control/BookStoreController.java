package control;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.table.DefaultTableModel;

import control.BBDD.CallerBooks;
import model.Book;
import model.Thematic;
import model.file.Warehouse;

public class BookStoreController {

	private ArrayList<Book> bookStore;
	private CallerBooks caller;

	public BookStoreController() {
		super();
		try {
			this.caller= new CallerBooks();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		readFile();
	}

	private void readFile() {
		try {
			readWarehouse();
		} catch (Exception e) {
		}
		if (null == this.bookStore) {
			this.bookStore = new ArrayList<Book>();
		}
	}

	public boolean addBook(String ISBN, String isbn, String title, String author, String editorial, float price,
			String format, String state, int units, Thematic thematic) {
		Book book = new Book(isbn, title, author, editorial, price, format, state, units, thematic);
		readWarehouse();
		bookStore.add(book);
		saveWarehouse(book);
		return true;
	}

	public boolean deleteBook(String isbn) {
		readWarehouse();
		Book deleteBook = giveMeBook(isbn);
		boolean removido = bookStore.remove(deleteBook);
		wareHouse.deleteObject(bookStore);
		return removido;
	}

	private Book giveMeBook(String isbn) {
		for (Book book : bookStore) {
			if (book.getIsbn().equals(isbn))
				return book;
		}
		return null;
	}

	private void readWarehouse() {
		this.bookStore = (ArrayList<Book>) wareHouse.recovers();
	}

	public boolean saveWarehouse(Book book) {
		try {
			return caller.insertBook(book);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	public Book searchBook(String isbn) {
		for (Book book : this.bookStore) {
			if (book.getIsbn().equals(isbn)) {
				return book;
			}
		}
		return null;
	}

	public boolean libroRepetido(String isbn) {
		return searchBook(isbn) != null;

	}

	public void addUnits(String isbn, int units) {
		readWarehouse();

		searchBook(isbn).changeValueUnitsAdd(units);
		Book bookTemporal = searchBook(isbn);
		deleteBook(isbn);
		bookStore.add(bookTemporal);
		saveWarehouse(bookTemporal);

	}

	public void eraseDrives(String isbn, int units) {
		readWarehouse();
		searchBook(isbn).changeValueUnitsDelete(units);
		Book bookTemporal = searchBook(isbn);
		deleteBook(isbn);
		bookStore.add(bookTemporal);
		saveWarehouse(bookTemporal);
	}

	public int getBookUnits(String text) {
		return searchBook(text).getUnits();
	}

	public DefaultTableModel fillTable() {
		readWarehouse();
		String columName[] = { "TITLE", "ISBN", "AUTHOR", "EDITORIAL", "FORMAT", "STATE", "PRICE", "UNITS",
				"Thematic" };
		String[][] tableRow = new String[this.bookStore.size()][columName.length];
		int i = 0;

		for (Book entry : bookStore) {

			tableRow[i][1] = entry.getIsbn();
			tableRow[i][0] = entry.getTitle();
			tableRow[i][2] = entry.getAuthor();
			tableRow[i][3] = entry.getEditorial();
			tableRow[i][4] = entry.getFormat();
			tableRow[i][5] = entry.getState();
			tableRow[i][6] = String.valueOf(entry.getPrice());
			tableRow[i][7] = String.valueOf(entry.getUnits());
			tableRow[i][8] = entry.getThematic().name();
			i++;
		}
		DefaultTableModel tablaCompleta = new DefaultTableModel(tableRow, columName);
		return tablaCompleta;
	}

}
