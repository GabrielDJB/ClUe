package gameui;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//
// Classe CardButtonHandler - Action Listener
//
// Descri��o: Action listener que, assim que o bot�o de cartas � acionada, ativa o frame de cartas.
//
// M�todos: actionPerformed
//

final class CardButtonHandler implements ActionListener {
	
	//
	// M�todo actionPerformed
	//
	// Descri��o: M�todo acionado automaticamente ao ocorrer de um clique sobre o bot�o de cartas.
	//
	// Par�metros: e - Action Event sobre o elemento no qual uma inst�ncia dessa classe est� registrado.
	//
	// Retorno: Sem retorno.
	//
	
	public void actionPerformed(ActionEvent e) {
		UI.cardFrame();
	}
}

//
// Classe CardPanel - JPanel
//
// Descri��o: Painel que cont�m o bot�o de cartas da interface.
//
// M�todos: CardPanel (Construtor)
//

public class CardPanel extends JPanel {
	int width; int height; int posx;
	JButton cards = new JButton("Cartas");
	
	//
	// M�todo CardPanel
	//
	// Descri��o: Instancia essa classe, inicializando o JPanel com o bot�o, j� com seu Action Listener.
	//
	// Par�metros: Sem par�metros.
	//
	
	public CardPanel(){
		super(new GridLayout(1,1));
		this.setBackground(Color.BLACK);
		cards.addActionListener(new CardButtonHandler());
		this.add(cards);
	}
}
