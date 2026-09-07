package Graphics;

import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Bean.Audio;
import Bean.Tempo;

public class Accoglienza { //l'accoglienza
	
	private static JPanel acc = new JPanel();
	private static boolean attivo = false; //se l'utente è entrato nella schermata dell'accoglienza allora risulterà true
		
	public Accoglienza(){
		
	}
	
	public boolean getAttivo() {
		return attivo;
	}
	
	public void inizializzaAccoglienza() { //aggiunge ma non rende visibile il panel, vale per tutte le classi
		
		acc.setLayout(null);
		acc.setBounds(0, 0, 436, 413);
		acc.setBackground(Color.black);
		
		JLabel trisLogo = new JLabel("");
		trisLogo.setIcon(new ImageIcon("img\\tris-logo.png"));
		trisLogo.setBounds(20, 40, 426, 275);
		acc.add(trisLogo);
		
		JLabel enterText = new JLabel("PREMERE INVIO PER GIOCARE");
		enterText.setForeground(Color.WHITE);
		enterText.setBounds(130, 375, 201, 13);
		acc.add(enterText);
		
		BaseFrame.addPanel(acc);
	}
	
	public void accoglienzaAdder() { //primo frame dell'accoglienza, rende visibile la classe e fa partire un timer semi-infinito
		Tempo tm = new Tempo();
		BaseFrame.visiblePanel(acc);
		attivo = true;
		tm.effettoScritte();
	}
	
	public void accoglienzaVisible() { //rende visibile il panel, vale solo per vittoria e accoglienza
		Audio ad = new Audio();
		BaseFrame.visiblePanel(acc);
		ad.suonaSigla(); //faccio partire la sigla
		
	}
	
	public void accoglienzaNVisible() { //rende invisibile il panel, vale per tutte le classi
		BaseFrame.notVisiblePanel(acc);
	}
	
	public void accoglienzaRemover() { //rimuove definitivamente il panel dal frame, vale solo per l'accoglienza e il caricamento
		BaseFrame.removePanel(acc);
		attivo = false;
	}
}
