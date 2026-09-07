package Graphics;

import java.awt.Color;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class BaseFrame implements KeyListener{ //il frame

	private static JFrame mainFrame = new JFrame("Tris"); //static in quanto unico, così vale per tutte le classi
	
	public BaseFrame(){
		mainFrame.getContentPane().setBackground(Color.BLACK);
		mainFrame.setIconImage(Toolkit.getDefaultToolkit().getImage("img\\tris-logo.png"));
		mainFrame.setBounds(100, 100, 450, 450);
		mainFrame.setResizable(false);
		mainFrame.getContentPane().setLayout(null);
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainFrame.setVisible(true);
		mainFrame.addKeyListener(this);
	}

	public static void addPanel(JPanel panel) { //metodi static perché li devono utilizzare tutti e quindi mi semplifico
		mainFrame.getContentPane().add(panel); //usato per aggiungere un pannello al frame senza renderlo visibile
		panel.setVisible(false);
	}
	
	public static void removePanel(JPanel panel) { //usato per rimuovere definitivamente un pannello dal frame, si usa solo quando il pannello non verrà più utilizzato nel programma dopo la sua scomparsa come il caricamento e l'accoglienza
		panel.setVisible(false);
		mainFrame.getContentPane().remove(panel);
		mainFrame.requestFocusInWindow();
	}
	
	public static void visiblePanel(JPanel panel) { //rende visibile un pannello invisibile
		panel.setVisible(true);
		mainFrame.setVisible(true);
	}
	
	public static void notVisiblePanel(JPanel panel) { //rende invisibile un pannello visibile, usato quando un panel ricomparirà prima o poi come la mappa 
		panel.setVisible(false);
	}
	
	public static void addLabel(JLabel label) { //le classi sucessive lavorano allo stesso modo ma con i label, usato con i simboli e le vittorie che ho voluto separare dalla mappa
		mainFrame.getContentPane().add(label);
		label.setVisible(false);
	}
	
	public static void visibleLabel(JLabel label) {
		label.setVisible(true);
	}
	
	public static void notVisibleLabel(JLabel label) {
		label.setVisible(false);
	}
	
	public static void requestFocus() { //rifocalizza l'attenzione su un pulsante se prima veniva utilizzata una tastiera e il contrario, in quanto entrambi non possono lavorare senza questo comando
		mainFrame.requestFocusInWindow();
	}

	@Override
	public void keyPressed(KeyEvent e) { //il keylistener funziona solo sui frame e non sui panel
		
		MainMenu mm = new MainMenu();
		
		switch(e.getKeyCode()) {
			case 10: 
				
				Accoglienza ac = new Accoglienza();
				
				if(ac.getAttivo()) { //se l'utente sta visulizzando l'accoglienza allora rimuovila e aggiungi il menu principale se l'utente preme invio
					ac.accoglienzaRemover();
					mm.mainMenuAdder();
				}
			break;
			
			case 27: //se l'utente preme esc
				
				MenuPausa mp = new MenuPausa();
				Mappa m = new Mappa();
				AnimazioniVittoria av = new AnimazioniVittoria();
				
				if(mp.isVisible()) { //se il menu di pausa è già visibile rimuovilo e aggiungi quello che c'era prima del menu di pausa
					mp.menuPausaNotAdder();
				
					if(mp.getMmTolto()) {
						mm.mainMenuAdder();
						mp.menuPausaNotAdder();
					} else {
						mp.menuPausaNotAdder();
						m.riaggiungiMappa();
					}
				} else { //se il menu di pausa non era visibile se è visibile la mappao il menu principale e se l'effetto di vittoria non è attivo allora apri il menu di pausa
					if(mm.isVisible() || m.isVisible() && !av.isVisible()) mp.menuPausaAdder();
				}
			break;
		 }
	}

	@Override
	public void keyTyped(KeyEvent e) { //anche se non uso questi due metodi li devo aggiungere per forza
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		
	}
}