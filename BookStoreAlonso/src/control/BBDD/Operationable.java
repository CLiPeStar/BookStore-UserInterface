package control.BBDD;

import java.sql.SQLException;

import model.Book;

public interface Operationable {
	public boolean insertBook(Book book) throws SQLException;

	public boolean deleteBook(Book book) throws SQLException;

	public boolean selectBook(Book book) throws SQLException;

	public boolean updateBook(Book book) throws SQLException;
}
