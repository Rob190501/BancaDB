package controller;

import java.sql.Connection;
import connessione.ConnessioneDB;
import dao.impl.PostgreSQL.ContoCorrenteDAOImpl;
import dao.interfaccia.ContoCorrenteDAO;


public class Controller {
	
	private Connection connection;
	private ContoCorrenteDAO contoCorrenteDAO;
	
	public Controller() throws Exception{
		connection = ConnessioneDB.getIstanza().getConnection();
			
		contoCorrenteDAO = new ContoCorrenteDAOImpl(this, connection);
	}
	
	public Connection getConnection() {
		return this.connection;
	}
	
	public ContoCorrenteDAO getContoCorrenteDAO() {
		return contoCorrenteDAO;
	}
	
	public static void main(String args[]) {
		
		Controller c = null;
		
		try {
			c = new Controller();
			
			String IBAN = "ITG1212UW";
			
//			System.out.println(IBAN);
			
			System.out.println(c.getContoCorrenteDAO().getContoCorenteBYIBAN(IBAN).stampaDettagliConto());
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
	}
}
