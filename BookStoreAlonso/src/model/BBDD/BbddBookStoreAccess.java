package model.BBDD;

import java.sql.Connection;
import java.sql.SQLException;

public class BbddBookStoreAccess {
	  private AccessBBDD accessMysql;
	  protected Connection connection = null;
	  protected final String USER;
	  protected final String PASSWORD;
	  protected final String URL;
	  

	  protected BbddBookStoreAccess() throws SQLException, ClassNotFoundException {
	    accessMysql = AccessBBDD.instance();
	    connection = accessMysql.getConnection();
	    this.PASSWORD=accessMysql.getPassword();
	    this.URL=accessMysql.getURL();
	    this.USER=accessMysql.getUser();
	  }
	}
