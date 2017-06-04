package gameui;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

final class TratadorNovoJogo implements ActionListener {
	
	public void actionPerformed(ActionEvent e) {
		UI.mainf.dispose();
		UI.PlayerSet();
	}
}

final class TratadorCarregarJogo implements ActionListener {
	private JFileChooser fc;
	private Component parent;
	
	public TratadorCarregarJogo(Component parent) {
		fc = new JFileChooser();
		this.parent = parent;
	}
	
	public void actionPerformed(ActionEvent e) {
		fc.showOpenDialog(parent);
	}
}
public class StartPanel extends JPanel {
	int width;
	int height;
	Image img;
	
	public StartPanel(int w, int h) {
		super();
		this.width = w;
		this.height = h;
		
		try {
			img = ImageIO.read(new File("img/Clue-Logo.png"));
		}
		catch (IOException e) {
			System.out.println(e.getMessage());
			System.exit(1);
		}
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		g.drawImage(img, width/2 - img.getWidth(null)/2, height/2 - img.getHeight(null)/2 - 250, null);
		
		g.setFont(new Font("Calibri", Font.PLAIN, 20));
		g.setColor(Color.BLACK);
		g.drawString("Inicie um jogo novo ou carrege um antigo!", this.width/2 - 173, this.height/2 - 75);
	}
	
	public void IniButtons(Insets in, int width, int height) {
		JButton b1 = new JButton("Novo Jogo");
		JButton b2 = new JButton("Carregar Jogo");
		
		b1.addActionListener(new TratadorNovoJogo());
		b2.addActionListener(new TratadorCarregarJogo(this));
		
		Dimension size1 = b1.getPreferredSize();
		Dimension size2 = b2.getPreferredSize();
		
		b1.setBounds(in.left + width/2 - size1.width, in.top + height/2 - 30, size1.width * 2, size1.height * 2);
		b2.setBounds(in.left + width/2 - size2.width, in.top + height/2 + 30, size2.width * 2, size2.height * 2);
		
		this.add(b1);
		this.add(b2);
	}

}
