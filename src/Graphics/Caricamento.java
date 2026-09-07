package Graphics;

import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Bean.Tempo;

public class Caricamento { //gestisce il caricamento
	
	private static JPanel ld = new JPanel();

	public Caricamento() {
		
	}
	
	public void inizializzaCaricamento() { //e' abbastanza vuoto in modo da essere caricato velocemente
		
		Tempo t = new Tempo();
		
		ld.setLayout(null);
		ld.setBounds(0, 0, 436, 413);
		ld.setBackground(Color.BLACK);
		
		JLabel caricamento = new JLabel("");
		caricamento.setIcon(new ImageIcon("gif\\caricamento-tris.gif"));
		caricamento.setBounds(366, 343, 60, 60);
		ld.add(caricamento);
		
		BaseFrame.addPanel(ld);
		BaseFrame.visiblePanel(ld);
		
		t.timerDelCaricamento();
	}
	
	public void caricamentoRemover() {
		BaseFrame.notVisiblePanel(ld);
	}
	
}
