package gameui;

import javax.swing.*;

import control.Control;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

//
// Classe DiceButtonHandler - ActionListener
//
// Métodos: actionPerformed
//

final class DiceButtonHandler implements ActionListener {

	//
	// Método actionPerformed
	//
	// Parâmetros: ActionEvent e - Referência à ação realizada sobre o botão de
	// dados.
	//
	// Retornos: Sem retorno.
	//

	public void actionPerformed(ActionEvent e) {

		if (Control.rodada.getDado() == 0) {
			Random r = new Random();
			int d = r.nextInt(6) + 1;
			UI.ChooseDice(d);
		} else {
			UI.Alert("O jogador " + Control.jogadores.get(0).getNome() + " deve jogar!");
		}

	}
}

//
// Classe DicePanel - JPanel
//
// Métodos: DicePanel (Construtor), SetImage
//

public class DicePanel extends JPanel {
	JButton dice = new JButton("Jogar Dados");
	JLabel diceImage = new JLabel();
	ImageIcon DiceIcon1, DiceIcon2, DiceIcon3, DiceIcon4, DiceIcon5, DiceIcon6;

	//
	// Construtor DicePanel
	//
	// Descrição: Inicializa o painel de dados, adicionando o botão e carregando
	// as imagens dos dados.
	//
	// Parâmetros: Sem Parâmetros.
	//

	public DicePanel() {
		super(new GridLayout(2, 1));
		this.add(dice);
		this.add(diceImage);
		diceImage.setHorizontalAlignment(JLabel.CENTER);
		dice.addActionListener(new DiceButtonHandler());

		DiceIcon1 = new ImageIcon("img/Tabuleiros/dado1.jpg");
		if (DiceIcon1.getImageLoadStatus() == MediaTracker.ERRORED) {
			System.out.println("Deu ruim no carregamento da imagem de dados 1");
		}
		DiceIcon2 = new ImageIcon("img/Tabuleiros/dado2.jpg");
		if (DiceIcon2.getImageLoadStatus() == MediaTracker.ERRORED) {
			System.out.println("Deu ruim no carregamento da imagem de dados 2");
		}
		DiceIcon3 = new ImageIcon("img/Tabuleiros/dado3.jpg");
		if (DiceIcon3.getImageLoadStatus() == MediaTracker.ERRORED) {
			System.out.println("Deu ruim no carregamento da imagem de dados 3");
		}
		DiceIcon4 = new ImageIcon("img/Tabuleiros/dado4.jpg");
		if (DiceIcon4.getImageLoadStatus() == MediaTracker.ERRORED) {
			System.out.println("Deu ruim no carregamento da imagem de dados 4");
		}
		DiceIcon5 = new ImageIcon("img/Tabuleiros/dado5.jpg");
		if (DiceIcon5.getImageLoadStatus() == MediaTracker.ERRORED) {
			System.out.println("Deu ruim no carregamento da imagem de dados 5");
		}
		DiceIcon6 = new ImageIcon("img/Tabuleiros/dado6.jpg");
		if (DiceIcon6.getImageLoadStatus() == MediaTracker.ERRORED) {
			System.out.println("Deu ruim no carregamento da imagem de dados 6");
		}
	}

	//
	// Método SetImage
	//
	// Descrição: Inicializa a imagem do dado no painel, ou atualiza a imagem no
	// painel com o valor do dado selecionado.
	//
	// Parâmetros: int dice - Valor do dado selecionado.
	//
	// Retorno: Sem retorno.
	//

	public void SetImage(int dice) {
		Control.rodada.setDado(dice);

		if (dice == 1) {
			diceImage.setIcon(DiceIcon1);
			diceImage.repaint();
			diceImage.setVisible(true);
		} else if (dice == 2) {
			diceImage.setIcon(DiceIcon2);
			diceImage.repaint();
			diceImage.setVisible(true);
		} else if (dice == 3) {
			diceImage.setIcon(DiceIcon3);
			diceImage.repaint();
			diceImage.setVisible(true);
		} else if (dice == 4) {
			diceImage.setIcon(DiceIcon4);
			diceImage.repaint();
			diceImage.setVisible(true);
		} else if (dice == 5) {
			diceImage.setIcon(DiceIcon5);
			diceImage.repaint();
			diceImage.setVisible(true);
		} else if (dice == 6) {
			diceImage.setIcon(DiceIcon6);
			diceImage.repaint();
			diceImage.setVisible(true);
		} else {
			UI.Alert("Valor Inválido no dado!");
		}

	}

}
