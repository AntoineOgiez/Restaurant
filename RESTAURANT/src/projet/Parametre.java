package projet;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Parametre extends JFrame implements ActionListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	JPanel param = new JPanel();
	JButton bt11 = new JButton("RETOUR");
	
	public Parametre() {
		this.setTitle("Paramètres");
		this.setSize(1500, 800);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setResizable(false);
		param.setLayout(null);
	    param.setBackground(Color.white);
	    setContentPane(param);
	    this.setVisible(true);
	    
	    bt11.setBounds(100, 50, 120, 60);
		param.add(bt11);
		bt11.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		this.dispose();
	}

}
