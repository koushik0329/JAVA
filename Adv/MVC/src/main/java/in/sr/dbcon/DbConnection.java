package in.sr.dbcon;

import java.sql.*;

public class DbConnection{
	public static Connection getConnection() {
		Connection con=null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","koushikkoushik");
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return con;
	}

}
