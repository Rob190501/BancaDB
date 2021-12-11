package dto;

import java.util.List;

public class ContoCorrente {

	private String IBAN;
	private int saldo;
	private String CFCorrentista;
	
	public ContoCorrente(String IBAN, int saldo) {
		this.setIBAN(IBAN);
		this.setSaldo(saldo);
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
	
	public String stampaDettagliConto() {
		String s = "IBAN: " + IBAN + " | Saldo: " + saldo; 
		
		return s;  
	}
}
