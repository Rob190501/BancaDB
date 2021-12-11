package dao.interfaccia;

import java.util.List;
import dto.Correntista;

public interface CorrentistaDAO {
	
	Correntista getCorrentistaBYCF(String CF) throws Exception;
	
	List<Correntista> getAllCorrentista() throws Exception;
	
	boolean insertCorrentista(Correntista correntista) throws Exception;
	
	boolean updateCorrentistaBYCF(String CF) throws Exception;
	
	boolean deleteCorrentistaBYCF(String CF) throws Exception;
	
}
