package gameui;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;

import control.Control;
import control.SaveGame;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

//
// Classe CardButtonHandler - Action Listener
//
// Descrição: Action listener que, assim que o botão de cartas é acionada, ativa o frame de cartas.
//
// Métodos: actionPerformed
//

final class CardButtonHandler implements ActionListener {

	//
	// Método actionPerformed
	//
	// Descrição: Método acionado automaticamente ao ocorrer de um clique sobre
	// o botão de cartas.
	//
	// Parâmetros: e - Action Event sobre o elemento no qual uma instância dessa
	// classe está registrado.
	//
	// Retorno: Sem retorno.
	//

	public void actionPerformed(ActionEvent e) {
		UI.cardFrame();
	}
}

final class SaveButtonHandler implements ActionListener {

	public void actionPerformed(ActionEvent e) {
		JFileChooser fc = new JFileChooser();
		int ret;

		ret = fc.showSaveDialog(null);
		fc.addChoosableFileFilter(new FileNameExtensionFilter("Clue save data", "cdata"));
		if (ret == JFileChooser.APPROVE_OPTION) {
			try {
				Control.SaveThisGame(fc.getSelectedFile());
			} finally {
				System.out.println("Salvei!");
			}
		}
	}
}

//
// Classe CardPanel - JPanel
//
// Descrição: Painel que contém o botão de cartas da interface.
//
// Métodos: CardPanel (Construtor)
//

public class CardPanel extends JPanel {
	int width;
	int height;
	int posx;
	JButton cards = new JButton("Cartas");
	JButton save = new JButton("Salvar Jogo");

	//
	// Método CardPanel
	//
	// Descrição: Instancia essa classe, inicializando o JPanel com o botão, já
	// com seu Action Listener.
	//
	// Parâmetros: Sem Parâmetros.
	//

	public CardPanel() {
		super(new GridLayout(2, 1));
		this.setBackground(Color.BLACK);
		cards.addActionListener(new CardButtonHandler());
		save.addActionListener(new SaveButtonHandler());
		this.add(save);
		this.add(cards);
	}
}
