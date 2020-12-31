package model.BBDD;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Book;

public interface Operationable {
	public boolean insertBook(Book book) throws SQLException;

	public boolean deleteBook(String isbn) throws SQLException;

	public ArrayList<Book> selectBook() throws SQLException;

	public boolean updateBook(Book book) throws SQLException;
}
