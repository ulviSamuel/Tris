package Bean;

import java.util.Timer;
import java.util.TimerTask;

import Graphics.Accoglienza;
import Graphics.AnimazioniVittoria;
import Graphics.BaseFrame;
import Graphics.Caricamento;
import Graphics.InizioPartitaTra;
import Graphics.MainMenu;
import Graphics.Mappa;
import Graphics.MenuPausa;
import Graphics.Simboli;

public class Tempo { //classe che gestisce il tempo

	private Timer tm = new Timer();
	private boolean visible = false; //se lo metto dentro alla classe che lo utilizza non funziona quando voglio dargli un valore
	private short cambiaTempo = 0;
	private static short conta = 0;
	
	public Tempo() {
		 
	}
	
	public void timerDelCaricamento() { //quando il caricamento deve finire
		Caricamento cs = new Caricamento();
		Accoglienza ac = new Accoglienza();
		
		tm.schedule( new java.util.TimerTask() { @Override public void run() { cs.caricamentoRemover(); ac.accoglienzaAdder(); } }, 5000);
	}
	
	public void timerDisegnaAuto() { //timer per il disegno automatico
		
		Mappa mp = new Mappa();
		
		tm.schedule( new java.util.TimerTask() { @Override public void run() { mp.disegnaAuto(); } }, 500);
	}
	
	public void effettoScritte() { //crea l'effetto del pre-menu
		Timer tmEs = new Timer();
		Accoglienza ac = new Accoglienza();
		
		
		tmEs.schedule(new TimerTask() {
		
		  @Override
		  public void run() {
			  if(visible) {
				  ac.accoglienzaNVisible();
				  visible = false;
			  } else {
				  ac.accoglienzaVisible();
				  visible = true;
			  }
		    if(!ac.getAttivo()) {
		    	tmEs.cancel();
		    }
		  }
		}, 0, 500);
		
	}
	
	public void effettoVittoria(short selezionato) { //l'effetto di quando vinco
		Timer tmEs = new Timer();
		AnimazioniVittoria av = new AnimazioniVittoria();
		Mappa m = new Mappa();
		
		m.clsPulsanti();
		
		visible = true;
		
		tmEs.schedule(new TimerTask() {
		
		  @Override
		  public void run() {
			  if(visible) {
				  av.vittoriaNotAdder(selezionato);
				  visible = false;
			  } else {
				  av.vittoriaAdder(selezionato);
				  visible = true;
			  }
		    if(av.getConta()==8) {
		    	  GestorePartita gp = new GestorePartita();
		    	  Simboli s = new Simboli();
				  Mappa m = new Mappa();
				  MainMenu mn = new MainMenu();
				  AnimazioniVittoria av = new AnimazioniVittoria();
				  
				  s.clsSimboli();
				  av.clsVittoria(selezionato);
				  m.mappaNotAdder();
				  mn.mainMenuAdder();
				  gp.finePartita();
				  tmEs.cancel();
		    }
		  }
		}, 0, 500);
		
	}
	
	public void inizioPartita() { //conto alla rovescia inizio partita tra
		Timer tmIp = new Timer();
		InizioPartitaTra ipt = new InizioPartitaTra();
		
		tmIp.schedule(new TimerTask() {
		
		  @Override
		  public void run() {
			  short conta = ipt.getConta(); //il fatto che la variabile viene ricreata ogni volta è fatto apposta
			  if(conta!=0) {
				  ipt.setTextTempoRimanente(conta);
			  }
			  else {
				  Mappa mp = new Mappa();
				  tmIp.cancel();
				  ipt.inizioPartitaNotAdder();
				  mp.mappaAdder();
				  BaseFrame.requestFocus();
			  }
		  }
		}, 0, 1000);	
	}
	
	public void tempoTraGiocatori() { //il timer di quando finisce il turno di un giocatore
		Timer tmTr = new Timer();
		Mappa m = new Mappa();
		MenuPausa mp = new MenuPausa();
		
		cambiaTempo = 0;
		
		tmTr.schedule(new TimerTask() {
		
		  @Override
		  public void run() {
			  
			  if(mp.isVisible()) {
				  tmTr.cancel();
			  } else {
				  if(cambiaTempo%5==0) conta = m.getConta(); //questa cosa risolve un bug che avevo quando prememvo di continuo il tastom esc in partita
				  if(conta!=0) {
					  if(cambiaTempo%5==0) m.setTextTempo(conta); //questa cosa risolve un bug che avevo quando prememvo di continuo il tastom esc in partita
					  GestorePartita gp = new GestorePartita();
					  if(gp.getPassato()==9) {
						  
						  if(gp.getVittorioso()==0) effettoVittoria((short) 8);
						  
						  tmTr.cancel();
					  } else {
						  cambiaTempo++;
					  }
				  }
			  }
		  }
		}, 0, 200);	
	}
}
