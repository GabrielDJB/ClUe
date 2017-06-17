package gameui;

import javax.imageio.ImageIO;
import javax.swing.*;

import control.Control;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.Random;

//
// Classe DiceButtonHandler - ActionListener
//
// Descrição: Listener do botão de dados. Caso esse botão seja clicado, abre a janela para seleção de dados. Posteriormente causar uma nova jogada de dado.
//
// Métodos: actionPerformed
//

final class DiceButtonHandler implements ActionListener {

	//
	// Método actionPerformed
	//
	// Descrição: Método acionado quando o botão é clicado, abrindo a janela de
	// seleção de botão, através de UI.DiceSelect().
	//
	// Parâmetros: ActionEvent e - Referência à ação realizada sobre o botão de
	// dados.
	//
	// Retornos: Sem retorno.
	//

	public void actionPerformed(ActionEvent e) {
		if (Control.rodada.dado == 0) {
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
// Descrição: Painel contendo o botão de dados e responsável pela exibição do
// dados selecionado.
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

		DiceIcon1 = new ImageIcon("img/Tabuleiros/dado1.JPG");
		DiceIcon2 = new ImageIcon("img/Tabuleiros/dado2.JPG");
		DiceIcon3 = new ImageIcon("img/Tabuleiros/dado3.JPG");
		DiceIcon4 = new ImageIcon("img/Tabuleiros/dado4.JPG");
		DiceIcon5 = new ImageIcon("img/Tabuleiros/dado5.JPG");
		DiceIcon6 = new ImageIcon("img/Tabuleiros/dado6.JPG");
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
		Control.rodada.dado = dice;
		System.out.println(dice);
		if (dice == 1) {
			diceImage.setIcon(DiceIcon1);
			diceImage.repaint();
			diceImage.setVisible(true);
			System.out.println("Repaint 1");
		} else if (dice == 2) {
			diceImage.setIcon(DiceIcon2);
			diceImage.repaint();
			System.out.println("Repaint 2");
		} else if (dice == 3) {
			diceImage.setIcon(DiceIcon3);
			diceImage.repaint();
			System.out.println("Repaint 3");
		} else if (dice == 4) {
			diceImage.setIcon(DiceIcon4);
			diceImage.repaint();
			System.out.println("Repaint 4");
		} else if (dice == 5) {
			diceImage.setIcon(DiceIcon5);
			diceImage.repaint();
			System.out.println("Repaint 5");
		} else if (dice == 6) {
			diceImage.setIcon(DiceIcon6);
			diceImage.repaint();
			System.out.println("Repaint 6");
		} else {
			UI.Alert("Valor Inválido no dado!");
		}

	}

}
