package gameui;

import control.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

final class AlertOKHandler implements ActionListener {

	public void actionPerformed(ActionEvent e) {
		UI.alert.dispose();
	}
}

public abstract class UI {
	static MainFrame mainf;
	static JFrame diceSelect;
	static JFrame alert;
	static Toolkit tk = Toolkit.getDefaultToolkit();
	static Dimension screen = tk.getScreenSize();

	public static void IniFrame() {
		Control.InitControl();
		System.out.println(Control.getMap().evalPath(1, 24, 4));
		mainf = new MainFrame();
		mainf.StartMenu();
		mainf.setVisible(true);
	}

	public static void PlayerSet() {
		mainf = new MainFrame();
		mainf.CharSelectMenu();
		mainf.setVisible(true);
	}

	public static void GameStart() {
		mainf = new MainFrame();
		mainf.GameMenu();
		mainf.setVisible(true);
	}

	public static void DiceSelect() {
		int width = 600, height = 450, x = screen.width / 2 - width / 2, y = screen.height / 2 - height / 2;
		diceSelect = new JFrame();
		TempDiceSelect diceSelectPane = new TempDiceSelect(diceSelect.getContentPane());
		diceSelect.setBounds(x, y, width, height);
		diceSelectPane.DiceButtons();
		diceSelect.setVisible(true);

	}

	public static void DiceClose() {
		if (diceSelect.isActive()) {
			diceSelect.dispose();
		}
	}

	public static void switchDice(int d) {
		mainf.ChooseDice(d);
	}

	public static void cardFrame() {
		JFrame cardf = new JFrame("Seleção de Cartas");
		CardSelector CardSPanel = new CardSelector(cardf.getContentPane());
		cardf.setBounds(50, 50, 500, 420);
		cardf.setVisible(true);
	}

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
	
	public static void RefreshMap(){
		mainf.RepaintMap();
	}
}
