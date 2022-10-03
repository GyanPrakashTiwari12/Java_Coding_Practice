package test;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
private static Connection con=null;//reference variable
private DBConnection() {}
static {
	try {
	Class.forName("oracle.jdbc.driver.OracleDriver");
	con = DriverManager.getConnection
	("jdbc:oracle:thin:@localhost:1521:orcl","c##gyan","gpt2209");
	}catch(Exception e) {
		e.printStackTrace();
	}
}
	public static Connection getCon() {
		return con;
	}

}
