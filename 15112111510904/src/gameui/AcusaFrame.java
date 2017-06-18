package gameui;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

final class AcusaOKHandler implements ActionListener{
	public void actionPerformed(ActionEvent e){
		UI.CloseAcusaFrame();
	}
}

public class AcusaFrame extends JFrame {
	ButtonGroup s, a, l;
	JRadioButton suspeitos[] = new JRadioButton[6];
	JRadioButton armas[] = new JRadioButton[6];
	JRadioButton locais[] = new JRadioButton[9];
	JLabel armasl, comodosl, suspeitosl;
	JPanel panel;
	Container c = this.getContentPane();
	JButton b = new JButton("Submeter Acusacao");

	public AcusaFrame() {

		super("Acusacao");
		panel = new JPanel(null);

		armasl = new JLabel("Armas");
		comodosl = new JLabel("Comodos");
		suspeitosl = new JLabel("Suspeitos");

		this.setBounds(100, 100, 480, 490);
		this.setResizable(false);
		b.setBounds(220, 360, 200, 50);
		b.addActionListener(new AcusaOKHandler());

		panel.add(b);
	}

	public void SuspectList() {

		s = new ButtonGroup();

		suspeitos[0] = new JRadioButton("Green");
		suspeitos[1] = new JRadioButton("Mustard");
		suspeitos[2] = new JRadioButton("Peacock");
		suspeitos[3] = new JRadioButton("Plum");
		suspeitos[4] = new JRadioButton("Scarlet");
		suspeitos[5] = new JRadioButton("White");

		suspeitosl.setBounds(40, 40, 80, 20);
		suspeitos[0].setBounds(40, 70, 100, 20);
		suspeitos[1].setBounds(40, 100, 100, 20);
		suspeitos[2].setBounds(40, 130, 100, 20);
		suspeitos[3].setBounds(40, 160, 100, 20);
		suspeitos[4].setBounds(40, 190, 100, 20);
		suspeitos[5].setBounds(40, 220, 100, 20);

		s.add(suspeitos[0]);
		s.add(suspeitos[1]);
		s.add(suspeitos[2]);
		s.add(suspeitos[3]);
		s.add(suspeitos[4]);
		s.add(suspeitos[5]);

		panel.add(suspeitosl);
		panel.add(suspeitos[0]);
		panel.add(suspeitos[1]);
		panel.add(suspeitos[2]);
		panel.add(suspeitos[3]);
		panel.add(suspeitos[4]);
		panel.add(suspeitos[5]);
	}

	public void GunList() {

		a = new ButtonGroup();

		armas[0] = new JRadioButton("Cano");
		armas[1] = new JRadioButton("Castical");
		armas[2] = new JRadioButton("Chave Inglesa");
		armas[3] = new JRadioButton("Corda");
		armas[4] = new JRadioButton("Faca");
		armas[5] = new JRadioButton("Revolver");

		armasl.setBounds(160, 40, 80, 20);
		armas[0].setBounds(160, 70, 120, 20);
		armas[1].setBounds(160, 100, 120, 20);
		armas[2].setBounds(160, 130, 120, 20);
		armas[3].setBounds(160, 160, 120, 20);
		armas[4].setBounds(160, 190, 120, 20);
		armas[5].setBounds(160, 220, 120, 20);

		a.add(armas[0]);
		a.add(armas[1]);
		a.add(armas[2]);
		a.add(armas[3]);
		a.add(armas[4]);
		a.add(armas[5]);

		panel.add(armasl);
		panel.add(armas[0]);
		panel.add(armas[1]);
		panel.add(armas[2]);
		panel.add(armas[3]);
		panel.add(armas[4]);
		panel.add(armas[5]);
	}

	public void LocaleList() {

		l = new ButtonGroup();

		locais[0] = new JRadioButton("Biblioteca");
		locais[1] = new JRadioButton("Cozinha");
		locais[2] = new JRadioButton("Entrada");
		locais[3] = new JRadioButton("Escritorio");
		locais[4] = new JRadioButton("Jardim de Inverno");
		locais[5] = new JRadioButton("Sala de Estar");
		locais[6] = new JRadioButton("Sala de Jantar");
		locais[7] = new JRadioButton("Sala de Musica");
		locais[8] = new JRadioButton("Sala de Jogos");

		comodosl.setBounds(300, 40, 80, 20);
		locais[0].setBounds(300, 70, 140, 20);
		locais[1].setBounds(300, 100, 140, 20);
		locais[2].setBounds(300, 130, 140, 20);
		locais[3].setBounds(300, 160, 140, 20);
		locais[4].setBounds(300, 190, 140, 20);
		locais[5].setBounds(300, 220, 140, 20);
		locais[6].setBounds(300, 250, 140, 20);
		locais[7].setBounds(300, 280, 140, 20);
		locais[8].setBounds(300, 310, 140, 20);

		l.add(locais[0]);
		l.add(locais[1]);
		l.add(locais[2]);
		l.add(locais[3]);
		l.add(locais[4]);
		l.add(locais[5]);
		l.add(locais[6]);
		l.add(locais[7]);
		l.add(locais[8]);

		panel.add(comodosl);
		panel.add(locais[0]);
		panel.add(locais[1]);
		panel.add(locais[2]);
		panel.add(locais[3]);
		panel.add(locais[4]);
		panel.add(locais[5]);
		panel.add(locais[6]);
		panel.add(locais[7]);
		panel.add(locais[8]);
	}

	public void Show() {
		c.add(panel);
		panel.setVisible(true);
	}
}
