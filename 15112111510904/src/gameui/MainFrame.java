package gameui;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.*;

public class MainFrame extends JFrame {
	public final int DEFAULT_WIDTH = 1200; //800;
	public final int DEFAULT_HEIGHT = 1000;//700;
	DicePanel d;
	MapPanel m;
	CardPanel c;
	PlayMenu p;
	
	public MainFrame(){		
		super("Clue!");
		
		Toolkit tk = Toolkit.getDefaultToolkit();
		Dimension screenSize = tk.getScreenSize();
		int width = screenSize.width;
		int height = screenSize.height;
		int x = width/2 - DEFAULT_WIDTH/2;
		int y = height/2 - DEFAULT_HEIGHT/2;
		
		setBounds(x,y,DEFAULT_WIDTH, DEFAULT_HEIGHT);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(Boolean.FALSE);
		
		try {
			UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
		}
		catch (ClassNotFoundException e){
			System.out.println("Look and Feel nao encontrado!");
		}
		catch (UnsupportedLookAndFeelException e) {
			System.out.println("Look and Feel nao suportado!");
		}
		catch (Exception e) {
			System.out.println("Erro na criacao do look and feel!");
		}
	}
	
	public void StartMenu(){
		StartPanel p = new StartPanel(DEFAULT_WIDTH, DEFAULT_HEIGHT);
		p.IniButtons(p.getInsets(), DEFAULT_WIDTH, DEFAULT_HEIGHT);
		p.setLayout(null);
		p.setBackground(Color.WHITE);
		
		getContentPane().add(p);
	}
	
	public void CharSelectMenu(){
		CharSelectPanel p = new CharSelectPanel(DEFAULT_WIDTH, DEFAULT_HEIGHT);
		p.IniCharList();
		p.UserButtons();
		p.setLayout(null);
		
		getContentPane().add(p);
	}
	
	public void GameMenu(){
		JPanel base = new JPanel(new GridBagLayout());
		base.setBounds(0, 0, DEFAULT_WIDTH, DEFAULT_HEIGHT);
		this.m = new MapPanel(DEFAULT_WIDTH, DEFAULT_HEIGHT);
		this.c = new CardPanel();
		this.d = new DicePanel();
		this.p = new PlayMenu();
		
		getContentPane().add(base);
		
		GridBagConstraints MapConst = new GridBagConstraints();
		MapConst.fill = GridBagConstraints.BOTH;
		MapConst.gridx = 0;
		MapConst.gridy = 0;
		MapConst.gridheight = 4;
		MapConst.gridwidth = 4;
		MapConst.weightx = 1;
		MapConst.weighty = 1;

		base.add(m, MapConst);
		
		GridBagConstraints CardConst = new GridBagConstraints();
		CardConst.fill = GridBagConstraints.BOTH;
		CardConst.gridx = 4;
		CardConst.gridy = 0;
		CardConst.weightx = 0.25;
		CardConst.weighty = 0.25;
		
		base.add(c, CardConst);
		
		GridBagConstraints DiceConst = new GridBagConstraints();
		DiceConst.fill = GridBagConstraints.BOTH;
		DiceConst.gridx = 4;
		DiceConst.gridy = 1;
		DiceConst.gridheight = 2;
		DiceConst.weightx = 0.25;
		DiceConst.weighty = 0.25;
		
		base.add(d, DiceConst);
		
		//GridBagConstraints MenuConst = new GridBagConstraints();
		//MenuConst.fill = GridBagConstraints.BOTH;
		//MenuConst.gridx = 4;
		//MenuConst.gridy = 3;
		//MenuConst.weightx = 0.0;
		//MenuConst.weighty = 0.10;
		
		//base.add(m, MenuConst);
		
	}
	
	public void ChooseDice(int value){
		d.SetImage(value);
	}
	
	public void RepaintMap(){
		m.repaint();
	}
}
