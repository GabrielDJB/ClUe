package gameui;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.*;

//
// Classe MainFrame - JFrame
//
// Descri��o: Classe do frame principal do jogo. Sobre ele s�o inseridos os diversos pain�is de jogo.
//
// M�todos: MainFrame (Construtor), StartMenu, CharSelectMenu, GameMenu, ChooseDice, RepaintMap
//

public class MainFrame extends JFrame {
	public final int DEFAULT_WIDTH = 1200; //800;
	public final int DEFAULT_HEIGHT = 1000;//700;
	DicePanel d;
	MapPanel m;
	CardPanel c;
	PlayMenu p;
	
	//
	// Construtor MainFrame
	//
	// Descri��o: Inicializa o frame principal do jogo com as propriedades default.
	//
	// Par�metros: Sem par�metros.
	//
	
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
	
	//
	// M�todo StartMenu
	//
	// Descri��o: Adiciona ao frame o painel de inicio de jogo.
	//
	// Par�metros: Sem par�metros.
	//
	// Retorno: Sem retorno.
	//
	
	public void StartMenu(){
		StartPanel p = new StartPanel(DEFAULT_WIDTH, DEFAULT_HEIGHT);
		p.IniButtons(p.getInsets(), DEFAULT_WIDTH, DEFAULT_HEIGHT);
		p.setLayout(null);
		p.setBackground(Color.WHITE);
		
		getContentPane().add(p);
	}
	
	//
	// M�todo CharSelectMenu
	//
	// Descri��o: Adiciona o painel de sele��o de personagens ao frame.
	//
	// Par�metros: Sem par�metros.
	//
	// Retornos: Sem retornos.
	//
	
	public void CharSelectMenu(){
		CharSelectPanel p = new CharSelectPanel(DEFAULT_WIDTH, DEFAULT_HEIGHT);
		p.IniCharList();
		p.UserButtons();
		p.setLayout(null);
		
		getContentPane().add(p);
	}
	
	//
	// M�todo GameMenu
	//
	// Descri��o: Inicia os pain�is de dado, do mapa, dos dados e das cartas, que comp�em a interface principal do jogo.
	//
	// Par�metros: Sem par�metros.
	//
	// Retorno: Sem retorno.
	//
	
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
	
	//
	// M�todo ChooseDice
	//
	// Descri��o: Delega a atualiza��o da imagem do dado para o painel de dados.
	//
	// Par�metros: int value - Novo valor do dado.
	//
	// Retorno: Sem retorno.
	//
	
	public void ChooseDice(int value){
		d.SetImage(value);
	}
	
	//
	// M�todo RepaintMap
	//
	// Descri��o: Repinta o mapa, ap�s atualiza��es de posi��o dos jogadores.
	//
	// Par�metros: Sem par�metros.
	//
	// Retorno: Sem retorno.
	//
	
	public void RepaintMap(){
		m.repaint();
	}
}
