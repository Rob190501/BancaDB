package controllore;

import java.sql.Connection;

import connessioneDB.Connessione;
import eccezioni.ConnessioneDBFallitaException;

public class Controllore {
	
	public static void main(String args[]) throws Exception{
		
		
		try {
			Connection con = Connessione.creaConnessione();
			
			
			
			//con.close();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
		//System.out.println("Connessione OK");
	}
	
}
