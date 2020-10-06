package control;

import java.util.HashMap;

import model.Book;
import model.BookStore;

public class BookStoreController {

	private BookStore arrayBookStore = new BookStore();

	public BookStoreController() {
		super();
		this.arrayBookStore = arrayBookStore;
	}

	public HashMap<String, Book> getHasMapBookStore() {
		return this.arrayBookStore.getHasBookStore();
	}

	public int getSize() {
		return arrayBookStore.getSize();
	}


	public Book searchBook(String ISBN) {
		return arrayBookStore.searchBook(ISBN);
	}

	public void addBook(String ISBN, Book book) {
		arrayBookStore.addBook(ISBN, book);
		;
	}

	public void deleteBook(String ISBN) {
		arrayBookStore.deleteBook(ISBN);
		;
	}

}
