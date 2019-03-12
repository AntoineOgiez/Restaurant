package projet;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Acceuil extends JFrame implements ActionListener, Runnable{
	
	Panneau pan = new Panneau();
	JPanel control = new JPanel();
	Container contentPane = getContentPane();
	
	//JLabel money = new JLabel("Money");
	//JLabel satisfactionClient = new JLabel("Satisfaction");
	//JLabel stock = new JLabel("Stock");
	
	JButton bt1 = new JButton("SHOP");
	JButton bt2 = new JButton("START");
	JButton bt3 = new JButton("CLEAN");
	JButton bt4 = new JButton("PARAMETRES");

	private static Font font = new Font(Font.MONOSPACED, Font.BOLD, 20);
	private static final int CHRONO_SPEED = 1000;
	private Chronometer chronometer = new Chronometer();
	private Acceuil instance = this;
	private boolean stop = true;

	private JLabel hourValue = new JLabel("");
	private JLabel minuteValue = new JLabel("");
	private JLabel secondValue = new JLabel("");
	
	private int xs, ys, xc, yc;
	private int xcli, ycli;
	
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
		pan.setLayout(null);
		
		//money.setLocation(50, 200);
		//pan.add(money);
		
		bt1.setBounds( 1250, 40, 120, 60);
		pan.add(bt1);
		bt1.addActionListener(this);
		
		bt2.setBounds( 1250, 160, 120, 60);
		pan.add(bt2);
		bt2.addActionListener(this);

		bt3.setBounds( 1250, 280, 120, 60);
		pan.add(bt3);

		bt4.setBounds( 1250, 550, 120, 60);
		pan.add(bt4);
		bt4.addActionListener(this);

		contentPane.setBounds(1250, 650, 180, 60);
		pan.add(contentPane);
		
		setContentPane(pan);
		this.setVisible(true);
	
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
		for(int i = 1200; i < pan.getWidth(); i++){
			xs = pan.getPosSerX();
			ys = pan.getPosSerY();
			xs++;
			pan.setPosSerX(xs);
			pan.setPosSerY(ys);
			pan.repaint();  
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		for(int i = 1150; i < pan.getWidth(); i++){
			xs = pan.getPosSerX();
			ys = pan.getPosSerY();
			ys++;
			pan.setPosSerX(xs);
			pan.setPosSerY(ys);
			pan.repaint();  
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		for(int i = 800; i < pan.getWidth(); i++){
			xcli = pan.getPosClientX();
			ycli = pan.getPosClientY();
			ycli--;
			pan.setPosClientX(xcli);
			pan.setPosClientY(ycli);
			pan.repaint();
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		for(int i = 1150; i < pan.getWidth(); i++){
			xs = pan.getPosSerX();
			ys = pan.getPosSerY();
			ys--;
			pan.setPosSerX(xs);
			pan.setPosSerY(ys);
			pan.repaint();  
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		for(int i = 1200; i < pan.getWidth(); i++){
			xs = pan.getPosSerX();
			ys = pan.getPosSerY();
			xs--;
			pan.setPosSerX(xs);
			pan.setPosSerY(ys);
			pan.repaint();  
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		for(int i = 1200; i < pan.getWidth(); i++){
			xc = pan.getPosChefX();
			yc = pan.getPosChefY();
			yc++;
			pan.setPosChefX(xc);
			pan.setPosChefY(yc);
			pan.repaint();
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == bt1) {
			@SuppressWarnings("unused")
			Shop shopy = new Shop();
		}
		
		if(e.getSource() == bt2) {
			t = new Thread(new Animation());
			t.start();
			stop = false;
			Thread chronoThread = new Thread(instance);
			chronoThread.start();
		}
		
		if(e.getSource() == bt4) {
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

