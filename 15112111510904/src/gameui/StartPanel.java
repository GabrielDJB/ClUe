package gameui;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

//
// Classe TratadorNovoJogo
//
// Descri��o: Tradador do bot�o NOVO JOGO.
//
// M�todos: actionPerformed
//

final class TratadorNovoJogo implements ActionListener {
	
	//
	// M�todo actionPerformed
	//
	// Descri��o: Lida com o clique no bot�o NOVO JOGO.
	//
	// Par�metros: ActionEvent e - Refer�ncia ao evento sobre o bot�o.
	//
	// Retorno: Sem retorno.
	//
	
	public void actionPerformed(ActionEvent e) {
		UI.mainf.dispose();
		UI.PlayerSet();
	}
}

//
// Classe TratadorCarregarJogo - ActionListener
//
// Descri��o: Tratador do bot�o de carregamento de partida.
//
// M�todos: TratadorCarregarJogo (Construtor), actionPerformed
//

final class TratadorCarregarJogo implements ActionListener {
	private JFileChooser fc;
	private Component parent;
	
	//
	// Construtor TratadorCarregarJogo
	//
	// Descri��o: Abre um file chooser para a sele��o de um arquivo de partida.
	//
	// Par�metros: Component parent - Refer�ncia ao ascendente dessa classe.
	//
	
	public TratadorCarregarJogo(Component parent) {
		fc = new JFileChooser();
		this.parent = parent;
	}
	
	//
	// M�todo actionPerformed
	//
	// Descri��o: Lida com o clique sobre o bot�o de carregamento de jogo.
	//
	// Par�metro: ActionEvent e - Refer�ncia para o evento sobre o bot�o de carregamento de jogo.
	//
	// Retorno: Sem retorno.
	//
	
	public void actionPerformed(ActionEvent e) {
		fc.showOpenDialog(parent);
	}
}

//
// Classe StartPanel - JPanel
//
// Descri��o: Painel de in�cio de jogo. Cont�m os bot�es NOVO JOGO e CARREGAR JOGO.
//
// M�todos: StartPanel (Construtor), paintComponent, IniButtons
//

public class StartPanel extends JPanel {
	int width;
	int height;
	Image img;
	
	//
	// Construtor StartPanel
	//
	// Descri��o: Inicia o painel com sua largura e sua altura, tamb�m carregando a imagem do t�tulo.
	//
	// Par�metros: int w - Largura do painel, int h - Altura do painel.
	//
	
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
	
	//
	// M�todo paintComponent
	//
	// Descri��o: Pinta os componentes do painel, nesse caso o t�tulo "CLUE".
	//
	// Par�metros: Graphics g - Refer�ncia ao m�dulo de gr�ficos do Swing.
	//
	// Retorno: Sem retorno.
	//
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		g.drawImage(img, width/2 - img.getWidth(null)/2, height/2 - img.getHeight(null)/2 - 250, null);
		
		g.setFont(new Font("Calibri", Font.PLAIN, 20));
		g.setColor(Color.BLACK);
		g.drawString("Inicie um jogo novo ou carrege um antigo!", this.width/2 - 173, this.height/2 - 75);
	}
	
	//
	// M�todo IniButtons
	//
	// Descri��o: Inicializa os bot�es no painel.
	//
	// Par�metros: Insets in - Dimens�es do container, int width - Largura do painel, int height - Altura do painel.
	//
	// Retorno: Sem retorno.
	//
	
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
