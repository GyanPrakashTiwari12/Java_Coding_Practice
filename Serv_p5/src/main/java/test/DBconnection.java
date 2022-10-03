package test;
import java.sql.*;
public class DBconnection {
private static Connection con=null;//Reference variable
private DBconnection() {}
static {
	try {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		con = DriverManager.getConnection
	("jdbc:oracle:thin:@localhost:1521:orcl","c##gyan","gpt2209");
	}catch(Exception e) {
		e.printStackTrace();
	}
}//end of block
public static Connection getcon() {
	return con;
	}
}
