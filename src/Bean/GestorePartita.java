package Bean;

import Graphics.AnimazioniVittoria;
import Graphics.Simboli;

public class GestorePartita { //gestisce la partita in generale
	
	private static short mappa[][] = { //punti della tabella occupati
            { 0, 0, 0, }, 
            { 0, 0, 0, }, 
            { 0, 0, 0 } 
        };
	private static short passato = 0; //quante simboli ci sono i tabella
	private static short vittorioso = 0; //chi vince

	public GestorePartita() {
		
	}
	
	public short getPassato() {
		if(vittorioso!=0) passato = 9; //se nessuno vince fai finire la partita
		return passato;
	}
	
	public short getVittorioso() {
		return vittorioso;
	}
	
	public boolean getPuntoOccupato(int riga, int colonna) { //dimmi se questo punto è occupato
		boolean torna = false;
		if(mappa[riga][colonna]==0) torna = true;
		
		return torna;
	}
	
	public short getPuntoGiocatoreOccupato(int riga, int colonna) { //chi occupa il punto
		return mappa[riga][colonna];
	}
	
	public void disegna(int griglia) { //fa una serie di controlli
		Simboli s = new Simboli();
		GestoreGiocatore gg = new GestoreGiocatore();
		
		if(gg.getGiocatore()) s.visibleX(griglia);
		else s.visibleO(griglia);
		
		cambiaMappa(griglia, gg.getGiocatore());
		
		if(passato>=4) {
			verificaVittoria();
		}
		
		gg.cambiaGiocatore();
		
		passato++;
	}
	
	public void cambiaMappa(int griglia, boolean giocatore) { //dopo aver disegnato memorizza dove ha diseganto e chi
		if(griglia>=0 && griglia<=2) {
			if(giocatore) mappa[0][griglia] = 1;
			else mappa[0][griglia] = 2;
		} else {
			if(griglia>=3 && griglia<=5) {
				if(giocatore) mappa[1][griglia-3] = 1;
				else mappa[1][griglia-3] = 2;
			} else {
				if(giocatore) mappa[2][griglia-6] = 1;
				else mappa[2][griglia-6] = 2;
			}
		}
	}
	
	public void verificaVittoria() { //verifica se qualcuno ha vinto
		
		AnimazioniVittoria av = new AnimazioniVittoria();
		Tempo tm = new Tempo();
		
		vittorioso = 0;
		
		if(mappa[0][0]!=0) {
			if(mappa[0][0]==mappa[0][1] && mappa[0][1]==mappa[0][2]) {
				vittorioso = mappa[0][1]; //verificare così (con i casi di vittoria già predisposti) senza leggere il vettore e verificare se ci sono ripetizioni a livello riorse costa meno e occupa meno ram (meno variabili), inoltre sono poche
				av.vittoriaAdder((short) 0);
				tm.effettoVittoria((short) 0);
			}
		}
		if(vittorioso==0 && mappa[1][0]!=0) {
			if(mappa[1][0]==mappa[1][1] && mappa[1][1]==mappa[1][2]) {
				vittorioso = mappa[1][0]; //prima di eseguire la verifica verifico che il primo valore da analizzare sia diverso da 0 sennò in automatico non è uan vittoria altrimenti se ci sarà uno 0 in un posto diverso verrà identificato come diverso dal primo valore e di conseguenza non considerato una vittora (in modo da non far vincere quando nel vettore ci sono tre 0 nelle posizioni di vittoria)
				av.vittoriaAdder((short) 1);
				tm.effettoVittoria((short) 1);
			}
		}
		if(vittorioso==0 && mappa[2][0]!=0) {
			if(mappa[2][0]==mappa[2][1] && mappa[2][1]==mappa[2][2]) {
				vittorioso = mappa[2][0];
				av.vittoriaAdder((short) 2);
				tm.effettoVittoria((short) 2);
			}
		}
		if(vittorioso==0 && mappa[0][0]!=0) {
			if(mappa[0][0]==mappa[1][0] && mappa[1][0]==mappa[2][0]) {
				vittorioso = mappa[0][0];
				av.vittoriaAdder((short) 3);
				tm.effettoVittoria((short) 3);
			}
		}
		if(vittorioso==0 && mappa[0][1]!=0) {
			if(mappa[0][1]==mappa[1][1] && mappa[1][1]==mappa[2][1]) {
				vittorioso = mappa[0][1];
				av.vittoriaAdder((short) 4);
				tm.effettoVittoria((short) 4);
			}
		}
		if(vittorioso==0 && mappa[0][2]!=0) {
			if(mappa[0][2]==mappa[1][2] && mappa[1][2]==mappa[2][2]) {
				vittorioso = mappa[0][2];
				av.vittoriaAdder((short) 5);
				tm.effettoVittoria((short) 5);
			}
		}
		if(vittorioso==0 && mappa[0][0]!=0) {
			if(mappa[0][0]==mappa[1][1] && mappa[1][1]==mappa[2][2]) {
				vittorioso = mappa[0][0];
				av.vittoriaAdder((short) 7);
				tm.effettoVittoria((short) 7);
			}
		}
		if(vittorioso==0 && mappa[0][2]!=0) {
			if(mappa[0][2]==mappa[1][1] && mappa[1][1]==mappa[2][0]) {
				vittorioso = mappa[0][2];
				av.vittoriaAdder((short) 6);
				tm.effettoVittoria((short) 6);
			}
		}
	}
	
	public void finePartita() { //azzera tutti i dati
		passato = 0;
		vittorioso = 0;
		for(short i=0;i<3;i++) {
			for(short j=0;j<3;j++) {
				mappa[i][j] = 0;
			}
		}
	}
}
