package Business;

import Bean.Audio;
import Graphics.Accoglienza;
import Graphics.AnimazioniVittoria;
import Graphics.BaseFrame;
import Graphics.Caricamento;
import Graphics.InizioPartitaTra;
import Graphics.MainMenu;
import Graphics.Mappa;
import Graphics.MenuPausa;
import Graphics.Simboli;

public class Console {

	public Console() {
		
	}
	
	public void esegui() {
		BaseFrame bs = new BaseFrame(); //l'unica classe con il costruttore e non il metodo inizializza in quanto viene dichoarat solo qui mentre gli altri anche in altre classi di conseguenza se usassi i costruttori ogni dichiarazione ricreerebbe il panel, l'unico modo sarebbe utlizzare static per ogni metodo ma non è elegantissimo
		MenuPausa mpa = new MenuPausa();
		Caricamento cs = new Caricamento();
		Accoglienza ac = new Accoglienza();
		Audio ad = new Audio();
		MainMenu mn = new MainMenu();
		InizioPartitaTra ipt = new InizioPartitaTra();
		Mappa mp = new Mappa();
		Simboli s = new Simboli();
		AnimazioniVittoria av = new AnimazioniVittoria();
		
		cs.inizializzaCaricamento(); //carico fin da subito e nel frattempo che carica mostro una finestra di caricamento, in modo da non ritrovarmi con schermi bianchi mentre uso il programma
		ac.inizializzaAccoglienza(); //tutto viene caricato in base a quando li utilizzo tranne per i simboli e gli effetti di vittoria che vanno caricati prima della mappa anche se utilizzati prima in quanto altrimenti verrebbero sovvrastati
		ad.inizializzaSigla();
		mpa.inizializzaMenuPausa();
		mn.inizializzaMainMenu();
		ipt.inizializzaInizioPartitaTra();
		av.inizializzaVittorie();
		s.add();
		mp.inizializzaMappa();
	}
}
