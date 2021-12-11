package controller;

import java.sql.Connection;
import connessione.ConnessioneDB;
import dao.impl.PostgreSQL.ContoCorrenteDAOImpl;
import dao.impl.PostgreSQL.CorrentistaDAOImpl;
import dao.interfaccia.ContoCorrenteDAO;
import dao.interfaccia.CorrentistaDAO;
import gui.LoginFrame;


public class Controller {
	
	private Connection connection;
	private ContoCorrenteDAO contoCorrenteDAO;
	private CorrentistaDAO correntistaDAO;
	private LoginFrame lf;
	
	public Controller() throws Exception{
		connection = ConnessioneDB.getIstanza().getConnection();
			
		contoCorrenteDAO = new ContoCorrenteDAOImpl(this, connection);
		
		correntistaDAO = new CorrentistaDAOImpl(this, connection);
		
		lf = new LoginFrame();
		lf.setVisible(true);
	}
	
	public Connection getConnection() {
		return this.connection;
	}
	
	public ContoCorrenteDAO getContoCorrenteDAO() {
		return contoCorrenteDAO;
	}
	
	public CorrentistaDAO getCorrentistaDAO() {
		return correntistaDAO;
	}
	
	public static void main(String args[]) {
		
		Controller c = null;
		
		try {
			c = new Controller();
			
			String IBAN = "ITG1212UW";
			
			String CF = "123";
			
			System.out.println(c.getContoCorrenteDAO().getContoCorenteBYIBAN(IBAN).stampaDettagliConto());
		
			System.out.println(c.getCorrentistaDAO().getCorrentistaBYCF(CF).stampaDettagliCorrentista());
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
	}
}
