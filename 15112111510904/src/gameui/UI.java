package gameui;

import control.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//
// Classe AlertOKHandler - Action Listener
//
// Descrição: Listener do botão OK nos Alerts.
//
// Métodos: actionPerformed
//

final class AlertOKHandler implements ActionListener {

	//
	// Método actionPerformed
	//
	// Descrição: Quando clicado o botão OK num alerta, esse listener fecha a janela do alerta.
	//
	// Parâmetros: ActionEvent e - Referência ao evento sobre o botão OK.
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
// Descrição: Representa uma classe que, de acordo com o design pattern de delegação, administra os comandos de interface do programa, sendo a camada mais externa de tal módulo.
//
// Métodos: IniFrame, PlayerSet, GameStart, DiceSelect, DiceClose, switchDice, cardFrame, Alert, RefreshMap
//

public abstract class UI {
	static MainFrame mainf;
	static JFrame diceSelect;
	static JFrame alert;
	static Toolkit tk = Toolkit.getDefaultToolkit();
	static Dimension screen = tk.getScreenSize();

	//
	// Método IniFrame
	//
	// Descrição: Inicializa o frame inicial do jogo, criando um MainFrame e chamando seu método StartMenu().
	//
	// Parâmetros: Sem parâmetros.
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
	// Método PlayerSet
	//
	// Descrição: Abre o seletor de personagens, através do método CharSelectMenu do MainFrame.
	//
	// Parâmetros: Sem parâmetros.
	//
	// Retorno: Sem retorno.
	//

	public static void PlayerSet() {
		mainf = new MainFrame();
		mainf.CharSelectMenu();
		mainf.setVisible(true);
	}
	
	//
	// Método GameStart
	//
	// Descrição: Inicializa a interface principal do jogo através do método GameMenu do MainFrame.
	//
	// Parâmetros: Sem parâmetros.
	//
	// Retorno: Sem retorno.
	//

	public static void GameStart() {
		mainf = new MainFrame();
		mainf.GameMenu();
		mainf.setVisible(true);
	}

	//
	// Método DiceSelect
	//
	// Descrição: Inicia o frame e o painel de seleção de dado.
	//
	// Parâmetros: Sem parâmetros.
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
	// Método DiceClose
	//
	// Descrição: Fecha a janela de seleção de dados.
	//
	// Parâmetros: Sem parâmetros.
	//
	// Retorno: Sem retorno.
	//

	public static void DiceClose() {
		if (diceSelect.isActive()) {
			diceSelect.dispose();
		}
	}

	//
	// Método switchDice
	//
	// Descrição: Passa o valor d como novo valor do dado e delega ao método ChooseDice do MainFrame para atualizá-lo.
	//
	// Parâmetros: int d - Novo valor do dado.
	//
	// Retorno: Sem retorno.
	//
	
	public static void switchDice(int d) {
		mainf.ChooseDice(d);
	}

	//
	// Método cardFrame
	//
	// Descrição: Abre o frame de escolha de cartas.
	//
	// Parâmetros: Sem parâmetros.
	//
	// Retorno: Sem retorno.
	//
	
	public static void cardFrame() {
		JFrame cardf = new JFrame("Seleção de Cartas");
		CardSelector CardSPanel = new CardSelector(cardf.getContentPane());
		cardf.setBounds(50, 50, 500, 420);
		cardf.setVisible(true);
	}

	//
	// Método Alert
	//
	// Descrição: Abre uma janela com um alerta escrito.
	//
	// Parâmetros: String s - Mensagem a ser impressa no alerta.
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
	// Método RefreshMap
	//
	// Descrição: Delega para o método RepaintMap do MainFrame para atualizar a impressão do mapa.
	//
	// Parâmetros: Sem parâmetros.
	//
	// Retorno: Sem retorno.
	//
	
	public static void RefreshMap(){
		mainf.RepaintMap();
	}
}
