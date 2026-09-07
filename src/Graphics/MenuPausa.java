package Graphics;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JPanel;

import Bean.GestorePartita;

public class MenuPausa { //gestisce il menu di pausa

	private static JPanel mp = new JPanel();
	private MainMenu mm = new MainMenu();
	private Mappa m = new Mappa();
	private static boolean mmTolto = false; //mi dice se lo sto utilizzando con la mappa o nel main menu
	
	public MenuPausa() {
		
	}
	
	public boolean getMmTolto() {
		return mmTolto;
	}
	
	public boolean isVisible() {
		return mp.isVisible();
	}
	
	public void ricliccato() { //se clicco due volte esc fa le stesse funzioni di continua
		menuPausaNotAdder();
	}
	
	public void inizializzaMenuPausa() {
		
		mp.setBackground(Color.BLACK);
		mp.setBounds(0, 0, 436, 413);
		mp.setLayout(null);
		
		JButton continua = new JButton("CONTINUA");
		continua.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) { //toglie il menu di pausa e riaggiunge quello che c'era prima
				menuPausaNotAdder();
				if(mmTolto) mm.mainMenuAdder();
				else m.riaggiungiMappa();
				BaseFrame.requestFocus();
			}
		});
		continua.setForeground(Color.WHITE);
		continua.setFocusPainted(false);
		continua.setBorderPainted(false);
		continua.setBackground(new Color(0, 0, 255));
		continua.setBounds(155, 161, 130, 40);
		mp.add(continua);
		
		JButton esci = new JButton("ESCI");
		esci.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) { //se mi trovo nel main menu esco dal gioco mentre se mi trovo in partita esco dalla partita
				if(mmTolto) {
					System.exit(0);
				} else {
					
					GestorePartita gp = new GestorePartita();
			    	Simboli s = new Simboli();
					Mappa m = new Mappa();
					  
					s.clsSimboli();
					m.mappaNotAdder();
					mm.mainMenuAdder();
					menuPausaNotAdder();
					BaseFrame.requestFocus();
					gp.finePartita();
				}
			}
		});
		esci.setForeground(Color.WHITE);
		esci.setFocusPainted(false);
		esci.setBorderPainted(false);
		esci.setBackground(Color.RED);
		esci.setBounds(155, 211, 130, 40);
		mp.add(esci);
		
		BaseFrame.addPanel(mp);
	}
	
	public void menuPausaAdder() { 
		
		if(mm.isVisible()) {
			mm.mainMenuNotAdder();
			mmTolto = true;
		} else {
			m.mappaNotAdder();
			mmTolto = false;
		}
		
		BaseFrame.visiblePanel(mp);
	}
	
	public void menuPausaNotAdder() { 
		BaseFrame.notVisiblePanel(mp);
	}
}
