package gameui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import control.Control;

final class NextPlayHandler implements ActionListener {
	public void actionPerformed(ActionEvent e) {
		Control.rodada.nextTurn();
		UI.Alert(Control.jogadores.get(0).getNome() + " - JOGUE O DADO!");
	}
}

final class AcuseHandler implements ActionListener {
	public void actionPerformed(ActionEvent e) {
		UI.AcusaFrame();
	}
}

final class PalpiteHandler implements ActionListener {
	public void actionPerformed(ActionEvent e) {
		UI.PalpiteFrame();
	}
}

//
// Classe PlayMenu
//
// Descrição: Painel responsável por acusações e pela chamada por uma próxima
// jogada.
//
// Métodos: PlayMenu
//

@SuppressWarnings("serial")
public class PlayMenu extends JPanel {
	JButton acuse;
	JButton next;
	JButton palpite;

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
		super(new GridLayout(3, 1));
		acuse = new JButton("Acusar");
		palpite = new JButton("Palpite");
		next = new JButton("Proxima Jogada");
		next.addActionListener(new NextPlayHandler());
		acuse.addActionListener(new AcuseHandler());
		palpite.addActionListener(new PalpiteHandler());
		this.add(acuse);
		this.add(palpite);
		this.add(next);
	}
}
