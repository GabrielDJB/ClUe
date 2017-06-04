package gameui;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.*;

public class GamePanel extends JPanel {
	int width;
	int height;
	Image map;
	Image dice;
	Image card;
	
	public GamePanel(int w, int h) {
		super(); 
		this.width = w;
		this.height = h;
		this.GameButtons();
		
		try {
			map = ImageIO.read(new File("img/Tabuleiros/Tabuleiro-Original.JPG"));
			dice = ImageIO.read(new File("img/Tabuleiros/dado5.jpg"));
			card = ImageIO.read(new File("img/Armas/Revolver.jpg"));
		}
		catch (IOException e) {
			System.out.println(e.getMessage());
			System.exit(1);
		}
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		g.drawImage(map, 0, 0, 5*width/8, 6*height/8, null);
		g.drawImage(dice, width - 100, 6*height/8 - 125, 50, 50, null);
		g.drawImage(card, width - 100, 6*height/8 - 50, 50, 50, null);
	}
	
	public void GameButtons() {
		int dicex = 3*width/16 - 100;
		
		JButton dice = new JButton("Jogar Dados");
		JButton cards = new JButton("Ver Cartas");
		
		
		dice.setBounds(5*width/8 + dicex - 50, 6*height/8 - 125, 200, 50);
		cards.setBounds(5*width/8 + dicex - 50, 6*height/8 - 50, 200, 50);
		
		this.add(dice);
		this.add(cards);
	}
}
