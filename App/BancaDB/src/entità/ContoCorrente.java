	
package entità;

public class ContoCorrente {

	private String IBAN;
	private int saldo;
	private String CFConrrentista;
	
	public ContoCorrente(String IBAN, int saldo, String CFCorrentista) {
		this.IBAN = IBAN;
		this.saldo = saldo;
		this.CFConrrentista = CFCorrentista;
	}

	public String getIBAN() {
		return IBAN;
	}

	public void setIBAN(String IBAN) {
		this.IBAN = IBAN;
	}

	public int getSaldo() {
		return saldo;
	}

	public void setSaldo(int saldo) {
		this.saldo = saldo;
	}

	public String getCFConrrentista() {
		return CFConrrentista;
	}

	public void setCFConrrentista(String cFConrrentista) {
		CFConrrentista = cFConrrentista;
	}
}
