package gameui;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.*;

//
// Classe PlayMenu
//
// Descrição: Painel responsável por acusações e pela chamada por uma próxima jogada.
//
// Métodos: PlayMenu
//

public class PlayMenu extends JPanel {
	JButton acuse;
	JButton next;

	//
	// Construtor PlayMenu
	//
	// Descrição: Inicializa o painel com os botões necessários.
	//
	// Parâmetros: Sem Parâmetros.
	//
	// Retorno: Sem retorno.
	//

	public PlayMenu() {
		super(new GridLayout(2, 1));
		acuse = new JButton("ACUSAR");
		next = new JButton("Próxima Jogada");
		this.add(acuse);
		this.add(next);
		this.setBackground(Color.BLUE);
	}
}
