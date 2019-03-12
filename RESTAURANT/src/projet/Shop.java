package projet;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Shop extends JFrame implements ActionListener{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	JPanel shop = new JPanel();
	
	JButton bt6 = new JButton("RETOUR");
	JButton bt7 = new JButton("PERSONNEL");
	JButton bt8 = new JButton("EQUIPEMENTS");
	JButton bt9 = new JButton("MEUBLES");
	JButton bt10 = new JButton("NOURRITURE");
	
	public Shop() {
		this.setTitle("Restaurant");
		this.setSize(1500, 800);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setResizable(false);
		
		bt6.setBounds(100, 50, 120, 60);
		shop.add(bt6);
		bt6.addActionListener(this);
		
		bt7.setBounds(350, 50, 800, 60);
		shop.add(bt7);
		
		bt8.setBounds(350, 150, 800, 60);
		shop.add(bt8);
		
		bt9.setBounds(350, 250, 800, 60);
		shop.add(bt9);
		
		bt10.setBounds(350, 350, 800, 60);
		shop.add(bt10);
		
		shop.setLayout(null);
	    shop.setBackground(Color.white);
	    setContentPane(shop);
	    this.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		this.dispose();
	}

}
