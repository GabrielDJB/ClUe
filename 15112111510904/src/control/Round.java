package control;

import java.util.ArrayList;
import java.util.List;

//
// Classe Round - Singleton
//
// Descrição: Classe responsável pela administração de rodadas. Estruturada de acordo com o design pattern de singletons.
//
// Variáveis: Não possui variáveis visíveis.
//
// Métodos: Round (Construtor), GetRodada, addNumP, nextTurn
//

public final class Round {
	private static Round instance = new Round();
	public int nPlayers = 0;
	public int dado = 0;

	//
	// Construtor Round - Privado (Singleton)
	//
	//

	private Round() {
	}

	//
	// Método GetRodada
	//
	// Descrição: Retorna uma referência a essa única instância.
	//
	// Parâmetros: Sem parâmetros.
	//
	// Retorno: Referência à rodada.
	//

	public static Round GetRodada() {
		return instance;
	}

	//
	// Método addNumP
	//
	// Descrição: Incrementa o número de jogadores no jogo.
	//
	// Parâmetros: Sem parâmetros.
	//
	// Retorno: Sem retorno.
	//

	public void addNumP() {
		nPlayers = nPlayers + 1;
	}

	public Player nextTurn() {
		Player p = Control.jogadores.get(0);
		Control.jogadores.remove(0);
		Control.jogadores.add(Control.jogadores.size(), p);
		dado = 0;
		return p;
	}
}