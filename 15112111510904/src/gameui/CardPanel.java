package gameui;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

final class CardButtonHandler implements ActionListener {
	
	public void actionPerformed(ActionEvent e) {
		UI.cardFrame();
	}
}

public class CardPanel extends JPanel {
	int width; int height; int posx;
	JButton cards = new JButton("Cartas");
	
	public CardPanel(){
		super(new GridLayout(1,1));
		this.setBackground(Color.BLACK);
		cards.addActionListener(new CardButtonHandler());
		this.add(cards);
	}
}
