package control.BBDD;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.ArrayList;

import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.JdbcRowSet;
import javax.sql.rowset.RowSetFactory;
import javax.sql.rowset.RowSetProvider;

import model.Book;
import model.Formats;
import model.State;
import model.Thematic;
import model.BBDD.BbddBookStoreAccess;
import model.BBDD.Operationable;

public class CallerBooks extends BbddBookStoreAccess implements Operationable {

	private RowSetFactory myRowSetFactory = null;
	private CachedRowSet cacheRowSet = null;
	private JdbcRowSet rowSet = null;

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
	public boolean deleteBook(String isbn) {
		try {

			myRowSetFactory = RowSetProvider.newFactory();
			rowSet = myRowSetFactory.createJdbcRowSet();

			rowSet.setUrl(URL);
			rowSet.setUsername(USER);
			rowSet.setPassword(PASSWORD);

			rowSet.setCommand("SELECT * FROM libro");
			rowSet.execute();

			while (rowSet.next()) {
				if (rowSet.getString(2).equals(isbn))
					rowSet.deleteRow();
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				rowSet.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}

		return true;
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
//		CallableStatement cstmt = (CallableStatement) connection.prepareCall("{call UpdateBook(?, ?,?,?,?,?,?,?,?,?)}");
//		cstmt.setString(1, book.getIsbn());
//		cstmt.setString(2, book.getAuthor());
//		cstmt.setString(3, book.getTitle());
//		cstmt.setString(4, book.getEditorial());
//		cstmt.setInt(5, book.getThematic().getId());// tematica
//		cstmt.setInt(6, book.getStateId());// State
//		cstmt.setInt(7, book.getFormatId());// format
//		cstmt.setInt(8, book.getUnits());
//		cstmt.setFloat(9, book.getPrice());
//		cstmt.registerOutParameter(10, Types.BOOLEAN);
//		cstmt.execute();
//		return cstmt.getBoolean(10);
		try {
			myRowSetFactory = RowSetProvider.newFactory();
			cacheRowSet = myRowSetFactory.createCachedRowSet();

			cacheRowSet.setUrl(URL);
			cacheRowSet.setUsername(USER);
			cacheRowSet.setPassword(PASSWORD);
			
			cacheRowSet.setCommand("SELECT * FROM libro");
			cacheRowSet.execute();
			
			while (cacheRowSet.next()) {
				if (rowSet.getString(2).equals(book.getIsbn())) {
					cacheRowSet.updateString(3, book.getAuthor());
					cacheRowSet.updateString(4,book.getTitle());
					cacheRowSet.updateString(5, book.getEditorial());
					cacheRowSet.updateInt(6,book.getThematic().getId());
					cacheRowSet.updateInt(7,book.getStateId());
					cacheRowSet.updateInt(8,book.getFormatId());
					cacheRowSet.updateInt(9,book.getUnits());
					cacheRowSet.updateFloat(10,book.getPrice());
					cacheRowSet.updateRow();
				}
			}

			cacheRowSet.acceptChanges(connection);
			cacheRowSet.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return true;
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
