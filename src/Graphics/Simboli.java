package Graphics;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Simboli { //gestisce i simboli
	
	private static JLabel cerchio[] = {new JLabel(), new JLabel(), new JLabel(), new JLabel(), new JLabel(),new JLabel(), new JLabel(),new JLabel(), new JLabel()};
	private static JLabel x[] = {new JLabel(), new JLabel(), new JLabel(), new JLabel(), new JLabel(),new JLabel(), new JLabel(),new JLabel(), new JLabel()};
	
	public Simboli() {
		
	}
	
	public void add() {
		cerchio[0].setIcon(new ImageIcon("img\\cerchio.png"));
		cerchio[0].setBounds(55, 46, 100, 100);
		BaseFrame.addLabel(cerchio[0]);
		
		cerchio[1].setIcon(new ImageIcon("img\\cerchio.png"));
		cerchio[1].setBounds(165, 46, 100, 100);
		BaseFrame.addLabel(cerchio[1]);

		cerchio[2].setIcon(new ImageIcon("img\\cerchio.png"));
		cerchio[2].setBounds(275, 46, 100, 100);
		BaseFrame.addLabel(cerchio[2]);
		
		cerchio[3].setIcon(new ImageIcon("img\\cerchio.png"));
		cerchio[3].setBounds(55, 156, 100, 100);
		BaseFrame.addLabel(cerchio[3]);

		cerchio[4].setIcon(new ImageIcon("img\\cerchio.png"));
		cerchio[4].setBounds(165, 156, 100, 100);
		BaseFrame.addLabel(cerchio[4]);
		
		cerchio[5].setIcon(new ImageIcon("img\\cerchio.png"));
		cerchio[5].setBounds(274, 155, 101, 100);
		BaseFrame.addLabel(cerchio[5]);
		
		cerchio[6].setIcon(new ImageIcon("img\\cerchio.png"));
		cerchio[6].setBounds(55, 266, 100, 100);
		BaseFrame.addLabel(cerchio[6]);
		
		cerchio[7].setIcon(new ImageIcon("img\\cerchio.png"));
		cerchio[7].setBounds(165, 266, 100, 100);
		BaseFrame.addLabel(cerchio[7]);
		
		cerchio[8].setIcon(new ImageIcon("img\\cerchio.png"));
		cerchio[8].setBounds(275, 266, 100, 100);
		BaseFrame.addLabel(cerchio[8]);
		
		x[0].setIcon(new ImageIcon("img\\x.png"));
		x[0].setBounds(55, 46, 100, 100);
		BaseFrame.addLabel(x[0]);
		
		x[1].setIcon(new ImageIcon("img\\x.png"));
		x[1].setBounds(165, 46, 100, 100);
		BaseFrame.addLabel(x[1]);

		x[2].setIcon(new ImageIcon("img\\x.png"));
		x[2].setBounds(275, 46, 100, 100);
		BaseFrame.addLabel(x[2]);
		
		x[3].setIcon(new ImageIcon("img\\x.png"));
		x[3].setBounds(55, 156, 100, 100);
		BaseFrame.addLabel(x[3]);

		x[4].setIcon(new ImageIcon("img\\x.png"));
		x[4].setBounds(165, 156, 100, 100);
		BaseFrame.addLabel(x[4]);
		
		x[5].setIcon(new ImageIcon("img\\x.png"));
		x[5].setBounds(274, 155, 101, 100);
		BaseFrame.addLabel(x[5]);
		
		x[6].setIcon(new ImageIcon("img\\x.png"));
		x[6].setBounds(55, 266, 100, 100);
		BaseFrame.addLabel(x[6]);
		
		x[7].setIcon(new ImageIcon("img\\x.png"));
		x[7].setBounds(165, 266, 100, 100);
		BaseFrame.addLabel(x[7]);
		
		x[8].setIcon(new ImageIcon("img\\x.png"));
		x[8].setBounds(275, 266, 100, 100);
		BaseFrame.addLabel(x[8]);
	}
	
	public void visibleO(int griglia) { //visualizzo il simbolo cerchio nella posizione che mi serve
		BaseFrame.visibleLabel(cerchio[griglia]);
	}
	
	public void visibleX(int griglia) { //visualizzo il simbolo x nella posizione che mi serve
		BaseFrame.visibleLabel(x[griglia]);
	}
	
	public void clsSimboli() { //toglie tutti i simboli
		for(short i=0;i<9;i++) {
			BaseFrame.notVisibleLabel(cerchio[i]);
			BaseFrame.notVisibleLabel(x[i]);
		}
	}
}