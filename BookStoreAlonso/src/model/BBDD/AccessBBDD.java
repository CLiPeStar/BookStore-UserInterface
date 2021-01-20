package model.BBDD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class AccessBBDD {
	private String user = null;
	private String password = null;
	private String nameDB = null;

	private String URL =  "jdbc:mysql://localhost:3306/model?useInformationSchema=true&serverTimezone=EST5EDT";
	private final String DRIVER = "com.mysql.cj.jdbc.Driver";
	private Connection connection = null;

	private static AccessBBDD access = null;

	public static AccessBBDD instance() throws SQLException, ClassNotFoundException {
		if (access == null) {
			return new AccessBBDD();
		}
		return access;
	}

	private AccessBBDD() throws SQLException, ClassNotFoundException {
		super();
		nameDB = "libreria";
		user = "root";
		password = "";
		this.URL = this.URL.replace("model", nameDB);

		Class.forName(this.DRIVER);

		connection = DriverManager.getConnection(this.URL, this.user, this.password);
	}
	public Connection getConnection() {
	    return connection;
	  }

	public String getUser() {
		return user;
	}

	public String getPassword() {
		return password;
	}

	public String getURL() {
		return URL;
	}
	
}
