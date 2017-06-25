package gameui;

import javax.swing.*;

import control.Control;
import control.Player;

import java.awt.*;

//
// Classe CardSelector - JPanel
//
// Descrição: Painel do frame de seleção de cartas. Posteriormente deve adicionar o bloco de notas do jogador, com carregamento de seleções de cada jogador.
//
// Variáveis: Sem Variáveis públicas.
//
// Métodos: CardSelector (Construtor)
//

public class CardSelector extends JPanel {
	JCheckBox armas[] = new JCheckBox[6];
	JCheckBox comodos[] = new JCheckBox[9];
	JCheckBox suspeitos[] = new JCheckBox[6];
	JLabel armasl, comodosl, suspeitosl;
	Player p;

	//
	// Método CardSelector - Construtor
	//
	// Descrição: Inicializa o painel, adicionando os botões referentes ás
	// possíveis cartas.
	//
	// Parâmetros: Container c - Referência ao container no qual o painel á ser
	// inserido.
	//

	public CardSelector(Container c) {
		super(null);

		// Initializing variables

		p = Control.GetCurrP();

		armasl = new JLabel("Armas");
		comodosl = new JLabel("Comodos");
		suspeitosl = new JLabel("Suspeitos");

		armas[0] = new JCheckBox("Cano");
		armas[1] = new JCheckBox("Castiçal");
		armas[2] = new JCheckBox("Chave Inglesa");
		armas[3] = new JCheckBox("Corda");
		armas[4] = new JCheckBox("Faca");
		armas[5] = new JCheckBox("Revolver");

		comodos[0] = new JCheckBox("Biblioteca");
		comodos[1] = new JCheckBox("Cozinha");
		comodos[2] = new JCheckBox("Entrada");
		comodos[3] = new JCheckBox("Escritorio");
		comodos[4] = new JCheckBox("Jardim de Inverno");
		comodos[5] = new JCheckBox("Sala de Estar");
		comodos[6] = new JCheckBox("Sala de Jantar");
		comodos[7] = new JCheckBox("Sala de Música");
		comodos[8] = new JCheckBox("Sala de Jogos");

		suspeitos[0] = new JCheckBox("Green");
		suspeitos[1] = new JCheckBox("Mustard");
		suspeitos[2] = new JCheckBox("Peacock");
		suspeitos[3] = new JCheckBox("Plum");
		suspeitos[4] = new JCheckBox("Scarlet");
		suspeitos[5] = new JCheckBox("White");

		// Setting positions

		suspeitosl.setBounds(40, 40, 80, 20);
		suspeitos[0].setBounds(40, 70, 100, 20);
		suspeitos[1].setBounds(40, 100, 100, 20);
		suspeitos[2].setBounds(40, 130, 100, 20);
		suspeitos[3].setBounds(40, 160, 100, 20);
		suspeitos[4].setBounds(40, 190, 100, 20);
		suspeitos[5].setBounds(40, 220, 100, 20);

		armasl.setBounds(160, 40, 80, 20);
		armas[0].setBounds(160, 70, 120, 20);
		armas[1].setBounds(160, 100, 120, 20);
		armas[2].setBounds(160, 130, 120, 20);
		armas[3].setBounds(160, 160, 120, 20);
		armas[4].setBounds(160, 190, 120, 20);
		armas[5].setBounds(160, 220, 120, 20);

		comodosl.setBounds(300, 40, 80, 20);
		comodos[0].setBounds(300, 70, 140, 20);
		comodos[1].setBounds(300, 100, 140, 20);
		comodos[2].setBounds(300, 130, 140, 20);
		comodos[3].setBounds(300, 160, 140, 20);
		comodos[4].setBounds(300, 190, 140, 20);
		comodos[5].setBounds(300, 220, 140, 20);
		comodos[6].setBounds(300, 250, 140, 20);
		comodos[7].setBounds(300, 280, 140, 20);
		comodos[8].setBounds(300, 310, 140, 20);

		// Adding to this pane

		this.add(suspeitosl);
		this.add(suspeitos[0]);
		this.add(suspeitos[1]);
		this.add(suspeitos[2]);
		this.add(suspeitos[3]);
		this.add(suspeitos[4]);
		this.add(suspeitos[5]);

		this.add(armasl);
		this.add(armas[0]);
		this.add(armas[1]);
		this.add(armas[2]);
		this.add(armas[3]);
		this.add(armas[4]);
		this.add(armas[5]);

		this.add(comodosl);
		this.add(comodos[0]);
		this.add(comodos[1]);
		this.add(comodos[2]);
		this.add(comodos[3]);
		this.add(comodos[4]);
		this.add(comodos[5]);
		this.add(comodos[6]);
		this.add(comodos[7]);
		this.add(comodos[8]);

		// Adding to the content pane
		this.IniInventory(p);

		this.setVisible(true);
		c.add(this);
	}

	private void IniInventory(Player p) {
		int i = 0;
		
		for (JCheckBox j1 : armas) {
			if (p.hasCard(0, i) == 1) {
				j1.setSelected(true);
			}
			i++;
		}
		
		i = 0;
		
		for (JCheckBox j2 : suspeitos) {
			if (p.hasCard(1, i) == 1) {
				j2.setSelected(true);
			}
			i++;
		}
		
		i = 0;
		
		for (JCheckBox j3 : comodos) {
			if (p.hasCard(2, i) == 1) {
				j3.setSelected(true);
			}
			i++;
		}
		
	}
	
}
