package gameui;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

//
// Classe TratadorNovoJogo
//
// Descrição: Tradador do botão NOVO JOGO.
//
// Métodos: actionPerformed
//

final class TratadorNovoJogo implements ActionListener {
	
	//
	// Método actionPerformed
	//
	// Descrição: Lida com o clique no botão NOVO JOGO.
	//
	// Parâmetros: ActionEvent e - Referência ao evento sobre o botão.
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
// Descrição: Tratador do botão de carregamento de partida.
//
// Métodos: TratadorCarregarJogo (Construtor), actionPerformed
//

final class TratadorCarregarJogo implements ActionListener {
	private JFileChooser fc;
	private Component parent;
	
	//
	// Construtor TratadorCarregarJogo
	//
	// Descrição: Abre um file chooser para a seleção de um arquivo de partida.
	//
	// Parâmetros: Component parent - Referência ao ascendente dessa classe.
	//
	
	public TratadorCarregarJogo(Component parent) {
		fc = new JFileChooser();
		this.parent = parent;
	}
	
	//
	// Método actionPerformed
	//
	// Descrição: Lida com o clique sobre o botão de carregamento de jogo.
	//
	// Parâmetro: ActionEvent e - Referência para o evento sobre o botão de carregamento de jogo.
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
// Descrição: Painel de início de jogo. Contém os botões NOVO JOGO e CARREGAR JOGO.
//
// Métodos: StartPanel (Construtor), paintComponent, IniButtons
//

public class StartPanel extends JPanel {
	int width;
	int height;
	Image img;
	
	//
	// Construtor StartPanel
	//
	// Descrição: Inicia o painel com sua largura e sua altura, também carregando a imagem do título.
	//
	// Parâmetros: int w - Largura do painel, int h - Altura do painel.
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
	// Método paintComponent
	//
	// Descrição: Pinta os componentes do painel, nesse caso o título "CLUE".
	//
	// Parâmetros: Graphics g - Referência ao módulo de gráficos do Swing.
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
	// Método IniButtons
	//
	// Descrição: Inicializa os botões no painel.
	//
	// Parâmetros: Insets in - Dimensões do container, int width - Largura do painel, int height - Altura do painel.
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
