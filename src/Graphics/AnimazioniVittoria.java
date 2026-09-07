package Graphics;

import java.awt.Color;

import javax.swing.JPanel;

public class AnimazioniVittoria { //gestisce le animazioni di vittoria
	
	private static JPanel vitoriaOu;
	private static JPanel vitoriaOb;
	private static JPanel vitoriaVs;
	private static JPanel vitoriaOc;
	private static JPanel vitoriaVc;
	private static JPanel vitoriaVd;
	private static JPanel vitOb1a;
	private static JPanel vitOb12b;
	private static JPanel vitOb1c;
	private static JPanel vitOb2c;
	private static JPanel vitOb2a;
	private short conta = -1; //la uso per far lampeggiare le sbarrette
	private static boolean vittoriaAttiva = false; //mi dice se anche una sola barra è stata attivata
	
	public AnimazioniVittoria() {
		
	}
	
	public short getConta() {
		return conta;
	}
	
	public boolean isVisible() {
		return vittoriaAttiva;
	}
	
	public void inizializzaVittorie() {
		vitoriaOu = new JPanel();
		vitoriaOu.setBackground(Color.RED);
		vitoriaOu.setBounds(55, 95, 320, 10);
		BaseFrame.addPanel(vitoriaOu);
		
		vitoriaOb = new JPanel();
		vitoriaOb.setBackground(Color.RED);
		vitoriaOb.setBounds(55, 310, 320, 10);
		BaseFrame.addPanel(vitoriaOb);
		
		vitoriaVs = new JPanel();
		vitoriaVs.setBackground(Color.RED);
		vitoriaVs.setBounds(100, 46, 10, 320);
		BaseFrame.addPanel(vitoriaVs);
		
		vitoriaOc = new JPanel();
		vitoriaOc.setBackground(Color.RED);
		vitoriaOc.setBounds(55, 200, 320, 10);
		BaseFrame.addPanel(vitoriaOc);
		
		vitoriaVc = new JPanel();
		vitoriaVc.setBackground(Color.RED);
		vitoriaVc.setBounds(208, 46, 10, 320);
		BaseFrame.addPanel(vitoriaVc);
		
		vitoriaVd = new JPanel();
		vitoriaVd.setBackground(Color.RED);
		vitoriaVd.setBounds(314, 46, 10, 320);
		BaseFrame.addPanel(vitoriaVd);
		
		vitOb1a = new JPanel();
		vitOb1a.setBackground(Color.RED);
		vitOb1a.setBounds(55, 310, 100, 10);
		BaseFrame.addPanel(vitOb1a);
		
		vitOb12b = new JPanel();
		vitOb12b.setBackground(Color.RED);
		vitOb12b.setBounds(155, 201, 119, 10);
		BaseFrame.addPanel(vitOb12b);
		
		vitOb1c = new JPanel();
		vitOb1c.setBackground(Color.RED);
		vitOb1c.setBounds(264, 93, 111, 10);
		BaseFrame.addPanel(vitOb1c);
		
		vitOb2c = new JPanel();
		vitOb2c.setBackground(Color.RED);
		vitOb2c.setBounds(54, 93, 111, 10);
		BaseFrame.addPanel(vitOb2c);
		
		vitOb2a = new JPanel();
		vitOb2a.setBackground(Color.RED);
		vitOb2a.setBounds(264, 310, 111, 10);
		BaseFrame.addPanel(vitOb2a);
	}
	
	public void vittoriaAdder(short vitt) { //rende visibile le sbarre che voglio
		
		vittoriaAttiva = true;
		
		switch(vitt) {
			case 0: BaseFrame.visiblePanel(vitoriaOu);
			break;
			
			case 1: BaseFrame.visiblePanel(vitoriaOc);
			break;
			
			case 2: BaseFrame.visiblePanel(vitoriaOb);
			break;
			
			case 3: BaseFrame.visiblePanel(vitoriaVs);
			break;
			
			case 4: BaseFrame.visiblePanel(vitoriaVc);
			break;
			
			case 5: BaseFrame.visiblePanel(vitoriaVd);
			break;
			
			case 6: BaseFrame.visiblePanel(vitOb1a);
					BaseFrame.visiblePanel(vitOb12b);
					BaseFrame.visiblePanel(vitOb1c);
			break;
			
			case 7: BaseFrame.visiblePanel(vitOb2a);
					BaseFrame.visiblePanel(vitOb12b);
					BaseFrame.visiblePanel(vitOb2c);
			break;
			
			case 8: BaseFrame.visiblePanel(vitoriaOu);
					BaseFrame.visiblePanel(vitoriaOc);
					BaseFrame.visiblePanel(vitoriaOb);
					BaseFrame.visiblePanel(vitoriaVs);
					BaseFrame.visiblePanel(vitoriaVc);
					BaseFrame.visiblePanel(vitoriaVd);
			break;
		}
		conta++;
	}
	
	public void clsVittoria(short vitt) { //rende nvisibili tutte le sbarre e azzera i dati
		
		switch(vitt) {
			case 0: BaseFrame.notVisiblePanel(vitoriaOu);
			break;
			
			case 1: BaseFrame.notVisiblePanel(vitoriaOc);
			break;
			
			case 2: BaseFrame.notVisiblePanel(vitoriaOb);
			break;
			
			case 3: BaseFrame.notVisiblePanel(vitoriaVs);
			break;
			
			case 4: BaseFrame.notVisiblePanel(vitoriaVc);
			break;
			
			case 5: BaseFrame.notVisiblePanel(vitoriaVd);
			break;
			
			case 6: BaseFrame.notVisiblePanel(vitOb1a);
					BaseFrame.notVisiblePanel(vitOb12b);
					BaseFrame.notVisiblePanel(vitOb1c);
			break;
			
			case 7: BaseFrame.notVisiblePanel(vitOb2a);
					BaseFrame.notVisiblePanel(vitOb12b);
					BaseFrame.notVisiblePanel(vitOb2c);
			break;

			case 8: BaseFrame.notVisiblePanel(vitoriaOu);
					BaseFrame.notVisiblePanel(vitoriaOc);
					BaseFrame.notVisiblePanel(vitoriaOb);
					BaseFrame.notVisiblePanel(vitoriaVs);
					BaseFrame.notVisiblePanel(vitoriaVc);
					BaseFrame.notVisiblePanel(vitoriaVd);
			break;
		}
		
		conta = 0;
		vittoriaAttiva = false;
	}
	
	public void vittoriaNotAdder(short vitt) { //rendo invisibile le sbarre che voglio
		switch(vitt) {
			case 0: BaseFrame.notVisiblePanel(vitoriaOu);
			break;
			
			case 1: BaseFrame.notVisiblePanel(vitoriaOc);
			break;
			
			case 2: BaseFrame.notVisiblePanel(vitoriaOb);
			break;
			
			case 3: BaseFrame.notVisiblePanel(vitoriaVs);
			break;
			
			case 4: BaseFrame.notVisiblePanel(vitoriaVc);
			break;
			
			case 5: BaseFrame.notVisiblePanel(vitoriaVd);
			break;
			
			case 6: BaseFrame.notVisiblePanel(vitOb1a);
					BaseFrame.notVisiblePanel(vitOb12b);
					BaseFrame.notVisiblePanel(vitOb1c);
			break;
			
			case 7: BaseFrame.notVisiblePanel(vitOb2a);
					BaseFrame.notVisiblePanel(vitOb12b);
					BaseFrame.notVisiblePanel(vitOb2c);
			break;
			
			case 8: BaseFrame.notVisiblePanel(vitoriaOu);
					BaseFrame.notVisiblePanel(vitoriaOc);
					BaseFrame.notVisiblePanel(vitoriaOb);
					BaseFrame.notVisiblePanel(vitoriaVs);
					BaseFrame.notVisiblePanel(vitoriaVc);
					BaseFrame.notVisiblePanel(vitoriaVd);
			break;
		}
		
		conta++;
	}
}
