package pkg;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseManager {

	private static Connection databaseConection;
	
	private static String CONNECTION_STRING = "jdbc:oracle:thin:@localhost:1521:xe";
	private static String USER = "FOODIT";
	private static String PASSWORD = "FOODIT";
	

	static {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			System.out.println("No tienes el driver en el BuildPath");
			e.printStackTrace();
		}
		
		try {
			databaseConection = DriverManager.getConnection(CONNECTION_STRING, USER, PASSWORD);
		}
		catch (SQLException e) {
			System.out.println("Error al conectarse a la base de datos");
		}
	}
	
	public static Connection getConnection() {
		return databaseConection;
	}
}