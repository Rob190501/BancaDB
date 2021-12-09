package connessioneDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import eccezioni.ConnessioneDBFallitaException;

public class Connessione {
	
	private static Connection connection = null;
	private String url = "jdbc:postgresql://localhost:5432/banca";
	private String user = "postgres";
	private String psw = "admin";
	
	private Connessione() throws Exception{
		try {
			
			Class.forName("org.postgresql.Driver");
			connection = DriverManager.getConnection(url, user, psw);
			
			System.out.println("Connessione ok");
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static Connection creaConnessione() throws Exception{
		if(connection == null) {
			try {
				new Connessione();
			}
			catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		return connection;
	}


}
