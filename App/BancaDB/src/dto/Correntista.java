package dto;

import java.util.List;

public class Correntista {
	
	private String CF;
	private String nome;
	private String cognome;
	private List<ContoCorrente> conti;
	
	public Correntista(String CF, String nome, String cognome) {
		this.setCF(CF);
		this.setNome(nome);
		this.setCognome(cognome);
	}

	public String getCF() {
		return CF;
	}

	public void setCF(String cF) {
		CF = cF;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}
	
	public String stampaDettagliCorrentista() {
		String s = "Nome: " + this.nome + " | Cognome: " + this.cognome + " | CF: " + this.CF;
		
		return s;
	}
	
}
