package control;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import gameui.UI;

//
// Classe Control - Abstrata (Não Instanciável)
//
// Funçao: Classe responsável pela delegação de comandos lógicos do jogo.
//
// Visibilidade: Visível por todas as classes no package control.
//
// Variáveis Visíveis: mapa, JogoAtivo, rodada, jogadores.
//
// Métodos: AddPlayer, getPlayer, getPlayersIt, getMap, printNP
//

public abstract class Control {
	public static Map mapa = Map.GetMapa(); // Mapa do jogo
	public static boolean JogoAtivo = false; // Determina se o jogo está rodando
	public static Round rodada = Round.GetRodada(); // Manager de rodadas do
													// jogo
	// Lista dos jogadores da instância do jogo
	public static List<Player> jogadores = new ArrayList<Player>();

	//
	// Método InitControl - Abstrato
	//
	// Descrição: Atribui o valor verdadeiro à variável JogoAtivo, indicando que
	// o jogo começou.
	//
	// Sem Parâmetros ou retornos.
	//

	public static void InitControl() {
		JogoAtivo = true;
	}

	//
	// Método AddPlayer - Abstrato
	//
	// Descrição: Adiciona um jogador na lista de jogadores.
	//
	// Parâmetros: name - Nome do jogador que deve ser adicionado.
	//
	// Retorno: Nada é retornado.
	//

	public static void AddPlayer(String name) {
		Player p = null;

		if (name.compareTo(new String("Pele")) == 0) {
			p = new Player(name, 2, 370, 75, Color.white);
		} else if (name.compareTo(new String("Maradona")) == 0) {
			p = new Player(name, 3 , 525, 75, Color.green);
		} else if (name.compareTo(new String("Eric Cantona")) == 0) {
			p = new Player(name, 31, 820, 290, Color.blue);
		} else if (name.compareTo(new String("Zinedine Zidane")) == 0) {
			p = new Player(name, 158, 820, 745, Color.cyan);
		} else if (name.compareTo(new String("Ronaldinho Gaucho")) == 0) {
			p = new Player(name, 177, 305, 930, Color.red);
		} else if (name.compareTo(new String("Taffarel")) == 0) {
			p = new Player(name, 122, 75, 680, Color.yellow);
		}

		jogadores.add(p);
	}

	//
	// Método getPlayer - Abstrato
	//
	// Descrição: Pega um jogador específico na lista de jogadores pelo nome do
	// jogador desejado.
	//
	// Parâmetros: name - Nome do jogador cuja referência deve ser retornada.
	//
	// Retorno: Referência à instância do jogador desejado.
	//

	public static Player getPlayer(String name) {
		for (Player i : jogadores) {
			if (i.getNome().equals(name)) {
				return i;
			}
		}
		UI.Alert("Erro na busca por jogador!");
		return null;
	}

	//
	// Método getMap - Abstrato
	//
	// Descrição: Obtém acesso ao mapa, através de sua referência.
	//
	// Parâmetros: Não possui Parâmetros.
	//
	// Retorno: Retorna uma referência ao mapa.
	//

	public static Map getMap() {
		return mapa;
	}

	//
	// Método printNP - Abstrato
	//
	// Descrição: Imprime no console o número de jogadores na partida.
	//

	public static void printNP() {
		System.out.println(Integer.toString(jogadores.size()));
	}

}
