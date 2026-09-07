
package Graphics;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MainMenu { //menu che gestisce la scelta del livello
	
	private static JPanel mn = new JPanel(); 
	private static boolean nBot = true; //se è true è stata selezionata uan partita 1vs1
	
	public MainMenu(){ 
		
	}
	
	public boolean getNBot() {
		return nBot;
	}
	
	public boolean isVisible() {
		return mn.isVisible();
	}
	
	public void inizializzaMainMenu() {
		
		mn.setLayout(null);
		mn.setBounds(0, 0, 436, 413);
		mn.setBackground(Color.black);
		
		JLabel x = new JLabel("");
		x.setIcon(new ImageIcon("img\\x-piccolo.png"));
		x.setBounds(307, 160, 25, 25);
		x.setVisible(false);
		mn.add(x);
		
		JLabel cerchio = new JLabel("");
		cerchio.setIcon(new ImageIcon("img\\cerchio-piccolo.png"));
		cerchio.setBounds(307, 219, 25, 25);
		mn.add(cerchio);
		cerchio.setVisible(false);
		
		JPanel riga = new JPanel();
		riga.setBackground(Color.RED);
		riga.setBounds(109, 195, 223, 10);
		mn.add(riga);
		
		JButton noBot = new JButton("1vs1");
		noBot.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				InizioPartitaTra inz = new InizioPartitaTra();
				mainMenuNotAdder();
				inz.inizioPartitaAdder();
				nBot = true;
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				x.setVisible(true);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				x.setVisible(false);
			}
		});
		noBot.setFont(new Font("Tahoma", Font.PLAIN, 20));
		noBot.setForeground(Color.WHITE);
		noBot.setFocusPainted(false);
		noBot.setContentAreaFilled(false);
		noBot.setBorderPainted(false);
		noBot.setBounds(109, 160, 223, 25);
		mn.add(noBot);
		
		JButton bot = new JButton("1vsbot");
		bot.setFont(new Font("Tahoma", Font.PLAIN, 20));
		bot.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				InizioPartitaTra inz = new InizioPartitaTra();
				mainMenuNotAdder();
				inz.inizioPartitaAdder();
				nBot = false;
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				cerchio.setVisible(true);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				cerchio.setVisible(false);
			}
		});
		bot.setForeground(Color.WHITE);
		bot.setFocusPainted(false);
		bot.setContentAreaFilled(false);
		bot.setBorderPainted(false);
		bot.setBounds(109, 215, 223, 25);
		mn.add(bot);
		
		BaseFrame.addPanel(mn);
	}
	
	public void mainMenuAdder() { 
		BaseFrame.visiblePanel(mn);
	}
	
	public void mainMenuNotAdder() { 
		BaseFrame.notVisiblePanel(mn);
	}
}

