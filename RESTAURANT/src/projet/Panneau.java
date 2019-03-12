package projet;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class Panneau extends JPanel{
	
	private int posSerX = 540;
	private int posSerY = 200;
	private int posChefX = 490;
	private int posChefY = 200;
	private int posClientX = 850;
	private int posClientY = 800;
	
	private BufferedImage table;
	private BufferedImage cuisine;
	private BufferedImage réserve;
	private BufferedImage serveur;
	private BufferedImage herbe;
	private BufferedImage chef;
	private BufferedImage gaziniere;
	private BufferedImage placard;
	private BufferedImage evier;
	private BufferedImage client;
	private BufferedImage jaugecli;
	private BufferedImage jaugemoney;
	private BufferedImage jaugestock;
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Panneau() {
		try {
			chef = ImageIO.read(getClass().getResourceAsStream("/chef.png"));
			serveur = ImageIO.read(getClass().getResourceAsStream("/serveur.png"));
			client = ImageIO.read(getClass().getResourceAsStream("/client1.png"));
			table = ImageIO.read(getClass().getResourceAsStream("/table.png"));
			cuisine = ImageIO.read(getClass().getResourceAsStream("/solcuisine.jpg"));
			réserve = ImageIO.read(getClass().getResourceAsStream("/solreserve.jpg"));
			herbe = ImageIO.read(getClass().getResourceAsStream("/herbe.jpg"));
			gaziniere = ImageIO.read(getClass().getResourceAsStream("/gaziniere.png"));
			placard = ImageIO.read(getClass().getResourceAsStream("/placard.png"));
			evier = ImageIO.read(getClass().getResourceAsStream("/evier.png"));
			jaugecli = ImageIO.read(getClass().getResourceAsStream("/cli25.png"));
			jaugemoney = ImageIO.read(getClass().getResourceAsStream("/money25.png"));
			jaugestock = ImageIO.read(getClass().getResourceAsStream("/stock25.png"));

		} catch(IOException e) {
			e.printStackTrace();
		}
	}
	public void paintComponent(Graphics g) {
		
		g.setColor(Color.white);
		g.fillRect(0, 0, this.getWidth(), this.getHeight());
		
		g.drawImage(herbe, 0, 0, this.getWidth(), this.getHeight(), null);
		
		g.drawImage(jaugecli, 50, 75, 250, 40, null);
		g.drawImage(jaugemoney, 50, 150, 250, 40, null);
		g.drawImage(jaugestock, 50, 225, 250, 40, null);
		
		g.setColor(Color.white);
		g.fillRect(400, 25, 700, 700);
		
		g.drawImage(cuisine, 401, 26, 300, 350, null);
		g.drawImage(réserve, 401, 377, 300, 348, null);
		
		g.drawImage(serveur, posSerX, posSerY, 120, 120, null);
		g.drawImage(chef, posChefX, posChefY, 120, 120, null);
		g.drawImage(client, posClientX, posClientY, 120, 120, null);
		
		g.drawImage(table, 750, 150, 112, 70, null);
		g.drawImage(table, 950, 150, 112, 70, null);
		g.drawImage(table, 750, 400, 112, 70, null);
		g.drawImage(table, 950, 400, 112, 70, null);
		
		g.drawImage(gaziniere, 401, 26, 112, 70, null);
		g.drawImage(evier, 588, 26, 112, 70, null);

		
		g.drawImage(placard, 401, 664, 270, 60, null);
		g.drawImage(placard, 401, 400, 60, 270, null);

		g.setColor(Color.black);
		g.drawLine(700, 250, 700, 26);
		g.drawLine(700, 725, 700, 300);
		g.drawLine(400, 377, 520, 377);
		g.drawLine(575, 377, 700, 377);

	}
	
	public int getPosSerX() {
		return posSerX;
	}
	
	public void setPosSerX(int posSerX) {
		this.posSerX = posSerX;
	}
	
	public int getPosSerY() {
		return posSerY;
	}
	
	public void setPosSerY(int posSerY) {
		this.posSerY = posSerY;
	}
	
	
	
	public int getPosChefX() {
		return posChefX;
	}
	
	public void setPosChefX(int posChefX) {
		this.posChefX = posChefX;
	}
	
	public int getPosChefY() {
		return posChefY;
	}
	
	public void setPosChefY(int posChefY) {
		this.posChefY = posChefY;
	}
	public int getPosClientX() {
		return posClientX;
	}
	public void setPosClientX(int posClientX) {
		this.posClientX = posClientX;
	}
	public int getPosClientY() {
		return posClientY;
	}
	public void setPosClientY(int posClientY) {
		this.posClientY = posClientY;
	}

}
