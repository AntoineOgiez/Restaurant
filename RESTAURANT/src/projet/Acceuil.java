package projet;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Acceuil extends JFrame implements Runnable{
	
	//Création des JPanel
	JPanel base = new JPanel(new BorderLayout());
	Panneau pan = new Panneau();
	JPanel pang = new JPanel(new GridLayout(8,1));
	JPanel pand = new JPanel(new GridLayout(5,1));
	
	//Création des JPanel servant à l'affichage des jauges de stock, de bucks et de satisfaction client
	JaugeS stockP = new JaugeS();
	JaugeSatisf satisP = new JaugeSatisf();
	JaugeB bucksP = new JaugeB();
	JaugeL levelP = new JaugeL();
	
	//JPanel servant exclusivement à l'affichage du chronomètre
	JPanel control = new JPanel();
	Container contentPane = getContentPane();
	
	//Création des JLabel szervant de description des jauges
	JLabel money = new JLabel("           BUCKS           ");
	JLabel satisfactionClient = new JLabel("           SATISFACTION           ");
	JLabel stock = new JLabel("           STOCK           ");
	JLabel level = new JLabel("           NIVEAU           ");
	
	//Création des boutons servant au fonctionnement du jeu
	JButton bt1 = new JButton("SHOP");
	JButton bt2 = new JButton("START");
	JButton bt3 = new JButton("CLEAN");
	JButton bt4 = new JButton("PARAMETRES");

	//Attributs servant au fonctionnement du chronomètre 
	private static Font font = new Font(Font.MONOSPACED, Font.BOLD, 20);
	private static final int CHRONO_SPEED = 1000;
	private Chronometer chronometer = new Chronometer();
	private Acceuil instance = this;
	private boolean stop = true;

	private JLabel hourValue = new JLabel("");
	private JLabel minuteValue = new JLabel("");
	private JLabel secondValue = new JLabel("");
	
	//Coordonnées des différents personnages servant à leurs déplacements
	private int xs, ys, xc, yc;
	private int xcli1, ycli1;
	private int xcli2, ycli2;
	private int xcli3, ycli3;
	private int xcli4, ycli4;
	
	//Servant à l'utilisation du Thread
	private Thread t;
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Acceuil(){
		this.setTitle("Restaurant");
		this.setSize(1500, 800);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setLayout(new BorderLayout());
		
		//STOCK
		
		//PANG
		pang.add(money);
		pang.add(bucksP);
		pang.add(satisfactionClient);
		pang.add(satisP);
		pang.add(stock);
		pang.add(stockP);
		pang.add(level);
		pang.add(levelP);
		
		//PAND
		bt1.setBounds( 1250, 40, 120, 60);
		pand.add(bt1);
		bt1.addActionListener(new ShopListener());
		
		bt2.setBounds( 1250, 160, 120, 60);
		pand.add(bt2);
		bt2.addActionListener(new StartListener());

		bt3.setBounds( 1250, 280, 120, 60);
		pand.add(bt3);

		bt4.setBounds( 1250, 550, 120, 60);
		pand.add(bt4);
		bt4.addActionListener(new ParamListener());

		contentPane.setBounds(1250, 650, 180, 60);
		pand.add(contentPane);
		
		//BASE
		base.add(pan, BorderLayout.CENTER);
		base.add(pand, BorderLayout.EAST);
		base.add(pang, BorderLayout.WEST);
		
		setContentPane(base);
		this.setVisible(true);
	
		//CHRONOMETRE
		updateValues();
		
		contentPane.setLayout(new BorderLayout());

		control.setLayout(new FlowLayout(FlowLayout.CENTER));
		hourValue.setFont(font);
		control.add(hourValue);

		minuteValue.setFont(font);
		control.add(minuteValue);

		secondValue.setFont(font);
		control.add(secondValue);

		contentPane.add(BorderLayout.NORTH, control);
	}
	
	private void updateValues() {
		// This part is for textual time printing.
		CyclicCounter hour = chronometer.getHour();
		hourValue.setText(hour.toString() + " ");

		CyclicCounter minute = chronometer.getMinute();
		minuteValue.setText(minute.toString() + " ");

		CyclicCounter second = chronometer.getSecond();
		secondValue.setText(second.toString() + " ");
	}
	
	public void run() {
		while (!stop) {
			try {
				Thread.sleep(CHRONO_SPEED);
			} catch (InterruptedException e) {
				System.out.println(e.getMessage());
			}
			chronometer.increment();
			if (!stop) {
				updateValues();
			}
		}
	}
	
	public void mvt() {
		for(int i = 880; i < pan.getWidth(); i++){
			xs = pan.getPosSerX();
			ys = pan.getPosSerY();
			xs++;
			pan.setPosSerX(xs);
			pan.setPosSerY(ys);
			pan.repaint();  
			try {
				Thread.sleep(3);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		for(int i = 800; i < pan.getWidth(); i++){
			xs = pan.getPosSerX();
			ys = pan.getPosSerY();
			ys++;
			pan.setPosSerX(xs);
			pan.setPosSerY(ys);
			pan.repaint();  
			try {
				Thread.sleep(3);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		for(int i = 500; i < pan.getWidth(); i++){
			xcli1 = pan.getPosClientX();
			ycli1 = pan.getPosClientY();
			ycli1--;
			pan.setPosClientX(xcli1);
			pan.setPosClientY(ycli1);
			pan.repaint();
			try {
				Thread.sleep(3);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		for(int i = 1055; i < pan.getWidth(); i++){
			xcli1 = pan.getPosClientX();
			ycli1 = pan.getPosClientY();
			xcli1++;
			pan.setPosClientX(xcli1);
			pan.setPosClientY(ycli1);
			pan.repaint();
			try {
				Thread.sleep(3);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		for(int i = 750; i < pan.getWidth(); i++){
			xcli2 = pan.getPosClient2X();
			ycli2 = pan.getPosClient2Y();
			ycli2--;
			pan.setPosClient2X(xcli2);
			pan.setPosClient2Y(ycli2);
			pan.repaint();
			try {
				Thread.sleep(3);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		for(int i = 1065; i < pan.getWidth(); i++){
			xcli2 = pan.getPosClient2X();
			ycli2 = pan.getPosClient2Y();
			xcli2++;
			pan.setPosClient2X(xcli2);
			pan.setPosClient2Y(ycli2);
			pan.repaint();
			try {
				Thread.sleep(3);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		for(int i = 500; i < pan.getWidth(); i++){
			xcli3 = pan.getPosClient3X();
			ycli3 = pan.getPosClient3Y();
			ycli3--;
			pan.setPosClient3X(xcli3);
			pan.setPosClient3Y(ycli3);
			pan.repaint();
			try {
				Thread.sleep(3);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		for(int i = 1065; i < pan.getWidth(); i++){
			xcli3 = pan.getPosClient3X();
			ycli3 = pan.getPosClient3Y();
			xcli3--;
			pan.setPosClient3X(xcli3);
			pan.setPosClient3Y(ycli3);
			pan.repaint();
			try {
				Thread.sleep(3);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		for(int i = 750; i < pan.getWidth(); i++){
			xcli4 = pan.getPosClient4X();
			ycli4 = pan.getPosClient4Y();
			ycli4--;
			pan.setPosClient4X(xcli4);
			pan.setPosClient4Y(ycli4);
			pan.repaint();
			try {
				Thread.sleep(3);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		for(int i = 1065; i < pan.getWidth(); i++){
			xcli4 = pan.getPosClient4X();
			ycli4 = pan.getPosClient4Y();
			xcli4--;
			pan.setPosClient4X(xcli4);
			pan.setPosClient4Y(ycli4);
			pan.repaint();
			try {
				Thread.sleep(3);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		for(int i = 800; i < pan.getWidth(); i++){
			xs = pan.getPosSerX();
			ys = pan.getPosSerY();
			ys--;
			pan.setPosSerX(xs);
			pan.setPosSerY(ys);
			pan.repaint();  
			try {
				Thread.sleep(3);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		for(int i = 870; i < pan.getWidth(); i++){
			xs = pan.getPosSerX();
			ys = pan.getPosSerY();
			xs--;
			pan.setPosSerX(xs);
			pan.setPosSerY(ys);
			pan.repaint();  
			try {
				Thread.sleep(3);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		for(int i = 900; i < pan.getWidth(); i++){
			xc = pan.getPosChefX();
			yc = pan.getPosChefY();
			yc++;
			pan.setPosChefX(xc);
			pan.setPosChefY(yc);
			pan.repaint();
			try {
				Thread.sleep(3);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		for(int i = 900; i < pan.getWidth(); i++){
			xc = pan.getPosChefX();
			yc = pan.getPosChefY();
			yc--;
			pan.setPosChefX(xc);
			pan.setPosChefY(yc);
			pan.repaint();
			try {
				Thread.sleep(3);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		for(int i = 900; i < pan.getWidth(); i++){
			xs = pan.getPosSerX();
			ys = pan.getPosSerY();
			xs++;
			pan.setPosSerX(xs);
			pan.setPosSerY(ys);
			pan.repaint();  
			try {
				Thread.sleep(3);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	class ShopListener implements ActionListener{
		public void actionPerformed(ActionEvent arg0) {
			@SuppressWarnings("unused")
			Shop shop = new Shop();
		}
	}
	
	class StartListener implements ActionListener{
		public void actionPerformed(ActionEvent arg0) {
			t = new Thread(new Animation());
			t.start();
			stop = false;
			Thread chronoThread = new Thread(instance);
			chronoThread.start();
		}
	}
	
	class ParamListener implements ActionListener{
		public void actionPerformed(ActionEvent arg0) {
			@SuppressWarnings("unused")
			Parametre param = new Parametre();
		}
	}
	
	class Animation implements Runnable{
		public void run() {
			mvt();
		}
	}
}

