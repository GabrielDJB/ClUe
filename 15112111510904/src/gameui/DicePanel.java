package gameui;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

//
// Classe DiceButtonHandler - ActionListener
//
// Descri��o: Listener do bot�o de dados. Caso esse bot�o seja clicado, abre a janela para sele��o de dados. Posteriormente causar� uma nova jogada de dado.
//
// M�todos: actionPerformed
//

final class DiceButtonHandler implements ActionListener {
	
	//
	// M�todo actionPerformed
	//
	// Descri��o: M�todo acionado quando o bot�o � clicado, abrindo a janela de sele��o de bot�o, atrav�s de UI.DiceSelect().
	//
	// Par�metros: ActionEvent e - Refer�ncia � a��o realizada sobre o bot�o de dados.
	//
	// Retornos: Sem retorno.
	//
	
	public void actionPerformed(ActionEvent e) {
		UI.DiceSelect();
	}
}

//
// Classe DicePanel - JPanel
//
// Descri��o: Painel contendo o bot�o de dados e respons�vel pela exibi��o do dados selecionado.
//
// M�todos: DicePanel (Construtor), SetImage
//

public class DicePanel extends JPanel {
	JButton dice = new JButton("Jogar Dados");
	JLabel diceImage = new JLabel();
	ImageIcon DiceIcon1, DiceIcon2, DiceIcon3, DiceIcon4, DiceIcon5, DiceIcon6;
	
	//
	// Construtor DicePanel
	//
	// Descri��o: Inicializa o painel de dados, adicionando o bot�o e carregando as imagens dos dados.
	//
	// Par�metros: Sem par�metros.
	//
	
	public DicePanel(){
		super(new GridLayout(2,1));
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
	// M�todo SetImage
	//
	// Descri��o: Inicializa a imagem do dado no painel, ou atualiza a imagem no painel com o valor do dado selecionado.
	//
	// Par�metros: int dice - Valor do dado selecionado.
	//
	// Retorno: Sem retorno.
	//
	
	public void SetImage(int dice){
		if(dice == 1){
			diceImage.setIcon(DiceIcon1);
			diceImage.repaint();
		} else if (dice == 2) {
			diceImage.setIcon(DiceIcon2);
			diceImage.repaint();
		} else if (dice == 3) {
			diceImage.setIcon(DiceIcon3);
			diceImage.repaint();
		} else if (dice == 4) {
			diceImage.setIcon(DiceIcon4);
			diceImage.repaint();
		} else if (dice == 5) {
			diceImage.setIcon(DiceIcon5);
			diceImage.repaint();
		} else if (dice == 6) {
			diceImage.setIcon(DiceIcon6);
			diceImage.repaint();
		} else {
			UI.Alert("Valor Inv�lido no dado!");
		}
	}
	
}
