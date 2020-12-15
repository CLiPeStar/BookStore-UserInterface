package control.BBDD;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.ArrayList;

import model.Book;
import model.Formats;
import model.State;
import model.Thematic;
import model.BBDD.BbddBookStoreAccess;

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
		cstmt.setInt(5, book.getThematic().getId());// tematica
		cstmt.setInt(6, book.getStateId());// State
		cstmt.setInt(7, book.getFormatId());// format
		cstmt.setInt(8, book.getUnits());
		cstmt.setFloat(9, book.getPrice());
		cstmt.registerOutParameter(10, Types.BOOLEAN);
		cstmt.execute();
		return cstmt.getBoolean(10);
	}

	@Override
	public boolean deleteBook(String isbn) throws SQLException {
		CallableStatement cstmt = (CallableStatement) connection.prepareCall("{call DeleteBook(?, ?)}");
		cstmt.setString(1, isbn);
		cstmt.registerOutParameter(2, Types.BOOLEAN);
		cstmt.execute();
		return cstmt.getBoolean(2);
	}

	@Override
	public ArrayList<Book> selectBook() {
		ArrayList<Book> books = new ArrayList<Book>();
		try (Statement miStatement = connection.createStatement();
				ResultSet miResulSet = miStatement.executeQuery("SELECT * FROM libro");) {

			while (miResulSet.next()) {
				String format = getFormat(miResulSet.getInt("formato"));
				String state = getState(miResulSet.getInt("estado"));
				Thematic thematic = getThematic(miResulSet.getInt("tematica"));
				Book book = new Book(miResulSet.getString("isbn"), miResulSet.getString("titulo"),
						miResulSet.getString("autor"), miResulSet.getString("editorial"), miResulSet.getFloat("precio"),
						format, state, miResulSet.getInt("unidades"), thematic);
				books.add(book);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return books;
	}

	@Override
	public boolean updateBook(Book book) throws SQLException {
		CallableStatement cstmt = (CallableStatement) connection.prepareCall("{call UpdateBook(?, ?,?,?,?,?,?,?,?,?)}");
		cstmt.setString(1, book.getIsbn());
		cstmt.setString(2, book.getAuthor());
		cstmt.setString(3, book.getTitle());
		cstmt.setString(4, book.getEditorial());
		cstmt.setInt(5, book.getThematic().getId());// tematica
		cstmt.setInt(6, book.getStateId());// State
		cstmt.setInt(7, book.getFormatId());// format
		cstmt.setInt(8, book.getUnits());
		cstmt.setFloat(9, book.getPrice());
		cstmt.registerOutParameter(10, Types.BOOLEAN);
		cstmt.execute();
		return cstmt.getBoolean(10);
	}

	private String getFormat(int id) throws SQLException {
		CallableStatement cstmt = (CallableStatement) connection.prepareCall("{call getFormat(?, ?)}");
		cstmt.setInt(1, id);
		cstmt.registerOutParameter(2, Types.VARCHAR);
		cstmt.execute();
		for (Formats format : Formats.values()) {
			if (format.getName().equals(cstmt.getString(2))) {
				return format.getName();
			}
		}
		return null;
	}

	private String getState(int id) throws SQLException {
		CallableStatement cstmt = (CallableStatement) connection.prepareCall("{call getState(?, ?)}");
		cstmt.setInt(1, id);
		cstmt.registerOutParameter(2, Types.VARCHAR);
		cstmt.execute();
		for (State state : State.values()) {
			if (state.getName().equals(cstmt.getString(2))) {
				return state.getName();
			}
		}
		return null;
	}

	private Thematic getThematic(int id) throws SQLException {
		CallableStatement cstmt = (CallableStatement) connection.prepareCall("{call getTematica(?, ?)}");
		cstmt.setInt(1, id);
		cstmt.registerOutParameter(2, Types.VARCHAR);
		cstmt.execute();
		for (Thematic thematic : Thematic.values()) {
			if (thematic.getName().equals(cstmt.getString(2))) {
				return thematic;

			}
		}
		return null;
	}

}
