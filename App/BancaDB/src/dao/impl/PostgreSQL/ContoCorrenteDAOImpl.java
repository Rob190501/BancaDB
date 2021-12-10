package dao.impl.PostgreSQL;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import controller.Controller;
import dao.interfaccia.ContoCorrenteDAO;
import dto.ContoCorrente;

public class ContoCorrenteDAOImpl implements ContoCorrenteDAO{
	
	private Controller controller;
	private Connection connection;
	
	public ContoCorrenteDAOImpl(Controller controller, Connection connection) {
		this.controller = controller;
		
		this.connection = connection;
	}
	
	@Override
	public ContoCorrente getContoCorenteBYIBAN(String IBAN) throws Exception{
		String query = "SELECT * " +
					   "FROM ContoCorrente " +
					   "WHERE IBAN = ?";
		
		
		
		PreparedStatement st = connection.prepareStatement(query);
		
		st.setString(1, IBAN);
		
		ResultSet rs = st.executeQuery();
		
//		while(rs.next()) {
//			System.out.printf("%s - %d - %s\n", rs.getString("IBAN"), rs.getInt("saldo"), rs.getString("CFCorrentista"));
//		}
		
		
		rs.next();
		
		return new ContoCorrente(rs.getString("IBAN"), rs.getInt("saldo"), rs.getString("CFCorrentista"));
	}

	@Override
	public List<ContoCorrente> getAllContoCorrente() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean insertContoCorrente(ContoCorrente conto) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateContoCorrente(String IBAN) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteContoCorrente(String IBAN) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}
	
	

}
