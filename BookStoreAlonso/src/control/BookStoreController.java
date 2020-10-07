package control;

import java.util.ArrayList;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import model.Book;

public class BookStoreController {

	private ArrayList<Book> arrayBookStore;

	public BookStoreController() {
		super();
		this.arrayBookStore = new ArrayList<Book>();

	}

	public ArrayList<Book> getArrayBookStore() {
		return arrayBookStore;
	}

	public void addBook(Book book) {
		arrayBookStore.add(book);
	}

	public void deleteBook(int index) {
		arrayBookStore.remove(index);
	}

	public Book searchBook(String ISBN) {
		for (int i = 0; i < arrayBookStore.size(); i++) {
			if (arrayBookStore.get(i).getIsbn().equals(ISBN)) {
				return arrayBookStore.get(i);
			}
		}
		return null;
	}

	public int getSize() {
		return arrayBookStore.size();
	}

	public Book getBook(int index) {
		return arrayBookStore.get(index);
	}

}
