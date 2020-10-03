package control;

import model.Book;
import model.BookStore;
public class BookStoreController {
	
	private BookStore arrayBookStore = new BookStore();

	public BookStoreController() {
		super();
		this.arrayBookStore = arrayBookStore;
	}
	
	
	
	public int getSize() {
		return arrayBookStore.getSize();
	}
	public  Book getBook(int index) {
		return arrayBookStore.getBook(index);
	}
	public Book searchBook(String ISBN) {
		return arrayBookStore.searchBook(ISBN);
	}
	public void addBook(Book book) {
		arrayBookStore.addBook(book);;
	}
	public void deleteBook(int index) {
		arrayBookStore.deleteBook(index);;
	}

	

}
