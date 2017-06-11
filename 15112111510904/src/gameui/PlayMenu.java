package gameui;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.*;

//
// Classe PlayMenu
//
// Descri��o: Painel respons�vel por acusa��es e pela chamada por uma pr�xima jogada.
//
// M�todos: PlayMenu
//

public class PlayMenu extends JPanel{
	JButton acuse;
	JButton next;
	
	//
	// Construtor PlayMenu
	//
	// Descri��o: Inicializa o painel com os bot�es necess�rios.
	//
	// Par�metros: Sem par�metros.
	//
	// Retorno: Sem retorno.
	//
	
	public PlayMenu(){
		super(new GridLayout(2,1));
		acuse = new JButton("ACUSAR");
		next = new JButton("Pr�xima Jogada");
		this.add(acuse);
		this.add(next);
		this.setBackground(Color.BLUE);
	}
}
