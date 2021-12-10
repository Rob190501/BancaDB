package dao.interfaccia;

import java.util.List;

import entità.ContoCorrente;

public interface ContoCorrenteDAO {
	
	ContoCorrente getContoCorenteBYIBAN(String IBAN) throws Exception;
	
	List<ContoCorrente> getAllContoCorrente() throws Exception;
	
	boolean insertContoCorrente(ContoCorrente conto) throws Exception;
	
	boolean updateContoCorrente(String IBAN) throws Exception;
	
	boolean deleteContoCorrente(String IBAN) throws Exception;
	
}
