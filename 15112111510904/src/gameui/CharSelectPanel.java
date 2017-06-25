package gameui;

import control.Control;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

//
// Classe TratadorOK - Action Listener
//
// Descrição: Listener do botão OK, adicionando os players ao jogo quando o botão é ativado.
//
// Métodos: TratadorOK (Construtor) ,actionPerformed
//

final class TratadorOK implements ActionListener {

	JCheckBox boxes[];

	//
	// Método TratadorOK - Construtor
	//
	// Descrição: Construtor do listener, administrando os checkboxes do painel.
	//
	// Parâmetros: JCheckBox b[] - Vetor com as referências dos checkboxes no
	// painel.
	//

	public TratadorOK(JCheckBox b[]) {
		boxes = b;
	}

	//
	// Método actionPerformed
	//
	// Descrição: Quando o botão for clicado, adiciona os jogadores selecionados
	// no painel no momento da ação.
	//
	// Parâmetros: ActionEvent e - Referência á ação realizada sobre o botão OK.
	//
	// Retorno: Sem retorno.
	//

	public void actionPerformed(ActionEvent e) {
		
		for (JCheckBox tmp : boxes) {
			if (tmp.isSelected())
				Control.rodada.addNumP();
		}

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
// Descrição: Listener do botão cancelar, voltando para o frame do jogo.
//
// Métodos: actionPerformed
//

final class TratadorCancelar implements ActionListener {

	//
	// Método actionPerformed
	//
	// Descrição: Quando o botão cancelar for clicado, esse Método volta para o
	// frame inicial.
	//
	// Parâmetros: ActionEvent e - Referência á ação realizada sobre o botão.
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
// Descrição: Painel de seleção de personagens do jogo, ativado ao início de uma
// nova partida.
//
// Variáveis: Sem variáveis visíveis.
//
// Métodos: CharSelectPanel (Construtor), IniCharList, UserButtons
//

public class CharSelectPanel extends JPanel {
	int width;
	int height;
	JCheckBox boxes[];

	//
	// Construtor CharSelectPanel
	//
	// Descrição: Instancia essa classe inicalizando parte das variáveis. Para
	// uma inicialização completa, deve ser seguinda do Método IniCharList.
	//
	// Parâmetros: int w - Largura do painel, int h - Altura do painel.
	//

	public CharSelectPanel(int w, int h) {
		this.width = w;
		this.height = h;
		boxes = new JCheckBox[7];
	}

	//
	// Método IniCharList
	//
	// Descrição: Inicializa todas as caixas de seleção de jogadores.
	//
	// Parâmetros: Sem Parâmetros.
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
	// Método UserButtons
	//
	// Descrição: Inicializa os botões OK e CANCELAR, funcionando como as opções
	// de saída da tela.
	//
	// Parâmetros: Sem Parâmetros.
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
