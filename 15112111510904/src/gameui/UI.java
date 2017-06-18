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
	static AcusaFrame acusa;
	static PalpiteFrame palpite;

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
		palpite = new PalpiteFrame();
		palpite.SuspectList();
		palpite.GunList();
		palpite.LocaleList();
		palpite.Show();
		palpite.setVisible(true);
	}

	public static void AcusaFrame() {
		acusa = new AcusaFrame();
		acusa.SuspectList();
		acusa.GunList();
		acusa.LocaleList();
		acusa.Show();
		acusa.setVisible(true);
	}
	
	public static void CloseAcusaFrame(){
		acusa.dispose();
	}
	
	public static void ClosePalpiteFrame(){
		palpite.dispose();
	}
	
	public static int[] PalpiteSelection(){
		return palpite.GetSelection();
	}
	
	public static int Palpite(int p[]){
		int ret = 0;
		ret = Control.CheckCards(p[0], p[1], p[2]);
		return ret;
	}
		
	public static int[] AcusaSelection(){
		return acusa.GetSelection();
	}
	
	public static int Acusa(int p[]){
		int ret = 0;
		ret = Control.CheckCards(p[0], p[1], p[2]);
		return ret;
	}
	
	public static void PrintCP(int cp[]){
		
		if(cp[0] == 0){
			if(cp[1] == 0)
				System.out.println("Cano");
			else if(cp[1] == 1)
				System.out.println("Castical");
			else if(cp[1] == 2)
				System.out.println("Chave Inglesa");
			else if(cp[1] == 3)
				System.out.println("Corda");
			else if(cp[1] == 4)
				System.out.println("Faca");
			else
				System.out.println("Revolver");
		}
		
		if(cp[0] == 1){
			if(cp[1] == 0)
				System.out.println("Green");
			else if(cp[1] == 1)
				System.out.println("Mustard");
			else if(cp[1] == 2)
				System.out.println("Peacock");
			else if(cp[1] == 3)
				System.out.println("Plum");
			else if(cp[1] == 4)
				System.out.println("Scarlet");
			else
				System.out.println("White");
		}
		
		if(cp[0] == 2){
			if(cp[1] == 0)
				System.out.println("Biblioteca");
			else if(cp[1] == 1)
				System.out.println("Cozinha");
			else if(cp[1] == 2)
				System.out.println("Entrada");
			else if(cp[1] == 3)
				System.out.println("Escritorio");
			else if(cp[1] == 4)
				System.out.println("Jardim de Inverno");
			else if(cp[1] == 5)
				System.out.println("Sala de Estar");
			else if(cp[1] == 6)
				System.out.println("Sala de Jantar");
			else if(cp[1] == 7)
				System.out.println("Sala de Musica");
			else if(cp[1] == 8)
				System.out.println("Sala de Jogos");
		}
	}

}
