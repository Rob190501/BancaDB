package controller;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.List;

import javax.swing.table.DefaultTableModel;

import connessione.ConnessioneDB;
import dao.impl.PostgreSQL.ContoCorrenteDAOImpl;
import dao.impl.PostgreSQL.CorrentistaDAOImpl;
import dao.interfaccia.ContoCorrenteDAO;
import dao.interfaccia.CorrentistaDAO;
import dto.Correntista;
import dto.ContoCorrente;
import eccezioni.ConnessioneDBFallitaException;
import gui.HomeFrame;
import gui.LoginFrame;

public class Controller {
	
	private Connection connection;
	
	private CorrentistaDAO correntistaDAO;
	private ContoCorrenteDAO contoCorrenteDAO;
	
	private Correntista correntistaLoggato;
	
	private LoginFrame lf;
	private HomeFrame hf;
	
	
	public Controller() throws Exception{
		connection = ConnessioneDB.getIstanza().getConnection();
			
		contoCorrenteDAO = new ContoCorrenteDAOImpl(this, connection);
		
		correntistaDAO = new CorrentistaDAOImpl(this, connection);
		
		lf = new LoginFrame(this);
		
	}
	
	public Connection getConnection() {
		return this.connection;
	}
	
	public CorrentistaDAO getCorrentistaDAO() {
		return correntistaDAO;
	}
	
	public ContoCorrenteDAO getContoCorrenteDAO() {
		return contoCorrenteDAO;
	}
	
	public Correntista getCorrentistaLoggato() {
		return correntistaLoggato;
	}
	
	public boolean ottieniCredenziali(String CF) throws Exception{
		correntistaLoggato = correntistaDAO.getCorrentistaBYCF(CF);
		
		if(correntistaLoggato == null) {
			return false;
		}
		
		return true;
	}
	
	public void accessoRiuscito() throws Exception {
		lf.setVisible(false);
		
		hf = new HomeFrame(this);
	}
	
	public DefaultTableModel convertiRSTabella(ResultSet rs) throws Exception{
		//Create new table model
        DefaultTableModel tableModel = new DefaultTableModel();

        //Retrieve meta data from ResultSet
        ResultSetMetaData metaData = rs.getMetaData();

        //Get number of columns from meta data
        int columnCount = metaData.getColumnCount();
        
        String columnNames[] = new String[columnCount];

        //Get all column names from meta data and add columns to table model
        for (int columnIndex = 1; columnIndex <= columnCount; columnIndex++){
            tableModel.addColumn(metaData.getColumnLabel(columnIndex));
            columnNames[columnIndex-1] = metaData.getColumnName(columnIndex).toUpperCase();
        }

        tableModel.addRow(columnNames);
        
        //Create array of Objects with size of column count from meta data
        Object[] row = new Object[columnCount];
        
        
        
        //Scroll through result set
        while (rs.next()){
            //Get object from column with specific index of result set to array of objects
            for (int i = 0; i < columnCount; i++){
                row[i] = rs.getObject(i+1);
            }
            //Now add row to table model with that array of objects as an argument
            tableModel.addRow(row);
        }

        //Now add that table model to your table and you are done :D
        //table.setModel(tableModel);
		
        
        
		return tableModel;
	}
	
	public void boh() throws Exception{
		
		
	}
	
	
	
	public static void main(String args[]) {
		
		Controller c = null;
		
		try {
			c = new Controller();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		//prova github desktop
	}
}
