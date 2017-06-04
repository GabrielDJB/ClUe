package gameui;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;


final class DiceButtonHandler implements ActionListener {
	
	public void actionPerformed(ActionEvent e) {
		UI.DiceSelect();
	}
}

public class DicePanel extends JPanel {
	JButton dice = new JButton("Jogar Dados");
	JLabel diceImage = new JLabel();
	ImageIcon DiceIcon1, DiceIcon2, DiceIcon3, DiceIcon4, DiceIcon5, DiceIcon6;
	
	public DicePanel(){
		super(new GridLayout(2,1));
		this.add(dice);
		this.add(diceImage);
		diceImage.setHorizontalAlignment(JLabel.CENTER);
		dice.addActionListener(new DiceButtonHandler());
		
		DiceIcon1 = new ImageIcon("img/Tabuleiros/dado1.JPG");
		DiceIcon2 = new ImageIcon("img/Tabuleiros/dado2.JPG");
		DiceIcon3 = new ImageIcon("img/Tabuleiros/dado3.JPG");
		DiceIcon4 = new ImageIcon("img/Tabuleiros/dado4.JPG");
		DiceIcon5 = new ImageIcon("img/Tabuleiros/dado5.JPG");
		DiceIcon6 = new ImageIcon("img/Tabuleiros/dado6.JPG");
	}
	
	public void SetImage(int dice){
		if(dice == 1){
			diceImage.setIcon(DiceIcon1);
			diceImage.repaint();
		} else if (dice == 2) {
			diceImage.setIcon(DiceIcon2);
			diceImage.repaint();
		} else if (dice == 3) {
			diceImage.setIcon(DiceIcon3);
			diceImage.repaint();
		} else if (dice == 4) {
			diceImage.setIcon(DiceIcon4);
			diceImage.repaint();
		} else if (dice == 5) {
			diceImage.setIcon(DiceIcon5);
			diceImage.repaint();
		} else if (dice == 6) {
			diceImage.setIcon(DiceIcon6);
			diceImage.repaint();
		} else {
			UI.Alert("Valor Inválido no dado!");
		}
	}
	
}
