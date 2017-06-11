package gameui;
import control.Control;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

//
// Classe TratadorOK - Action Listener
//
// Descri��o: Listener do bot�o OK, adicionando os players ao jogo quando o bot�o � ativado.
//
// M�todos: TratadorOK (Construtor) ,actionPerformed
//

final class TratadorOK implements ActionListener {
	
	JCheckBox boxes[];
	
	//
	// M�todo TratadorOK - Construtor
	//
	// Descri��o: Construtor do listener, administrando os checkboxes do painel.
	//
	// Par�metros: JCheckBox b[] - Vetor com as refer�ncias dos checkboxes no painel.
	//
	
	public TratadorOK(JCheckBox b[]) {
		boxes = b;
	}
	
	//
	// M�todo actionPerformed
	//
	// Descri��o: Quando o bot�o for clicado, adiciona os jogadores selecionados no painel no momento da a��o.
	//
	// Par�metros: ActionEvent e - Refer�ncia � a��o realizada sobre o bot�o OK.
	//
	// Retorno: Sem retorno.
	//
	
	public void actionPerformed(ActionEvent e) {
		for (JCheckBox b : boxes) {
			if (b.isSelected()) {
				Control.AddPlayer(b.getText());
			}
		}
		Control.printNP();
		UI.mainf.dispose();
		UI.GameStart();
	}
}

//
// Classe TratadorCancelar - Action Listener
//
// Descri��o: Listener do bot�o cancelar, voltando para o frame do jogo.
//
// M�todos: actionPerformed
//

final class TratadorCancelar implements ActionListener {
	
	//
	// M�todo actionPerformed
	//
	// Descri��o: Quando o bot�o cancelar for clicado, esse m�todo volta para o frame inicial.
	//
	// Par�metros: ActionEvent e - Refer�ncia � a��o realizada sobre o bot�o.
	//
	// Retorno: Sem retornos.
	//
	
	public void actionPerformed(ActionEvent e) {
		UI.mainf.dispose();
		UI.IniFrame();
	}
}

//
// Classe CharSelectPanel - JPanel
//
// Descri��o: Painel de sele��o de personagens do jogo, ativado ao in�cio de uma nova partida.
//
// Vari�veis: Sem vari�veis vis�veis.
//
// M�todos: CharSelectPanel (Construtor), IniCharList, UserButtons
//

public class CharSelectPanel extends JPanel {
	int width;
	int height;
	JCheckBox boxes[];
	
	//
	// Construtor CharSelectPanel
	//
	// Descri��o: Instancia essa classe inicalizando parte das vari�veis. Para uma inicializa��o completa, deve ser seguinda do m�todo IniCharList.
	//
	// Par�metros: int w - Largura do painel, int h - Altura do painel.
	//
	
	public CharSelectPanel(int w, int h) {
		this.width = w;
		this.height = h;
		boxes = new JCheckBox[7];
	}
	
	//
	// M�todo IniCharList
	//
	// Descri��o: Inicializa todas as caixas de sele��o de jogadores.
	//
	// Par�metros: Sem par�metros.
	//
	// Retorno: Sem retornos.
	//
	
	public void IniCharList() {
		JLabel l = new JLabel("Selecione os personagens da partida: ");
		l.setFont(new Font("Calibri", Font.PLAIN, 20));
		l.setBounds(100, 75, 600, 50);
		
		boxes[0] = new JCheckBox("Pele");
		boxes[1] = new JCheckBox("Maradona");
		boxes[2] = new JCheckBox("Eric Cantona");
		boxes[3] = new JCheckBox("Zinedine Zidane");
		boxes[4] = new JCheckBox("Ronaldinho Gaucho");
		boxes[5] = new JCheckBox("Taffarel");
		boxes[6] = new JCheckBox("Zico");
		
		
		boxes[0].setBounds(100, 150, 200, 30);
		boxes[1].setBounds(100, 200, 200, 30);
		boxes[2].setBounds(100, 250, 200, 30);
		boxes[3].setBounds(100, 300, 200, 30);
		boxes[4].setBounds(100, 350, 200, 30);
		boxes[5].setBounds(100, 400, 200, 30);
		boxes[6].setBounds(100, 450, 200, 30);
		
		this.add(l);
		
		for (JCheckBox b : boxes) {
			this.add(b);
		}
	}
	
	//
	// M�todo UserButtons
	//
	// Descri��o: Inicializa os bot�es OK e CANCELAR, funcionando como as op��es de sa�da da tela.
	//
	// Par�metros: Sem par�metros.
	//
	// Retorno: Sem retorno.
	//
	
	public void UserButtons() {
		JButton ok = new JButton("OK");
		JButton cancelar = new JButton("Cancelar");
		
		ok.addActionListener(new TratadorOK(this.boxes));
		cancelar.addActionListener(new TratadorCancelar());
		
		ok.setBounds(600, 600, 100, 50);
		cancelar.setBounds(700, 600, 100, 50);
		
		this.add(ok);
		this.add(cancelar);
	}
}
