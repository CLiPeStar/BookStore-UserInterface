package control.BBDD;

import java.sql.Connection;
import java.sql.SQLException;

public class BbddBookStoreAccess {
	  private AccessBBDD accessMysql;
	  protected Connection connection = null;

	  protected BbddBookStoreAccess() throws SQLException, ClassNotFoundException {
	    accessMysql = AccessBBDD.instance();
	    connection = accessMysql.getConnection();
	  }
	}
