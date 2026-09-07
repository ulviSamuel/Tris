package Graphics;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Bean.Bot;
import Bean.GestorePartita;
import Bean.Tempo;

public class Mappa { //classe che gestisce la mappa
	
	private static JPanel mp = new JPanel();
	private static JLabel tempo = new JLabel();
	private static short conta = 11;
	private GestorePartita gp = new GestorePartita();
	private Tempo tm = new Tempo();
	private MainMenu mm = new MainMenu();
	private static JButton g1;
	private static JButton g2;
	private static JButton g3;
	private static JButton g4;
	private static JButton g5;
	private static JButton g6;
	private static JButton g7;
	private static JButton g8;
	private static JButton g9;
	

	public Mappa() {
		
	}
	
	public boolean isVisible() {
		return mp.isVisible();
	}
	
	public void setTextTempo(short numero) {
		tempo.setText(Integer.toString(numero));
	}
	
	public short getConta() { //tempo mancante prima che il bot inserisca un valore casuale + cambio colore
		
		conta--;
		if(conta<4 && conta>0) tempo.setForeground(Color.red);
		else tempo.setForeground(Color.white);
		if(conta==0) {
			disegnaAuto();
			conta = 10;
		}
		return conta;
	}
	
	public void disegnaAuto() { //disegna in automatico
		
		Bot bt = new Bot();
			
		switch(bt.lvMedAdd()) {
			case 0:
				gp.disegna(0);
				g1.setVisible(false);
			break;
			
			case 1:
				gp.disegna(1);
				g2.setVisible(false);
			break;
				
			case 2:
				gp.disegna(2);
				g3.setVisible(false);
			break;
			
			case 3:
				gp.disegna(3);
				g4.setVisible(false);
			break;
			
			case 4:
				gp.disegna(4);
				g5.setVisible(false);
			break;
			
			case 5:
				gp.disegna(5);
				g6.setVisible(false);
			break;
			
			case 6:
				gp.disegna(6);
				g7.setVisible(false);
			break;
			
			case 7:
				gp.disegna(7);
				g8.setVisible(false);
			break;
			
			case 8:
				gp.disegna(8);
				g9.setVisible(false);
			break;
		}
	}
	
	public void inizializzaMappa() { //quando clicco un pulsante scompare e disegna
		
		mp.setBackground(Color.BLACK);
		mp.setBounds(0, 0, 436, 413);
		mp.setLayout(null);
		
		JPanel rigaLeft = new JPanel();
		rigaLeft.setBackground(Color.RED);
		rigaLeft.setBounds(155, 46, 10, 320);
		mp.add(rigaLeft);
		
		JPanel rigaTop = new JPanel();
		rigaTop.setBackground(Color.RED);
		rigaTop.setBounds(55, 145, 320, 10);
		mp.add(rigaTop);
		
		JPanel rigaRight = new JPanel();
		rigaRight.setBackground(Color.RED);
		rigaRight.setBounds(264, 46, 10, 320);
		mp.add(rigaRight);
		
		JPanel rigaBottom = new JPanel();
		rigaBottom.setBackground(Color.RED);
		rigaBottom.setBounds(54, 255, 320, 10);
		mp.add(rigaBottom);
		
		g1 = new JButton("");
		g1.setVisible(false);
		g1.setContentAreaFilled(false);
		g1.setBorderPainted(false);
		g1.setBounds(55, 46, 100, 100);
		g1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				gp.disegna(0);
				if(gp.getVittorioso()==0 && !mm.getNBot() && gp.getPassato()==9) tm.effettoVittoria((short) 8);
				if(!mm.getNBot() && gp.getVittorioso()==0 && gp.getPassato()!=9) disegnaAuto();
				conta = 11;
				g1.setVisible(false);
				BaseFrame.requestFocus();
			}
		});
		mp.add(g1);
		
		g3 = new JButton("");
		g3.setVisible(false);
		g3.setContentAreaFilled(false);
		g3.setBorderPainted(false);
		g3.setBounds(275, 46, 100, 100);
		g3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				gp.disegna(2);
				if(gp.getVittorioso()==0 && !mm.getNBot() && gp.getPassato()==9) tm.effettoVittoria((short) 8);
				if(!mm.getNBot() && gp.getVittorioso()==0  && gp.getPassato()!=9) disegnaAuto();
				g3.setVisible(false);
				conta = 11;
				BaseFrame.requestFocus();
			}
		});
		mp.add(g3);
		
		g2 = new JButton("");
		g2.setVisible(false);
		g2.setBorderPainted(false);
		g2.setContentAreaFilled(false);
		g2.setBounds(165, 46, 100, 100);
		g2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				gp.disegna(1);
				if(gp.getVittorioso()==0 && !mm.getNBot() && gp.getPassato()==9) tm.effettoVittoria((short) 8);
				if(!mm.getNBot() && gp.getVittorioso()==0 && gp.getPassato()!=9) disegnaAuto();
				g2.setVisible(false);
				conta = 11;
				BaseFrame.requestFocus();
			}
		});
		mp.add(g2);
		
		g4 = new JButton("");
		g4.setVisible(false);
		g4.setContentAreaFilled(false);
		g4.setBorderPainted(false);
		g4.setBounds(55, 156, 100, 100);
		g4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				gp.disegna(3);
				if(gp.getVittorioso()==0 && !mm.getNBot() && gp.getPassato()==9) tm.effettoVittoria((short) 8);
				if(!mm.getNBot() && gp.getVittorioso()==0 && gp.getPassato()!=9) disegnaAuto();
				g4.setVisible(false);
				conta = 11;
				BaseFrame.requestFocus();
			}
		});
		mp.add(g4);
		
		g5 = new JButton("");
		g5.setVisible(false);
		g5.setContentAreaFilled(false);
		g5.setBorderPainted(false);
		g5.setBounds(165, 156, 100, 100);
		g5.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				gp.disegna(4);
				if(gp.getVittorioso()==0 && !mm.getNBot() && gp.getPassato()==9) tm.effettoVittoria((short) 8);
				if(!mm.getNBot() && gp.getVittorioso()==0 && gp.getPassato()!=9) disegnaAuto();
				g5.setVisible(false);
				conta = 11;
				BaseFrame.requestFocus();
			}
		});
		mp.add(g5);
		
		g9 = new JButton("");	
		g9.setVisible(false);
		g9.setBorderPainted(false);
		g9.setContentAreaFilled(false);
		g9.setBounds(275, 266, 100, 100);
		g9.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				gp.disegna(8);
				if(gp.getVittorioso()==0 && !mm.getNBot() && gp.getPassato()==9) tm.effettoVittoria((short) 8);
				if(!mm.getNBot() && gp.getVittorioso()==0 && gp.getPassato()!=9) disegnaAuto();
				g9.setVisible(false);
				conta = 11;
				BaseFrame.requestFocus();
			}
		});
		mp.add(g9);
		
		g6 = new JButton("");
		g6.setVisible(false);
		g6.setContentAreaFilled(false);
		g6.setBorderPainted(false);
		g6.setBounds(274, 155, 101, 100);
		g6.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				gp.disegna(5);
				if(gp.getVittorioso()==0 && !mm.getNBot() && gp.getPassato()==9) tm.effettoVittoria((short) 8);
				if(!mm.getNBot() && gp.getVittorioso()==0  && gp.getPassato()!=9) disegnaAuto();
				g6.setVisible(false);
				conta = 11;
				BaseFrame.requestFocus();
			}
		});
		mp.add(g6);
		
		g8 = new JButton("");
		g8.setVisible(false);
		g8.setContentAreaFilled(false);
		g8.setBorderPainted(false);
		g8.setBounds(165, 266, 100, 100);
		g8.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				gp.disegna(7);
				if(gp.getVittorioso()==0 && !mm.getNBot() && gp.getPassato()==9) tm.effettoVittoria((short) 8);
				if(!mm.getNBot() && gp.getVittorioso()==0  && gp.getPassato()!=9) disegnaAuto();
				g8.setVisible(false);
				conta = 11;
				BaseFrame.requestFocus();
			}
		});
		mp.add(g8);
		
		g7 = new JButton("");
		g7.setVisible(false);
		g7.setContentAreaFilled(false);
		g7.setBorderPainted(false);
		g7.setBounds(55, 266, 100, 100);
		g7.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				gp.disegna(6);
				if(gp.getVittorioso()==0 && !mm.getNBot() && gp.getPassato()==9) tm.effettoVittoria((short) 8);
				if(!mm.getNBot() && gp.getVittorioso()==0  && gp.getPassato()!=9) disegnaAuto();
				g7.setVisible(false);
				conta = 11;
				BaseFrame.requestFocus();
			}
		});
		mp.add(g7);
		
		tempo = new JLabel("10");
		tempo.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 30));
		tempo.setForeground(Color.WHITE);
		tempo.setBounds(389, 10, 37, 30);
		mp.add(tempo);
		
		BaseFrame.addPanel(mp);
	}
	
	public void mappaAdder() { 
		BaseFrame.visiblePanel(mp);
		ripristina();
		if(mm.getNBot()) {
			conta = 11;
			tm.tempoTraGiocatori();
			tempo.setVisible(true);
		} else {
			tempo.setVisible(false);
		}
	}
	
	public void riaggiungiMappa() {
		
		if(mm.getNBot()) {
			tm.tempoTraGiocatori();
		}
		
		BaseFrame.visiblePanel(mp);
	}
	
	public void mappaNotAdder() {
		BaseFrame.notVisiblePanel(mp);
	}
	
	public void clsPulsanti() { //tutti i pulsanti risultano inutilizzabili
		g1.setVisible(false);
		g2.setVisible(false);
		g3.setVisible(false);
		g4.setVisible(false);
		g5.setVisible(false);
		g6.setVisible(false);
		g7.setVisible(false);
		g8.setVisible(false);
		g9.setVisible(false);
	}
	
	public void ripristina() { //tutti i pulsanti risultano utilizzabili
		g1.setVisible(true);
		g2.setVisible(true);
		g3.setVisible(true);
		g4.setVisible(true);
		g5.setVisible(true);
		g6.setVisible(true);
		g7.setVisible(true);
		g8.setVisible(true);
		g9.setVisible(true);
	}
}
