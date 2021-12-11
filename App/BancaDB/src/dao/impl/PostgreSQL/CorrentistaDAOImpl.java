package dao.impl.PostgreSQL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import controller.Controller;
import dao.interfaccia.CorrentistaDAO;
import dto.ContoCorrente;
import dto.Correntista;

public class CorrentistaDAOImpl implements CorrentistaDAO{
	
	private Controller controller;
	private Connection connection;
	
	public CorrentistaDAOImpl(Controller controller, Connection connection) {
		this.controller = controller;
		
		this.connection = connection;
	}
	
	@Override
	public Correntista getCorrentistaBYCF(String CF) throws Exception {
		String query = "SELECT * " +
				   	   "FROM Correntista " +
				   	   "WHERE CF = ?";
	
		PreparedStatement st = connection.prepareStatement(query);
		
		st.setString(1, CF);
		
		ResultSet rs = st.executeQuery();
		
		if(rs.next()) {
			return new Correntista(rs.getString("CF"), rs.getString("nome"), rs.getString("cognome"));
		}
			
		return null;
	}

	@Override
	public List<Correntista> getAllCorrentista() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean insertCorrentista(Correntista correntista) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateCorrentistaBYCF(String CF) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteCorrentistaBYCF(String CF) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}
	
	public boolean verificaCredenziali(String CF) throws Exception{
		
		String query = "SELECT * " +
			   	   "FROM Correntista " +
			   	   "WHERE CF = ?";

		PreparedStatement st = connection.prepareStatement(query);
	
		st.setString(1, CF);
	
		ResultSet rs = st.executeQuery();
		
		
		return false;
	}

}
