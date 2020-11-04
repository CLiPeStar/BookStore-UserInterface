package model;

import javax.swing.JOptionPane;

public class Book {
	private String isbn, title, author, editorial, format, state;
	private Thematic thematic;
	private float price = 0f;
	private int units;

	public Book(String isbn, String title, String author, String editorial, float price, String format, String state,
			int units, Thematic thematic) {
		super();

		this.isbn = isbn;
		this.title = title;
		this.author = author;
		this.editorial = editorial;
		this.price = price;
		this.format = format;
		this.state = state;
		this.units = units;
		this.thematic=thematic;

	}

	public void changeValueUnitsDelete(int units) {
		this.units = this.units-units;
	}
	public void changeValueUnitsAdd(int units) {
		this.units = this.units+units;
	}

	public int getUnits() {
		return units;
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
	

	public Thematic getThematic() {
		return thematic;
	}

	@Override
	public String toString() {

		return "ISBN : " + this.isbn + "\nTitle : " + this.title + "\nAuthor : " + this.author + "\nEditorial : "
				+ this.editorial + "\nPrice : " + this.price + "€" + "\nFormat : " + this.format + "\nState : "
				+ this.state + "\nUnits : " + this.units;
	}
}
