package control;

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
	private static int turn;
	private static int nPlayers = 0;
	
	//
	// Construtor Round - Privado (Singleton)
	//
	// Descrição: Cria a instância do singleton, iniciando o número de rodadas em zero.
	//
	
	private Round() {
		turn = 0;
		/* Vazio */
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
	
	public static void addNumP(){
		nPlayers = nPlayers + 1;
	}
	
	//
	// Método nextTurn
	//
	// Descrição: Atribui à variável turn o número do jogador que deve jogar na próxima.
	//
	// Parâmetros: Sem parâmetros.
	//
	// Retorno: Sem retornos.
	//
	
	public static void nextTurn(){
		turn = (turn + 1) % nPlayers;
	}
}
