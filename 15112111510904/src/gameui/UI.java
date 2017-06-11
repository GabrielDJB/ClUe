package gameui;

import control.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//
// Classe AlertOKHandler - Action Listener
//
// Descri��o: Listener do bot�o OK nos Alerts.
//
// M�todos: actionPerformed
//

final class AlertOKHandler implements ActionListener {

	//
	// M�todo actionPerformed
	//
	// Descri��o: Quando clicado o bot�o OK num alerta, esse listener fecha a janela do alerta.
	//
	// Par�metros: ActionEvent e - Refer�ncia ao evento sobre o bot�o OK.
	//
	// Retorno: Sem retorno.
	//
	
	public void actionPerformed(ActionEvent e) {
		UI.alert.dispose();
	}
}

//
// Classe UI - Abstrata - Delegadora
//
// Descri��o: Representa uma classe que, de acordo com o design pattern de delega��o, administra os comandos de interface do programa, sendo a camada mais externa de tal m�dulo.
//
// M�todos: IniFrame, PlayerSet, GameStart, DiceSelect, DiceClose, switchDice, cardFrame, Alert, RefreshMap
//

public abstract class UI {
	static MainFrame mainf;
	static JFrame diceSelect;
	static JFrame alert;
	static Toolkit tk = Toolkit.getDefaultToolkit();
	static Dimension screen = tk.getScreenSize();

	//
	// M�todo IniFrame
	//
	// Descri��o: Inicializa o frame inicial do jogo, criando um MainFrame e chamando seu m�todo StartMenu().
	//
	// Par�metros: Sem par�metros.
	//
	// Retorno: Sem retorno.
	//
	
	public static void IniFrame() {
		Control.InitControl();
		System.out.println(Control.getMap().evalPath(1, 24, 4));
		mainf = new MainFrame();
		mainf.StartMenu();
		mainf.setVisible(true);
	}
	
	//
	// M�todo PlayerSet
	//
	// Descri��o: Abre o seletor de personagens, atrav�s do m�todo CharSelectMenu do MainFrame.
	//
	// Par�metros: Sem par�metros.
	//
	// Retorno: Sem retorno.
	//

	public static void PlayerSet() {
		mainf = new MainFrame();
		mainf.CharSelectMenu();
		mainf.setVisible(true);
	}
	
	//
	// M�todo GameStart
	//
	// Descri��o: Inicializa a interface principal do jogo atrav�s do m�todo GameMenu do MainFrame.
	//
	// Par�metros: Sem par�metros.
	//
	// Retorno: Sem retorno.
	//

	public static void GameStart() {
		mainf = new MainFrame();
		mainf.GameMenu();
		mainf.setVisible(true);
	}

	//
	// M�todo DiceSelect
	//
	// Descri��o: Inicia o frame e o painel de sele��o de dado.
	//
	// Par�metros: Sem par�metros.
	//
	// Retorno: Sem retorno.
	//
	
	public static void DiceSelect() {
		int width = 600, height = 450, x = screen.width / 2 - width / 2, y = screen.height / 2 - height / 2;
		diceSelect = new JFrame();
		TempDiceSelect diceSelectPane = new TempDiceSelect(diceSelect.getContentPane());
		diceSelect.setBounds(x, y, width, height);
		diceSelectPane.DiceButtons();
		diceSelect.setVisible(true);

	}
	
	//
	// M�todo DiceClose
	//
	// Descri��o: Fecha a janela de sele��o de dados.
	//
	// Par�metros: Sem par�metros.
	//
	// Retorno: Sem retorno.
	//

	public static void DiceClose() {
		if (diceSelect.isActive()) {
			diceSelect.dispose();
		}
	}

	//
	// M�todo switchDice
	//
	// Descri��o: Passa o valor d como novo valor do dado e delega ao m�todo ChooseDice do MainFrame para atualiz�-lo.
	//
	// Par�metros: int d - Novo valor do dado.
	//
	// Retorno: Sem retorno.
	//
	
	public static void switchDice(int d) {
		mainf.ChooseDice(d);
	}

	//
	// M�todo cardFrame
	//
	// Descri��o: Abre o frame de escolha de cartas.
	//
	// Par�metros: Sem par�metros.
	//
	// Retorno: Sem retorno.
	//
	
	public static void cardFrame() {
		JFrame cardf = new JFrame("Sele��o de Cartas");
		CardSelector CardSPanel = new CardSelector(cardf.getContentPane());
		cardf.setBounds(50, 50, 500, 420);
		cardf.setVisible(true);
	}

	//
	// M�todo Alert
	//
	// Descri��o: Abre uma janela com um alerta escrito.
	//
	// Par�metros: String s - Mensagem a ser impressa no alerta.
	//
	// Retorno: Sem retorno.
	//
	
	public static void Alert(String s) {
		alert = new JFrame();
		JPanel alertPanel = new JPanel();
		JLabel msg = new JLabel(s);
		JButton b = new JButton("OK");
		int x, y, width = 300, height = 150;
		x = screen.width / 2 - width / 2;
		y = screen.height / 2 - height / 2;

		alert.setBounds(x, y, width, height);
		alert.setResizable(false);
		alert.getContentPane().add(alertPanel);

		alertPanel.setLayout(new GridLayout(2, 1));
		alertPanel.add(msg);
		alertPanel.add(b);
		b.addActionListener(new AlertOKHandler());
		msg.setHorizontalAlignment(JLabel.CENTER);
		alert.setVisible(true);
	}
	
	//
	// M�todo RefreshMap
	//
	// Descri��o: Delega para o m�todo RepaintMap do MainFrame para atualizar a impress�o do mapa.
	//
	// Par�metros: Sem par�metros.
	//
	// Retorno: Sem retorno.
	//
	
	public static void RefreshMap(){
		mainf.RepaintMap();
	}
}
