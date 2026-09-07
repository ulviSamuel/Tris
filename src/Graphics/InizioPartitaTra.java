package Graphics;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;

import Bean.Tempo;

public class InizioPartitaTra { //gestisce la schermata di inizio partita tra
	
	private static JPanel ipt = new JPanel(); 
	private static JLabel tempoRimanente = new JLabel();
	private short conta = 4; //serve per contare il tempo che rimane

	public InizioPartitaTra() {
		
	}
	
	public void setTextTempoRimanente(short numero) { //cambia il valore del tempo, vale anche per mappa
		tempoRimanente.setText(Integer.toString(numero));
	}
	
	public short getConta() { //diminuisce il valore e cambia il colore del numero
		conta--;
		if(conta==2) tempoRimanente.setForeground(Color.green);
		else if(conta==1) tempoRimanente.setForeground(Color.red);
		return conta;
	}
	
	public void inizializzaInizioPartitaTra() {
		
		ipt.setLayout(null);
		ipt.setBounds(0, 0, 436, 413);
		ipt.setBackground(Color.black);
		
		JLabel inizioPartita = new JLabel("Inizio partita tra");
		inizioPartita.setBackground(Color.BLACK);
		inizioPartita.setForeground(Color.BLUE);
		inizioPartita.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 50));
		inizioPartita.setBounds(23, 59, 403, 194);
		ipt.add(inizioPartita);
		
		tempoRimanente = new JLabel("");
		tempoRimanente.setForeground(Color.YELLOW);
		tempoRimanente.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 70));
		tempoRimanente.setBackground(Color.WHITE);
		tempoRimanente.setBounds(184, 244, 52, 75);
		ipt.add(tempoRimanente);
		
		BaseFrame.addPanel(ipt);
	}
	
	public void inizioPartitaAdder() { 
		Tempo tm = new Tempo();
		BaseFrame.visiblePanel(ipt);
		tm.inizioPartita(); //fa partire la conta
	}
	
	public void inizioPartitaNotAdder() { 
		BaseFrame.notVisiblePanel(ipt);
	}
}
