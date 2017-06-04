package gameui;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.*;


public class PlayMenu extends JPanel{
	JButton acuse;
	JButton next;
	public PlayMenu(){
		super(new GridLayout(2,1));
		acuse = new JButton("ACUSAR");
		next = new JButton("Próxima Jogada");
		this.add(acuse);
		this.add(next);
		this.setBackground(Color.BLUE);
	}
}
