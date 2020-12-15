package control.BBDD;

import java.sql.CallableStatement;
import java.sql.SQLException;
import java.sql.Types;
import java.text.Format;

import model.Formats;
import model.State;
import model.Thematic;
import model.BBDD.BbddBookStoreAccess;

public class AñadirDatos extends BbddBookStoreAccess {

	protected AñadirDatos() throws SQLException, ClassNotFoundException {
		super();
	}

	public boolean insertState() throws SQLException {
		CallableStatement cstmt = (CallableStatement) connection.prepareCall("{call InsertState(?, ?)}");
		for (int i = 0; i < State.values().length; i++) {
			cstmt.setString(1, State.values()[i].name());
			cstmt.registerOutParameter(2, Types.BOOLEAN);
			cstmt.execute();
		}
		return cstmt.getBoolean(2);
	}

	public boolean insertFormat() throws SQLException {
		CallableStatement cstmt = (CallableStatement) connection.prepareCall("{call InsertFormat(?, ?)}");
		for (int i = 0; i < Formats.values().length; i++) {
			cstmt.setString(1, Formats.values()[i].name());
			cstmt.registerOutParameter(2, Types.BOOLEAN);
			cstmt.execute();
		}
		return cstmt.getBoolean(2);
	}

	public boolean inserttematica() throws SQLException {
		CallableStatement cstmt = (CallableStatement) connection.prepareCall("{call InsertTematic(?, ?)}");
		for (int i = 0; i < Thematic.values().length; i++) {
			cstmt.setString(1, Thematic.values()[i].name());
			cstmt.registerOutParameter(2, Types.BOOLEAN);
			cstmt.execute();
		}
		return cstmt.getBoolean(2);
	}

	public static void main(String[] args) {
		try {
			AñadirDatos add = new AñadirDatos();
			add.inserttematica();
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}
