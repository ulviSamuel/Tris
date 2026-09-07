package Bean;

public class GestoreGiocatore { //gestisce il giocatore
	
	private static boolean giocatore = true; //il simbolo che uso

	public GestoreGiocatore() {
		
	}
	
	public boolean getGiocatore() {
		return giocatore;
	}
	
	public void cambiaGiocatore() {
		giocatore = !giocatore;
	}
}
