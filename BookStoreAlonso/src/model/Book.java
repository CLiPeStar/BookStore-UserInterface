package model;

import javax.swing.JOptionPane;

public class Book {
	private String isbn, title, author, editorial, format, state;
	private float price = 0f;

	public Book(String isbn, String title, String author, String editorial, float price, String format, String state) {
		super();

		assert isbn.isEmpty() || title.isEmpty() || author.isEmpty() || editorial.isEmpty();
		this.isbn = isbn;
		this.title = title;
		this.author = author;
		this.editorial = editorial;
		this.price = price;
		this.format = format;
		this.state = state;

	}

	public String getIsbn() {
		return isbn;
	}

	public String getTitle() {
		return title;
	}

	public String getAuthor() {
		return author;
	}

	public String getEditorial() {
		return editorial;
	}

	public float getPrice() {
		return price;
	}

	public String getFormat() {
		return format;
	}

	public String getState() {
		return state;
	}

	@Override
	public String toString() {

		return "ISBN : " + this.isbn + "\nTitle : " + this.title + "\nAuthor : " + this.author + "\nEditorial : "
				+ this.editorial + "\nPrice : " + this.price + "€" + "\nFormat : " + this.format + "\nState : " + this.state;
	}
}
