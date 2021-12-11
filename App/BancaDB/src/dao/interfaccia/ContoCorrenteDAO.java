package dao.interfaccia;

import java.sql.ResultSet;
import java.util.List;

import dto.ContoCorrente;

public interface ContoCorrenteDAO {
	
	ContoCorrente getContoCorenteBYIBAN(String IBAN) throws Exception;
	
	ResultSet getContoCorrenteBYCFProprietario(String CFProprietario) throws Exception;
	
	List<ContoCorrente> getAllContoCorrente() throws Exception;
	
	boolean insertContoCorrente(ContoCorrente conto) throws Exception;
	
	boolean updateContoCorrente(String IBAN) throws Exception;
	
	boolean deleteContoCorrente(String IBAN) throws Exception;
	
}
