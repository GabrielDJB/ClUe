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
	// Descrição: Quando clicado o botão OK num alerta, esse listener fecha a
	// janela do alerta.
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
// Descrição: Representa uma classe que, de acordo com o design pattern de
// delegação, administra os comandos de interface do programa, sendo a camada
// mais externa de tal módulo.
//
// Métodos: IniFrame, PlayerSet, GameStart, DiceSelect, DiceClose, switchDice,
// cardFrame, Alert, RefreshMap
//

public abstract class UI {
	static MainFrame mainf;
	static JFrame alert;
	static Toolkit tk = Toolkit.getDefaultToolkit();
	static Dimension screen = tk.getScreenSize();

	//
	// Método IniFrame
	//
	// Descrição: Inicializa o frame inicial do jogo, criando um MainFrame e
	// chamando seu Método StartMenu().
	//
	// Parâmetros: Sem Parâmetros.
	//
	// Retorno: Sem retorno.
	//

	public static void IniFrame() {
		Control.InitControl();
		mainf = new MainFrame();
		mainf.StartMenu();
		mainf.setVisible(true);
	}

	//
	// Método PlayerSet
	//
	// Descrição: Abre o seletor de personagens, através do Método
	// CharSelectMenu do MainFrame.
	//
	// Parâmetros: Sem Parâmetros.
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
	// Descrição: Inicializa a interface principal do jogo através do Método
	// GameMenu do MainFrame.
	//
	// Parâmetros: Sem Parâmetros.
	//
	// Retorno: Sem retorno.
	//

	public static void GameStart() {
		mainf = new MainFrame();
		mainf.GameMenu();
		mainf.setVisible(true);
	}

	//
	// Método cardFrame
	//
	// Descrição: Abre o frame de escolha de cartas.
	//
	// Parâmetros: Sem Parâmetros.
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
	// Metodo ChooseDice
	//
	// Descricao: Recebe o valor do dado e passa para o painel esse valor para
	// redesenhar
	//
	// Parametros: d - Valor do dado
	//
	// Retornos: Nenhum
	//

	public static void ChooseDice(int d) {
		mainf.ChooseDice(d);
	}

	//
	// Método RefreshMap
	//
	// Descrição: Delega para o Método RepaintMap do MainFrame para atualizar a
	// impressão do mapa.
	//
	// Parâmetros: Sem Parâmetros.
	//
	// Retorno: Sem retorno.
	//

	public static void RefreshMap() {
		mainf.RepaintMap();
	}

	public static void PalpiteFrame() {
		PalpiteFrame p = new PalpiteFrame();
		p.SuspectList();
		p.GunList();
		p.LocaleList();
		p.Show();
		p.setVisible(true);
	}

	public static void AcusaFrame() {
		AcusaFrame a = new AcusaFrame();
		a.SuspectList();
		a.GunList();
		a.LocaleList();
		a.Show();
		a.setVisible(true);
	}
}
