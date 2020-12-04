package control.BBDD;

import java.sql.CallableStatement;
import java.sql.SQLException;
import java.sql.Types;

import model.Book;

public class CallerBooks extends BbddBookStoreAccess implements Operationable {

	public CallerBooks() throws SQLException, ClassNotFoundException {
		super();
	}

	@Override
	public boolean insertBook(Book book) throws SQLException {
		CallableStatement cstmt = (CallableStatement) connection.prepareCall("{call InsertBook(?, ?,?,?,?,?,?,?,?,?)}");
		cstmt.setString(1, book.getIsbn());
		cstmt.setString(2, book.getAuthor());
		cstmt.setString(3, book.getTitle());
		cstmt.setString(4, book.getEditorial());
		cstmt.setInt(5, book.getThematic().ordinal());
		cstmt.setInt(6, 1);
		cstmt.setInt(7, 2);
		cstmt.setInt(8, book.getUnits());
		cstmt.setFloat(9, book.getPrice());
		cstmt.registerOutParameter(10, Types.BOOLEAN);
		cstmt.execute();
		return cstmt.getBoolean(10);
	}

	@Override
	public boolean deleteBook(Book book) throws SQLException {
		CallableStatement cstmt = (CallableStatement) connection.prepareCall("{call DeleteBook(?, ?)}");
		cstmt.setString(1, book.getIsbn());
		cstmt.registerOutParameter(2, Types.BOOLEAN);
		cstmt.execute();
		return cstmt.getBoolean(2);
	}

	@Override
	public boolean selectBook(Book book) throws SQLException {
		CallableStatement cstmt = (CallableStatement) connection.prepareCall("{call SelectBook(?, ?)}");
		cstmt.setString(1, "");
		cstmt.registerOutParameter(2, Types.BOOLEAN);
		cstmt.execute();
		return cstmt.getBoolean(2);
	}

	@Override
	public boolean updateBook(Book book) throws SQLException {
		CallableStatement cstmt = (CallableStatement) connection.prepareCall("{call UpdateBook(?, ?)}");
		cstmt.setString(1, "");
		cstmt.registerOutParameter(2, Types.BOOLEAN);
		cstmt.execute();
		return cstmt.getBoolean(2);
	}

}
