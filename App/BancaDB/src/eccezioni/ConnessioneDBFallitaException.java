package eccezioni;

public class ConnessioneDBFallitaException extends Exception {

	public ConnessioneDBFallitaException () {
		super("Connessione al DB non riuscita.");
	}

}
